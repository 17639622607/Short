package mdao.service;

import mdao.common.GetTime;
import mdao.entity.Record;
import mdao.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("recordService")
@Transactional
public class RecordServiceImpl implements  RecordServiceIF {
    @Autowired
    RecordMapper  recordMapper;


    @Override
    @Transactional(propagation =   Propagation.SUPPORTS)
    public int insert(int id,String longurl,String shorturl) {
        Record record=new Record();
        record.setId(id);
        record.setLong_url(longurl);
        record.setShort_url(shorturl);
        record.setYear_month_(GetTime.getYear_month_());
        record.setYear_month_day_(GetTime.getYear_month_day_());
        record.setCreate_time(new Date());
        String month= "record"+GetTime.getMonth();
        int result=recordMapper.insert(record,month);
        return result;
    }

    @Override
    public int selectMaxId() {
        String month=GetTime.getMonth();
        String lastMonth=GetTime.getlastMonth();
        try {
            //查询本月的数据
            int maxID=recordMapper.selectMaxId("record"+month);
            if(maxID>14000000){//如果本月的数据大于14000000，则从头开始
                return 1;
            }
            return maxID;
        } catch (Exception e) {
            try {
                System.out.println("本月数据表为空，查找上月的数据表");
                int maxID=recordMapper.selectMaxId("record"+lastMonth);
                if(maxID>14000000){//如果本月的数据大于14000000，则从头开始
                    return 1;
                }
                return  maxID;
            } catch (Exception e1) {
                System.out.println("数据库为空，短信业务从零开始");
                return 1;
            }
        }

    }
    @Override
    public Record selectRecordByShortUrl(String shortUrl,String month)  {
        return recordMapper.selectRecordByShortUrl(month,shortUrl);
    }
}

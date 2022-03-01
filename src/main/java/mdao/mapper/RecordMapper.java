package mdao.mapper;


import mdao.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RecordMapper {
    public int insert(@Param("record") Record record,@Param("tablename") String tablename);

    public int selectMaxId(@Param("tablename") String tablename);

    public Record selectRecordByShortUrl(@Param("tablename") String tablename,String short_url);
}

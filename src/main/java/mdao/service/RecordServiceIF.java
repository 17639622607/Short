package mdao.service;

import mdao.entity.Record;

import java.util.List;

public interface RecordServiceIF {
    public int insert(int id,String longurl,String shorturl);

    public int selectMaxId();

    public Record selectRecordByShortUrl(String shortUrl,String month);


}

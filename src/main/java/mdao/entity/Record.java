package mdao.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {
    static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    int id;
    String long_url;
    String short_url;
    int year_month_;
    int year_month_day_;
    String create_time;

    public Record() {
    }

    public Record(String long_url, String short_url, int year_month_, int year_month_day_, String create_time) {
        this.long_url = long_url;
        this.short_url = short_url;
        this.year_month_ = year_month_;
        this.year_month_day_ = year_month_day_;
        this.create_time = create_time;
    }

    public Record(int id, String long_url, String short_url, int year_month_, int year_month_day_, String create_time) {
        this.id = id;
        this.long_url = long_url;
        this.short_url = short_url;
        this.year_month_ = year_month_;
        this.year_month_day_ = year_month_day_;
        this.create_time = create_time;
    }

    public static SimpleDateFormat getSdf2() {
        return sdf2;
    }

    public static void setSdf2(SimpleDateFormat sdf2) {
        Record.sdf2 = sdf2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLong_url() {
        return long_url;
    }

    public void setLong_url(String long_url) {
        this.long_url = long_url;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url;
    }

    public int getYear_month_() {
        return year_month_;
    }

    public void setYear_month_(int year_month_) {
        this.year_month_ = year_month_;
    }

    public int getYear_month_day_() {
        return year_month_day_;
    }

    public void setYear_month_day_(int year_month_day_) {
        this.year_month_day_ = year_month_day_;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = sdf2.format(create_time);
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", long_url='" + long_url + '\'' +
                ", short_url='" + short_url + '\'' +
                ", year_month_=" + year_month_ +
                ", year_month_day_=" + year_month_day_ +
                ", create_time='" + create_time + '\'' +
                '}';
    }
}

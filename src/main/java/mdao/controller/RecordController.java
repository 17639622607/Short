package mdao.controller;
import com.alibaba.fastjson.JSON;
import mdao.common.By62;
import mdao.common.Static;
import mdao.entity.Record;
import mdao.entity.Response;
import mdao.service.RecordServiceIF;
import mdao.service.RedisTestImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Sg")
public class RecordController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RecordServiceIF recordServiceIF;
    @Autowired
    RedisTestImpl   redisTest;

//    @RequestMapping("/insertRecord")
//    @ResponseBody
//    public String insert(){
//        Record record=new Record();
//        int id=recordServiceIF.selectMaxId();
//        recordServiceIF.insert(record);
//        return "aa";
//    }
    @RequestMapping("/selectMax")
    @ResponseBody
    public String selectMax(){
        int a=recordServiceIF.selectMaxId();
        return a+"";
    }

   /* @RequestMapping("/index")
    @ResponseBody
    public String index(String url){
        int id10=Static.newID+1;
        while (true){
            synchronized ((Object)Static.newID){
                String id62= By62._10_to_62(id10);//转换为62进制后的唯一id
                try {
                    redisTest.insert(id62,url);//存进redis中
                    logger.info("Redis储存...KEY: "+id62+" VALUE: "+url);
                } catch (Exception e) {
                    logger.info("Redis数据储存错误...KEY: "+id62+" VALUE: "+url);
                    e.printStackTrace();
                }
                try {
                    recordServiceIF.insert(id10,url,Static.Short+id62);//存到数据库中
                    logger.info("Mysql储存...short_url: "+(Static.Short+id62)+" long_url: "+url);
                } catch (Exception e) {
                    logger.info("Mysql储存错误...short_url: "+(Static.Short+id62)+" long_url: "+url);
                    e.printStackTrace();
                }
                Static.newID++;//将静态id+1
                logger.info("十进制id："+id10);
                Response response=new Response(Static.Short+id62,url,0);
                String returnResponse= JSON.toJSONString(response);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return returnResponse;
            }
        }
    }*/

    /**
     * 短连接生成1，根据长连接返回对象(对象中包含长连接、短连接、type,模仿新浪)
     * @param url
     * @return
     */
    @RequestMapping("/index")
    @ResponseBody
    public String index(String url){

        while (true){
            synchronized (redisTest){
                int id10=Integer.parseInt(redisTest.find("StaticID"));
                redisTest.insert("StaticID",String.valueOf(id10+1));
                String id62= By62._10_to_62(id10);//转换为62进制后的唯一id
                try {
                    redisTest.insert(id62,url);//存进redis中
                    logger.info("Redis储存...KEY: "+id62+" VALUE: "+url);
                } catch (Exception e) {
                    logger.info("Redis数据储存错误...KEY: "+id62+" VALUE: "+url);
                    e.printStackTrace();
                }
                /*try {
                    recordServiceIF.insert(id10,url,Static.Short+id62);//存到数据库中
                    logger.info("Mysql储存...short_url: "+(Static.Short+id62)+" long_url: "+url);
                } catch (Exception e) {
                    logger.info("Mysql储存错误...short_url: "+(Static.Short+id62)+" long_url: "+url);
                    e.printStackTrace();
                }*/

                logger.info("十进制id："+id10);
                Response response=new Response(Static.Short+id62,url,0);
                String returnResponse= JSON.toJSONString(response);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return returnResponse;
            }
        }
    }

    /**
     * 短连接生成2，直接根据长连接返回短连接
     * @param url
     * @return
     */
    @RequestMapping("/main")
    @ResponseBody
    public String main(String url){

        while (true){
            synchronized (redisTest){
                int id10=Integer.parseInt(redisTest.find("StaticID"));
                if(id10>10000000){
                    id10=1;
                }
                redisTest.insert("StaticID",String.valueOf(id10+1));
                String id62= By62._10_to_62(id10);//转换为62进制后的唯一id
                try {
                    redisTest.insert(id62,url);//存进redis中
                    logger.info("Redis储存...KEY: "+id62+" VALUE: "+url);
                } catch (Exception e) {
                    logger.info("Redis数据储存错误...KEY: "+id62+" VALUE: "+url);
                    e.printStackTrace();
                }
                /*try {
                    recordServiceIF.insert(id10,url,Static.Short+id62);//存到数据库中
                    logger.info("Mysql储存...short_url: "+(Static.Short+id62)+" long_url: "+url);
                } catch (Exception e) {
                    logger.info("Mysql储存错误...short_url: "+(Static.Short+id62)+" long_url: "+url);
                    e.printStackTrace();
                }*/

                logger.info("十进制id："+id10);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return Static.Short+id62;
            }
        }
    }
}

package mdao.common;

import mdao.service.RecordServiceIF;
import mdao.service.RedisTestImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Initialize implements ApplicationRunner {
    private final  Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    RecordServiceIF recordServiceIF;
    @Autowired
    RedisTestImpl redisTest;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("初始化数据");
        //Static.newID=recordServiceIF.selectMaxId();
        //redis版
        try {
            logger.info("初始化静态ID: "+Integer.parseInt(redisTest.find("StaticID")));
        } catch (NumberFormatException e) {
            redisTest.insert("StaticID","1");
            logger.info("初始化静态ID: "+Integer.parseInt(redisTest.find("StaticID")));
        }

        //数据库加redis版
        /*redisTest.insert("StaticID",String.valueOf(recordServiceIF.selectMaxId()));
        if (Integer.parseInt(redisTest.find("StaticID"))>0){
            logger.info("初始化数据成功");
            logger.info("初始化静态ID: "+Integer.parseInt(redisTest.find("StaticID")));
        }else {
            logger.info("初始化数据失败或者数据库为空，请测试...");
            logger.info("初始化静态ID: "+Integer.parseInt(redisTest.find("StaticID")));
        }*/
    }
}

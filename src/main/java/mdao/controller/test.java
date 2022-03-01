package mdao.controller;

import mdao.common.By62;
import mdao.service.RecordServiceIF;
import mdao.service.RedisTestImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class test {
    @Autowired
    RedisTestImpl redisTest;
    @RequestMapping("/deleteRedis")
    @ResponseBody
    public String deleteRedis(String key) {
        System.out.println(1);
        for(int i=0;i<900000;i++){
            redisTest.delete(By62._10_to_62(i));
        }
        return "0";
    }

}

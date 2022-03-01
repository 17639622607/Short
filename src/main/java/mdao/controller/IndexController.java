package mdao.controller;

import mdao.common.GetTime;
import mdao.common.Static;
import mdao.service.RecordServiceIF;
import mdao.service.RedisTestImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    RedisTestImpl redisTest;
    @Autowired
    RecordServiceIF recordServiceIF;

    @RequestMapping("{moduleName}")
    public String item_add(@PathVariable String moduleName){
        logger.info(moduleName);
        String url=null;
            url=redisTest.select(moduleName);
            logger.info("访问请求: 来自"+Static.Short+moduleName+" Redis缓存查询...");
         if(url==null) {
                logger.info("访问请求: 来自"+Static.Short+moduleName+" 数据库查询...");
                //如果查到本月
                if(recordServiceIF.selectRecordByShortUrl(Static.Short+moduleName,("record"+ GetTime.getMonth())).getLong_url()!=null){
                    return "redirect:"+recordServiceIF.selectRecordByShortUrl(Static.Short+moduleName,("record"+ GetTime.getMonth())).getLong_url();
                }else{//如果查不到本月，就查询上个月的
                    return "redirect:"+recordServiceIF.selectRecordByShortUrl(Static.Short+moduleName,("record"+ GetTime.getlastMonth())).getLong_url();
                }
        }
        return  "redirect:"+url;
    }
}
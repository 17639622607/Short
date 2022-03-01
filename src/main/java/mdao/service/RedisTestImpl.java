package mdao.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisTestImpl {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    public void test(){
        for(int i=0;i<500000;i++){
            String key="ceshi"+i;
            stringRedisTemplate.opsForValue().set(key,key);
            stringRedisTemplate.expire(key,10, TimeUnit.HOURS);
            System.out.println(key);
        }
    }
    public String find(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
    public void insert(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
        stringRedisTemplate.expire(String.valueOf(key),15, TimeUnit.DAYS);
        //stringRedisTemplate.expire(String.valueOf(key),1, TimeUnit.HOURS);
    }
    public String select(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
    public void delete(String key){
        stringRedisTemplate.delete(key);
    }

    public String tes1t(){
        return stringRedisTemplate.opsForValue().get("StaticID");
    }
}

package com.zut.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {
    /**
     * 此处的getLogger中的class一定要是当前的类，这样将来出了问题才好排查是哪个类出错了
     * 这句可以被注解 @Slf4j 替换，然后用log代替logger
     */
    /*
    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    @Test
    public void test(){
        logger.info("info...");
        logger.debug("debug...");
        logger.error("error...");
    }*/

    @Test
    public void test(){
        String name = "zoe";
        String pwd="123456";
        log.info("name:{},pwd:{}",name,pwd);
        log.debug("debug...");
        log.warn("warn...");
        log.error("error...");
    }
}

package com.cun.plus;

import com.cun.plus.entity.SuccessKilled;
import com.cun.plus.mapper.SuccessKilledMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ning11.zhang
 * @Description:
 * @date 2021/2/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SuccessSeckillTest {
    @Autowired
    private SuccessKilledMapper successKilledMapper;

    @Test
    public void insertTest2() {
        SuccessKilled successKilled = new SuccessKilled();
        successKilled.setSeckillId(123L);
        successKilled.setUserPhone(13623232323L);
        successKilled.setState(1);
        try {
            successKilledMapper.insert(successKilled);
        } catch (RuntimeException ex) {
            System.out.println( "==="+ ex.getMessage());
        }

    }
}

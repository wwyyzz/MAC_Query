package com.wj.MAC_Query;

import com.wj.MAC_Query.entity.macAddr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class macaddrRepositoryTest {

    @Autowired
    private macaddrRepository macaddrRepository;

    @Test
    public void addAddr(){
        macAddr addr = new macAddr();
        addr.setId(2);
        addr.setMacaddr("00-00-01");
        addr.setManu("CISCO");
    }
}

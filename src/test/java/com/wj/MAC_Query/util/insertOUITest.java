package com.wj.MAC_Query.util;

import com.wj.MAC_Query.DAO.macaddrRepository;
import com.wj.MAC_Query.entity.macAddr;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class insertOUITest {
    @Autowired
    private com.wj.MAC_Query.DAO.macaddrRepository macaddrRepository;

    @Test
    void insert() {
        macAddr oui = new macAddr();
        oui.setManu("C01692");
        oui.setMacaddr("China Mobile Group Device Co.,Ltd.");
        macaddrRepository.save(oui);
    }
}
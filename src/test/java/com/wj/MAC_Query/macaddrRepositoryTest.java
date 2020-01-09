package com.wj.MAC_Query;

import com.wj.MAC_Query.entity.macAddr;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class macaddrRepositoryTest {

    @Autowired
    private com.wj.MAC_Query.DAO.macaddrRepository macaddrRepository;

    @Test
    public void addAddr(){
        String pathname = "mac_address_map.txt";
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                String[] str = line.split("\t");

                macAddr addr = new macAddr();
                addr.setMacaddr(str[0]);
                addr.setManu(str[1]);
                macaddrRepository.save(addr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

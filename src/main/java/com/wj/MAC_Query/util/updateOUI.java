package com.wj.MAC_Query.util;

import com.wj.MAC_Query.DAO.macaddrRepository;
import com.wj.MAC_Query.MacQueryApplication;
import com.wj.MAC_Query.entity.macAddr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class updateOUI {
    private Logger logger = LoggerFactory.getLogger(MacQueryApplication.class);

    @Autowired
    private macAddr oui;

    @Autowired
    private macaddrRepository macaddrRepo;

    @Transactional
    @Scheduled(cron = "0 22 18 * * *")
    public void update() {
        String pathname = "./db/new_oui.txt";


        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                //对读入的数据根据\t进行拆分
                System.out.println(line);
                String[] str = line.split("\t");
                oui.setMacaddr(str[0]);
                oui.setMacaddr(str[1]);
                macaddrRepo.saveAndFlush(oui);
                System.out.println(macaddrRepo.findByMacaddr(str[0]));

                logger.info("update oui");
                System.out.println("update oui ....");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }




    }

}

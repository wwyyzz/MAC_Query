package com.wj.MAC_Query.util;

import com.wj.MAC_Query.DAO.macaddrRepository;
import com.wj.MAC_Query.MacQueryApplication;
import com.wj.MAC_Query.entity.macAddr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.transaction.Transactional;

@Component
public class checkOUI {
    private Logger logger = LoggerFactory.getLogger(MacQueryApplication.class);

    @Autowired
    private macAddr oui;

    @Autowired
    private macaddrRepository macaddrRepo;

    @Transactional
    @Scheduled(cron = "0 27 17 * * *")
    public void check() {


        oui.setMacaddr("C01692");
        oui.setManu("China Mobile Group Device Co.,Ltd.");

        macaddrRepo.deleteByMacaddr("C01692");

        logger.info("delete oui");
        System.out.println("delete oui ....");

    }

}

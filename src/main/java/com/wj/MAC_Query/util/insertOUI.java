package com.wj.MAC_Query.util;

import com.wj.MAC_Query.DAO.macaddrRepository;
import com.wj.MAC_Query.entity.macAddr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class insertOUI {

    @Autowired
    macaddrRepository macaddrRepo;


    public void insert() {
        macAddr oui = new macAddr();
        oui.setMacaddr("C01692");
        oui.setManu("China Mobile Group Device Co.,Ltd.");
        macaddrRepo.save(oui);

    }

}

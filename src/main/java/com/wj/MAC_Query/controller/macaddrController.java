package com.wj.MAC_Query.controller;

import com.wj.MAC_Query.entity.macAddr;
import com.wj.MAC_Query.DAO.macaddrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class macaddrController {
    @Autowired
    macaddrRepository macaddrRepo;

    @RequestMapping("/")
    public String query(Model model){

        model.addAttribute("hello","你好!");
        return "index";
    }

    @RequestMapping("/query")
    public String query_mac(Model model,@RequestParam("macaddr") String mac){
        macAddr result = macaddrRepo.findByMacaddr(mac);
        System.out.println(result);
        model.addAttribute("hello","你好!");
        model.addAttribute("manu",result.getManu());
        return "index";
    }
}

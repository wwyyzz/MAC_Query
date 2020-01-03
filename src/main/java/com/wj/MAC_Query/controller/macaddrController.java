package com.wj.MAC_Query.controller;

import com.wj.MAC_Query.MacQueryApplication;
import com.wj.MAC_Query.entity.macAddr;
import com.wj.MAC_Query.DAO.macaddrRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class macaddrController {
    final static String INVALID = "NOT A VALID MAC ADDRESS";
    private Logger logger = LoggerFactory.getLogger(MacQueryApplication.class);

    @Autowired
    macaddrRepository macaddrRepo;


    @RequestMapping("/")
    public String query() {
        return "index";
    }

    @RequestMapping("/query")
    public String query_mac(Model model, @RequestParam("macaddr") String mac) {
        String oui = getOUI(mac);

        //查询OUI数据库
        macAddr result = macaddrRepo.findByMacaddr(oui);

        model.addAttribute("mac", mac);
        model.addAttribute("oui", oui);

        //OUI解析失败，或者数据库查询为空，则返回MAC地址无效的提示
        if (oui.equals(INVALID) || result == null) {
            model.addAttribute("manu", INVALID);
            logger.info("MAC address: " + mac + " is " + INVALID);
            return "index";
        }

//        System.out.println(result);
        //获取厂家信息，添加到manu属性，用于前端展示
        String manu = result.getManu();
        model.addAttribute("manu", manu);
        logger.info("query MAC address... " + mac + " is " + manu);
        return "index";
    }

    /*
    从MAC地址中提前OUI。
    1、字符串转为大写
    2、只保留0-9、A-F字符
    3、长度大于6个字符
    4、截取前6个字符返回
     */
    public String getOUI(String mac) {
        String str = mac.toUpperCase();
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if ((aChar >= '0' && aChar <= '9') || (aChar >= 'A' && aChar <= 'F')) {
                sb.append(aChar);
            }
        }
        if (sb.length() < 6) {
            return INVALID;
        }
//        System.out.println(sb.substring(0, 6));
        return sb.substring(0, 6);
    }

    @GetMapping ("/addOUI")
    public String addOUI() {

        new com.wj.MAC_Query.util.insertOUI().insert();

        return "index";
    }

}

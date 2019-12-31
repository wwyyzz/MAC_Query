package com.wj.MAC_Query.util;

import com.wj.MAC_Query.entity.macAddr;
import com.wj.MAC_Query.DAO.macaddrRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

public class insertData {
//    @Autowired
//    private macaddrRepository mac_addrRepository;


    public static void main(String[] args) {

        String pathname = "mac_address_map.txt";

        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                //对读入的数据根据\t进行拆分
                String[] str = line.split("\t");
                addAddr(str[0], str[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /*
    向数据库逐条插入数据
     */
    private static void addAddr(String mac, String manu) {
        macAddr addr = new macAddr();
        addr.setMacaddr(mac);
        addr.setManu(manu);
        System.out.println(addr);

    }

}

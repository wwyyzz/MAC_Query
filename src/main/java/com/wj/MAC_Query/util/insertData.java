package com.wj.MAC_Query.util;

import com.wj.MAC_Query.entity.macAddr;
import com.wj.MAC_Query.DAO.macaddrRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

public class insertData {
    @Autowired
    private macaddrRepository mac_addrRepository;


    public static void main(String[] args) {


        String pathname = "mac_address_map.txt";
        String mac = "";
        String manu = "";
        String sql = "";
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
//                Arrays.toString(line.split("\t"));
                String[] str = line.split("\t");
                mac = str[0];
                manu = str[1];
//                sql = "INSERT INTO MAC_ADDRESS(MAC_ADDDR, MANU) VALUES(" + mac + ", " + manu + ");";
//                System.out.println(sql);
                addcAddr(mac, manu);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void addcAddr(String mac, String manu) {
        macAddr addr = new macAddr();
        addr.setMacaddr(mac);
        addr.setManu(manu);
        System.out.println(addr);
//        mac_addrRepository.save(addr);
    }

}

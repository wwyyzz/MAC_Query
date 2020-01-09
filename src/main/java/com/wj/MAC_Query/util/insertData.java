package com.wj.MAC_Query.util;

import com.wj.MAC_Query.DAO.macaddrRepository;
import com.wj.MAC_Query.entity.macAddr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.*;

@EnableJpaRepositories("com.wj.MAC_Query.DAO.macaddrRepository")
public class insertData {
    @Autowired
    macaddrRepository macaddrRepo;


    public static void main(String[] args) {
//        System.out.println(macaddrRepo);
        new insertData().updateOUI();
    }


    public static void initOUI() {

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

     */
    public void updateOUI() {
        String pathname = "./OUI_files/new_map.txt";

        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                //对读入的数据根据\t进行拆分
                String[] str = line.split("\t");
                System.out.println(str[0]);
//                System.out.println(macaddrRepo);
                macAddr oui = addAddr(str[0],str[1]);
                macaddrRepo.save(oui);
//                if ( result == null){
//                    System.out.println(str[0]);
//                    System.out.println(str[1]);
//                    addAddr(str[0], str[1]);
//                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    /*
    向数据库逐条插入数据
     */
    private static macAddr addAddr(String mac, String manu) {
        macAddr addr = new macAddr();
        addr.setMacaddr(mac);
        addr.setManu(manu);
//        macaddrRepository.save(addr);
        System.out.println(addr);
        return addr;
//        String result = addr.getMacaddr(mac);
//        System.out.println("query..." + addr.getMacaddr(mac));
//        if ( result == null) {
//            addr.setMacaddr(mac);
//            addr.setManu(manu);
//            System.out.println("set OUI..." + addr);
//            System.out.println(addr.getMacaddr("C01692"));
//        }
    }

    private String queryAddr(String mac) {
        macAddr addr = new macAddr();
        System.out.println("query..." + addr.getMacaddr(mac));
        return addr.getMacaddr(mac);

//        System.out.println(addr);

    }

}

package com.wj.MAC_Query.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class runPython {
    public static void main(String[] args) {
        Process proc;
        try {
            proc = Runtime.getRuntime().exec("python3 /home/navy/PythonProject/MAC-query/get_macaddress_map.py");// 执行py文件
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}

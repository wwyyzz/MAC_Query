package com.wj.MAC_Query.util;

//public class downloadOUI {
//    String url = "http://standards.ieee.org/develop/regauth/oui/oui.txt";
//
//
//    public static String downloadFromUrl(String url,String dir) {
//
//        try {
//            URL httpurl = new URL(url);
//            String fileName = "oui_" + LocalDate.now() + ".txt";
//            System.out.println(fileName);
//            File f = new File(dir + fileName);
//            FileUtils.
//            FileUtils.copyURLToFile(httpurl, f);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Fault!";
//        }
//        return "Successful!";
//    }
//}


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class downloadOUI {
    String url = "http://standards.ieee.org/develop/regauth/oui/oui.txt";

    public static void main(String[] args) {
        String url = "http://standards.ieee.org/develop/regauth/oui/oui.txt";
        try (BufferedInputStream inputStream = new BufferedInputStream(new URL(url).openStream());
             FileOutputStream fileOS = new FileOutputStream("./OUI_files/oui.txt")) {
            byte data[] = new byte[10240];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 10240)) != -1) {
                fileOS.write(data, 0, byteContent);
            }
        } catch (IOException e) {
            // handles IO exceptions
        }

    }
}
package com.wj.MAC_Query.util;

import java.io.IOException;

public class runPython {
    public static void main(String[] args) {
        Process proc;

        {
            try {
                proc = Runtime.getRuntime().exec("ls -l");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

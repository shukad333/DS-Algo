package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

public class Perm {

    public static void main(String[] args) {

        Perm p = new Perm();
        List<String> resp = new ArrayList<>();
        p.perm("shu".toCharArray(), resp, new StringBuilder());
        System.out.println(resp);

    }


    void perm(char[] chars, List<String> resp, StringBuilder temp) {
        if (temp.length() == chars.length)
            resp.add(new String(temp.toString()));
        else {
            for (int i = 0; i < chars.length; i++) {
                if(temp.indexOf(chars[i]+"")!=-1)
                    continue;
                temp = temp.append(chars[i]);
                perm(chars, resp, temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
}

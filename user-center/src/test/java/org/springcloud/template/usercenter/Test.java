package org.springcloud.template.usercenter;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试
 *
 * @author zjx
 * @date 2020/7/10 0010 13:45
 */
public class Test {

    public static void main(String[] args) {

        String s = UUID.randomUUID().toString();
        System.out.println(s.length());
        System.out.println(s);

         /*Pattern p = Pattern.compile("[M,F]");
        Matcher matcher = p.matcher("MF");
        boolean b = matcher.matches();
        System.out.println(b);*/


        /*Pattern p = Pattern.compile("[0-1]{1}");
        Matcher matcher = p.matcher("1");
        boolean b = matcher.matches();
        System.out.println(b);*/
    }

}

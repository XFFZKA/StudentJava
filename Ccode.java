package com.heima.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ccode {
    public static void main(String[] args) {

        char[] charArray = {'1', '2', '3'};
        StringBuilder sb = new StringBuilder();

        for (char c : charArray) {
            sb.append(c); // 添加字符
        }

        String result = sb.toString(); // 转换为字符串
        System.out.println(result); // 输出: 123
        System.out.println(sb); // 输出: 123

        String realCode = new String(getCode());
        System.out.println(realCode);     //8HyEp

        String realCode2 = getCode().toString();
        System.out.println(realCode2);   //[C@b4c966a

        String realCode3 = Arrays.toString(getCode());
        System.out.println(realCode3);    //[j, 1, m, w, t]

        char[] realCode4 = getCode();
        System.out.println(realCode4);    //Bua3P
        System.out.println(getCode());    //NqQ3n
        String xxxx ="ssss";
        //xxxx.length()
        //www.length
        char[] www ={'1','2','3'};
        StringBuilder sb1 = new StringBuilder();
        sb.append('1');
        sb.append('2');
        System.out.println(sb1.toString());
        System.out.println(www.toString());
        System.out.println(www);
        System.out.println(new String(www));//123
        System.out.println(Arrays.toString(www));   //[1, 2, 3]

        char[] www3 ={'a','b','1'};
        System.out.println(www3);
        System.out.println(new String(www3));//abc
        System.out.println(Arrays.toString(www3));   //[a, b, c]

        int[] www2 ={1,2,3};

        System.out.println(Arrays.toString(www2));   //[I@2f4d3709

        char[] charArray1 = {'H', 'e', 'l', 'l', 'o'};
        String str = new String(charArray1);
        System.out.println(str); // 输出: Hello
    }

    private static char[] getCode() {
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char)('a'+i));
            list.add((char)('A'+i));
        }
        Random rand = new Random();
        char[] code = new char[5];
        for (int i = 0; i < 4; i++) {
            int randNum1 = rand.nextInt(list.size());
            code[i]=list.get(randNum1);
        }
        int randNum2 = rand.nextInt(48,58);
        code[4] = (char) randNum2;

        int randNum3 = rand.nextInt(4);
        char temp = code[randNum3];
        code[randNum3] = code[4];
        code[4] = temp;
        return code;
    }
}
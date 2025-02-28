package com.heima.array;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
    private String name;
    private int age;

    public ArrayListDemo() {
    }

    public ArrayListDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        String P="aaaaa";
        for (int i = 0; i < P.length()-1; i++) {
            char iii=P.charAt(i);
            if(iii<'0'||iii>'9'){
                return;
            }
        }

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String>  list2 = new ArrayList<>();
        list.add("aaa");
        boolean bbb = list.add("bbb");
        list.add(2,"xxx");
        list.remove("bbb");

        Scanner sc = new Scanner(System.in);
        String sss = sc.next();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);

        }
        for (int i = 0; i < list2.size(); i++) {
            String s = list2.get(i);
            System.out.println(list2);

        }
        list.remove("aaa");
        ArrayList<String>  list3 =new ArrayList<>();

        while (true) {
            ArrayList<String> list5 =new ArrayList<>();
            for (int i = 0; i < list3.size(); i++) {
                String s = list.get(i);
                System.out.println(s);
            }
        }


    }
}

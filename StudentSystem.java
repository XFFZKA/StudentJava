package com.heima.array;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void studentSystem() {
        Scanner sc =new Scanner(System.in);
        ArrayList<Student> list =new ArrayList<>();
        while (true) {
            System.out.println(" --欢迎来到ygh创建的学生管理系统--");
            System.out.println("|\t\t\t1.添加学生\t\t\t|");
            System.out.println("|\t\t\t2.修改学生\t\t\t|");
            System.out.println("|\t\t\t3.删除学生\t\t\t|");
            System.out.println("|\t\t\t4.查询学生\t\t\t|");
            System.out.println("|\t\t\t5.退出系统\t\t\t|");
            System.out.println(" -------------------------------");
            System.out.print("请输入您的选项：");
            String choose = sc.next();
            switch(choose){
                case "1" -> addStudent(list);
                case "2" -> updateStudent(list);
                case "3" -> deleteStudent(list);
                case "4" -> queryStudent(list);
                case "5" -> {
                    System.out.println("系统已经退出，欢迎下次使用！");
                    System.exit(0);
                }
                default -> System.out.println("没有这个选项，请重新选择!");
            }
        }
    }

    private static void queryStudent(ArrayList<Student> list) {
        System.out.println("id"+"\t\t"+"姓名"+"\t"+"年龄"+"\t"+"地址");
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            System.out.println(student.getId()+"\t\t"+student.getName() +"\t\t"+student.getAge()+"\t\t"+student.getAddress());
        }
        System.out.println("学生查询成功！");
        System.out.println(" ");
    }

    private static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        String id = null;
        int flag = 0;
        while (true) {
            System.out.print("请输入要删除的学生id:");
            id = sc.next();
            flag = checkIndex(list, id);
            if(flag==-1){
                System.out.println("输入的学生id不存在！请重新输入！");
                System.out.println(" ");
            }else{
                break;
            }
        }
        list.remove(flag);
        System.out.println("学生 "+ id +" 删除成功！");
        System.out.println(" ");
    }

    private static int checkIndex(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            String id1 = student.getId();
            if(id1.equals(id)){
                return i;
            }
        }
        return -1;
    }

    private static void updateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        String id = null;
        int flag = 0;
        while (true) {
            System.out.print("请输入要修改的学生id:");
            id = sc.next();
            flag = checkIndex(list, id);
            if(flag == -1){
                System.out.println("学生id不存在，请重新输入!");
            }else{
                break;
            }
        }
        System.out.print("请输入要修改的学生姓名：");
        String name = sc.next();

        System.out.print("请输入要修改的学生年龄：");
        int age = sc.nextInt();

        System.out.print("请输入要修改的学生地址：");
        String address = sc.next();

        Student stu =new Student(id,name,age,address);
        list.set(flag,stu);
        System.out.println("学生id " +id +" 修改完成！");
        System.out.println(" ");

    }

    private static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        String id;
        System.out.println("请输入添加的学生信息:");
        while (true) {
            System.out.print("请输入学生id:");
            id = sc.next();
            boolean flag = checkID(list, id);
            if(!flag){
                System.out.println("输入的id重复，请重新输入!");
                System.out.println(" ");
            }else{
                System.out.println("输入学生id " + id + " 成功！");
                break;
            }
        }
        System.out.print("请输入学生姓名:");
        String name =sc.next();
        System.out.print("请输入学生年龄:");
        int age =sc.nextInt();
        System.out.print("请输入学生地址:");
        String address =sc.next();

        Student student =new Student(id,name,age,address);
        list.add(student);
        System.out.println("学生id " +id +" 添加成功！");
        System.out.println(" ");
    }

    private static boolean checkID(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if(student.getId().equals(id)){
                return false;
            }
        }
        return true;
    }
}
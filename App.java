package com.heima.array;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome！欢迎来到ygh的学生管理系统！");
            System.out.println("系统选项： 1.登录  2.注册  3.忘记密码  4.退出 ");
            System.out.print("请选择你的选项：");

            String choose = sc.next();
            switch(choose){
                case "1"-> loginIN(list);
                case "2"-> registerIN(list);
                case "3"-> forgetIN(list);
                case "4"-> exitIN();
                default -> {
                    System.out.println("没有这个选项，请重新选择！");
                }
            }
        }
    }

    private static void registerIN(ArrayList<User> list) {
        Scanner sc =new Scanner(System.in);
        String username;
        while (true) {
            System.out.println("请输入用户名：（长度为5-10位，只由数字和字母组成）");
            username = sc.next();
            boolean result1 = isUsername(username);
            if(!result1){
                System.out.println("用户名格式错误，请重新输入！");
                continue;
            }
            boolean flag = checkUsername(list, username);
            if(!flag){
                System.out.println("用户名重复，请重新输入！");
            }else{
                System.out.println("用户名输入正确！");
                break;
            }
        }
        String password;
        while (true) {
            System.out.println("请输入密码：（长度为6-15位，可以为任何字符，但必须包括数字和字母）");
            password = sc.next();
            boolean flag = checkPassword(password);
            if(!flag){
                System.out.println("密码格式错误，请重新输入");
                continue;
            }
            System.out.println("请再次输入密码：");
            String password2 = sc.next();
            if(!password.equals(password2)){
                System.out.println("两次密码不一致，请重新输入！");
            }else{
                System.out.println("密码输入成功！");
                break;
            }
        }

        String personID;
        while (true) {
            System.out.println("请输入身份证号：");
            personID =sc.next();
            boolean flag = checkPersonID(personID);
            if(!flag){
                System.out.println("身份证号格式输入错误！请重新输入！");
            }else{
                System.out.println("身份证号输入成功！");
                break;
            }
        }

        String phoneNumber;
        while (true) {
            System.out.println("请输入手机号码(+86)：");
            phoneNumber =sc.next();
            boolean flag = checkPhoneNumber(phoneNumber);
            if(!flag){
                System.out.println("手机号码输入错误，请重新输入！");
            }else{
                System.out.println("手机号码输入正确！");
                break;
            }
        }
        User user = new User(username,password,personID,phoneNumber);
        list.add(user);
        System.out.println("用户添加成功！添加信息："+user.getUsername()+" "+user.getPassword()+" "+user.getPersonID()+" "+user.getPhoneNumber());
    }

    private static boolean checkPhoneNumber(String phoneNumber) {
        if(phoneNumber.length()!=11){
            return false;
        }
        if(phoneNumber.startsWith("0")){
            return false;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            char c = phoneNumber.charAt(i);
            if(c < '0'||c > '9'){
                return false;
            }
        }
        return true;
    }

    private static boolean checkPersonID(String personID) {
        if(personID.length() != 18){
            return false;
        }
        if(personID.startsWith("0")){
            return false;
        }
        if(!(personID.charAt(17)=='x' || personID.charAt(17)=='X'||(personID.charAt(17)>'0'&&personID.charAt(17)<'9'))){
            return false;
        }
        for (int i = 0; i < personID.length()-1; i++) {
            char c = personID.charAt(i);
            if(c < '0' || c > '9'){
                return false;
            }
        }
        return true;
    }

    private static boolean checkPassword(String password) {
        int countNumber = 0;
        int countByte = 0;
        if(password.length()<6||password.length()>15){
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
                countByte++;
            }
            if(c>='0'&&c<='9'){
                countNumber++;
            }
            if(countByte > 0 && countNumber > 0){
                return true;
            }
        }
        return false;
    }

    private static boolean checkUsername(ArrayList<User> list, String username) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            String username1 = user.getUsername();
            System.out.println(1);
            if(username1.equals(username)){
                System.out.println("用户名重复，请重新输入！");
                return false;
            }
        }
        return true;
    }

    private static boolean isUsername(String username) {
        if(username.length()<5 ||username.length()>10){
            return false;
        }
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if(!((c>='a'&&c<='z')||(c>='A'&&c<='Z')||(c>='0'&&c<='9'))){
                return false;
            }
        }
        int count=0;
        for (int i = 0; i < username.length(); i++) {
            char c = username.charAt(i);
            if((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
                count++;
                break;
            }
        }
        return count>0;
    }

    private static void loginIN(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);
        for(int j = 0; j < 3 ;j++) {
            System.out.println("请输入用户名：");
            String username = sc.next();
            System.out.println("请输入密码：");
            String password = sc.next();
            while (true) {
                String realCode = new String(getCode());
                System.out.println(realCode);
                System.out.println("请输入验证码：");
                String code = sc.next();
                if(!code.equalsIgnoreCase(realCode)){
                    System.out.println("验证码错误，请重新输入！");
                }else{
                    break;
                }
            }
            int flag = hasUsername(list,username);

            if(flag  == -1){
                System.out.println("用户未注册，请注册！");
                return;
            }
            User user = list.get(flag);
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                break;
            }

        }
        System.out.println("登录成功！");
        System.out.println(" ");
        StudentSystem SS =new StudentSystem();
        SS.studentSystem();

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

    private static int hasUsername(ArrayList<User> list,String username) {
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            String username1 = user.getUsername();
            if(username1.equals(username)){
                return i;
            }
        }
        return -1;
    }

    private static void forgetIN(ArrayList<User> list) {
        Scanner sc = new Scanner(System.in);

            System.out.println("请输入要修改的用户名：");
            String username = sc.next();
            int flag = hasUsername(list,username);

            if(flag  == -1){
                System.out.println("用户未注册，请注册！");
                return;
            }
            User user = list.get(flag);
            String personID;
            while (true) {
                System.out.println("请输入该用户名的身份证号：");
                personID = sc.next();
                boolean flagPersonID = checkPersonID(personID);
                if(!flagPersonID){
                    System.out.println("身份证号格式错误，请重新输入！");
                }else{
                    break;
                }
            }
        while (true) {
            String phoneNumber;
            while (true) {
                System.out.println("请输入该用户名的电话号码：");
                phoneNumber = sc.next();
                boolean flagPhoneNumber = checkPhoneNumber(phoneNumber);
                if(!flagPhoneNumber){
                    System.out.println("手机号码输入格式错误，请重新输入！");
                }else{
                    break;
                }
            }
            if(user.getPersonID().equals(personID) && user.getPhoneNumber().equals(phoneNumber)){
                String newPassword;
                String newPassword2;
                while (true) {
                    System.out.println("请输入该用户名的新密码：");
                    newPassword = sc.next();
                    boolean newFlagPassword = checkPassword(newPassword);
                    if(!newFlagPassword){
                        System.out.println("密码格式错误，请重新输入！");
                        continue;
                    }
                    System.out.println("请再次输入新密码：");
                    newPassword2 = sc.next();
                    if(!newPassword.equals(newPassword2)){
                        System.out.println("两次密码不一致，请重新输入！");
                    }else{
                        System.out.println("密码输入成功！");
                        break;
                    }
                }
                user.setPassword(newPassword);
                System.out.println("密码修改成功！");
                break;
            }else{
                System.out.println("输入的身份证号和手机号码不正确，请重新输入！");
            }
        }
    }

    private static void exitIN() {
        System.out.println("系统已经退出，欢迎下次使用！");
        System.exit(0);
    }
}
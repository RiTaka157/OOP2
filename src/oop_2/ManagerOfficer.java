/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class ManagerOfficer {

    private ArrayList<Officer> officer = new ArrayList<>();
    String Name;
    String Address;
    int age;
    String gender;

    void addOfficer() {
        int func = 0;
        Scanner cin = new Scanner(System.in);
        boolean isCheckValid = true;
        System.out.println("--------------------- THEM CAN BO -----------------------");
        System.out.println("1.Them ky su.");
        System.out.println("2.Them nhan vien.");
        System.out.println("3.Them cong nhan.");
        System.out.println("4.thoat.");
        do {
            try {
                isCheckValid = true;
                System.out.print("    Chuc nang: ");
                func = Integer.parseInt(cin.nextLine().trim());
                if (func < 1 || func > 4) {
                    System.out.println("Error: Ban chi co the chon trong nhung lua chon nay!");
                    isCheckValid = false;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Error: Ban chi co the chon trong nhung lua chon nay!");
                isCheckValid = false;
            }
        } while (isCheckValid == false);
        if (func != 4) {
            System.out.println("--------------------- THEM CAN BO -----------------------");
            do {
                isCheckValid = true;
                System.out.print("Hay nhap ten can bo: ");
                Name = cin.nextLine().trim();
                if (Name.isEmpty()) {
                    isCheckValid = false;
                    System.out.println("Error: Ten can bo khong duoc rong!");
                }
            } while (isCheckValid == false);

            do {
                isCheckValid = true;
                System.out.print("Hay nhap dia chi can bo: ");
                Address = cin.nextLine().trim();

                if (Address.isEmpty()) {
                    isCheckValid = false;
                    System.out.println("Error: Dia chi can bo khong duoc rong!");
                }
            } while (isCheckValid == false);

            do {
                isCheckValid = true;
                try {

                    System.out.print("Hay nhap tuoi cua can bo: ");
                    age = Integer.parseInt(cin.nextLine().trim());
                    if (age <= 0 || age > 70) {
                        System.out.println("Error: Tuoi cua can bo phai la mot so nguyen duoi 0 va lon hon 70!");
                        isCheckValid = false;
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Error: Tuoi cua can bo phai la mot so nguyen duoi 0 va lon hon 70!");
                    isCheckValid = false;
                }
            } while (isCheckValid == false);

            do {
                isCheckValid = true;
                System.out.print("Hay nhap gioi tinh cua can bo(nu/nam): ");
                gender = cin.nextLine().trim();
                if (!(gender.toLowerCase().equalsIgnoreCase("nu") || gender.toLowerCase().equalsIgnoreCase("nam"))) {
                    System.out.println("Error: Gioi tinh chi duoc la nu/nam!");
                    isCheckValid = false;
                }
            } while (isCheckValid == false);

            if (func == 1) {
                String branch;
                do {
                    isCheckValid = true;
                    System.out.print("Hay nhap nganh hoc cua ky su: ");
                    branch = cin.nextLine().trim();
                    if (branch.isEmpty()) {
                        System.out.println("Error: Nganh hoc cua ky su khong duoc rong!");
                        isCheckValid = false;
                    }
                } while (isCheckValid == false);
                officer.add(new Engineer(Name, Address, age, gender, branch));
            } else if (func == 2) {
                String task;
                do {
                    isCheckValid = true;
                    System.out.print("Hay nhap cong viec cua nhan vien: ");
                    task = cin.nextLine().trim();
                    if (task.isEmpty()) {
                        System.out.println("Error: Cong viec cua nhan vien khong duoc rong!");
                        isCheckValid = false;
                    }
                } while (isCheckValid == false);
                officer.add(new Staff(Name, Address, age, gender, Address));
            } else {
                int leve = 0;
                do {
                    isCheckValid = true;
                    try {
                        System.out.print("Hay nhap bac cua cong nhan ( 1 - 10): ");
                        leve = cin.nextInt();
                        if (leve < 1 || leve > 10) {
                            System.out.println("Error: Bac cua cong nhan phai la mot so nguyen tu 1 den 10!");
                            isCheckValid = false;
                        }
                    } catch (InputMismatchException E) {
                        System.out.println("Error: Bac cua cong nhan phai la mot so nguyen tu 1 den 10!");
                        isCheckValid = false;
                    }
                } while (isCheckValid == false);
                officer.add(new Worker(Name, Address, age, gender, leve));

            }
            System.out.println("Da them thanh cong!!!");

        }

    }

    void display(ArrayList<Officer> a) {
        ArrayList<Officer> b = new ArrayList<>();
        b = (ArrayList<Officer>) a.clone();
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|             Ten              |     dia chi   | Tuoi |Gioi tinh|");
        System.out.println("+------------------------------+---------------+------|---------+");
        for (Officer officer1 : b) {
            System.out.printf("|%-30s|%-15s|   %3d|%9s|\n", officer1.getName(), officer1.getAddress(), officer1.getAge(), officer1.gender);
        }
        System.out.println("+---------------------------------------------------------------+");
        b.clear();

    }

    void showListInforOfficer() {
        display(officer);
    }

    void searchOfficerByName() {
        String key;
        Scanner cin = new Scanner(System.in);
        ArrayList<Officer> c = new ArrayList<>();
        do {
            System.out.println("Nhap vao ten ban muon tim kiem: ");
            key = cin.nextLine().trim().toLowerCase();
        } while (key.equalsIgnoreCase(""));

        for (Officer officer1 : officer) {
            if (officer1.getName().toLowerCase().contains(key)) {
                c.add(officer1);
            }
        }
        if (!c.isEmpty()) {
            display(c);
            c.clear();
        } else{
            System.out.println("Khong tim thay ten can bo!");
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int func = 0;
        boolean isCheckValid = true;
        ManagerOfficer office = new ManagerOfficer();
        Scanner cin = new Scanner(System.in);
        do {
            System.out.println("--------------------- MANAGER OFFICER -----------------------");
            System.out.println("1.Them moi can bo.");
            System.out.println("2.Tim kiem theo ho ten.");
            System.out.println("3.Hien thi thong tin ve danh sach cac can bo.");
            System.out.println("4.Thoat.");
            do {
                try {
                    isCheckValid = true;
                    System.out.print("    Chuc nang: ");
                    func = Integer.parseInt(cin.nextLine().trim());
                } catch (NumberFormatException ex) {
                    System.out.println("Error: Ban chi co the chon trong nhung lua chon nay!");
                    isCheckValid = false;
                }
            } while (isCheckValid == false);
            switch (func) {
                case 1:
                    office.addOfficer();
                    office.showListInforOfficer();
                    cin.nextLine();
                    break;
                case 2:
                    office.searchOfficerByName();
                    cin.nextLine();
                    break;
                case 3:
                    office.showListInforOfficer();
                    cin.nextLine();
                    break;
                default:
                    if (func != 4) {
                        System.out.println("Error: Ban chi co the chon trong nhung lua chon nay!");
                    }

            }
        } while (func != 4);
        System.out.println("Cam on ban da su dung! Tam biet!");
    }

}

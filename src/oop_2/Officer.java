/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_2;

/**
 *
 * @author ACER
 */
public class Officer {
    String Name;
    String Address;
    int age;
    String gender;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Officer(String Name, String Address, int age, String gender) {
        this.Name = Name;
        this.Address = Address;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Officer{" + "Name=" + Name + ", Address=" + Address + ", age=" + age + ", gender=" + gender + '}';
    }


    
    
}

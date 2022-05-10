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
public class Staff extends Officer {

    String task;

    public Staff(String Name, String Address, int age, String gender, String task) {
        super(Name, Address, age, gender);
        this.task = task;
    }




    
}

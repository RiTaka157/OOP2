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
public class Engineer extends Officer {

    String branch;

    public Engineer(String Name, String Address, int age, String gender, String branch) {
        super(Name, Address, age, gender);
        this.branch = branch;
    }


    }

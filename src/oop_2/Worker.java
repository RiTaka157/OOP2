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
public class Worker extends Officer {

    int leve;

    public Worker(String Name, String Address, int age, String gender, int leve) {
        super(Name, Address, age, gender);
        this.leve = leve;
    }

  

}

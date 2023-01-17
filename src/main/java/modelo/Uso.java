/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author fl_va
 */
public class Uso {
    /*
     "andar": 11,
        "elevador": "A",
        "turno": "M"
    */
    public Integer andar;
    public char elevador;
    public char turno;
    
    @Override
    public String toString(){
        return " Elevador:" + this.elevador + " Andar" + this.andar + " Turno: " + this.turno;
    }
}

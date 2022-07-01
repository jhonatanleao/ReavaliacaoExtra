/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jhonatan
 */
public class Imposto {
    private String tipo;
    private double porcentagemImposto;
    private double valorImposto;

    public Imposto(String tipo, double porcentagemImposto, double valorImposto) {
        this.tipo = tipo;
        this.porcentagemImposto = porcentagemImposto;
        this.valorImposto = valorImposto;
    }

    @Override
    public String toString() {
        return "Imposto{" + "tipo=" + tipo + ", porcentagemImposto=" + porcentagemImposto + ", valorImposto=" + valorImposto + '}';
    }

    public double getValorImposto() {
        return valorImposto;
    }

    
}

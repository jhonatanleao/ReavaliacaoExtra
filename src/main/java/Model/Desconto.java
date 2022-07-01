/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jhonatan
 */
public class Desconto {
    private String tipo;
    private double porcentagemDesconto;
    private double valorDesconto;

    public Desconto(String tipo, double porcentagemDesconto, double valorDesconto) {
        this.tipo = tipo;
        this.porcentagemDesconto = porcentagemDesconto;
        this.valorDesconto = valorDesconto;
    }
    
    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return porcentagemDesconto;
    }

    public double getPorcentagemDesconto() {
        return porcentagemDesconto;
    }

    public double getValorDesconto() {
        return valorDesconto;
    } 

    @Override
    public String toString() {
        return "Desconto{" + "tipo=" + tipo + ", porcentagemDesconto=" + porcentagemDesconto + ", valorDesconto=" + valorDesconto + '}';
    }
    
    
}

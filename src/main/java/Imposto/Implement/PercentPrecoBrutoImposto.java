/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Imposto.Implement;

import Imposto.IMetodoImposto;
import Model.Desconto;
import Model.Imposto;
import Model.Pedido;

/**
 *
 * @author jhonatan
 */
public class PercentPrecoBrutoImposto implements IMetodoImposto{
    private String nome;
    private double procentagemImposto;

    public PercentPrecoBrutoImposto(String nome, double procentagemImposto) {
        this.nome = nome;
        this.procentagemImposto = procentagemImposto;
    }
    
    @Override
    public void calcular(Pedido pedido) {
        double valorDesconto=0;
        
        valorDesconto = pedido.getValorBruto() * procentagemImposto;
        pedido.setListImposto(new Imposto(nome, procentagemImposto, valorDesconto));
    }
    
}

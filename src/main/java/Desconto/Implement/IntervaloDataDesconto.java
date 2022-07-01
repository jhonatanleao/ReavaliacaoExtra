/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Desconto.Implement;

import Desconto.IMetodoDesconto;
import Model.Desconto;
import Model.Pedido;
import java.time.LocalDate;

/**
 *
 * @author jhonatan
 */
public class IntervaloDataDesconto implements IMetodoDesconto{
    private String nome;
    private double procentagemDesconto;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public IntervaloDataDesconto(String nome, double procentagemDesconto, LocalDate dataInicio, LocalDate dataFim) {
        this.nome = nome;
        this.procentagemDesconto = procentagemDesconto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }
    
    @Override
    public void calcular(Pedido pedido) {
        double valorDesconto=0;
        LocalDate dataPedido = pedido.getDataPedido();
        
        if(dataPedido.isAfter(dataInicio)){
            if(dataPedido.isBefore(dataFim)){
                valorDesconto = pedido.getValorBruto() * procentagemDesconto;
                pedido.setListDesconto(new Desconto(nome, procentagemDesconto, valorDesconto));
            }
        }

    }
    
    
}

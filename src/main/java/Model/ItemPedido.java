/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javax.swing.JOptionPane;

/**
 *
 * @author jhonatan
 */
public class ItemPedido {
    private Produto produto;
    private int qtdPedido;
    private double valorUnitario;
    private double valorTotal;

    public ItemPedido(Produto produto, int qtdPedido, double valorUnitario) {
        try{
            this.produto = produto;
            this.qtdPedido = 0;
            this.valorUnitario = valorUnitario;
            this.valorTotal = 0;
            aumentaQtd(qtdPedido);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public void aumentaQtd(int qtd){
        if(this.produto.retiraEstoque(qtd)){
            this.qtdPedido += qtd;
            this.valorTotal = this.qtdPedido * this.valorUnitario;
        } 
    }
    
    public void diminuiQtd(int qtd){
        this.qtdPedido -= qtd;
        this.valorTotal = this.qtdPedido * this.valorUnitario;
        this.produto.adcEstoque(qtd);
    }

    public Produto getProduto() {
        return produto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return "ItemPedido{" + "produto=" + produto + ", qtdPedido=" + qtdPedido + ", valorUnitario=" + valorUnitario + ", valorTotal=" + valorTotal + '}';
    }
    
}

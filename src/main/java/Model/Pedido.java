/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author jhonatan
 */
public class Pedido {
    private String nomeCliente;
    private LocalDate dataPedido;
    private double valorTotal;
    private double valorBruto;
    private ArrayList<ItemPedido> listItemPedido;
    private ArrayList<Imposto> listImposto;
    private ArrayList<Desconto> listDesconto;

    public Pedido(String nomeCliente, LocalDate dataPedido, ArrayList<ItemPedido> listItemPedido, ArrayList<Imposto> listImposto, ArrayList<Desconto> listDesconto) {
        this.nomeCliente = nomeCliente;
        this.dataPedido = dataPedido;
        this.valorBruto = 0;
        this.listItemPedido = listItemPedido;
        this.listImposto = listImposto;
        this.listDesconto = listDesconto;
        calculaPrecoBruto();
        this.valorTotal = this.valorBruto;        
    }
    
    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setListDesconto(Desconto desconto) {
        this.listDesconto.add(desconto);
    }

    public void setListImposto(Imposto imposto) {
        this.listImposto.add(imposto);
    }
    
    public ArrayList<ItemPedido> getListItemPedido() {
        return listItemPedido;
    }

    public double getValorBruto() {
        return valorBruto;
    }
    
    public void calculaPrecoBruto(){
        for(ItemPedido itemPedido : listItemPedido){
            this.valorBruto += itemPedido.getValorTotal();
        }
    }

    public ArrayList<Imposto> getListImposto() {
        return listImposto;
    }

    public ArrayList<Desconto> getListDesconto() {
        return listDesconto;
    }

    @Override
    public String toString() {
        return "Pedido{" + "nomeCliente=" + nomeCliente + ", dataPedido=" + dataPedido + ", valorTotal=" + valorTotal + ", valorBruto=" + valorBruto + ", listItemPedido=" + listItemPedido + ", listImposto=" + listImposto + ", listDesconto=" + listDesconto + '}';
    }
    
    public void subtraiDesconto(){
        for(Desconto desconto : listDesconto){
            this.valorTotal -= desconto.getValorDesconto();
        }
    }
    
    public void somaImposto(){
        for(Imposto imposto : listImposto){
            this.valorTotal += imposto.getValorImposto();
        }
    }
}

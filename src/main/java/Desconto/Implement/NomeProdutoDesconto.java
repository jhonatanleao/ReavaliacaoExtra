/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Desconto.Implement;

import Desconto.IMetodoDesconto;
import Model.Desconto;
import Model.ItemPedido;
import Model.Pedido;
import Model.Produto;
import java.util.ArrayList;

/**
 *
 * @author jhonatan
 */
public class NomeProdutoDesconto implements IMetodoDesconto{
    private String nomeDesconto;
    private String nomeProduto;
    private double procentagemDesconto;
    private int flag;

    public NomeProdutoDesconto(String nomeDesconto, String nomeProduto, double procentagemDesconto) {
        this.nomeDesconto = nomeDesconto;
        this.nomeProduto = nomeProduto;
        this.procentagemDesconto = procentagemDesconto;
        this.flag = 0;
    }
    
    @Override
    public void calcular(Pedido pedido) {
        double valorDesconto=0, precoBruto=0;
        ArrayList<ItemPedido> listItem = pedido.getListItemPedido();
        
        for(ItemPedido itemPedido : listItem){
            Produto produto = itemPedido.getProduto();
            
            if(produto.verificaNomeProduto(nomeProduto)){
                precoBruto += itemPedido.getValorTotal();
                this.flag = 1;
            }
        }
        
        if(flag == 1){
            valorDesconto = precoBruto * procentagemDesconto;
            pedido.setListDesconto(new Desconto(nomeDesconto, procentagemDesconto, valorDesconto));
            flag = 0;
        }        
    }
    
}

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
public class CategoriaProdutoDesconto implements IMetodoDesconto{
    private String nomeDesconto;
    private double procentagemDesconto;
    private ArrayList<String> listCategoria;
    

    public CategoriaProdutoDesconto(String nomeDesconto, double procentagemDesconto, ArrayList<String> listCategoria) {
        this.nomeDesconto = nomeDesconto;
        this.procentagemDesconto = procentagemDesconto;
        this.listCategoria = listCategoria;
    }
    
    @Override
    public void calcular(Pedido pedido) {
        int flag=0;
        double valorDesconto=0, precoBruto=0;
        ArrayList<ItemPedido> listItem = pedido.getListItemPedido();
        
        for(ItemPedido itemPedido : listItem){
            Produto produto = itemPedido.getProduto();
            
            for(String categoriaDesconto : listCategoria){
                if(produto.verificaCategoria(categoriaDesconto)){
                    precoBruto += itemPedido.getValorTotal();
                    flag = 1;
                }                
            }            
        }
        
        if(flag == 1){
            valorDesconto = precoBruto * procentagemDesconto;
            pedido.setListDesconto(new Desconto(nomeDesconto, procentagemDesconto, valorDesconto));
            flag = 0;
        }  
    }
    
}

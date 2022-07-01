/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Initializer;

import Desconto.IMetodoDesconto;
import Desconto.Implement.CategoriaProdutoDesconto;
import Desconto.Implement.IntervaloDataDesconto;
import Desconto.Implement.NomeProdutoDesconto;
import Imposto.IMetodoImposto;
import Imposto.Implement.PercentPrecoBrutoImposto;
import Model.Desconto;
import Model.Imposto;
import Model.ItemPedido;
import Model.Pedido;
import Model.Produto;
import Services.PedidoService;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author jhonatan
 */
public class Init {

    public static void main(String[] args) {
        ArrayList<ItemPedido> listItemPedido = new ArrayList();
        ArrayList<Imposto> listImposto = new ArrayList();
        ArrayList<IMetodoImposto> listMetodoImposto = new ArrayList(); 
        ArrayList<IMetodoDesconto> listMetodoDesconto = new ArrayList();
        ArrayList<Desconto> listDesconto = new ArrayList();
        ArrayList<String> listCategoria = new ArrayList();
        
        LocalDate dataPedido = LocalDate.parse("2022-12-23");
        LocalDate dataInicio = LocalDate.parse("2022-12-20");
        LocalDate dataFim = LocalDate.parse("2022-12-26");
        
        Produto papel = new Produto("Papel A4", 15, 20, "Papelaria");
        Produto caneta = new Produto("Caneta", 7, 20, "Papelaria");
        Produto borracha = new Produto("Borracha", 2, 20, "Papelaria");
        Produto lapis = new Produto("Lápis 0.7", 1.2, 20, "Papelaria");
        Produto faca = new Produto("Faca", 30.50, 20, "Cozinha");
        
        ItemPedido papelPedido = new ItemPedido(papel, 5, 15);
        ItemPedido canetaPedido = new ItemPedido(caneta, 6, 7);
        ItemPedido borrachaPedido = new ItemPedido(borracha, 6, 2);
        ItemPedido lapisPedido = new ItemPedido(lapis, 6, 1.2);
        //ItemPedido facaPedido = new ItemPedido(faca, 6, 30.10);
        
        listItemPedido.add(papelPedido);
        listItemPedido.add(canetaPedido);
        listItemPedido.add(borrachaPedido);
        listItemPedido.add(lapisPedido);
        //listItemPedido.add(facaPedido);
        
        Pedido pedido1 = new Pedido("Fulano de Tal", dataPedido, listItemPedido, listImposto, listDesconto);
        
        listCategoria.add("Papelaria");   
        listCategoria.add("Casa");  
        IMetodoDesconto tipoProduto = new CategoriaProdutoDesconto("Desconto por tipo de produto (Papelaria)", 0.01, listCategoria);
        IMetodoDesconto incentivoEdu = new NomeProdutoDesconto("Desconto incentivo educação (Lápis)", "Lápis" , 0.005);
        IMetodoDesconto natal = new IntervaloDataDesconto("Promocao de Natal", 0.03, dataInicio, dataFim);
            
        listMetodoDesconto.add(tipoProduto);
        listMetodoDesconto.add(incentivoEdu);
        listMetodoDesconto.add(natal);
        
        IMetodoImposto ISS = new PercentPrecoBrutoImposto("ISS", 0.02);
        IMetodoImposto ICMS = new PercentPrecoBrutoImposto("ICMS", 0.07);
        
        listMetodoImposto.add(ISS);
        listMetodoImposto.add(ICMS);  
        
        PedidoService pedidoService = new PedidoService(listMetodoDesconto, listMetodoImposto);
        
        pedidoService.processarDescontos(pedido1);
        
        ArrayList<Desconto> listDesconto2 = pedido1.getListDesconto();
        
        for(Desconto desconto : listDesconto2){
            System.out.println(desconto);
        }  
        
        pedidoService.processarImposto(pedido1);
        
        ArrayList<Imposto> listImposto2 = pedido1.getListImposto();
        
        for(Imposto imposto : listImposto2){
            System.out.println(imposto);
        }
        
        pedido1.subtraiDesconto();
        pedido1.somaImposto();
        
        System.out.println(pedido1);
    }
}

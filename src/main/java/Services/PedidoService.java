/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Desconto.IMetodoDesconto;
import Imposto.IMetodoImposto;
import Model.Pedido;
import java.util.ArrayList;

/**
 *
 * @author jhonatan
 */
public class PedidoService {
    private ArrayList<IMetodoDesconto> metodoDesconto;
    private ArrayList<IMetodoImposto> metodoImposto;

    public PedidoService(ArrayList<IMetodoDesconto> metodoDesconto, ArrayList<IMetodoImposto> metodoImposto) {
        this.metodoDesconto = metodoDesconto;
        this.metodoImposto = metodoImposto;
    }
    
    public void processarDescontos(Pedido pedido){
        if(!this.metodoDesconto.isEmpty()){
            for(IMetodoDesconto desconto : this.metodoDesconto){
                desconto.calcular(pedido);
            }
        }
    }    
    
    public void processarImposto(Pedido pedido){       
        if(!this.metodoImposto.isEmpty()){
            for(IMetodoImposto imposto : this.metodoImposto){
                imposto.calcular(pedido);
            }
        }
    } 
}

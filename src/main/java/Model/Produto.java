/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jhonatan
 */
public class Produto {
    private String nome;
    private double precoUnitario;
    private int qtdEstoque;
    private String categoria;
    

    public Produto(String nome, double precoUnitario, int qtdEstoque, String categoria) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
        this.qtdEstoque = qtdEstoque;
        this.categoria = categoria;
    }

    
    public boolean retiraEstoque(int qtd){

        if(this.qtdEstoque > qtd){
            this.qtdEstoque -= qtd;
            return true;
        }else{
            throw new RuntimeException("Não tem estoque suficiente");
        }

    }
    
    public void adcEstoque(int qtd){
        this.qtdEstoque += qtd; 
    }
    
    public boolean verificaCategoria(String categoria){
        return this.categoria.contentEquals(categoria);
    }
    
    public boolean verificaNomeProduto(String nome){
        return this.nome.contains(nome);   
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", precoUnitario=" + precoUnitario + ", qtdEstoque=" + qtdEstoque + ", categoria=" + categoria + '}';
    }
    
    
}

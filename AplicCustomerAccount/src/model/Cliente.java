/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Tamie
 */
public class Cliente {
    private int id;
    private String cpfCnpj, nome;
    private String ativo;
    private double valorTotal;
    
    public Cliente(int id, String cpfCnpj, String nome){
        this.id = id;
        this.cpfCnpj = cpfCnpj;
        this.nome = nome;
    }
    public int getId(){
        return(id);
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getAtivo() {
        return ativo;
    }

    public double getValorTotal() {
        return valorTotal;
    }
    
    public void setAtivo(String ativo){
        this.ativo = ativo;
    }
    public void setValorTotal(double valor){
        valorTotal = valor;
    }
    
}

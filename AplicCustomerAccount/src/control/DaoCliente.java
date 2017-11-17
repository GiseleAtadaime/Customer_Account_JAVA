/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Cliente;

/**
 *
 * @author Tamie
 */

public class DaoCliente {

    private Connection conn;
    
    public DaoCliente(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO TB_CUSTOMER_ACCOUNT( id_customer, cpf_cnpj, nm_customer, is_active, vl_total) VALUES(?,?,?,?,?)");
            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getCpfCnpj());
            ps.setString(3, cliente.getNome());
            ps.setString(4,cliente.getAtivo());
            ps.setDouble(5, cliente.getValorTotal());
                      
            ps.execute();
            conn.commit();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tb_customer_account set cpf_cnpj = ?,nm_customer = ?,is_active = ?,vl_total = ? " +
                                                 "where id_customer = ?");
            
            ps.setString(1, cliente.getCpfCnpj());
            ps.setString(2, cliente.getNome());
            ps.setString(3, String.valueOf(cliente.getAtivo()));
            ps.setDouble(4, cliente.getValorTotal());
            ps.setInt(5, cliente.getId());
           
            ps.execute();
            conn.commit();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public  Double consultarMedia() {
        double media = 0;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT avg(vl_total) as media from tb_customer_account where " +
                                                 "id_customer between 1500 and 2700 and vl_total > 560");
            
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
               media = rs.getDouble("media");
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (media);
    }    
     public  Double consultarMediaFinal() {
        double media = 0;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT avg(vl_total) as media from tb_customer_account");
            
            ResultSet rs = ps.executeQuery();
           
            if (rs.next() == true) {
               media = rs.getDouble("media");
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (media);
    }  
     public  ArrayList<Cliente> consultarClientes(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps = null;
        int i = 0;
        try {
            ps = conn.prepareStatement("SELECT * from tb_customer_account where " +
                                                 "id_customer between 1500 and 2700 and vl_total > 560" + 
                                                "order by vl_total");
            
            ResultSet rs = ps.executeQuery();
           
            while (rs.next() == true) {
               clientes.add(new Cliente(rs.getInt("id_customer"),rs.getString("cpf_cnpj"),rs.getString("nm_customer")));
               clientes.get(i).setAtivo(rs.getString("is_active"));
               clientes.get(i).setValorTotal(rs.getDouble("vl_total"));
               i++;
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (clientes);
    } 
     
     public void excluir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tb_customer_account where id_customer = ?");
            
            ps.setInt(1, cliente.getId());
                      
            ps.execute();
            conn.commit();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}


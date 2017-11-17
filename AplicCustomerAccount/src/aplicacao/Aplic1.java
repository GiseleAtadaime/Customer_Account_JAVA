/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import control.Conexao;
import control.DaoCliente;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author Tamie
 */
public class Aplic1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DaoCliente daoCliente=null;
        Conexao conexao=null;
        ArrayList<Cliente> clientes = new ArrayList<>();
        int i=0;
        
        //Conectando com o banco de dados Oracle 11g
        conexao = new Conexao("bd1","bd1");
        conexao.setDriver("oracle.jdbc.driver.OracleDriver");
        conexao.setConnectionString("jdbc:oracle:thin:@localhost:1521:xe");
        daoCliente = new DaoCliente(conexao.conectar());
        
        //Inserindo clientes
        clientes.add(new Cliente(2,"111.222.333-44","Fernando Fernandes"));
        clientes.get((clientes.size()-1)).setAtivo("Y");
        clientes.get((clientes.size()-1)).setValorTotal(1200);
        
        clientes.add(new Cliente(3,"888.444.555-12","Pedro Rocha"));
        clientes.get((clientes.size()-1)).setAtivo("Y");
        clientes.get((clientes.size()-1)).setValorTotal(1590.90);
        
        clientes.add(new Cliente(4,"222.777.444-90","Rodrigo Rodrigues"));
        clientes.get(clientes.size()-1).setAtivo("N");
        clientes.get(clientes.size()-1).setValorTotal(870.90);
        
        clientes.add(new Cliente(1200,"123.456.234-90","Fabio Barros"));
        clientes.get((clientes.size()-1)).setAtivo("N");
        clientes.get((clientes.size()-1)).setValorTotal(580.99);
        
        clientes.add(new Cliente(2000,"876.654.098-89","Carlos Pereira"));
        clientes.get((clientes.size()-1)).setAtivo("Y");
        clientes.get((clientes.size()-1)).setValorTotal(2390.56);
        
        clientes.add(new Cliente(2700,"897.434.661-36","Franco Moura"));
        clientes.get(clientes.size()-1).setAtivo("Y");
        clientes.get(clientes.size()-1).setValorTotal(480);
        
        clientes.add(new Cliente(1250,"545.623.412-98","Carlos Souza"));
        clientes.get((clientes.size()-1)).setAtivo("Y");
        clientes.get((clientes.size()-1)).setValorTotal(1080.70);
        
        clientes.add(new Cliente(1809,"096.645.423-11","Lucas Leandro"));
        clientes.get((clientes.size()-1)).setAtivo("Y");
        clientes.get((clientes.size()-1)).setValorTotal(1429);
        
        clientes.add(new Cliente(4299,"483.358.321-55","Moacir Rocha"));
        clientes.get(clientes.size()-1).setAtivo("Y");
        clientes.get(clientes.size()-1).setValorTotal(720);
        
        //Inserindo clientes no banco
        while(i < clientes.size()){
            daoCliente.inserir(clientes.get(i));
            i++;
        }
        i=0;
        
        
        //Exibindo a media apenas dos 1500 < ids < 2700 e saldo > 560
        System.out.println("\n\nMedia : R$" + daoCliente.consultarMedia());
        
        //exibindo a media de todos os clientes
        System.out.println("\nMedia Final: R$" + daoCliente.consultarMediaFinal()+"\n\n");
        
        //Exibindo todos os clientes que obedecem aos critérios da primeira pesquisa
        clientes = daoCliente.consultarClientes();
        if(clientes.isEmpty()){
            System.out.println("Nenhuma linha selecionada!");
        }
        else{
            while(i < clientes.size()){  
                System.out.printf("\nID:  " +  clientes.get(i).getId());
                System.out.println("\tCPF/CNPJ: " + clientes.get(i).getCpfCnpj() +  "   Nome: " + clientes.get(i).getNome());
                System.out.println("Ativo: "+clientes.get(i).getAtivo() + "   Saldo:  " + clientes.get(i).getValorTotal());
                i++;
            }
        }
        conexao.fecharConexao();
        
    }
    
}

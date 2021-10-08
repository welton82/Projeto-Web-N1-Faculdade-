/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.util.*;
import java.util.List;
import java.util.Scanner;
import model.dao.DCadastro;
import entity.ECadastro;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Recepçao
 */
public class Program {
    
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DCadastro dc = new DCadastro();
        ECadastro ec = new ECadastro();
        Date data= new Date();
        
        Scanner scan = new Scanner(System.in);
        
        
         
        System.out.print("Informe nome do Paciente: ");
        ec.setNome(scan.nextLine());
        System.out.print("Informe o CPF: ");
        ec.setCpf(scan.next());      
        
        System.out.print("Informe o Ano de nascimento: ");
        ec.setAnoNacimento(scan.nextInt());
        scan.nextLine();
       
        
       
        System.out.print("Informe a Data Da Primeira Dose: ");
        String dat = scan.next();
        ec.setDataPrimeiraDose(dat);
        data = sdf.parse(dat);
        java.sql.Date sql_Date = convertDate(data);
        //ec.setDataPrimeiraDose(sql_Date);
        System.out.print("Informe a Data Da Segunda Dose: ");
        dat = scan.next();
        data = sdf.parse(dat);
        sql_Date = convertDate(data);
       // ec.setDataSegundaDose(sql_Date);
        
        System.out.print("(booleano) Vacinou? true - false: ");
        boolean b = scan.nextBoolean();
        ec.setVacinou(b);
    
        // System.out.print("1ª Dose? [s ou n]: ");
        //ec.setPrimeiraDose(scan.nextLine().charAt(0));
        
        dc.incluir(ec);
        //dc.alterar(ec);
        System.out.print("");
  
        
       
            
           
        System.out.println("===== Listando Cadastro de Pessoas ========\n");
        List<ECadastro> lista = dc.listar();
        for(ECadastro x:lista){
            System.out.println("Codigo: "+x.getCodigo());
            System.out.println("Nome: " + x.getNome());
            System.out.println("Ano de Nascimento " + x.getAnoNacimento());
            System.out.println("CPF: " + x.getCpf());
            System.out.println("data Primeira Dose " + x.getDataPrimeiraDose());
            System.out.println("data Segunda Dose: " + x.getDataSegundaDose());
            System.out.println("Vacinou: " + x.getVacinou());
            
            System.out.println();
            
        }
        /*
        System.out.print("Codigo a ser Consultado: ");
        int codigo = scan.nextInt();
        
        ec = dc.consultar(codigo);
       
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + ec.getNome());
        System.out.println("Cpf: " + ec.getCpf());
        System.out.println("Ano Nascimento: " + ec.getAnoNacimento());
        System.out.println("Vacinou? " + ec.getVacinou());
        System.out.println("Data 1ªDose: " + ec.getDataPrimeiraDose());
        System.out.println("Data 2ªDose: " + ec.getDataSegundaDose());
        
     /*  /*
        System.out.print("Codigo a ser alterado: ");
        ep.setCodigo(scan.nextInt());
        scan.nextLine();
        System.out.print("Nome do produto: ");
        ep.setNome(scan.nextLine());
        System.out.print("Informe a quantidade: ");
        ep.setQuantidade(scan.nextInt());
        
        dp.alterar(ep);
        lista = dp.listar();
         for(EProduto x:lista){
            System.out.println("Nome: " + x.getNome());
            System.out.println("Codigo: "+x.getCodigo());
            System.out.println("Quantidade: "+ x.getQuantidade());
            System.out.println();
            
        }
      */  
    }
    //CRIEI ESTA CLASSE PARA TRANSFORMAR DATE EM SQL.DATE
    //POIS O SQL NÃO ACEITA TIPO DATE INSERIDOS DIRETAMENTE NO BANCO DE DADOS
    private static java.sql.Date convertDate(java.util.Date date){
        java.sql.Date myDate = new java.sql.Date(date.getTime());
        return myDate;
    }
    
}



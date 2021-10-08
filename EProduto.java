/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author welton
 */
public class EProduto {
    Integer codigo;
    
    String  nome;
    
    
    //Date dataSegundaDose;
    //Date dataPrimeiraDose;
    Date dataPrimeira;
    
    
    Boolean vacinou;
    
    Integer anoNacimento;
    
    
    
    
    public EProduto() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   

    public Date getDataPrimeira() {
        return dataPrimeira;
    }

    public void setDataPrimeira(Date dt){
        this.dataPrimeira =  dt;
    }
}
/*



*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.List;
import model.dao.DCadastro;
import entity.ECadastro;

/**
 *
 * @author Recepçao
 */
public class BCadastro {
     private DCadastro dao;

    public BCadastro() {
        dao = new DCadastro();
    }
     
    //validação de dados do produto
    public void salvar (ECadastro cadastro) throws Exception {
        
      
        validarProduto(cadastro);
        //se código nao preenchido
        if(cadastro.getCodigo() == 0 || cadastro.getCodigo()==null){
            dao.incluir(cadastro);
            
        }else{
            dao.alterar(cadastro);
        }
        
    }

    private void validarProduto(ECadastro cadastro) throws Exception {
          if(cadastro.getNome() == null){
            throw new Exception("Necessário Preencher o nome");

        }
        if(cadastro.getNome().isEmpty()){
            throw new Exception("Necessário Preencher o nome");
        }
       /* if(cadastro.getQuantidade() == 0){
            throw new Exception("quantidade não pode ser igual a zero");
            
        }*/
    }
     
    public void excluir(int codigo){
        dao.excluir(codigo);
    }
    public ECadastro consultar(int codigo){
        return dao.consultar(codigo);
    }
    public List<ECadastro>listar(){
        return dao.listar();
    }
     
}



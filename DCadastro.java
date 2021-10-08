package model.dao;

/**
 *
 * @author welton
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.EProduto;
import java.sql.Date;
import java.text.SimpleDateFormat;
import util.Conexao;
import util.Conexao;

public class DCadastro {
    private Connection cnn;

    public DCadastro() {
        this.cnn = Conexao.getConnection();
    }
    
    
    
    public void incluir(EProduto produto){
        try{
            String sql = "INSERT INTO " + 
              "cadastro(nome, dataPrimeira) VALUES(?,?);";
            //
            PreparedStatement prds = cnn.prepareStatement(sql);
            
            prds.setString(1,produto.getNome());
            
            prds.setDate(2, (Date) produto.getDataPrimeira());
            
            //prds.setLong(parameterIndex, x);
            //CHAR DATE e BOOLEAN ESTÃO DANDO PROBLEMAS NESSE MÉTODO 
            //PARA RELIZAR O ENVIO PARA O POSGRES
            
            //Dificuldade em enviar o char para o banco
            
            prds.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void alterar(EProduto produto){
        try{
            
            String sql = "UPDATE cadastro SET nome=?,dataPrimeira=?;";
                
            PreparedStatement prds = cnn.prepareStatement(sql);
            prds.setString(1,produto.getNome());
            prds.setDate(3, (Date) produto.getDataPrimeira());
            prds.executeUpdate(); 
        }catch(Exception e){
        e.printStackTrace();
    }
    }
    /**/
    public void excluir(int codigo){
        try{
            String sql = "DELET FROM cadastro WHERE codigo=?; ";
            PreparedStatement prds = cnn.prepareStatement(sql);
            prds.setInt(1,codigo);
            prds.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
   
    public List <EProduto>listar(){
        List <EProduto> lista =  new ArrayList<EProduto>();
        try{
            
            String sql = "SELECT * FROM cadastro ORDER BY codigo desc;";
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                
                EProduto produto = new EProduto();
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setDataPrimeira((Date)(rs.getDate("dataPrimeira")));
                
                //DateFormat formatar
                lista.add(produto);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public EProduto consultar(int codigo){
        EProduto produto = new EProduto();
        try{
            //String sql = "SELECT cadastro WHERE codigo=?;";
            String sql = "select * from cadastro where codigo=?;";
            PreparedStatement prds = cnn.prepareStatement(sql);
            prds.setInt(1, codigo);
            
            ResultSet rs = prds.executeQuery();
            if(rs.next()){
                System.out.println("*****Entrou*****");
                //cadastro.setCodigo(codigo);
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                
                produto.setDataPrimeira(rs.getDate("dataPrimeiraDose"));
               
                
            }    
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return produto;
    } 
}

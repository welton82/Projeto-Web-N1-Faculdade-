package controller;

import business.BCadastro;
import entity.ECadastro;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.util.logging.Level;
import org.jboss.logging.Logger;




@WebServlet(name = "CadastroController", urlPatterns = {"/CadastroController"})
public class CadastroController extends HttpServlet {

    private final BCadastro bCadastro;
    private static final String MANTER = "/manter.jsp";
    private static final String LISTAR = "/listar.jsp";

    public CadastroController (){ 
        super();
        bCadastro = new BCadastro();

    }

   
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String avancar = "";
        String acao = request.getParameter("acao");

        if(acao.equalsIgnoreCase("alterar")){

            avancar = MANTER;//indica qual página deverá seguir
            
            //recupera o parametro informado naURL, no caso código do produto
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            
            //Consulta produto a partir da classe de negócio
            ECadastro cadastro = bCadastro.consultar(codigo);
            
            /*cria um atributo chamado produto que é o objeto produto que foi 
            consultado esse atributoserá recuperado na tela de manutenção*/
            request.setAttribute("cadastro", cadastro);

        }else if(acao.equalsIgnoreCase("excluir")){

            avancar = LISTAR;//avançar para a tela de listagem depois de excluir
            //recupera o parâmetro informado na URL, código de produto
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            
            bCadastro.excluir(codigo);
            //carrega um novo atributo produtos que é uma lista atualizada
            //consultada a partir do banco 
            //request.setAttribute(acao, acao);
            request.setAttribute("cadastros", bCadastro.listar());

        }else if(acao.equalsIgnoreCase("listar")){

            avancar = LISTAR;
            request.setAttribute("cadastros", bCadastro.listar());
        }else{
            avancar = MANTER;
        }

        RequestDispatcher view = request.getRequestDispatcher(avancar);
        view.forward(request, response);


    }

    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ECadastro eCadastro = new ECadastro();
        eCadastro.setNome(request.getParameter("nome"));
        String erro = "";
        
        String anoNascimento = request.getParameter("anoNascimento");
        if(anoNascimento != null && !anoNascimento.isEmpty()){
            
            eCadastro.setAnoNacimento(Integer.parseInt(request.getParameter("anoNascimento")));
            eCadastro.setCpf(String.valueOf(request.getParameter("cpf")));
            
            try {
                eCadastro.setDataPrimeiraDose(String.valueOf(request.getParameter("dataPrimeiraDose")));
            } catch (ParseException ex) {
                java.util.logging.Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            eCadastro.setNome(String.valueOf(request.getParameter("nome")));
            
            try {
                eCadastro.setDataSegundaDose(String.valueOf(request.getParameter("dataSegundaDose")));
            } catch (ParseException ex) {
                java.util.logging.Logger.getLogger(CadastroController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(request.getParameter("vacinou").equalsIgnoreCase("true")){
                eCadastro.setVacinou(true);
            }else if(request.getParameter("vacinou").equalsIgnoreCase("false")){
                eCadastro.setVacinou(false);
            }
            
            
        }

        String codigo = request.getParameter("codigo");

        if(codigo != null && !codigo.isEmpty()){
            eCadastro.setCodigo(Integer.parseInt(codigo));
            
        }
        else if(codigo.equals("")){
           eCadastro.setCodigo(0);
        }
        RequestDispatcher view;
        
        try{
            bCadastro.salvar(eCadastro);
            view = request.getRequestDispatcher(LISTAR);
            request.setAttribute("cadastro",bCadastro.listar());
        }catch (Exception e){
            erro = e.getMessage();
            view = request.getRequestDispatcher(MANTER);
            Logger.getLogger(CadastroController.class.getName()).log(Logger.Level.ERROR, null, e);
        }

        
        request.setAttribute("erro", erro);
        view.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}



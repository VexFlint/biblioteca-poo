import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.*;

public abstract class Usuario implements Serializable{
   private boolean perfil; // Se administrador ou pessoa
   protected String nome_usuario;
   private int matricula;
   private String senha;
   private int limite_livros = 0;

   public Usuario(){}

   public Usuario(String nome_usuario, int matricula,  String senha, boolean perfil){
      this.nome_usuario = nome_usuario;
      this.matricula = matricula;
      this.senha = senha;
      this.perfil = perfil;
   }

   public boolean getPerfil(){
      return this.perfil;
   }

   public int getMatricula(){
      return this.matricula;
   }

   public int getLimite(){
      return this.limite_livros;
   }

   public void setLimite(int tipo){
      
      if(tipo == 1)
         this.limite_livros++;
      else
         this.limite_livros--;
   }

   public String getNome(){
      return this.nome_usuario;
   }

   public boolean validar_senha(String senha){

      try{
         if(this.senha.equals(senha)){
            return true;
         }
         else{
            throw new ExceptionSenha();
         }
      }
      catch(ExceptionSenha e){
         JOptionPane.showMessageDialog(null, e.getMessage());
      }
      return false;
   }

   public abstract String consultar_livros(ArrayList<Livro> livros);

   public String toString(){

      String content = "";

      content += String.format("  %-20s", this.nome_usuario);
      content += String.format("%-15s", this.matricula);
      content += String.format("%-22s", this.limite_livros);
      content += String.format("%s  \n", "(Pessoa)");

      return content;
   }
}

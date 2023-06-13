import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Administrador extends Usuario{

   public Administrador(){}
   
   public Administrador(String nome_usuario, int matricula,  String senha, boolean perfil){
      super(nome_usuario, matricula, senha, perfil);
   }

   public String consultar_livros(ArrayList<Livro> livros){

      String content = "";

      content += String.format("  %-10s", "CÓDIGO");
      content += String.format("%-20s", "NOME DO LIVRO");
      content += String.format("%-25s", "AUTOR");
      content += String.format("%-13s", "CATEGORIA");
      content += String.format("%-12s", "PÁGINAS");
      content += String.format("%-12s", "SITUAÇÃO");
      content += String.format("%s  \n", "USUÁRIO");

      for(Livro livro : livros){
         content += livro.toString();
      }
      return content;
   }

   public void adicionar_livro(ArrayList<Livro> livros, Livro livro){
      livros.add(livro);
   }

   public void remover(ArrayList<Livro> livros, int cod_livro){

      for (Livro livro : livros){
         if(livro.getCod() == cod_livro){
            JOptionPane.showMessageDialog(null, "Livro removido: "+livro.getNome());
            livros.remove(livro);
            break;
         }
      }
   }

   public void remover(int matricula, ArrayList<Usuario> usuarios) throws ExceptionRemoverUsuario{
      
      try{
         for (Usuario usuario : usuarios){
            if(usuario.getMatricula() == matricula){
               if(usuario.getPerfil() == true)
                  throw new ExceptionRemoverUsuario();
               else{
                  JOptionPane.showMessageDialog(null, "Usuário removido: "+usuario.getNome());
                  usuarios.remove(usuario);
                  break;
               }         
            }
         }
      }
      catch(ExceptionRemoverUsuario e){
         JOptionPane.showMessageDialog(null, e.getMessage());
      }
   }

   public String consultar_usuarios(ArrayList<Usuario> usuarios){

      String content = "";

      content += String.format("  %-20s", "NOME DO USUÁRIO");
      content += String.format("%-15s", "MATRÍCULA");
      content += String.format("%-22s", "LIVROS EMPRESTADOS");
      content += String.format("%s  \n", "TIPO DE USUÁRIO");

      for(Usuario usuario : usuarios){
         content += usuario.toString();
      }
      return content;
   }
   
   public String toString(){
      
      String content = "";
      
      content += String.format("  %-20s", this.nome_usuario);
      content += String.format("%-15s", "-----");
      content += String.format("%-22s", "-");
      content += String.format("%s  \n", "(Administrador)");

      return content;
   }
}

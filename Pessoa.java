import java.util.ArrayList;
import javax.swing.*;

public class Pessoa extends Usuario{

   public Pessoa(){}

   public Pessoa(String nome_usuario, int matricula,  String senha, boolean perfil){
      super(nome_usuario, matricula, senha, perfil);
   }

   public void emprestar_livro(ArrayList<Livro> livros, ArrayList<Usuario> usuarios, int matricula, int cod_livro) throws ExceptionLivro{

      try{
         if(verificar_limite(usuarios, matricula) == 3)
            throw new ExceptionLimiteLivro();
         else{
            if(verificar_livro(livros, cod_livro)){
               if(verificar_emprestimo(livros, cod_livro, matricula))
                  throw new ExceptionEmprestar("Você já emprestou esse livro!");
               else{
                  for (Livro livro : livros) {
                     if(livro.getCod() == cod_livro){
                        if(livro.getSituacao() == false){
                           livro.setSituacao(true);
                           livro.setMatUsuario(matricula);
                           atualizar_limite(usuarios, matricula, 1);
                           JOptionPane.showMessageDialog(null, "Livro emprestado: "+livro.getNome());
                        }
                        else
                           throw new ExceptionEmprestar("Livro já emprestado!");
                     }
                  }
               }
            }
            else
               throw new ExceptionLivroNaoEncontrado();
         }
      }
      catch(ExceptionLimiteLivro e){
         JOptionPane.showMessageDialog(null, e.getMessage());
      }
      catch(ExceptionLivroNaoEncontrado e){
         JOptionPane.showMessageDialog(null, e.getMessage());
      }
      catch(ExceptionEmprestar e){
         JOptionPane.showMessageDialog(null, e.getMessage());
      }
   }

   public void devolver_livro(ArrayList<Livro> livros,  ArrayList<Usuario> usuarios,  int matricula, int cod_livro) throws ExceptionLivro{

      try{
         if(verificar_limite(usuarios, matricula) == 0){
            throw new ExceptionDevolver("Não há livros para devolver!");
         }
         else{
            if(verificar_livro(livros, cod_livro)){
               if(!verificar_emprestimo(livros, cod_livro, matricula))
                  throw new ExceptionDevolver("Este livro não pode ser devolvido por você!");
               else{
                  for (Livro livro : livros) {
                     if(livro.getCod() == cod_livro){
                        livro.setSituacao(false);
                        livro.setMatUsuario(0);
                        atualizar_limite(usuarios, matricula, 2);
                        JOptionPane.showMessageDialog(null, "Livro devolvido: "+livro.getNome());
                     }
                  }
               }
            }
            else
               throw new ExceptionLivroNaoEncontrado();
         }
      }
      catch(ExceptionDevolver e){
         JOptionPane.showMessageDialog(null, e.getMessage());
      }
      catch(ExceptionLivroNaoEncontrado e){
         JOptionPane.showMessageDialog(null, e.getMessage());
      }
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

   public boolean verificar_livro(ArrayList<Livro> livros, int cod_livro){

      for (Livro livro : livros) {
         if(livro.getCod() == cod_livro)
            return true;
      }
      return false;
   }
   
   public boolean verificar_emprestimo(ArrayList<Livro> livros, int cod_livro, int matricula){

      for (Livro livro : livros) {
         if(livro.getCod() == cod_livro){
            if(livro.getMatUsuario() == matricula)
               return true;
         }
      }
      return false;
   }

   public int verificar_limite(ArrayList<Usuario> usuarios, int matricula){

      for (Usuario usuario : usuarios) {
         if(usuario.getMatricula() == matricula)
            return usuario.getLimite();
      }
      return 0;
   }

   public void atualizar_limite(ArrayList<Usuario> usuarios, int matricula, int tipo){

      for (Usuario usuario : usuarios) {
         if(usuario.getMatricula() == matricula)
            usuario.setLimite(tipo);
      }
   }

}

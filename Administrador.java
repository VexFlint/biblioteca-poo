import java.util.ArrayList;

public class Administrador extends Usuario{

   public Administrador(String nome_usuario, int matricula,  String senha){
      super(nome_usuario, matricula, senha);
      this.perfil = true;
   }

   public void consultar_livros(ArrayList<Livro> livros){

      for(Livro livro : livros){
         System.out.println(livro);
      }
   }

   public void adicionar_livro(ArrayList<Livro> livros, Livro livro){
      livros.add(livro);
   }

   public void remover(ArrayList<Livro> livros, int cod_livro){
      livros.remove(cod_livro - 1);
      // Redefinir todos os IDs e Decrementar ID global
   }

   public void remover(int id_usuario, ArrayList<Usuario> usuarios){
      for (Usuario usuario : usuarios){
         if(usuario.getID() == id_usuario){
            if(usuario.getPerfil() == true)
               System.out.println("Não é possível remover um Administrador!");
            else
               usuarios.remove(id_usuario - 1);
         }
      }
      // Redefinir todos os IDs e Decrementar ID global
   }

   public void consultar_usuarios(ArrayList<Usuario> usuarios){

      for(Usuario usuario : usuarios){
         System.out.println(usuario);
      }
   }
   
   public String toString(){
      
      String content = "";
      content += "Informações confidenciais (Administrador)";
      return content;
   }
}

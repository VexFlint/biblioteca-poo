import java.util.ArrayList;

public class Biblioteca {
   private String nome_biblioteca;
   private ArrayList <Livro> livros;
   private ArrayList <Usuario> usuarios;

   public Biblioteca(String nome_biblioteca){
      this.nome_biblioteca = nome_biblioteca;
      this.livros = new ArrayList<Livro>();
      this.usuarios = new ArrayList<Usuario>();
   }

   public void adicionar_usuario(Usuario usuario){
      this.usuarios.add(usuario);
   }

   public ArrayList<Livro> getLivros(){
      return this.livros;
   }

   public ArrayList<Usuario> getUsuarios(){
      return this.usuarios;
   }
}

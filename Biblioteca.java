import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.*;

public class Biblioteca implements Serializable{
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
   
   public int autenticar_usuario(int matricula, String senha) throws ExceptionAutenticacao{

      try{
         if(verificar_usuario(matricula)){
            for (Usuario usuario : usuarios) {
               if (usuario.getMatricula() == matricula){
                  if(usuario.validar_senha(senha)){
                     if(usuario.getPerfil() == true)
                        return 1;
                     else
                        return 2;
                  }
               }
            }
         }
         else{
            throw new ExceptionUsuario();
         }
      }
      catch(ExceptionUsuario e){
         JOptionPane.showMessageDialog(null, e.getMessage());
      }
      return 0;
   }
   
   public ArrayList<Livro> getLivros(){
      return this.livros;
   }

   public ArrayList<Usuario> getUsuarios(){
      return this.usuarios;
   }

   public boolean verificar_usuario(int matricula){

      for (Usuario usuario : usuarios) {
         if(usuario.getMatricula() == matricula)
            return true;
      }
      return false;
   }

}

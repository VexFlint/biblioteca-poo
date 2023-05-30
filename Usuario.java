import java.util.ArrayList;

public abstract class Usuario{
   private static int id_global = 0;
   private int id_usuario;
   protected boolean perfil = false; // Se administrador ou pessoa
   private String nome_usuario;
   protected int matricula;
   private String senha;
   protected int limite_livros = 0;


   public Usuario(String nome_usuario, int matricula,  String senha){
      id_global++;
      this.id_usuario = id_global;
      this.nome_usuario = nome_usuario;
      this.matricula = matricula;
      this.senha = senha;
   }

   public int getID(){
      return this.id_usuario;
   }

   public boolean getPerfil(){
      return this.perfil;
   }

   public int getMatUsuario(){
      return this.matricula;
   }

   public String getSenha(){
      return this.senha;
   }

   public void autenticar_usuario(int matricula, String senha){

      if(this.matricula == matricula && this.senha == senha)
         System.out.println("Sucesso na autenticação!");
      else
         System.out.println("Falha na autenticação!");
   }

   public abstract void consultar_livros(ArrayList<Livro> livros);

   public String toString(){

      String content = "";
      content += "ID: "+this.id_usuario+"    Nome: "+this.nome_usuario;
      return content;
   }
}

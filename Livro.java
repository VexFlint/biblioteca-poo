import java.io.Serializable;

public class Livro implements Serializable{
   private int cod_livro;
   private String nome_livro;
   private String autor;
   private String categoria;
   private int paginas;
   private boolean situacao;    // Se livro esta emprestado ou não
   private int mat_usuario = 0; // Mátricula da pessoa que emprestou o livro

   public Livro(int cod_livro, String nome_livro, String autor, String categoria, int paginas){
      this.cod_livro = cod_livro;
      this.nome_livro = nome_livro;
      this.autor = autor;
      this. categoria = categoria;
      this.paginas = paginas;
      this.situacao = false;
   }

   public int getCod(){
      return this.cod_livro;
   }

   public int getMatUsuario(){
      return this.mat_usuario;
   }

   public void setMatUsuario(int mat_usuario){
      this.mat_usuario = mat_usuario;
   }

   public boolean getSituacao(){
      return this.situacao;
   }

   public void setSituacao(boolean situacao){
      this.situacao = situacao;
   }

   public String getNome(){
      return this.nome_livro;
   }
   
   public String toString(){

      String content = "";

      content += String.format("  %-10s", this.cod_livro);
      content += String.format("%-20s", this.nome_livro);
      content += String.format("%-25s", this.autor);
      content += String.format("%-13s", this.categoria);
      content += String.format("%-10s", this.paginas);

      if (this.situacao == true){
         content += String.format("%-15s", "(Emprestado)");
         content += String.format("%s  \n", this.mat_usuario);
      }
      else{
         content += String.format("%-15s\n", "(Disponível)");
      }
      return content;
   }
}

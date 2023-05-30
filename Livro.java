public class Livro {
   private static int cod_global = 0;
   private int cod_livro;
   private String nome_livro;
   private String autor;
   private String categoria;
   private int paginas;
   private boolean situacao;    // Se livro esta emprestado ou não
   private int mat_usuario = 0; // Mátricula da pessoa que emprestou o livro

   public Livro(String nome_livro, String autor, String categoria, int paginas){
      cod_global++;
      this.cod_livro = cod_global;
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

   public String toString(){

      String content = "";
      content += "Código: "+this.cod_livro+"    Livro: "+this.nome_livro;
      return content;
      // Apresentar livro se livro esta disponível ou não
   }
}

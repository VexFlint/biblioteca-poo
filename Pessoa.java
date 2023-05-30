import java.util.ArrayList;

public class Pessoa extends Usuario{

   public Pessoa(String nome_usuario, int matricula,  String senha){
      super(nome_usuario, matricula, senha);
   }

   public void emprestar_livro(ArrayList<Livro> livros, int cod_livro){

      if(this.limite_livros == 3)
         System.out.println("Você atingiu o limite de empréstimos!");
      else{
         if(verificar_livro(livros, cod_livro)){
            if(verificar_usuario(livros, cod_livro))
               System.out.println("Você já emprestou esse livro!");
            else{
               for (Livro livro : livros) {
                  if(livro.getCod() == cod_livro){
                     if(livro.getSituacao() == false){
                        livro.setSituacao(true);
                        livro.setMatUsuario(this.matricula);
                        this.limite_livros++;
                        System.out.println("EMPRESTADO -> "+livro.toString());
                     }
                     else
                        System.out.println("Livro já emprestado!");
                  }
               }
            }
         }
         else
            System.out.println("Livro não encontrado!");
      }
   }

   public void devolver_livro(ArrayList<Livro> livros, int cod_livro){

      if(this.limite_livros == 0){
         System.out.println("Não há livros para devolver!");
      }
      else{
         if(verificar_livro(livros, cod_livro)){
            if(!verificar_usuario(livros, cod_livro))
               System.out.println("Este livro não pode ser devolvido por você!");
            else{
               for (Livro livro : livros) {
                  if(livro.getCod() == cod_livro){
                     livro.setSituacao(false);
                     livro.setMatUsuario(0);
                     this.limite_livros--;
                     System.out.println("DEVOLVIDO -> "+livro.toString());
                  }
               }
            }
         }
         else
            System.out.println("Livro não encontrado!");
      }
   }

   public void consultar_livros(ArrayList<Livro> livros){

      for(Livro livro : livros){
         System.out.println(livro);
      }
   }

   public boolean verificar_livro(ArrayList<Livro> livros, int cod_livro){

      for (Livro livro : livros) {
         if(livro.getCod() == cod_livro)
            return true;
      }
      return false;
   }

   public boolean verificar_usuario(ArrayList<Livro> livros, int cod_livro){

      for (Livro livro : livros) {
         if(livro.getCod() == cod_livro){
            if(livro.getMatUsuario() == this.matricula)
               return true;
         }
      }
      return false;
   }
}

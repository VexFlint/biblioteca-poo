import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import javax.swing.*;
import java.awt.*;

class Popular_Biblioteca{
   public static void main(String[] args) throws Exception{
      
      Biblioteca biblioteca = new Biblioteca("Corujinha");
      Administrador admin = new Administrador();
      Pessoa pessoa = new Pessoa();

// Popular usuários do arquivo "usuarios.txt"

      try{
         File dados = new File("usuarios.txt");
         Scanner scanner = new Scanner(dados);

         while(scanner.hasNext()){

            boolean perfil = scanner.nextBoolean();
            String nome_usuario = scanner.next();
            int matricula = scanner.nextInt();
            String senha = scanner.next();

            if(perfil == true){
               admin = new Administrador(nome_usuario, matricula, senha, perfil);
               biblioteca.adicionar_usuario(admin);
            }
            else{
               pessoa = new Pessoa(nome_usuario, matricula, senha, perfil);
               biblioteca.adicionar_usuario(pessoa);
            }
         }
         scanner.close();
      }
      catch(FileNotFoundException e){
         e.printStackTrace();
      }

// Popular livros do arquivo "livros.txt"

      try{
         File dados = new File("livros.txt");
         Scanner scanner = new Scanner(dados);

         while(scanner.hasNext()){

            int codigo = scanner.nextInt();
            String nome_livro = scanner.next();
            String autor = scanner.next();
            String categoria = scanner.next();
            int paginas = scanner.nextInt();

            Livro livro = new Livro(codigo, nome_livro, autor, categoria, paginas);

            admin.adicionar_livro(biblioteca.getLivros(), livro);
         }
         scanner.close();
      }
      catch(FileNotFoundException e){
         e.printStackTrace();
      }

// Serialização do objeto biblioteca com os dados já populados

      FileOutputStream arqSaida = new FileOutputStream("Biblioteca.o");
      ObjectOutputStream objSaida = new ObjectOutputStream(arqSaida);

      objSaida.writeObject(biblioteca);
      
      objSaida.close();
      arqSaida.close();
   }
}

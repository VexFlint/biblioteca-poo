class Main {
   public static void main(String[] args){

      Biblioteca biblioteca = new Biblioteca("Corujinha");

      Administrador admin1 = new Administrador("Caillou", 10000, "pensar");
      Administrador admin2 = new Administrador("Pedro", 10001, "ler");

      Pessoa pessoa1 = new Pessoa("Daniel", 10002, "palavra");
      Pessoa pessoa2 = new Pessoa("João", 10003, "folha");
      Pessoa pessoa3 = new Pessoa("Pedro", 10004, "mente");

      biblioteca.adicionar_usuario(admin1);
      biblioteca.adicionar_usuario(admin2);
      biblioteca.adicionar_usuario(pessoa1);
      biblioteca.adicionar_usuario(pessoa2);
      biblioteca.adicionar_usuario(pessoa3);

      Livro livro1 = new Livro("Hamlet", "Shakespeare", "Drama", 237);
      Livro livro2 = new Livro("A Odisseia", "Homero", "Poema", 340);
      Livro livro3 = new Livro("A Tempestade", "Shakespeare", "Comédia", 63);
      Livro livro4 = new Livro("Coraline", "Neil Gaiman", "Fantasia", 224);
      Livro livro5 = new Livro("Dom Casmurro", "Machado de Assis", "Romance", 230);

      admin1.adicionar_livro(biblioteca.getLivros(), livro1);
      admin1.adicionar_livro(biblioteca.getLivros(), livro2);
      admin1.adicionar_livro(biblioteca.getLivros(), livro3);
      admin2.adicionar_livro(biblioteca.getLivros(), livro4);
      admin2.adicionar_livro(biblioteca.getLivros(), livro5);

      // Teste na classe administrador
      admin2.remover(4, biblioteca.getUsuarios()); // Remover usuário 4 (João)
      admin2.remover(biblioteca.getLivros(), 3);   // Remover livro 3 (A Tempestade)

      System.out.println("---------------------------------------------");
      admin1.consultar_livros(biblioteca.getLivros());
      System.out.println("---------------------------------------------");
      admin1.consultar_usuarios(biblioteca.getUsuarios());
      System.out.println("---------------------------------------------");

      // Teste na classe pessoa

      pessoa1.emprestar_livro(biblioteca.getLivros(), 1);
      pessoa1.emprestar_livro(biblioteca.getLivros(), 2);
      pessoa1.emprestar_livro(biblioteca.getLivros(), 4);
      pessoa2.emprestar_livro(biblioteca.getLivros(), 1); // Tenta emprestar um livro já em uso
      pessoa1.devolver_livro(biblioteca.getLivros(), 1);
      System.out.println("---------------------------------------------");
      pessoa3.consultar_livros(biblioteca.getLivros());
      System.out.println("---------------------------------------------");

   }   
}

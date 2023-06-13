import java.io.ObjectInputStream;
import java.io.FileInputStream;
import javax.swing.*;
import java.awt.*;

class Operar_Biblioteca {

   public static void main(String[] args) throws Exception{

// Deserialização do objeto biblioteca com os dados já populados nas classes

      FileInputStream arqEntrada = new FileInputStream("Biblioteca.o");
      ObjectInputStream objEntrada = new ObjectInputStream(arqEntrada);

      Biblioteca biblioteca = null;
      Administrador admin = new Administrador();
      Pessoa pessoa = new Pessoa();   

      try {
         biblioteca = (Biblioteca) objEntrada.readObject();
      }
      catch (ClassNotFoundException e) {
         e.printStackTrace();
      }

      arqEntrada.close();
      objEntrada.close();

// Menu principal

      int escolha_menu; // -> opções do menu principal
      int option; //  -> variável para o botão "cancelar"

      do{
         JLabel menu1 = new JLabel("              MENU PRINCIPAL");
         JLabel menu2 = new JLabel(" ");
         JLabel menu3 = new JLabel(" [ 1 ] Autenticar     ");
         JLabel menu4 = new JLabel(" [ 2 ] Alunos         ");
         JLabel menu5 = new JLabel(" ");
         JTextField input_menu = new JTextField();

         Object[] menuOBJ = { menu1, menu2, menu3, menu4, menu5, input_menu };

         option = JOptionPane.showConfirmDialog(null, menuOBJ, "Input", JOptionPane.OK_CANCEL_OPTION);

   // Verificação se clicou no botão "cancelar"
         if(option == JOptionPane.CANCEL_OPTION){
            break;
         }
   
   // Verificação se o campo esta vazio
         if(input_menu.getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo de entrada esta vazio.");
            continue;
         }

         escolha_menu = Integer.parseInt(input_menu.getText());

   // Verificação se escolha é válida
         if(escolha_menu != 1 && escolha_menu != 2){
            JOptionPane.showMessageDialog(null, "Escolha inválida! Tente novamente.");
            continue;
         }

// Autenticar usuário

         else if(escolha_menu == 1){

            do{
               JLabel auth1 = new JLabel("                  AUTENTICAR");
               JLabel auth2 = new JLabel(" ");
               JLabel auth3 = new JLabel(" Matrícula");
               JTextField input_auth1 = new JTextField();
               JLabel auth4 = new JLabel(" Senha");
               JTextField input_auth2 = new JTextField();

               Object[] authOBJ = { auth1, auth2, auth3, input_auth1, auth4, input_auth2 };

               option = JOptionPane.showConfirmDialog(null, authOBJ, "Input", JOptionPane.OK_CANCEL_OPTION);

         // Verificação se clicou no botão "cancelar"
               if(option == JOptionPane.CANCEL_OPTION){
                  break;
               }
   
         // Verificação se os campos estão vazios
               if(input_auth1.getText().equals("") || input_auth2.getText().equals("")){
                  JOptionPane.showMessageDialog(null, "Os campos de entrada estão vazios.");
                  continue;
               }
               
               int matricula = Integer.parseInt(input_auth1.getText());
               String senha = input_auth2.getText();

         // Resposta = 1 -> Administrador  |  Resposta = 2 -> Pessoa
               int resposta_auth = biblioteca.autenticar_usuario(matricula, senha);

   // Sessão do Administrador
               if(resposta_auth == 1){

                  do{
                     JLabel adm1 = new JLabel("    BEM VINDO ADMINISTRADOR");
                     JLabel adm2 = new JLabel(" ");
                     JLabel adm3 = new JLabel(" [ 1 ] Consultar livros     ");
                     JLabel adm4 = new JLabel(" [ 2 ] Consultar usuários   ");
                     JLabel adm5 = new JLabel(" [ 3 ] Adicionar livro      ");
                     JLabel adm6 = new JLabel(" [ 4 ] Adicionar usuário    ");
                     JLabel adm7 = new JLabel(" [ 5 ] Remover livro        ");
                     JLabel adm8 = new JLabel(" [ 6 ] Remover usuário      ");
                     JLabel adm9 = new JLabel(" ");
                     JTextField input_adm = new JTextField();

                     Object[] admOBJ = { adm1, adm2, adm3, adm4, adm5, adm6, adm7, adm8, adm9, input_adm };

                     option = JOptionPane.showConfirmDialog(null, admOBJ, "Input", JOptionPane.OK_CANCEL_OPTION);

               // Verificação se clicou no botão "cancelar"
                     if(option == JOptionPane.CANCEL_OPTION){
                        break;
                     }

               // Verificação se o campo esta vazio
                     if(input_adm.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "O campo de entrada esta vazio.");
                        continue;
                     }

                     int escolha_admin = Integer.parseInt(input_adm.getText());
               
               // Verificação se escolha é válida
                     if(escolha_admin < 1 || escolha_admin > 6){
                        JOptionPane.showMessageDialog(null, "Escolha inválida! Tente novamente.");
                        continue;
                     }
               
         // Operação de consulta dos livros
                     else if(escolha_admin == 1){
                        JTextArea textArea = new JTextArea(admin.consultar_livros(biblioteca.getLivros()));
                        textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
                        textArea.setEditable(false);

                        JOptionPane.showMessageDialog(null, textArea);
                     }
               
         // Operação de consulta dos usuários
                     else if(escolha_admin == 2){
                        JTextArea textArea = new JTextArea(admin.consultar_usuarios(biblioteca.getUsuarios()));
                        textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
                        textArea.setEditable(false);

                        JOptionPane.showMessageDialog(null, textArea);
                     }

         // Operação de adicionar livro
                     else if(escolha_admin == 3){

                        JLabel add1 = new JLabel("              ADICIONAR LIVRO");
                        JLabel add2 = new JLabel(" ");
                        JLabel add3 = new JLabel(" Código do livro");
                        JTextField input_add1 = new JTextField();
                        JLabel add4 = new JLabel(" Nome do livro");
                        JTextField input_add2 = new JTextField();
                        JLabel add5 = new JLabel(" Autor");
                        JTextField input_add3 = new JTextField();
                        JLabel add6 = new JLabel(" Categoria");
                        JTextField input_add4 = new JTextField();
                        JLabel add7 = new JLabel(" Número de páginas");
                        JTextField input_add5 = new JTextField();

                        Object[] addOBJ = { add1, add2, add3, input_add1, add4, input_add2, add5,
                                                    input_add3, add6, input_add4, add7, input_add5  };

                        option = JOptionPane.showConfirmDialog(null, addOBJ, "Input", JOptionPane.OK_CANCEL_OPTION);
                        
                  // Verificação se clicou no botão "cancelar"
                        if(option == JOptionPane.CANCEL_OPTION){
                           break;
                        }
                  
                  // Verificação se os campos estão vazios
                        if(input_add1.getText().equals("") || input_add2.getText().equals("") || input_add3.getText().equals("") || 
                           input_add4.getText().equals("") || input_add5.getText().equals("")){
                           JOptionPane.showMessageDialog(null, "Os campos de entrada estão vazios.");
                           continue;
                        }

                        int cod_livro = Integer.parseInt(input_add1.getText());
                        String nome_livro = input_add2.getText();
                        String autor = input_add3.getText();
                        String categoria = input_add4.getText();
                        int paginas = Integer.parseInt(input_add5.getText());

                        Livro livro = new Livro(cod_livro, nome_livro, autor, categoria, paginas);

                        admin.adicionar_livro(biblioteca.getLivros(), livro);

                        JOptionPane.showMessageDialog(null, "Livro adicionado com sucesso.");
                     }

         // Operação de adicionar livro
                     else if(escolha_admin == 4){

                        JLabel add1 = new JLabel("             ADICIONAR USUÁRIO");
                        JLabel add2 = new JLabel(" ");
                        JLabel add3 = new JLabel(" Nome do usuário");
                        JTextField input_add1 = new JTextField();
                        JLabel add4 = new JLabel(" Matrícula");
                        JTextField input_add2 = new JTextField();
                        JLabel add5 = new JLabel(" Senha");
                        JTextField input_add3 = new JTextField();
                        JLabel add6 = new JLabel(" Perfil");
                        JTextField input_add4 = new JTextField();

                        Object[] addOBJ = { add1, add2, add3, input_add1, add4, input_add2, add5,
                                                    input_add3, add6, input_add4, };

                        option = JOptionPane.showConfirmDialog(null, addOBJ, "Input", JOptionPane.OK_CANCEL_OPTION);
                        
                  // Verificação se clicou no botão "cancelar"
                        if(option == JOptionPane.CANCEL_OPTION){
                           break;
                        }
                  
                  // Verificação se os campos estão vazios
                        if(input_add1.getText().equals("") || input_add2.getText().equals("") || 
                           input_add3.getText().equals("") || input_add4.getText().equals("")){
                           JOptionPane.showMessageDialog(null, "Os campos de entrada estão vazios.");
                           continue;
                        }

                        String nome_usuario = input_add1.getText();
                        int mat_usuario = Integer.parseInt(input_add2.getText());
                        String senha_usuario = input_add3.getText();
                        Boolean perfil = Boolean.parseBoolean(input_add4.getText());

                        if(perfil == true){
                           admin = new Administrador(nome_usuario, mat_usuario, senha_usuario, perfil);
                           biblioteca.adicionar_usuario(admin);
                        }
                        else{
                           pessoa = new Pessoa(nome_usuario, mat_usuario, senha_usuario, perfil);
                           biblioteca.adicionar_usuario(pessoa);
                        }

                        JOptionPane.showMessageDialog(null, "Usuário adicionado com sucesso.");
                     }
         // Operação de remover livro
                     else if(escolha_admin == 5){

                        JLabel remov1 = new JLabel("             REMOVER LIVRO");
                        JLabel remov2 = new JLabel(" ");
                        JLabel remov3 = new JLabel(" Código do livro");
                        JTextField input_remov = new JTextField();

                        Object[] removOBJ = { remov1, remov2, remov3, input_remov };

                        option = JOptionPane.showConfirmDialog(null, removOBJ, "Input", JOptionPane.OK_CANCEL_OPTION);
                  
                  // Verificação se clicou no botão "cancelar"
                        if(option == JOptionPane.CANCEL_OPTION){
                           break;
                        }

                  // Verificação se o campo esta vazio
                        if(input_remov.getText().equals("")){
                           JOptionPane.showMessageDialog(null, "O campo de entrada esta vazio.");
                           continue;
                        }
                        
                        int cod_livro = Integer.parseInt(input_remov.getText());

                        admin.remover(biblioteca.getLivros(), cod_livro);
                     }

         // Operação de remover usuário      
                     else if(escolha_admin == 6){

                        JLabel remov1 = new JLabel("            REMOVER USUÁRIO");
                        JLabel remov2 = new JLabel(" ");
                        JLabel remov3 = new JLabel(" Matrícula do usuário");
                        JTextField input_remov = new JTextField();

                        Object[] removOBJ = { remov1, remov2, remov3, input_remov };

                        option = JOptionPane.showConfirmDialog(null, removOBJ, "Input", JOptionPane.OK_CANCEL_OPTION);

                   // Verificação se clicou no botão "cancelar"
                        if(option == JOptionPane.CANCEL_OPTION){
                           break;
                        }

                  // Verificação se o campo esta vazio
                        if(input_remov.getText().equals("")){
                           JOptionPane.showMessageDialog(null, "O campo de entrada esta vazio.");
                           continue;
                        }
                        
                        int mat_usuario = Integer.parseInt(input_remov.getText());

                        admin.remover(mat_usuario, biblioteca.getUsuarios());
                     }
                  }
                  while(true);
               }

   // Sessão da Pessoa
               else if(resposta_auth == 2){

                  do{
                     JLabel pes1 = new JLabel("                 BEM VINDO");
                     JLabel pes2 = new JLabel(" ");
                     JLabel pes3 = new JLabel(" [ 1 ] Consultar livros     ");
                     JLabel pes4 = new JLabel(" [ 2 ] Emprestar livro      ");
                     JLabel pes5 = new JLabel(" [ 3 ] Devolver livro       ");
                     JLabel pes6 = new JLabel(" ");
                     JTextField input_pes = new JTextField();

                     Object[] pesOBJ = { pes1, pes2, pes3, pes4, pes5, pes6, input_pes };

                     option = JOptionPane.showConfirmDialog(null, pesOBJ, "Input", JOptionPane.OK_CANCEL_OPTION);

               // Verificação se clicou no botão "cancelar"
                     if(option == JOptionPane.CANCEL_OPTION){
                        break;
                     }
               
               // Verificação se o campo esta vazio
                     if(input_pes.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "O campo de entrada esta vazio.");
                        continue;
                     }

                     int escolha_pessoa = Integer.parseInt(input_pes.getText());

               // Verificação se escolha é válida
                     if(escolha_pessoa != 1 && escolha_pessoa != 2 && escolha_pessoa != 3){
                        JOptionPane.showMessageDialog(null, "Escolha inválida! Tente novamente.");
                        continue;
                     }
               
         // Operação de consulta dos livros
                     else if(escolha_pessoa == 1){

                        JTextArea textArea = new JTextArea(pessoa.consultar_livros(biblioteca.getLivros()));
                        textArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
                        textArea.setEditable(false);

                        JOptionPane.showMessageDialog(null, textArea);
                     }

         // Operação de emprestar livro
                     else if(escolha_pessoa == 2){

                        JLabel empres1 = new JLabel("           EMPRESTAR LIVRO");
                        JLabel empres2 = new JLabel(" ");
                        JLabel empres3 = new JLabel(" Código do livro");
                        JTextField input_empres = new JTextField();

                        Object[] empresOBJ = { empres1, empres2, empres3, input_empres };

                        option = JOptionPane.showConfirmDialog(null, empresOBJ, "Input", JOptionPane.OK_CANCEL_OPTION);
                     
                  // Verificação se clicou no botão "cancelar"
                        if(option == JOptionPane.CANCEL_OPTION){
                           break;
                        }
                     
                  // Verificação se o campo esta vazio
                        if(input_empres.getText().equals("")){
                           JOptionPane.showMessageDialog(null, "O campo de entrada esta vazio.");
                           continue;
                        }
                        
                        int cod_livro = Integer.parseInt(input_empres.getText());

                        pessoa.emprestar_livro(biblioteca.getLivros(), biblioteca.getUsuarios(), matricula, cod_livro);
                     }

         // Operação de devolver livro
                     else if(escolha_pessoa == 3){

                        JLabel devol1 = new JLabel("           DEVOLVER LIVRO");
                        JLabel devol2 = new JLabel(" ");
                        JLabel devol3 = new JLabel(" Código do livro");
                        JTextField input_devol = new JTextField();

                        Object[] devolOBJ = { devol1, devol2, devol3, input_devol };

                        option = JOptionPane.showConfirmDialog(null, devolOBJ, "Input", JOptionPane.OK_CANCEL_OPTION);

                  // Verificação se clicou no botão "cancelar"
                        if(option == JOptionPane.CANCEL_OPTION){
                           break;
                        }

                  // Verificação se o campo esta vazio
                        if(input_devol.getText().equals("")){
                           JOptionPane.showMessageDialog(null, "O campo de entrada esta vazio.");
                           continue;
                        }
                        
                        int cod_livro = Integer.parseInt(input_devol.getText());

                        pessoa.devolver_livro(biblioteca.getLivros(), biblioteca.getUsuarios(), matricula, cod_livro);
                     }
                  }
                  while(true);
               }
            }
            while(true);
         }
   
// Alunos do projeto

         else if(escolha_menu == 2){
            
            JLabel aluno1 = new JLabel("                      ALUNOS");
            JLabel aluno2 = new JLabel(" ");
            JLabel aluno3 = new JLabel(" Daniel Mendes");
            JLabel aluno4 = new JLabel(" Dougley Doll");
            JLabel aluno5 = new JLabel(" Bruno Bellizzi");
            JLabel aluno6 = new JLabel(" ");

            Object[] alunoOBJ = { aluno1, aluno2, aluno3, aluno4, aluno5, aluno6 };

            JOptionPane.showConfirmDialog(null, alunoOBJ, "Input", JOptionPane.OK_CANCEL_OPTION);
         }
      }
      while(true);

// Fim do programa

      JOptionPane.showMessageDialog(null, "Programa finalizado :)");
   }
}


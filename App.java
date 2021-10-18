import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static String menu() {

        Scanner inp = new Scanner(System.in);

        System.out.println(" -----> Menu <-----");

        String[] options = { "Sair", "Listar livros", "Listar autores", "Cadastrar livros", "Cadastrar autores",
                "Get livro", "Get autor", "Atualizar livro", "Atualizar autor", "Deletar livro", "Deletar autor" };

        for (int i = 0; i < options.length; i++) {
            System.out.println("(" + i + ")" + options[i]);
        }

        System.out.println("Digite a opcao desejada: ");

        String option = inp.next();

        option += " - " + options[Integer.parseInt(option)];

        return option;

    }

    public static void main(String[] args) throws IOException {

        Arquivos arquivos = new Arquivos();

        arquivos.mkDir("files");

        int exit = 0;

        while (exit != 1) {
            String option = menu();

            System.out.println("Opção selecionada: " + option);

            switch (option) {
                case "1 - Listar livros":
                    listarLivros();
                    break;
                case "2 - Listar autores":
                    listarAutores();
                    break;
                case "3 - Cadastrar livros":
                    cadastrarLivros();
                    break;
                case "4 - Cadastrar autores":
                    cadastrarAutores();
                    break;
                case "5 - Get livro":
                    getLivro();
                    break;
                case "6 - Get autor":
                    getAutor();
                    break;
                case "7 - Atualizar livro":
                    updateLivro();
                    break;
                case "8 - Atualizar autor":
                    updateAutor();
                    break;
                case "9 - Deletar livro":
                    deleteLivro();
                    break;
                case "10 - Deletar autor":
                    deleteAutor();
                    break;
                case "0 - Sair":
                    System.exit(0);
                    break;
            }
        }

    }

    private static Autor cadastrarAutores() throws IOException {

        Scanner inp = new Scanner(System.in);

        String[] dados = { "ID", "Nome", "Idade" };
        String[] resp = { "", "", "" };

        for (int i = 0; i < dados.length; i++) {
            System.out.println("Digite o " + dados[i] + " do autor: ");
            String res = inp.nextLine();

            resp[i] = res;
        }

        int id = Integer.parseInt(resp[0]);

        Autor autor = new Autor(resp[1], resp[2], id, 0, 0);

        new arquivosAutor(autor.getNome(), autor.getIdade(), autor.getId(), autor.getPublicados(), autor.getVendidos());

        return autor;

    }

    private static Livro cadastrarLivros() throws IOException {

        Scanner inp = new Scanner(System.in);

        String[] dados = { "ID", "Nome", "Genero", "ID do Autor", "Numero de Paginas" };
        String[] resp = { "", "", "", "", "" };

        for (int i = 0; i < dados.length; i++) {
            System.out.println("Digite o " + dados[i] + " do livro: ");
            String res = inp.nextLine();

            resp[i] = res;
        }

        int id = Integer.parseInt(resp[0]);

        int id_autor = Integer.parseInt(resp[3]);

        int num_pags = Integer.parseInt(resp[4]);

        Livro livro = new Livro(id, resp[1], resp[2], id_autor, num_pags, 0);

        new arquivosLivro(livro.getId(), livro.getNome(), livro.getGenero(), livro.getIdAutor(), livro.getPaginas(),
                livro.getVendidas());

        return livro;
    }

    private static void listarAutores() throws IOException {
        List<String> lista = new ArrayList<String>();

        lista = arquivosAutor.listar();

        System.out.println(lista);
    }

    private static void listarLivros() throws IOException {
        List<String> lista = new ArrayList<String>();

        lista = arquivosLivro.listar();

        System.out.println(lista);
    }

    private static void getAutor() throws IOException {

        Scanner inp = new Scanner(System.in);

        System.out.println("Digite o ID do autor: ");

        String id = inp.nextLine();

        List<String> lista = new ArrayList<String>();

        lista = arquivosAutor.getAutor(Integer.parseInt(id));

        System.out.println(lista);

    }

    private static void getLivro() throws IOException {

        Scanner inp = new Scanner(System.in);

        System.out.println("Digite o ID do livro: ");

        String id = inp.nextLine();

        List<String> lista = new ArrayList<String>();

        lista = arquivosLivro.getLivro(Integer.parseInt(id));

        System.out.println(lista);

    }

    private static void updateAutor() throws NumberFormatException, IOException {

        Scanner inp = new Scanner(System.in);

        System.out.println("Digite o ID do autor que desejas editar: ");

        String id_p = inp.nextLine();

        System.out.println("Digite a nova idade do autor: ");

        String idade = inp.nextLine();

        System.out.println("Digite o novo nome do autor: ");

        String nome = inp.nextLine();

        System.out.println("Digite o novo numero de livros publicados do autor: ");

        String publicados = inp.nextLine();

        System.out.println("Digite o novo numero de livros vendidos do autor: ");

        String vendidos = inp.nextLine();

        arquivosAutor.updateAuthor(Integer.parseInt(id_p), nome, idade, Integer.parseInt(vendidos),
                Integer.parseInt(publicados));

    }

    private static void updateLivro() throws NumberFormatException, IOException {

        Scanner inp = new Scanner(System.in);

        System.out.println("Digite o ID do livro que desejas editar: ");

        String id_p = inp.nextLine();

        System.out.println("Digite o novo nome do livro: ");

        String nome = inp.nextLine();

        System.out.println("Digiteo novo genero do livro: ");

        String genero = inp.nextLine();

        System.out.println("Digite o ID do novo autor do autor: ");

        String id_autor = inp.nextLine();

        System.out.println("Digite o novo numero de paginas: ");

        String paginas = inp.nextLine();

        System.out.println("Digite o novo numero de copias vendidas: ");

        String vendidas = inp.nextLine();

        arquivosLivro.updateBook(Integer.parseInt(id_p), nome, genero, Integer.parseInt(id_autor),
                Integer.parseInt(paginas), Integer.parseInt(vendidas));

    }

    private static void deleteAutor() throws NumberFormatException, IOException {

        Scanner inp = new Scanner(System.in);

        System.out.println("Digite o ID do autor: ");

        String id_p = inp.nextLine();

        arquivosAutor.deleteAuthor(Integer.parseInt(id_p));

    }

    private static void deleteLivro() throws NumberFormatException, IOException {

        Scanner inp = new Scanner(System.in);

        System.out.println("Digite o ID do livro: ");

        String id = inp.nextLine();

        arquivosLivro.deleteBook(Integer.parseInt(id));

    }

}
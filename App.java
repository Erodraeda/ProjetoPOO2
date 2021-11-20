import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    /**
     * Mostra um menu com todas as opções
     * 
     * @return retorna opção escolhida
     */
    private static String menu() {

        Scanner inp = new Scanner(System.in);

        System.out.println(" -----> Menu <-----");

        String[] options = { "Sair", "Listar autores", "Cadastrar autores", "Get autor", "Atualizar autor",
                "Deletar autor" };

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
            case "1 - Listar autores":
                listarAutores();
                break;
            case "2 - Cadastrar autores":
                cadastrarAutores();
                break;
            case "3 - Get autor":
                getAutor();
                break;
            case "4 - Atualizar autor":
                updateAutor();
                break;
            case "5 - Deletar autor":
                deleteAutor();
                break;
            case "0 - Sair":
                System.exit(0);
                break;
            }
        }

    }

    /**
     * Inicia o procedimento de cadastro de um autor
     * 
     * @return objeto do autor
     * @throws IOException
     */
    private static Autor cadastrarAutores() throws IOException {

        Scanner inp = new Scanner(System.in);

        String[] dados = { "Nome", "Idade" };
        String[] resp = { "", "" };

        for (int i = 0; i < dados.length; i++) {
            System.out.println("Digite o " + dados[i] + " do autor: ");
            String res = inp.nextLine();

            resp[i] = res;
        }

        int id = getLastAutor() + 1;

        System.out.println("id: " + id);

        Autor autor = new Autor(resp[0], resp[1], id);

        new arquivosAutor(autor.getNome(), autor.getIdade(), autor.getId());

        return autor;

    }

    /**
     * Lista os autores cadastrados
     * 
     * @throws IOException
     */
    private static void listarAutores() throws IOException {
        List<String> lista = new ArrayList<String>();

        lista = arquivosAutor.listar();

        System.out.println(lista);
    }

    /**
     * Get de um autor específico
     * 
     * @throws IOException
     */
    private static void getAutor() throws IOException {

        Scanner inp = new Scanner(System.in);

        System.out.println("Digite o ID do autor: ");

        String id = inp.nextLine();

        List<String> lista = new ArrayList<String>();

        lista = arquivosAutor.getAutor(Integer.parseInt(id));

        System.out.println(lista);

    }

    /**
     * Atualização de um autor específico
     * 
     * @throws NumberFormatException
     * @throws IOException
     */
    private static void updateAutor() throws NumberFormatException, IOException {

        Scanner inp = new Scanner(System.in);

        System.out.println("Digite o ID do autor que desejas editar: ");

        String id_p = inp.nextLine();

        System.out.println("Digite a nova idade do autor: ");

        String idade = inp.nextLine();

        System.out.println("Digite o novo nome do autor: ");

        String nome = inp.nextLine();

        arquivosAutor.updateAuthor(Integer.parseInt(id_p), nome, idade);

    }

    /**
     * Delete de um autor específico
     * 
     * @throws NumberFormatException
     * @throws IOException
     */
    private static void deleteAutor() throws NumberFormatException, IOException {

        Scanner inp = new Scanner(System.in);

        System.out.println("Digite o ID do autor: ");

        String id_p = inp.nextLine();

        arquivosAutor.deleteAuthor(Integer.parseInt(id_p));

    }

    private static int getLastAutor() throws NumberFormatException, IOException {

        List<String> lista = new ArrayList<String>();

        char lastId = 0;

        lista = arquivosAutor.listar();

        String lastAuthor = lista.get(lista.size() - 1);

        lastId = lastAuthor.charAt(1);

        System.out.println("Last Id: " + lastId);

        int id = Character.getNumericValue(lastId);

        return id;

    }

}
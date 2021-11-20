package recuperacao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class arquivosAutor {

    private int id;
    private String idade;
    private String nome;

    private static Path authorDir = Paths.get("files", "Authors.csv");

    public arquivosAutor(String nome, String idade, int id) throws IOException {

        this.nome = nome;
        this.idade = idade;
        this.id = id;

        newAuthor();

        fillAuthorFile(nome, idade, id);

    }

    @Override
    public String toString() {
        return this.id + ";" + this.nome + ";" + this.idade + ";";
    }

    public void fillAuthorFile(String nome, String idade, int id) throws IOException {
        Files.writeString(authorDir, this.toString() + "\n", StandardOpenOption.APPEND);
    }

    public static List<String> listar() throws IOException {

        var linhas = Files.readAllLines(authorDir);

        List<String> lista = new ArrayList<String>();

        String[] campos = { "", "", "" };

        for (String linha : linhas) {
            campos = linha.split(";");

            int id = Integer.parseInt(campos[0]);

            Autor a = new Autor(campos[1], campos[2], id);

            lista.add("\n" + a.getId() + ";" + a.getNome() + ";" + a.getIdade() + ";");

            // (String nome, String idade, int id
        }

        return lista;
    }

    public static void newAuthor() throws IOException {

        Path dir = authorDir;
        if (!Files.exists(dir)) {
            Files.createFile(dir);
        }

    }

    public static List<String> getAutor(int id_p) throws IOException {

        var linhas = Files.readAllLines(authorDir);

        List<String> lista = new ArrayList<String>();

        String[] campos = { "", "", "" };

        for (String linha : linhas) {
            campos = linha.split(";");

            int id = Integer.parseInt(campos[0]);

            if (id == id_p) {

                Autor a = new Autor(campos[1], campos[2], id);

                lista.add(a.getId() + ";" + a.getNome() + ";" + a.getIdade() + ";");

            }

            // (String nome, String idade, int id
        }

        return lista;

    }

    public static void updateAuthor(int id_p, String nome, String idade) throws IOException {

        List<String> obj = getAutor(id_p);
        List<String> tudo = listar();

        String[] campos = { "", "", "" };

        Files.delete(authorDir);

        newAuthor();

        for (int i = 0; i < tudo.size(); i++) {
            tudo.set(i, tudo.get(i).replaceAll("\n", ""));
            if (!tudo.get(i).equals(obj.get(0))) {
                campos = tudo.get(i).split(";");

                int id = Integer.parseInt(campos[0]);

                Autor a = new Autor(campos[1], campos[2], id);

                new arquivosAutor(a.getNome(), a.getIdade(), a.getId());

            }
            if (tudo.get(i).equals(obj.get(0))) {

                System.out.println("obj " + obj);

                campos = obj.get(0).split(";");

                int id = Integer.parseInt(campos[0]);

                Autor a = new Autor(nome, idade, id);

                new arquivosAutor(a.getNome(), a.getIdade(), a.getId());

            }
        }

    }

    public static void deleteAuthor(int id_p) throws IOException {

        List<String> obj = getAutor(id_p);
        List<String> tudo = listar();

        String[] campos = { "", "", "" };

        Files.delete(authorDir);

        newAuthor();

        for (int i = 0; i < tudo.size(); i++) {
            tudo.set(i, tudo.get(i).replaceAll("\n", ""));
            if (!tudo.get(i).equals(obj.get(0))) {
                campos = tudo.get(i).split(";");

                int id = Integer.parseInt(campos[0]);

                Autor a = new Autor(campos[1], campos[2], id);

                new arquivosAutor(a.getNome(), a.getIdade(), a.getId());

            }
        }

    }

}

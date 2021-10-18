import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class arquivosAutor {

    private int id;
    private int vendidos;
    private int publicados;
    private String idade;
    private String nome;

    private static Path authorDir = Paths.get("files", "Authors.csv");

    public arquivosAutor(String nome, String idade, int id, int publicados, int vendidos) throws IOException {

        setNome(nome);
        setIdade(idade);
        setId(id);
        setVendidos(vendidos);
        setPublicados(publicados);

        newAuthor();

        fillAuthorFile(nome, idade, id, publicados, vendidos);

    }

    @Override
    public String toString() {
        return this.id + ";" + this.nome + ";" + this.idade + ";" + this.publicados + ";" + this.vendidos;
    }

    public void fillAuthorFile(String nome, String idade, int id, int publicados, int vendidos) throws IOException {
        Files.writeString(authorDir, this.toString() + "\n", StandardOpenOption.APPEND);
    }

    public static List<String> listar() throws IOException {

        var linhas = Files.readAllLines(authorDir);

        List<String> lista = new ArrayList<String>();

        String[] campos = { "", "", "", "", "" };

        for (String linha : linhas) {
            campos = linha.split(";");

            int id = Integer.parseInt(campos[0]);
            int vendidos = Integer.parseInt(campos[3]);
            int publicados = Integer.parseInt(campos[4]);

            Autor a = new Autor(campos[1], campos[2], id, vendidos, publicados);

            lista.add("\n" + a.getId() + ";" + a.getNome() + ";" + a.getIdade() + ";" + a.getPublicados() + ";"
                    + a.getVendidos());

            // (String nome, String idade, int id, int vendidos, int publicados
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

        String[] campos = { "", "", "", "", "" };

        for (String linha : linhas) {
            campos = linha.split(";");

            int id = Integer.parseInt(campos[0]);

            if (id == id_p) {

                int vendidos = Integer.parseInt(campos[3]);
                int publicados = Integer.parseInt(campos[4]);

                Autor a = new Autor(campos[1], campos[2], id, vendidos, publicados);

                lista.add(a.getId() + ";" + a.getNome() + ";" + a.getIdade() + ";" + a.getPublicados() + ";"
                        + a.getVendidos());

            }

            // (String nome, String idade, int id, int vendidos, int publicados
        }

        return lista;

    }

    public static void updateAuthor(int id_p, String nome, String idade, int vendidos, int publicados)
            throws IOException {

        List<String> obj = getAutor(id_p);
        List<String> tudo = listar();

        String[] campos = { "", "", "", "", "" };

        Files.delete(authorDir);

        newAuthor();

        for (int i = 0; i < tudo.size(); i++) {
            tudo.set(i, tudo.get(i).replaceAll("\n", ""));
            if (!tudo.get(i).equals(obj.get(0))) {
                campos = tudo.get(i).split(";");

                int id = Integer.parseInt(campos[0]);
                int nvendidos = Integer.parseInt(campos[3]);
                int npublicados = Integer.parseInt(campos[4]);

                Autor a = new Autor(campos[1], campos[2], id, nvendidos, npublicados);

                new arquivosAutor(a.getNome(), a.getIdade(), a.getId(), a.getPublicados(), a.getVendidos());

            }
            if (tudo.get(i).equals(obj.get(0))) {

                System.out.println("obj " + obj);

                campos = obj.get(0).split(";");

                int id = Integer.parseInt(campos[0]);

                Autor a = new Autor(nome, idade, id, vendidos, publicados);

                new arquivosAutor(a.getNome(), a.getIdade(), a.getId(), a.getPublicados(), a.getVendidos());

            }
        }

    }

    public static void deleteAuthor(int id_p) throws IOException {

        List<String> obj = getAutor(id_p);
        List<String> tudo = listar();

        String[] campos = { "", "", "", "", "" };

        Files.delete(authorDir);

        newAuthor();

        for (int i = 0; i < tudo.size(); i++) {
            tudo.set(i, tudo.get(i).replaceAll("\n", ""));
            if (!tudo.get(i).equals(obj.get(0))) {
                campos = tudo.get(i).split(";");

                int id = Integer.parseInt(campos[0]);
                int vendidos = Integer.parseInt(campos[3]);
                int publicados = Integer.parseInt(campos[4]);

                Autor a = new Autor(campos[1], campos[2], id, vendidos, publicados);

                new arquivosAutor(a.getNome(), a.getIdade(), a.getId(), a.getPublicados(), a.getVendidos());

            }
        }

    }

    public int setVendidos(int vendidos) {
        this.vendidos = vendidos;
        return this.vendidos;
    }

    public int setPublicados(int publicados) {
        this.publicados = publicados;
        return this.publicados;
    }

    private int setId(int id) {
        this.id = id;
        return this.id;
    }

    private String setIdade(String idade) {
        this.idade = idade;
        return this.idade;
    }

    private String setNome(String nome) {
        this.nome = nome;
        return this.nome;
    }

}

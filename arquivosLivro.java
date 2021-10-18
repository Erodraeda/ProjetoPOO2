import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class arquivosLivro {

    private int id;
    private String nome;
    private String genero;
    private int id_autor;
    private int paginas;
    private int vendidas;

    private static Path bookDir = Paths.get("files", "Books.csv");

    public arquivosLivro(int id, String nome, String genero, int id_autor, int paginas, int vendidas)
            throws IOException {

        setNome(nome);
        setGenero(genero);
        setId(id);
        setIdAutor(id_autor);
        setPaginas(paginas);
        setVendidas(vendidas);

        newBook();

        fillBookFile(id, nome, genero, id_autor, paginas, vendidas);

    }

    @Override
    public String toString() {
        return this.id + ";" + this.nome + ";" + this.id_autor + ";" + this.genero + ";" + this.paginas + ";"
                + this.vendidas;
    }

    public void fillBookFile(int id, String nome, String genero, int id_autor, int paginas, int vendidas)
            throws IOException {
        Files.writeString(bookDir, this.toString() + "\n", StandardOpenOption.APPEND);
    }

    public static void newBook() throws IOException {

        Path dir = bookDir;
        if (!Files.exists(dir)) {
            Files.createFile(dir);
        }

    }

    public static void deleteBook(int id_p) throws IOException {

        List<String> obj = getLivro(id_p);
        List<String> tudo = listar();

        String[] campos = { "", "", "", "", "", "" };

        Files.delete(bookDir);

        newBook();

        for (int i = 0; i < tudo.size(); i++) {
            tudo.set(i, tudo.get(i).replaceAll("\n", ""));
            if (!tudo.get(i).equals(obj.get(0))) {
                campos = tudo.get(i).split(";");

                int id = Integer.parseInt(campos[0]);
                int id_autor = Integer.parseInt(campos[2]);
                int paginas = Integer.parseInt(campos[4]);
                int vendidas = Integer.parseInt(campos[5]);

                Livro a = new Livro(id, campos[1], campos[3], id_autor, paginas, vendidas);

                new arquivosLivro(a.getId(), a.getNome(), a.getGenero(), a.getIdAutor(), a.getPaginas(),
                        a.getVendidas());

            }
        }

    }

    public static List<String> listar() throws IOException {

        var linhas = Files.readAllLines(bookDir);

        List<String> lista = new ArrayList<String>();

        String[] campos = { "", "", "", "", "", "" };

        for (String linha : linhas) {
            campos = linha.split(";");

            int id = Integer.parseInt(campos[0]);
            int id_autor = Integer.parseInt(campos[2]);
            int paginas = Integer.parseInt(campos[4]);
            int vendidas = Integer.parseInt(campos[5]);

            Livro a = new Livro(id, campos[1], campos[3], id_autor, paginas, vendidas);

            lista.add("\n" + a.getId() + ";" + a.getNome() + ";" + a.getIdAutor() + ";" + a.getGenero() + ";"
                    + a.getPaginas() + ";" + a.getVendidas());

            // int id, String nome, String genero, int id_autor, int paginas, int vendidas
        }

        return lista;
    }

    public static List<String> getLivro(int id_p) throws IOException {

        var linhas = Files.readAllLines(bookDir);

        List<String> lista = new ArrayList<String>();

        String[] campos = { "", "", "", "", "", "" };

        for (String linha : linhas) {
            campos = linha.split(";");

            int id = Integer.parseInt(campos[0]);

            if (id == id_p) {

                int id_autor = Integer.parseInt(campos[2]);
                int paginas = Integer.parseInt(campos[4]);
                int vendidas = Integer.parseInt(campos[5]);

                Livro a = new Livro(id, campos[1], campos[3], id_autor, paginas, vendidas);

                lista.add(a.getId() + ";" + a.getNome() + ";" + a.getIdAutor() + ";" + a.getGenero() + ";"
                        + a.getPaginas() + ";" + a.getVendidas());

            }

            // int id, String nome, String genero, int id_autor, int paginas, int vendidas
        }

        return lista;
    }

    public static void updateBook(int id_p, String nome, String genero, int id_autor, int paginas, int vendidas)
            throws IOException {

        List<String> obj = getLivro(id_p);
        List<String> tudo = listar();

        String[] campos = { "", "", "", "", "", "" };

        Files.delete(bookDir);

        newBook();

        for (int i = 0; i < tudo.size(); i++) {
            tudo.set(i, tudo.get(i).replaceAll("\n", ""));
            if (!tudo.get(i).equals(obj.get(0))) {
                campos = tudo.get(i).split(";");

                int id = Integer.parseInt(campos[0]);
                int nid_autor = Integer.parseInt(campos[2]);
                int npaginas = Integer.parseInt(campos[4]);
                int nvendidas = Integer.parseInt(campos[5]);

                Livro a = new Livro(id, campos[1], campos[3], nid_autor, npaginas, nvendidas);

                new arquivosLivro(a.getId(), a.getNome(), a.getGenero(), a.getIdAutor(), a.getPaginas(),
                        a.getVendidas());

            }
            if (tudo.get(i).equals(obj.get(0))) {

                System.out.println("obj " + obj);

                campos = obj.get(0).split(";");

                int id = Integer.parseInt(campos[0]);

                Livro a = new Livro(id, nome, genero, id_autor, paginas, vendidas);

                // String nome, String genero, int id_autor, int paginas, int vendidas

                new arquivosLivro(a.getId(), a.getNome(), a.getGenero(), a.getIdAutor(), a.getPaginas(),
                        a.getVendidas());

            }
        }

    }

    /**
     * Set do numero de vendas do livro
     * 
     * @param venda numero de vendas do livro
     * @return numero de vendas do livro
     */
    public int setVendidas(int venda) {
        this.vendidas = this.vendidas + venda;
        return this.vendidas;
    }

    /**
     * Set do nome do livro
     * 
     * @param nome nome do livro
     * @return nome do livro
     */
    private String setNome(String nome) {
        this.nome = nome;
        return this.nome;
    }

    /**
     * Set do genero do livro
     * 
     * @param genero genero do livro
     * @return genero do livro
     */
    private String setGenero(String genero) {
        this.genero = genero;
        return this.genero;
    }

    /**
     * Set do ID do livro
     * 
     * @param id ID do livro
     * @return ID do livro
     */
    private int setId(int id) {
        this.id = id;
        return this.id;
    }

    /**
     * Set do ID do autor do livro
     * 
     * @param id_autor ID do autor do livro
     * @return ID do autor do livro
     */
    private int setIdAutor(int id_autor) {
        this.id_autor = id_autor;
        return this.id_autor;
    }

    /**
     * Set do numero de paginas do livro
     * 
     * @param paginas numero de paginas do livro
     * @return numero de paginas do livro
     */
    private int setPaginas(int paginas) {
        this.paginas = paginas;
        return this.paginas;
    }

}

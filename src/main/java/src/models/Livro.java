package src.models;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;

public class Livro {

    private int id;
    private String nome;
    private int paginas;
    private Autor autor;

    public Livro(int id, String nome, int paginas, Autor autor) {

        setId(id);
        setNome(nome);
        setPaginas(paginas);
        setAutor(autor);

    }

    /**
     * Construtor da classe Livro
     *
     * @param nome
     * @param paginas
     * @throws IOException
     */
    public Livro(String nome, int paginas) {

        setNome(nome);
        setPaginas(paginas);

    }

    public Livro() {

    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public int getPaginas() {
        return this.paginas;
    }

    public Autor getAutor() {
        return this.autor;
    }

    public int setPaginas(int paginas) {
        this.paginas = paginas;
        return this.paginas;
    }

    public String setNome(String nome) {
        this.nome = nome;
        return this.nome;
    }

    public int setId(int id) {
        this.id = id;
        return this.id;
    }

    public Autor setAutor(Autor autor) {
            this.autor = autor;

        return this.autor;
    }
}
package src.models;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;

public class Livro {

    private int id;
    private String nome;
    private int paginas;
    private ArrayList<Autor> autores = new ArrayList<Autor>();

    /**
     * Construtor da classe Livro
     *
     * @param id
     * @param nome
     * @param paginas
     * @throws IOException
     */
    public Livro(int id, String nome, int paginas, ArrayList<Autor> autores) {

        setId(id);
        setNome(nome);
        setPaginas(paginas);
        setAutores(autores);

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
        setAutores(autores);

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

    public ArrayList<Autor> getAutores() {
        return this.autores;
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

    public ArrayList<Autor> setAutores(ArrayList<Autor> autores) {
        for (var autor:autores) {
            this.autores.add(autor);
        }

        return this.autores;
    }
}
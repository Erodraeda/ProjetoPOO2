package src.models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Livro {

    private int id;
    private String nome;
    private int paginas;
    private final ArrayList<Autor> autor = new ArrayList<>();

    public Livro(int id, String nome, int paginas, ArrayList<Autor> autores) {

        this.id = id;
        this.nome = nome;
        this.paginas = paginas;
        this.autor.addAll(autores);

    }

    public Livro(int id, String nome, int paginas, Autor autor) {

        this.id = id;
        this.nome = nome;
        this.paginas = paginas;
        this.autor.add(autor);

    }

    public Livro(String nome, int paginas) {

        this.nome = nome;
        this.paginas = paginas;

    }

    public Livro(String nome, int paginas, Autor autorLivro) {

        this.nome = nome;
        this.paginas = paginas;
        this.autor.add(autorLivro);

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

    public ArrayList<Autor> getAutor() {
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

    public ArrayList<Autor> setAutor(Autor autorLivro) {
        ArrayList<Autor> autor = new ArrayList<>();
        this.autor.add(autorLivro);
        return this.autor;
    }

    public ArrayList<Autor> setAutores(ArrayList<Autor> autores) {
        this.autor.addAll(autores);
        return this.autor;
    }
}
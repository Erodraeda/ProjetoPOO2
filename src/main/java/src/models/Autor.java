package src.models;

import java.io.IOException;

public class Autor {

    private int id;
    private int idade;
    private String nome;

    /**
     * Construtor da classe Autor
     *
     * @param nome
     * @param idade
     * @throws IOException
     */
    public Autor(String nome, int idade, int id) throws IOException {

        setNome(nome);
        setIdade(idade);
        setId(id);

    }

    /**
     * Construtor da classe Autor
     *
     * @param nome
     * @param idade
     * @throws IOException
     */
    public Autor(String nome, int idade) throws IOException {

        setNome(nome);
        setIdade(idade);

    }

    public Autor(String nome) {

        setNome(nome);

    }

    public Autor() throws IOException {}

    public int getId() {
        return this.id;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getNome() {
        return this.nome;
    }

    public int setId(int id) {
        this.id = id;
        return this.id;
    }

    public int setIdade(int idade) {
        this.idade = idade;
        return this.idade;
    }

    public String setNome(String nome) {
        this.nome = nome;
        return this.nome;
    }

}
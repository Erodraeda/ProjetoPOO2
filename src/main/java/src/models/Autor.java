package src.models;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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

    public Autor(String nome, int idade) throws IOException {

        setNome(nome);
        setIdade(idade);

    }

    public Autor() throws IOException {}

    /**
     * Get do ID do autor
     * 
     * @return ID do autor
     */
    public int getId() {
        return this.id;
    }

    /**
     * Get da idade do autor
     * 
     * @return idade do autor
     */
    public int getIdade() {
        return this.idade;
    }

    /**
     * Get do nome do autor
     * 
     * @return nome do autor
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Set do ID do autor
     *
     * @param id
     * @return ID do autor
     */
    public int setId(int id) {
        this.id = id;
        return this.id;
    }

    /**
     * Set da idade do autor
     * 
     * @param idade
     * @return idade do autor
     */
    public int setIdade(int idade) {
        this.idade = idade;
        return this.idade;
    }

    /**
     * Set do nome do autor
     * 
     * @param nome
     * @return nome do autor
     */
    public String setNome(String nome) {
        this.nome = nome;
        return this.nome;
    }

}
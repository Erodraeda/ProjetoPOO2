package recuperacao;

import java.io.IOException;

public class Autor {

    private int id;
    private String idade;
    private String nome;

    /**
     * Construtor da classe Autor
     * 
     * @param nome
     * @param idade
     * @param id
     * @throws IOException
     */
    public Autor(String nome, String idade, int id) throws IOException {

        setNome(nome);
        setIdade(idade);
        setId(id);

    }

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
    public String getIdade() {
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
    private int setId(int id) {
        this.id = id;
        return this.id;
    }

    /**
     * Set da idade do autor
     * 
     * @param idade
     * @return idade do autor
     */
    private String setIdade(String idade) {
        this.idade = idade;
        return this.idade;
    }

    /**
     * Set do nome do autor
     * 
     * @param nome
     * @return nome do autor
     */
    private String setNome(String nome) {
        this.nome = nome;
        return this.nome;
    }

}
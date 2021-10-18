import java.io.IOException;

public class Autor {

    private int id;
    private int vendidos = 0;
    private int publicados = 0;
    private String idade;
    private String nome;

    /**
     * Construtor da classe Autor
     * 
     * @param nome
     * @param idade
     * @param id
     * @param vendidos
     * @param publicados
     * @throws IOException
     */
    public Autor(String nome, String idade, int id, int vendidos, int publicados) throws IOException {

        setNome(nome);
        setIdade(idade);
        setId(id);
        setVendidos(vendidos);
        setPublicados(publicados);

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
     * Get do numero de copias vendidas do autor
     * 
     * @return numero de copias vendidas
     */
    public int getVendidos() {
        return this.vendidos;
    }

    /**
     * Get do numero de copias publicadas do autor
     * 
     * @return numero de copias publicadas
     */
    public int getPublicados() {
        return this.publicados;
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
     * Set do numero de copias vendidas
     * 
     * @param vendidos
     * @return numero copias vendidas
     */
    public int setVendidos(int vendidos) {
        this.vendidos = vendidos;
        return this.vendidos;
    }

    /**
     * Set do numero de copias publicadas
     * 
     * @param publicados
     * @return numero copias publicadas
     */
    public int setPublicados(int publicados) {
        this.publicados = publicados;
        return this.publicados;
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
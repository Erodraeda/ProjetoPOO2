import java.io.IOException;

public class Livro {

    private int id;
    private String nome;
    private String genero;
    private int id_autor;
    private int paginas;
    private int vendidas;

    public Livro(int id, String nome, String genero, int id_autor, int paginas, int vendidas) throws IOException {

        setNome(nome);
        setGenero(genero);
        setId(id);
        setIdAutor(id_autor);
        setPaginas(paginas);
        setVendidas(vendidas);

    }

    /**
     * Get do ID do livro
     * 
     * @return ID do livro
     */
    public int getId() {
        return this.id;
    }

    /**
     * Get do ID do autor do livro
     * 
     * @return ID do autor do livro
     */
    public int getIdAutor() {
        return this.id_autor;
    }

    /**
     * Get do nome do livro
     * 
     * @return nome do livro
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Get do genero do livro
     * 
     * @return genero do livro
     */
    public String getGenero() {
        return this.genero;
    }

    /**
     * Get do numero de paginas do livro
     * 
     * @return numero de paginas do livro
     */
    public int getPaginas() {
        return this.paginas;
    }

    /**
     * Get do numero de vendas do livro
     * 
     * @return numero de vendas do livro
     */
    public int getVendidas() {
        return this.vendidas;
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
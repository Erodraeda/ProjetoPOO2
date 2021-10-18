import java.io.IOException;

public class Autor {

    private int id;
    private int vendidos = 0;
    private int publicados = 0;
    private String idade;
    private String nome;

    public Autor(String nome, String idade, int id, int vendidos, int publicados) throws IOException {

        setNome(nome);
        setIdade(idade);
        setId(id);
        setVendidos(vendidos);
        setPublicados(publicados);

    }

    public int getId() {
        return this.id;
    }

    public int getVendidos() {
        return this.vendidos;
    }

    public int getPublicados() {
        return this.publicados;
    }

    public String getIdade() {
        return this.idade;
    }

    public String getNome() {
        return this.nome;
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
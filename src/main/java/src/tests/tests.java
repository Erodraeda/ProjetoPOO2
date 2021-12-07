package src.tests;

import java.io.IOException;
import java.sql.SQLException;

public class tests {

    public static void main(String[] args) throws IOException, SQLException {

        TestAutor testAutor = new TestAutor();
        TestLivro testLivro = new TestLivro();

        if (testAutor.testInsertAutor() && testAutor.testGetAutor() && testAutor.testListAutor() && testAutor.testUpdateAutor() && testAutor.testDeleteAutor()) {
            System.out.println("Testes autor todos ok");
        } else {
            System.out.println("Algum teste de autor não está funcional.");
        }

        if (testLivro.testInsertLivro() && testLivro.testGetLivro() && testLivro.testListLivro() && testLivro.testUpdateLivro() && testLivro.testDeleteLivro()) {
            System.out.println("Testes livro todos ok");
        } else {
            System.out.println("Algum teste de livro não está funcional.");
        }

        if (testLivro.testInsertAutoriaAutomatico() && testLivro.testInsertAutoriaManual() && testLivro.testDeleteAutoria()) {
            System.out.println("Testes autoria todos ok");
        } else {
            System.out.println("Algum teste de autoria não está funcional.");
        }

    }

}
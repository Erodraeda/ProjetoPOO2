package src.tests;

import src.DAO.LivroDAO;
import src.models.Autor;
import src.models.Livro;

import java.io.IOException;

public class TestLivro {

    Autor autor = new Autor("Lucas", 21, 1);

    Livro livro = new Livro(1, "HP 1", 420, autor);
    Livro livro2 = new Livro(2, "HP 2", 690, autor);

    src.DAO.LivroDAO livroDAO = new LivroDAO();

    public TestLivro() throws IOException {
    }

    public boolean testInsertLivro() {
        var insert = livroDAO.insert(livro);

        if (insert == true) {
            System.out.println("testInsertLivro ok");
            return true;
        }
        else return false;
    }

    public boolean testInsertAutoriaAutomatico() {
        var insert = livroDAO.insert(1);

        if (insert == true) {
            System.out.println("testInsertAutoriaAutomatico ok");
            return true;
        }
        else return false;
    }

    public boolean testInsertAutoriaManual() {
        var insert = livroDAO.insert(1, 2);

        if (insert == true) {
            System.out.println("testInsertAutoriaManual ok");
            return true;
        }
        else return false;
    }

    public boolean testGetLivro() {
        String get = livroDAO.get(1).getNome() + ", " + livroDAO.get(1).getPaginas();

        if ("HP 1, 420".equals(get)) {
            System.out.println("testGetLivro ok");
            return true;
        }
        else return false;
    }

    public boolean testListLivro() {
        var list = livroDAO.list();

        if (!list.isEmpty()) {
            System.out.println("testListLivro ok");
            return true;
        }
        else return false;
    }

    public boolean testUpdateLivro() {
        Livro livroUpdate = new Livro(1, "Harry Potter 1", 420,  autor);

        var update = livroDAO.update(livroUpdate);

        if (update == true) {
            System.out.println("testUpdateLivro ok");
            return true;
        }
        else return false;
    }

    public boolean testDeleteLivro() {
        livroDAO.insert(livro2);
        var delete = livroDAO.delete(2);

        if (delete == true) {
            System.out.println("testDeleteLivro ok");
            return true;
        }
        else return false;
    }

    public boolean testDeleteAutoria() {
        var delete = livroDAO.deleteAutoria(2, 1);

        if (delete == true) {
            System.out.println("testDeleteAutoria ok");
            return true;
        }
        else return false;
    }
}

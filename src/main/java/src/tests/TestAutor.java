package src.tests;

import src.DAO.AutorDAO;
import src.models.Autor;

import java.io.IOException;

public class TestAutor {

    Autor autor = new Autor("Lucas", 21, 1);
    Autor autor2 = new Autor("Walter", 21, 2);

    src.DAO.AutorDAO AutorDAO = new AutorDAO();

    public TestAutor() throws IOException {}

    boolean testInsertAutor() {
        var insert = AutorDAO.insert(autor);

        if (insert == true) {
            System.out.println("testInsertAutor ok");
            return true;
        }
        else return false;
    }

    boolean testGetAutor() {
        String get = AutorDAO.get(1).getNome() + ", " + AutorDAO.get(1).getIdade();

        if ("Lucas, 21".equals(get)) {
            System.out.println("testGetAutor ok");
            return true;
        }
        else return false;
    }

    boolean testListAutor() {
        var list = AutorDAO.list();

        if (!list.isEmpty()) {
            System.out.println("testListAutor ok");
            return true;
        }
        else return false;
    }

    boolean testUpdateAutor() throws IOException {
        Autor autorUpdate = new Autor("Lucas Walter", 21, 1);

        var update = AutorDAO.update(autorUpdate);

        if (update == true) {
            System.out.println("testUpdateAutor ok");
            return true;
        }
        else return false;
    }

    boolean testDeleteAutor() {
        AutorDAO.insert(autor2);
        var delete = AutorDAO.delete(2);

        if (delete == true) {
            System.out.println("testDeleteAutor ok");
            return true;
        }
        else return false;
    }











}

package src.tests;

import src.DAO.AutorDAO;
import src.models.Autor;

import java.io.IOException;
import java.sql.SQLException;

public class tests {

    private static int testValues = 0;

    public static void main(String[] args) throws IOException, SQLException {

        Autor autor = new Autor("Lucas", 21, 1);
        Autor autor2 = new Autor("Walter", 21, 2);

        AutorDAO AutorDAO = new AutorDAO();

        var insert = AutorDAO.insert(autor);

        if (insert == true) testValues++;

        System.out.println("Get: " + AutorDAO.get(1).getId() + ", " + AutorDAO.get(1).getNome() + ", " + AutorDAO.get(1).getIdade());

        var list = AutorDAO.list();

        if (!list.isEmpty()) testValues++;

        Autor autorUpdate = new Autor("Lucas Walter", 21, 1);

        var update = AutorDAO.update(autorUpdate);

        if (update == true) testValues++;

        var delete = AutorDAO.delete(2);

        if (delete == true) testValues++;

        System.out.println("Valor total nos testes: " + testValues + "/4");

    }

}

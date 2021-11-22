package src.tests;

import src.DAO.Autor_DAO;
import src.models.Autor;

import java.io.IOException;
import java.sql.SQLException;

public class tests {

    private static int testValues = 0;

    public static void main(String[] args) throws IOException, SQLException {

        Autor autor = new Autor("Lucas", 21, 1);
        Autor autor2 = new Autor("Walter", 21, 2);

        var insert = Autor_DAO.insert(autor);

        if (insert == true) testValues++;

        System.out.println("Get: " + Autor_DAO.get(1).getId() + ", " + Autor_DAO.get(1).getNome() + ", " + Autor_DAO.get(1).getIdade());

        var list = Autor_DAO.list();

        if (!list.isEmpty()) testValues++;

        Autor autorUpdate = new Autor("Lucas Walter", 21, 1);

        var update = Autor_DAO.update(autorUpdate);

        if (update == true) testValues++;

        var delete = Autor_DAO.delete(2);

        if (delete == true) testValues++;

        System.out.println("Valor total nos testes: " + testValues + "/4");

    }

}

package src.DAO;

import java.sql.Connection;
import java.sql.SQLException;

public class Autor_DAO {

    public static void insert() throws SQLException {

        Connection con = ConnectionFactory.getConnection();

        String query = "INSERT INTO autores(nome, idade) VALUES (?,?)";
        var pstm = con.prepareStatement(query);
        System.out.println(pstm);
    }

    // public static void () throws SQLException {

    // }

}

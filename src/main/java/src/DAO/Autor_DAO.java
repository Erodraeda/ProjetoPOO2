package src.DAO;

import src.models.Autor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Autor_DAO {

    public static boolean insert(Autor autor) throws SQLException {
//
        String query = "INSERT INTO autor(nome, idade) VALUES (?,?)";

        try (Connection con = ConnectionFactory.getConnection()){
            var pstm = con.prepareStatement(query);
            pstm.setString(1, autor.getNome());
            pstm.setInt(2, autor.getIdade());

            var rs = pstm.executeUpdate();
//            rs.next();
//            rs.close();
            pstm.close();
            return true;
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static Autor get(int id) throws SQLException {

        String sql = "SELECT * FROM autor WHERE id = ?";

        try(Connection con = ConnectionFactory.getConnection()){
            var pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            var rs = pstm.executeQuery();
            Autor autor = null;
            if (rs.next()){
                autor = new Autor();
                autor.setNome(rs.getString("nome"));
                autor.setIdade(rs.getInt("idade"));
                rs.close();
                pstm.close();
            }
            return autor;
        }catch (SQLException | IOException e){
            throw new RuntimeException(e);
        }
    }

    public static List<Autor> list() throws SQLException {

        String sql = "SELECT * FROM autor";

        List<Autor> users = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection()){
            var pstm = con.prepareStatement(sql);
//            pstm.setInt(1, limit);
//            pstm.setInt(2, offset);
            var rs = pstm.executeQuery();
            while (rs.next()){
                Autor u = new Autor();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setIdade(rs.getInt("idade"));
                users.add(u);
            }
            rs.close();
            pstm.close();
            return users;
        }catch(SQLException | IOException e){
            throw new RuntimeException(e);
        }

    }

    public static boolean update(Autor autor) {
        String sql = "UPDATE autor SET nome = ?, idade = ? WHERE id = ?";
        try (Connection con = ConnectionFactory.getConnection()){
            var pstm = con.prepareStatement(sql);
            pstm.setString(1, autor.getNome());
            pstm.setInt(2, autor.getIdade());
            pstm.setInt(3, autor.getId());
            pstm.execute();
            pstm.close();
            return true;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static boolean delete(int id) {
        String sql = "DELETE FROM autor WHERE id = ?";
        try (Connection con = ConnectionFactory.getConnection()){
            var pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
            pstm.close();
            return true;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}

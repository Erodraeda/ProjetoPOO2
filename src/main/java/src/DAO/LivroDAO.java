package src.DAO;

import src.models.Autor;
import src.models.Livro;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO implements DAO<Livro> {

    public boolean insert(Livro livro) {

        String query = "INSERT INTO livro(nome, paginas) VALUES (?,?)";

        try (Connection con = ConnectionFactory.getConnection()){
            var pstm = con.prepareStatement(query);
            pstm.setString(1, livro.getNome());
            pstm.setInt(2, livro.getPaginas());

            pstm.executeUpdate();
            pstm.close();
            return true;
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean insert(int id_autor) {

        String query = "SELECT id FROM livro ORDER BY id DESC LIMIT 1";

        String query2 = "INSERT INTO autoria (id_autor, id_livro) VALUES (?,?)";

        try (Connection con = ConnectionFactory.getConnection()){
            var pstm = con.prepareStatement(query);
            var rs = pstm.executeQuery();

            if (rs.next()) {
                int id_livro = rs.getInt("id");
                var pstm2 = con.prepareStatement(query2);
                pstm2.setInt(1, id_autor);
                pstm2.setInt(2, id_livro);
                pstm2.executeUpdate();
                rs.close();
                pstm2.close();
            }

            pstm.close();

            return true;
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Livro get(int id) {

        String sql = "SELECT * FROM livro WHERE id = ?";

        try(Connection con = ConnectionFactory.getConnection()){
            var pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            var rs = pstm.executeQuery();
            Livro livro = null;
            if (rs.next()){
                livro = new Livro();
                livro.setNome(rs.getString("nome"));
                livro.setPaginas(rs.getInt("paginas"));
                rs.close();
                pstm.close();
            }
            return livro;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Livro> list() {

        String sql = "SELECT * FROM livro";

        List<Livro> livros = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection()){
            var pstm = con.prepareStatement(sql);
//            pstm.setInt(1, limit);
//            pstm.setInt(2, offset);
            var rs = pstm.executeQuery();
            while (rs.next()){
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setNome(rs.getString("nome"));
                livro.setPaginas(rs.getInt("paginas"));
                livros.add(livro);
            }
            rs.close();
            pstm.close();
            return livros;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    public boolean update(Livro livro) {
        String sql = "UPDATE livro SET nome = ?, paginas = ? WHERE id = ?";
        try (Connection con = ConnectionFactory.getConnection()){
            var pstm = con.prepareStatement(sql);
            pstm.setString(1, livro.getNome());
            pstm.setInt(2, livro.getPaginas());
            pstm.setInt(3, livro.getId());
            pstm.execute();
            pstm.close();
            return true;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM livro WHERE id = ?";
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

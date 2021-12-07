package src.DAO;

import src.models.Autor;
import src.models.Livro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        } catch(SQLException e) {
            System.out.println("Erro executando insert Livro: " + e.getMessage());
            return false;
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
            System.out.println("Erro executando insert Livro: " + e.getMessage());
            return false;
        }

    }

    public boolean insert(int id_autor, int id_livro) {

        String query = "INSERT INTO autoria (id_autor, id_livro) VALUES (?,?)";

        try (Connection con = ConnectionFactory.getConnection()){
            var pstm = con.prepareStatement(query);

            pstm.setInt(1, id_autor);
            pstm.setInt(2, id_livro);

            pstm.executeUpdate();
            pstm.close();
            return true;
        }catch(SQLException e) {
            System.out.println("Erro executando insert Autoria: " + e.getMessage());
            return false;
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

        String sql = "select livro.id, livro.nome, livro.paginas, autor.nome, autor.idade, autor.id from livro join autoria on livro.id = autoria.id_livro join autor on autor.id = autoria.id_autor";

        List<Livro> livros = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection()){
            var pstm = con.prepareStatement(sql);
//            pstm.setInt(1, limit);
//            pstm.setInt(2, offset);
            var rs = pstm.executeQuery();
            while (rs.next()){
                Livro livro = new Livro();

                ArrayList<Autor> autores = new ArrayList<>();
                livro.setId(rs.getInt(1));
                livro.setNome(rs.getString(2));
                livro.setPaginas(rs.getInt(3));
                livro.setAutor(new Autor(rs.getString(4), rs.getInt(5), rs.getInt(6)));
                livros.add(livro);
            }
            rs.close();
            pstm.close();
            return livros;
        }catch(SQLException | IOException e){
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

    public boolean deleteAutoria(int id_livro, int id_autor) {
        String sql = "DELETE FROM autoria WHERE id_livro = ? AND id_autor = ?";
        try (Connection con = ConnectionFactory.getConnection()){
            var pstm = con.prepareStatement(sql);
            pstm.setInt(1, id_livro);
            pstm.setInt(2, id_autor);
            pstm.execute();
            pstm.close();
            return true;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}

package src.DAO;

import src.models.Autor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutorDAO implements DAO<Autor> {

    public boolean insert(Autor autor) {

        String query = "INSERT INTO autor(nome, idade) VALUES (?,?)";

        try (Connection con = ConnectionFactory.getConnection()){
            var pstm = con.prepareStatement(query);
            pstm.setString(1, autor.getNome());
            pstm.setInt(2, autor.getIdade());

            pstm.executeUpdate();
            pstm.close();
            return true;
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public Autor get(int id) {

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

    public List<Autor> list() {

        String sql = "SELECT * FROM autor";

        List<Autor> autores = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection()){
            var pstm = con.prepareStatement(sql);
//            pstm.setInt(1, limit);
//            pstm.setInt(2, offset);
            var rs = pstm.executeQuery();
            while (rs.next()){
                Autor autor = new Autor();
                autor.setId(rs.getInt("id"));
                autor.setNome(rs.getString("nome"));
                autor.setIdade(rs.getInt("idade"));
                autores.add(autor);
            }
            rs.close();
            pstm.close();
            return autores;
        }catch(SQLException | IOException e){
            throw new RuntimeException(e);
        }

    }

    public List<Autor> listAutores(int id_livro) {

        String sql = "SELECT autor.id, autor.nome FROM livro JOIN autoria ON livro.id = autoria.id_livro JOIN autor ON autor.id = autoria.id_autor WHERE autoria.id_livro = ?";

        List<Autor> autores = new ArrayList<>();

        try (Connection con = ConnectionFactory.getConnection()){
            var pstm = con.prepareStatement(sql);
            pstm.setInt(1, id_livro);
            var rs = pstm.executeQuery();
            while (rs.next()){
                Autor autor = new Autor();

                autor.setId(rs.getInt(1));
                autor.setNome(rs.getString(2));
                autores.add(autor);
            }
            rs.close();
            pstm.close();
            return autores;
        }catch(SQLException | IOException e){
            throw new RuntimeException(e);
        }

    }

    public boolean update(Autor autor) {
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

    public boolean delete(int id) {
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

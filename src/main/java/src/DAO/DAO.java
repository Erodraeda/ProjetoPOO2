package src.DAO;

public interface DAO <T> {

    public boolean insert(T obj);
    public T get (int id);
    public boolean update(T obj);
    public boolean delete(int id);

}
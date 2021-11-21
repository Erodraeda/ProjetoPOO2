package recuperacao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class testPersistencia {

    private static Path authorDir = Paths.get("files", "Authors.csv");
    private static int testValue = 0;

    public static void testes() throws IOException {

        Path dir = authorDir;
        if (Files.exists(dir)) {
            Files.delete(dir);
            Files.createFile(dir);
            testValue++;
        } else {
            Files.createFile(dir);
            testValue++;
        }

        Autor autor1 = new Autor("Lucas", "21", 1);
        if (autor1.getId() == 1) {
            System.out.println("Autor 1 existe? " + true);
            testValue++;
        } else
            System.out.println("Autor 1 existe? " + false);

        new arquivosAutor(autor1.getNome(), autor1.getIdade(), autor1.getId());
        if (arquivosAutor.getAutor(1) != null) {
            System.out.println("Autor 1 " + arquivosAutor.getAutor(1));
            testValue++;
        }

        Autor autor2 = new Autor("Alice", "18", 2);
        if (autor2.getId() == 2) {
            System.out.println("Autor 2 existe? " + true);
            testValue++;
        } else
            System.out.println("Autor 2 existe? " + false);

        new arquivosAutor(autor2.getNome(), autor2.getIdade(), autor2.getId());
        if (arquivosAutor.getAutor(2) != null) {
            System.out.println("Autor 2 " + arquivosAutor.getAutor(2));
            testValue++;
        }

        Autor autor3 = new Autor("Thiago", "30", 3);
        if (autor3.getId() == 3) {
            System.out.println("Autor 3 existe? " + true);
            testValue++;
        } else
            System.out.println("Autor 3 existe? " + false);

        new arquivosAutor(autor3.getNome(), autor3.getIdade(), autor3.getId());
        if (arquivosAutor.getAutor(3) != null) {
            System.out.println("Autor 3 " + arquivosAutor.getAutor(3));
            testValue++;
        }

        arquivosAutor.listar();
        if (!arquivosAutor.listar().isEmpty()) {
            System.out.println("Lista de autores vazia? " + false + "\n" + arquivosAutor.listar());
            testValue++;
        } else
            System.out.println("Lista de autores vazia? " + true);

        arquivosAutor.updateAuthor(3, "Tiago", "32");
        System.out.println("Autor editado: " + arquivosAutor.getAutor(3));
        if (arquivosAutor.getAutor(3).get(0).equals("3;Tiago;32;")) {
            testValue++;
        }

        arquivosAutor.deleteAuthor(2);
        System.out.println("Autor deletado: " + arquivosAutor.getAutor(2));
        if (arquivosAutor.getAutor(2).isEmpty()) {
            System.out.println("Autor Deletado? " + true);
            testValue++;
        } else
            System.out.println("Autor Deletado? " + false);

        System.out.println("Valor total nos testes: " + testValue + "/10");

        System.exit(1);
    }

}

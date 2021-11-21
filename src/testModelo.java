package src;

import java.io.IOException;

import src.models.Autor;

public class testModelo {

    public static void testes() throws IOException {
        Autor autor1 = new Autor("Lucas", "21", 1);
        if (autor1.getId() == 1)
            System.out.println("Autor 1 existe? " + true);
        else
            System.out.println("Autor 1 existe? " + false);

        Autor autor2 = new Autor("Alice", "18", 2);
        if (autor2.getId() == 2)
            System.out.println("Autor 2 existe? " + true);
        else
            System.out.println("Autor 2 existe? " + false);

        Autor autor3 = new Autor("Thiago", "30", 3);
        if (autor3.getId() == 3)
            System.out.println("Autor 3 existe? " + true);
        else
            System.out.println("Autor 3 existe? " + false);

        System.out.println(autor1.getId());
        System.out.println(autor1.getNome());
        System.out.println(autor1.getIdade());

        System.out.println(autor2.getId());
        System.out.println(autor2.getNome());
        System.out.println(autor2.getIdade());

        System.out.println(autor3.getId());
        System.out.println(autor3.getNome());
        System.out.println(autor3.getIdade());

    }

}

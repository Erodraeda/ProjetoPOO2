package recuperacao;

import java.io.IOException;

public class testModelo {

    private static int testValue = 0;

    public static void testes() throws IOException {
        Autor autor1 = new Autor("Lucas", "21", 1);
        if (autor1.getId() == 1) {
            System.out.println("Autor 1 existe? " + true);
            testValue++;
        } else
            System.out.println("Autor 1 existe? " + false);

        Autor autor2 = new Autor("Alice", "18", 2);
        if (autor2.getId() == 2) {
            System.out.println("Autor 2 existe? " + true);
            testValue++;
        } else
            System.out.println("Autor 2 existe? " + false);

        Autor autor3 = new Autor("Thiago", "30", 3);
        if (autor3.getId() == 3) {
            System.out.println("Autor 3 existe? " + true);
            testValue++;
        } else
            System.out.println("Autor 3 existe? " + false);

        System.out.println(autor1.getId());
        if (autor1.getId() == 1)
            testValue++;
        System.out.println(autor1.getNome());
        if (autor1.getNome() == "Lucas")
            testValue++;
        System.out.println(autor1.getIdade());
        if (autor1.getIdade() == "21")
            testValue++;

        System.out.println(autor2.getId());
        if (autor2.getId() == 2)
            testValue++;
        System.out.println(autor2.getNome());
        if (autor2.getNome() == "Alice")
            testValue++;
        System.out.println(autor2.getIdade());
        if (autor2.getIdade() == "18")
            testValue++;

        System.out.println(autor3.getId());
        if (autor3.getId() == 3)
            testValue++;
        System.out.println(autor3.getNome());
        if (autor3.getNome() == "Thiago")
            testValue++;
        System.out.println(autor3.getIdade());
        if (autor3.getIdade() == "30")
            testValue++;

        System.out.println("Valor total nos testes: " + testValue + "/12");

    }

}

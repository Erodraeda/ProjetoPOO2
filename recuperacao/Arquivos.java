package recuperacao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Arquivos {

    private Path dir;

    public Arquivos() {
        this.dir = Paths.get("");
    }

    public void mkDir(String dir) throws IOException {

        Path newDir = this.dir.resolve(dir);
        if (!Files.exists(newDir)) {
            Files.createDirectory(newDir);
        }

    }

}
import java.nio.file.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileIO {
    public void read() {
        try {
            List<String> linhas = Files.readAllLines(Paths.get("arquivo.txt"));
            System.out.println(Paths.get("arquivo.txt").toString());
            linhas.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

        public void write() {
        try {
            Files.write(Paths.get("arquivo.txt"), Arrays.asList("Nova linha adicionada"), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}

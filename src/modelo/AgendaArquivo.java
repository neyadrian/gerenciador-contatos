package modelo;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AgendaArquivo {

    List<String> linhas = Files.readAllLines(Paths.get("agenda.txt"));

}

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileHandler {

    private FileHandler(){

    }
    public List<Nomination> readNominationFile(String path){
        try(Stream<String> linesStream = Files.lines(
                Paths.get(path), StandardCharsets.UTF_8)){
            return linesStream.skip(1).map((java.util.function.Function<? super String, ? extends Nomination>) this::parseLineToNomination).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private Object parseLineToNomination(String s) {
        String[] parts = s.split("\t");
        int year_film = Integer.parseInt(parts[0]);
        int year_ceremony = Integer.parseInt(parts[1]);
        int ceremony = Integer.parseInt(parts[2]);
        String category = parts[3];
        String name = parts[4];
        String film = parts[5];
        boolean winner = parts[6].equals("True");
        return new Nomination(year_film, year_ceremony, ceremony, category, name, film, winner);
    }
}

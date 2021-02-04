package se.nackademin.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class InputProvider {

    final static Logger logger = Logger.getLogger(InputProvider.class.getSimpleName());

    public static List<Integer> integersFromInput(String day) {
        try {
            return Files.lines(Paths.get(String.format("src/se/nackademin/resource/day%s.txt", day)))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            logger.log(Level.WARNING, "File not found.");
            return null;
        }
    }

    public static List<String> linesFromInput(String day) {
        try {
            return Files.lines(Paths.get(String.format("src/se/nackademin/resource/day%s.txt", day)))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            logger.log(Level.WARNING, "File not found.");
            return null;
        }
    }
}

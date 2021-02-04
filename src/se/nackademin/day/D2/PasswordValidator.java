package se.nackademin.day.D2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordValidator {

    protected String sequence;
    protected char character;
    protected int min;
    protected int max;

    public PasswordValidator(String sequence, String character, String interval) {
        List<Integer> minMax = Arrays.stream(interval.split("-"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        char letter = character.replace(":", "").charAt(0);

        this.sequence = sequence;
        this.character = letter;
        this.min = minMax.get(0);
        this.max = minMax.get(1);
    }

    public boolean isValid() {
        long numberOfInstances = sequence.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c == character)
                .count();

        return numberOfInstances >= min && numberOfInstances <= max;
    }

    public boolean isValid2() {
        if (sequence.charAt(min - 1) == character && sequence.charAt(max - 1) == character)
            return false;

        return sequence.charAt(min - 1) == character || sequence.charAt(max - 1) == character;
    }
}

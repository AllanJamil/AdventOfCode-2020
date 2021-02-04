package se.nackademin.day.D4;

import se.nackademin.util.InputProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Day4 {

    final private List<String> input = InputProvider.linesFromInput("4");

    public void getPart1Result() {
        Map<String, String> passport = new HashMap<>();
        AtomicInteger validPassports = new AtomicInteger(0);

        input.forEach(line -> {
            if (!line.isEmpty()) {
                String[] fields = line.split(" ");
                for (String field : fields) {
                    String[] keyAndValue = field.split(":");
                    passport.put(keyAndValue[0], keyAndValue[1]);
                }
            } else {
                final int ALL_FIELDS = 8;
                if (passport.size() == (ALL_FIELDS - 1) && !passport.containsKey("cid") || passport.size() == ALL_FIELDS)
                    validPassports.getAndIncrement();

                passport.clear();
            }

        });

        System.out.println("Number of valid passports: " + validPassports);
    }

    public void getPart2Result() {
        Map<String, String> passport = new HashMap<>();
        AtomicInteger validPassports = new AtomicInteger(0);

        input.forEach(line -> {
            if (!line.isEmpty()) {
                String[] fields = line.split(" ");
                for (String field : fields) {
                    String[] keyAndValue = field.split(":");
                    passport.put(keyAndValue[0], keyAndValue[1]);
                }
            } else {
                final int ALL_FIELDS = 8;
                if (passport.size() == (ALL_FIELDS - 1) && !passport.containsKey("cid") || passport.size() == ALL_FIELDS) {
                    if (PassportFieldValidator.isValid(passport))
                        validPassports.getAndIncrement();
                }
                passport.clear();
            }
        });

        System.out.println("Number of valid passports: " + validPassports);
    }

}

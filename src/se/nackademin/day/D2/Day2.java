package se.nackademin.day.D2;

import se.nackademin.util.InputProvider;

import java.util.List;
import java.util.stream.Collectors;

public class Day2 {

    final private List<String> input = InputProvider.linesFromInput("2");
    final private List<PasswordValidator> passwordValidators;

    public Day2() {
        passwordValidators = input.stream()
                .map(line -> {
                    String[] s = line.split(" ");
                    return new PasswordValidator(s[2], s[1], s[0]);
                })
                .collect(Collectors.toList());
    }

    /*
    For example, suppose you have the following list:

    1-3 a: abcde
    1-3 b: cdefg
    2-9 c: ccccccccc

    Each line gives the password policy and then the password. The password policy indicates the lowest and
    highest number of times a given letter must appear for the password to be valid. For example, 1-3 a means
    that the password must contain a at least 1 time and at most 3 times.

    In the above example, 2 passwords are valid. The middle password, cdefg, is not; it contains no instances of b,
    but needs at least 1. The first and third passwords are valid: they contain one a or nine c, both within the
    limits of their respective policies
    */

    public void getPart1Result() {
        long count = passwordValidators.stream()
                .filter(PasswordValidator::isValid)
                .count();
        System.out.println("valid passwords: " + count);
    }

    /*
    Given the same example list from above:

    1-3 a: abcde is valid: position 1 contains a and position 3 does not.
    1-3 b: cdefg is invalid: neither position 1 nor position 3 contains b.
    2-9 c: ccccccccc is invalid: both position 2 and position 9 contain c.
    */

    public void getPart2Result() {
        long count = passwordValidators.stream()
                .filter(PasswordValidator::isValid2)
                .count();
        System.out.println("valid passwords: " + count);
    }

}

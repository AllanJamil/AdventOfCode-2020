package se.nackademin.day.D1;

import se.nackademin.util.InputProvider;

import java.util.List;

public class Day1 {

    /*
    In this list, the two entries that sum to 2020 are 1721 and 299.
    Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.
    */

    List<Integer> values = InputProvider.integersFromInput("1");
    final int EXPECTED_SUM = 2020;

    public void getPart1Result() {

        Integer sum = values.stream()
                .filter(integer -> values.stream()
                        .anyMatch(value -> value + integer == EXPECTED_SUM))
                .reduce(1, (n1, n2) -> (n1 * n2));

        System.out.println("Sum is " + sum);
    }

    /*
    Using the above example again, the three entries that sum to 2020 are 979, 366, and 675.
    Multiplying them together produces the answer, 241861950.
    */

    public void getPart2Result() {
        Integer sum = values.stream()
                .filter(integer -> values.stream()
                        .anyMatch(value -> values.stream()
                                .anyMatch(n3 -> value + integer + n3 == EXPECTED_SUM)))
                .reduce(1, (n1, n2) -> (n1 * n2));

        System.out.println("Sum is " + sum);
    }
}

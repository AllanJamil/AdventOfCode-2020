package se.nackademin.day.D4;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassportFieldValidator {


    public static boolean isValid(Map<String, String> passport) {
        String byr = passport.get("byr");
        String iyr = passport.get("iyr");
        String eyr = passport.get("eyr");
        String hgt = passport.get("hgt");
        String hcl = passport.get("hcl");
        String ecl = passport.get("ecl");
        String pid = passport.get("pid");
        return checkDate(byr, 1920, 2002) &&
                checkDate(iyr, 2010, 2020) &&
                checkDate(eyr, 2020, 2030) &&
                checkHeight(hgt) &&
                checkHairColor(hcl) &&
                checkEyeColor(ecl) &&
                checkPassportID(pid);
    }

    private static boolean checkDate(String date, int min, int max) {
        int keyDate = Integer.parseInt(date);
        return keyDate >= min && keyDate <= max;
    }

    private static boolean checkHeight(String hgt) {
        if (hgt.contains("cm")) {
            String value = hgt.substring(0, hgt.indexOf("c"));
            int height = Integer.parseInt(value);
            return height >= 150 && height <= 193;
        } else if (hgt.contains("in")) {
            String value = hgt.substring(0, hgt.indexOf("i"));
            int height = Integer.parseInt(value);
            return height >= 59 && height <= 76;
        } else
            return false;
    }

    private static boolean checkHairColor(String hcl) {
        final String PATTERN = "^[#][a-f0-9]{6}$";
        Matcher matcher = Pattern.compile(PATTERN).matcher(hcl);
        return matcher.matches();
    }

    private static boolean checkEyeColor(String ecl) {
        String[] colors = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
        for (String color : colors) {
            if (ecl.equals(color))
                return true;
        }

        return false;
    }

    private static boolean checkPassportID(String pid) {
        if (pid.length() != 9)
            return false;

        char[] chars = pid.toCharArray();

        for (char aChar : chars) {
            if (!Character.isDigit(aChar))
                return false;
        }

        return true;
    }
}

package utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.UUID;

public class Parser {
    public static LocalDate parseDate(String str){
        try {
            return LocalDate.parse(str);
        } catch (DateTimeParseException e) {
            System.err.println("\nDate parsing failed\n");
        }
        return LocalDate.now();
    }

    public static int parseInt(String str){
        try{
            return Integer.parseInt(str);
        } catch(NumberFormatException e) {
            System.out.println("\nERROR: Integer parsing failed\n");
        }
        return -1;
    }

    public static double parseDouble(String str){
        try{
            return Double.parseDouble(str);
        } catch(NumberFormatException e) {
            System.out.println("\nERROR: Double parsing failed\n");
        }
        return -1;
    }

    public static UUID parseUUID(String str){
        try {
            return UUID.fromString(str);
        } catch (IllegalArgumentException e) {
            System.out.println("\nERROR: ID parsing failed\n");
        }
        return null;
    }
}

package utils;

import utils.enums.InputType;

import java.util.List;
import java.util.Scanner;

public class Validator {



    public static boolean isEmpty(String str) {
        boolean isEmpty = str.isEmpty();
        if(isEmpty) System.out.println("\nERROR: Input string cannot be empty\n");
        return isEmpty;
    }

    public static boolean isInteger(String str) {
        boolean isInteger = str.matches("^[-+]?\\d+$");
        if(!isInteger) System.out.println("\nERROR: Input integer is not valid\n");
        return isInteger;
    }

    public static boolean isDouble(String str) {
        boolean isDouble = str.matches("^[+-]?([0-9]*[.])?[0-9]+$");
        if(!isDouble) System.out.println("\nERROR: Input double is not valid\n");
        return isDouble;
    }

    public static boolean isDate(String str) {
        boolean isDate = str.matches("^\\d{4}-\\d{2}-\\d{2}$");
        if(!isDate) System.out.println("\nERROR: Input date is not valid\n");
        return isDate;
    }

    public static boolean isWhithinRange(String option, int... range) {
        boolean isWhithinRange;
        if(range.length == 1) {
            isWhithinRange = Parser.parseDouble(option) >= range[0];
        } else {
            if(range[1] < range[0]) return false;
            isWhithinRange = Parser.parseDouble(option) >= range[0] && Parser.parseDouble(option) <= range[1];
        }

        if(!isWhithinRange) System.out.println("\nERROR: Input option is not valid\n");
        return isWhithinRange;
    }


    public static int validateInteger(String str) {
        if(isInteger(str)) {
            return Parser.parseInt(str);
        }

        return -1;
    }

    public static boolean isValidInput(String input, InputType type, int... range) {
        boolean isValidInput = true;

        switch (type) {
            case DATE:
                isValidInput = isDate(input);
                break;
            case INTEGER:
                isValidInput = isInteger(input);
                break;
            case DOUBLE:
                isValidInput = isDouble(input);
                break;
            case OPTION:
                isValidInput = isWhithinRange(input, range);
                break;
            default:
                isValidInput = !isEmpty(input);;
        }

        return isValidInput;
    }

    public static String validateInput(String prompt, InputType type, int... range){

        String input;
        do {
            System.out.print(prompt);
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();

        } while(!isValidInput(input, type, range));

        return input;
    }

    public static boolean listIsEmpty(List<?> list) {
        if(list.isEmpty()){
            System.out.println("\nERROR: No data available!\n");
            return true;
        }

        return false;
    }
}

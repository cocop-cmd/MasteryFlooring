package Flooringmastery.ui;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.math.BigDecimal.ROUND_UP;

public class UserIOConsoleImpl implements UserIO {

     private Scanner input = new Scanner(System.in);

    
    @Override
    public void print(String prompt) {
        System.out.println(prompt);
    }
    @Override
    public String readString(String Prompt) {
        System.out.println(Prompt);
        return input.nextLine();
    }

    @Override
    public String readString(String prompt, int max) {
        boolean valid = false;
        String result = "";
        do {
            result = readString(prompt);
            if (result.length() <= max) {
                valid = true;
            } else {
                System.out.printf(" The entry has to be %s letters or less.\n", max);
            }
        } while (!valid);
        return result;
    }

    @Override
    public String formatCurrency(BigDecimal amount) {
        return NumberFormat.getCurrencyInstance().format(amount);
    }

    @Override
    public BigDecimal readBigDecimal(String prompt, int scale) {
        boolean valid = false;
        BigDecimal result = null;
        do {
            String value = null;
            try {
                value = readString(prompt);
                result = new BigDecimal(value).setScale(scale, ROUND_UP);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.printf("The value '%s' is not a number.\n", value);
            }
        } while (!valid);
        return result;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt, int scale, BigDecimal min) {
       boolean valid = false;
       BigDecimal result = null;
       do {
           result = readBigDecimal(prompt, scale);
           if (result.compareTo(min) >=0) {
               valid = true;
           } else {
               String minString = String.valueOf(min);
               System.out.printf("The value must be grater than %s.\n", minString);
           }
       } while (!valid);
       return result;
    }

    @Override
    public int readInt(String prompt) {
        boolean valid = false;
        int result = 0;
        do {
            String value = null;
            try {
                value = readString(prompt);
                result = Integer.parseInt(value);
                valid = true;
            } catch (NumberFormatException ex) {
                System.out.printf("The value '%s' is not a whole number.\n", value);
            }
        } while (!valid);
        return result;
    }

    @Override
    public int readInt(String prompt, int min, int max) {

        boolean valid = false;
        int result = 0;

        do {
            result = readInt(prompt);
            if (result >= min && result <= max) {
                valid = true;
            } else {
                System.out.printf("The value must be between %d and %d.\n", min, max);
            }
        } while (!valid);

        return result;
    }

    @Override
    public LocalDate readDate(String prompt) {
        boolean valid = false;
        LocalDate result = null;
        do {
            String value = null;
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
                value = readString(prompt);
                result = LocalDate.parse(value, formatter);
                valid = true;
            } catch (DateTimeParseException ex) {
                System.out.printf("The value '%s' is not a valid date. (MM-DD-YYYY)\n", value);
            }
        } while (!valid);

        return result;
    }

    @Override
    public LocalDate readDate(String prompt, LocalDate min, LocalDate max) {
        boolean valid = false;
        LocalDate result = null;
        do {
            result = readDate(prompt);
            if (result.isAfter(min) && result.isBefore(max)) {
                valid = true;
            } else {
                System.out.printf("Please choose a date within bounds. (%s to %s)\n", min, max);
            }
        } while (!valid);

        return result;
    }

}


    
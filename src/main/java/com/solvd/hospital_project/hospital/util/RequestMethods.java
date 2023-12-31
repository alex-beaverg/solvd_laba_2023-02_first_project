package com.solvd.hospital_project.hospital.util;

import com.solvd.hospital_project.hospital.custom_exceptions.*;

import java.util.Scanner;

public class RequestMethods {
    private static final Scanner scanner = new Scanner(System.in);

    public static int requestingInfoWithChoice(String text, int menuItemsNumber)
            throws EmptyInputException, NumberFormatException, MenuItemOutOfBoundsException {
        Printers.PRINT.info(text);
        String answer = scanner.nextLine();
        if (answer.isEmpty()) {
            throw new EmptyInputException("[EmptyInputException]: Entered data can not be empty!");
        }
        int numberFromAnswer = Integer.parseInt(answer);
        if (numberFromAnswer < 1 || numberFromAnswer > menuItemsNumber) {
            throw new MenuItemOutOfBoundsException("[MenuItemNumberOutOfBoundsException]: Entered data " +
                    "must be equal to some menu item!");
        }
        return numberFromAnswer;
    }

    public static String requestingInfoString(String text) throws EmptyInputException, StringFormatException {
        Printers.PRINT.info(text);
        String answer = scanner.nextLine();
        if (answer.isEmpty()) {
            throw new EmptyInputException("[EmptyInputException]: Entered data can not be empty!");
        }
        if (!answer.matches("^[a-zA-Zа-яёА-ЯЁ]+[\\s-]?[a-zA-Zа-яёА-ЯЁ]+$")) {
            throw new StringFormatException("[StringFormatException]: Entered data is not a letter character!");
        }
        return answer;
    }

    public static int requestingInfoInt(String text)
            throws EmptyInputException, NumberFormatException, NegativeNumberException {
        Printers.PRINT.info(text);
        String answer = scanner.nextLine();
        if (answer.isEmpty()) {
            throw new EmptyInputException("[EmptyInputException]: Entered data can not be empty!");
        }
        int numberFromAnswer = Integer.parseInt(answer);
        if (numberFromAnswer < 0) {
            throw new NegativeNumberException("[NegativeNumberException]: Entered data can not be negative");
        }
        return numberFromAnswer;
    }

    public static String requestingInfoWithYesOrNo(String text) throws EmptyInputException, YesOrNoException {
        Printers.PRINT.info(text);
        String answer = scanner.nextLine();
        if (answer.isEmpty()) {
            throw new EmptyInputException("[EmptyInputException]: Entered data can not be empty!");
        }
        if (!answer.equals("y") && !answer.equals("n")) {
            throw new YesOrNoException("[YesOrNoException]: Entered data must be equal to 'y' or 'n'!");
        }
        return answer;
    }

    static void closeScanner() {
        scanner.close();
    }
}

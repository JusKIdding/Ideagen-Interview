/*
 * Author: Dana
 * Purpose: For Ideagen Java Remote Code Testing
 */

/*
 * Summary:
 * Questions 1 - 7 for Part 1 have been answered.
 * 
 * Question 1 -2 for Part 2 have been attempted but unable to resolve logic error regarding the arthimetic brackets within
 * 
 * Extra question not attempted
*/

public class Ideagen_Interview {

    public static void main(String[] args) {
        System.out.println(calculate("1 + 1")); // Answer: 2
        System.out.println(calculate("2 * 2")); // Answer: 4
        System.out.println(calculate("1 + 2 + 3")); // Answer: 6
        System.out.println(calculate("6 / 2")); // Answer: 3
        System.out.println(calculate("11 + 23")); // Answer: 34
        System.out.println(calculate("11.1 + 23")); // Answer: 34.1
        System.out.println(calculate("1 + 1 * 3")); // Answer: 4

        // System.out.println(calculate("( 11.5 + 15.4 ) + 10.1")); // Answer: 37 //need
        // fix - attempted
        // System.out.println(calculate("23 - ( 29.3 - 12.5 )")); //Answer: 6.2 //need
        // fix - attempted

    }

    public static double calculate(String sum) {
        double total = 0;

        String operator1 = "";
        String operator2 = "";

        String operatorBracket1 = "";
        String operatorBracket2 = "";

        double num1 = 0;
        double num2 = 0;
        double num3 = 0;

        System.out.println("\n\nRemoving whitespace.");
        String removedWhiteSpace = sum.replaceAll(" ", "");

        // For numbers split
        // String[] arrNumSplit = removedWhiteSpace.split("[-+*/]");
        String[] arrNumSplit = removedWhiteSpace.split("[()-+*/]");

        // System.out.println("Check length of arrNumSplit:: " + arrNumSplit.length);

        for (String item : arrNumSplit) {
            System.out.println("\nCheck arrNumSplit item:: " + item);

            if (item.equals("")) {
                System.out.println("NUMBER Index is empty.");
            } else {
                if (num1 == 0 && num2 == 0 && num3 == 0) {
                    num1 = Double.parseDouble(item);
                } else if (num1 != 0 && num2 == 0 && num3 == 0) {
                    num2 = Double.parseDouble(item);
                } else {
                    num3 = Double.parseDouble(item);
                }
            }
        }

        System.out.println("\nDEBUG num1-- :: " + num1);
        System.out.println("DEBUG num2-- :: " + num2);
        System.out.println("DEBUG num3-- :: " + num3);

        // For operator split
        // String[] arrOperatorSplit = removedWhiteSpace.split("[0-9.]");
        String[] arrOperatorSplit = removedWhiteSpace.split("[\\d.]");

        // System.out.println("Check arrOperatorSplit length::" + arrNumSplit.length);

        for (String item : arrOperatorSplit) {
            System.out.println("\nCheck arrOperatorSplit item:: " + item);

            if (item.equals("")) {
                System.out.println("OPERATOR Index is empty.");
            } else {

                if (operator1.equals("") & operator2.equals("")) {
                    if (item.toString() == "(") {
                        operatorBracket1 = item.toString();
                    } else {
                        operator1 = item.toString();

                        System.out.println("Operator1 inserted:: " + operator1);
                    }

                } else if (!operator1.equals("") & operator2.equals("")) {
                    if (item.toString() == ")") {
                        operatorBracket2 = item.toString();
                    } else {
                        operator2 = item.toString();

                        System.out.println("Operator2 inserted:: " + operator2);
                    }

                }
            }
        } // end of arrOperatorSplit

        if (operator2.equals("*") || operator2.equals("/")) {
            switch (operator2) {
                case "*":
                    total = num2 * num3;
                    break;
                case "/":
                    total = num2 / num3;
                    break;

                default:
                    System.out.println("N/A");
                    break;
            }

            switch (operator1) {
                case "+":
                    total = total + num1;
                    break;
                case "-":
                    total = total - num1;
                    break;
                case "*":
                    total = total * num1;
                    break;
                case "/":
                    total = total / num1;
                    break;

                default:
                    System.out.println("N/A");
                    break;
            }
        }

        if (operator2.equals("+") || operator2.equals("-") || operator2.equals("")) {
            System.out.println("\nOperator2 is either + - or none");

            // if detect 1 operator
            if (!operator1.isEmpty() && operator2.isEmpty()) {

                switch (operator1) {
                    case "+":
                        total = num1 + num2;
                        break;
                    case "-":
                        total = num1 - num2;
                        break;
                    case "*":
                        total = num1 * num2;
                        break;
                    case "/":
                        total = num1 / num2;
                        break;

                    default:
                        System.out.println("N/A");
                        break;
                }
            }

            // if detect 2 operator
            if (!operator1.isEmpty() && !operator2.isEmpty()) {
                switch (operator1) {
                    case "+":
                        total = num1 + num2;
                        break;
                    case "-":
                        total = num1 - num2;
                        break;
                    case "*":
                        total = num1 * num2;
                        break;
                    case "/":
                        total = num1 / num2;
                        break;

                    default:
                        System.out.println("N/A");
                        break;
                }

                switch (operator2) {
                    case "+":
                        total = total + num3;
                        break;
                    case "-":
                        total = total - num3;
                        break;
                    case "*":
                        total = total * num3;
                        break;
                    case "/":
                        total = total / num3;
                        break;

                    default:
                        System.out.println("N/A");
                        break;
                }
            }
        }

        // to return double variable
        System.out.println("\nAnswer:: " + total);
        return total;

    } // end of calculate method
}

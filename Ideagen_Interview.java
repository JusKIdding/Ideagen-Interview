public class Ideagen_Interview {
    public static void main(String[] args) {
        // System.out.println(calculate("1 + 1")); //Answer: 2
        // System.out.println(calculate("2 * 2")); //Answer: 4
        // System.out.println(calculate("1 + 2 + 3")); //Answer: 6
        // System.out.println(calculate("6 / 2")); //Answer: 3
        // System.out.println(calculate("11 + 23")); //Answer: 34
        // System.out.println(calculate("11.1 + 23")); //Answer: 34.1
        // System.out.println(calculate("1 + 1 * 3")); // Answer: 4 

        // System.out.println(calculate("( 11.5 + 15.4 ) + 10.1")); //Answer: 37 //need fix, cannot trigger - attempted
        // System.out.println(calculate("23 - ( 29.3 - 12.5 )")); //Answer: 6.2 //need fix, cannot trigger - attempted
    }

    public static double calculate(String sum) {
        double total = 0;

        String operator1 = "";
        String operator2 = "";
        String operator3 = "";

        double num1 = 0;
        double num2 = 0;
        double num3 = 0;

        System.out.println("\n\nRemoving whitespace.");
        String removedWhiteSpace = sum.replaceAll(" ", "");

        // For numbers split
        String[] arrNumSplit = removedWhiteSpace.split("[-+*/]");

        for (String item : arrNumSplit) {
            System.out.println("Check arrNumSplit:: " + item);

            if (num1 == 0 && num2 == 0 && num3 == 0) {
                num1 = Double.parseDouble(item);
            } else if (num1 != 0 && num2 == 0 && num3 == 0) {
                num2 = Double.parseDouble(item);
            } else {
                num3 = Double.parseDouble(item);
            }
        }

        //For operator split
        String[] arrOperatorSplit = removedWhiteSpace.split("[0-9.]");

        for (String item : arrOperatorSplit) {
            System.out.println("Check arrOperatorSplit:: " + item);

            if (operator1.equals("") & operator2.equals("") && operator3.equals("")) {
                operator1 = item.toString();

                System.out.println("Operator1 inserted:: " + operator1);
            } else if (!operator1.equals("") & operator2.equals("") && operator3.equals("")) {
                operator2 = item.toString();

                System.out.println("Operator2 inserted:: " + operator2);
            } else {
                operator3 = item.toString();

                System.out.println("Operator3 inserted:: " + operator3);
            }
        }

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
            if (!operator1.isEmpty() && operator2.isEmpty() && operator3.isEmpty()) {

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
            if (!operator1.isEmpty() && !operator2.isEmpty() && operator3.isEmpty()) {
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
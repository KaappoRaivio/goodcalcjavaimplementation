

import java.lang.Math;

class CustomArithmetic {

    public static String add (String operand1, String operand2) {
        return String.valueOf(Float.parseFloat(operand1) + Float.parseFloat(operand2));
    }

    public static String sub (String operand1, String operand2) {
        return String.valueOf(Float.parseFloat(operand1) - Float.parseFloat(operand2));
    }

    public static String mul (String operand1, String operand2) {
        return String.valueOf(Float.parseFloat(operand1) * Float.parseFloat(operand2));
    }

    public static String div (String operand1, String operand2) {
        return String.valueOf(Float.parseFloat(operand1) / Float.parseFloat(operand2));

    }

    public static String pow (String operand1, String operand2) {
        return String.valueOf(Math.pow(Float.parseFloat(operand1), Float.parseFloat(operand2)));
    }
}
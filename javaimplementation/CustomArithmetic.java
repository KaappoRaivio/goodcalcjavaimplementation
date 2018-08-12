import org.jetbrains.annotations.NotNull;

import java.lang.Math;

class CustomArithmetic {
    @NotNull
    public static String add (String operand1, String operand2) {
        return String.valueOf(Float.parseFloat(operand1) + Float.parseFloat(operand2));
    }
    @NotNull
    public static String sub (String operand1, String operand2) {
        return String.valueOf(Float.parseFloat(operand1) - Float.parseFloat(operand2));
    }
    @NotNull
    public static String mul (String operand1, String operand2) {
        return String.valueOf(Float.parseFloat(operand1) * Float.parseFloat(operand2));
    }
    @NotNull
    public static String div (String operand1, String operand2) {
        return String.valueOf(Float.parseFloat(operand1) / Float.parseFloat(operand2));

    }
    @NotNull
    public static String pow (String operand1, String operand2) {
        return String.valueOf(Math.pow(Float.parseFloat(operand1), Float.parseFloat(operand2)));
    }
}
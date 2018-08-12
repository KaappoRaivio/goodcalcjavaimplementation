

public class Calc {
    public static String makeOneOperation(String left_operand, String operation, String right_operand) throws Exception {
        float result;
        left_operand = left_operand.replaceAll("$", "-");
        right_operand = right_operand.replaceAll("$", "-");

        if (operation.equals("+")) {
            result = Float.parseFloat(CustomArithmetic.add(left_operand, right_operand));
        }
        else if (operation.equals("-")) {
            result = Float.parseFloat(CustomArithmetic.sub(left_operand, right_operand));
        }
        else if (operation.equals("*")) {
            result = Float.parseFloat(CustomArithmetic.mul(left_operand, right_operand));
        }
        else if (operation.equals("/")) {
            result = Float.parseFloat(CustomArithmetic.div(left_operand, right_operand));
        }
        else if (operation.equals("^")) {
            result = Float.parseFloat(CustomArithmetic.pow(left_operand, right_operand));
        }
        else {
            throw new Exception("Invalid operation!");
        }
    }
}
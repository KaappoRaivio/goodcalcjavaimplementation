import java.lang.Math;

public class Calc {
    private static boolean isInteger (float num) {
        return Integer.parseInt(String.valueOf(num)) == num;
    }

    public static String makeOneOperation(String left_operand, String operation, String right_operand) throws Exception {
        float result;
//        left_operand = left_operand.replaceAll("$", "-");
//        right_operand = right_operand.replaceAll("$", "-");

//        switch (operation) {
//            case "+":
//                result = Float.parseFloat(CustomArithmetic.add(left_operand, right_operand));
//            case "-":
//                result = Float.parseFloat(CustomArithmetic.sub(left_operand, right_operand));
//            case "*":
//                result = Float.parseFloat(CustomArithmetic.mul(left_operand, right_operand));
//            case "/":
//                result = Float.parseFloat(CustomArithmetic.div(left_operand, right_operand));
//            case "^":
//                result = Float.parseFloat(CustomArithmetic.pow(left_operand, right_operand));
//            default:
//                throw new Exception("asd");
//        }
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



        String _final;

        if (isInteger(result)) {
            _final = String.valueOf(Math.round(result));
        } else {
            _final = String.valueOf(result);
        }

        return _final;

    }

    public static void main (String[] args) throws Exception {
        System.out.println(makeOneOperation("4", "+", "5"));
    }
}
//import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.regex.*;

public class SearchExprs {
    private static Pattern PATTERN = Pattern.compile("[$0-9.]");

    public static NamedTuples.ExprSlice getContentInsideBraces (String expression) throws Exception{
        if (expression.length() == 0) {
            throw new Exception("no argument provided!");
        }

        int opening_brace_pos = -1;
        int closing_brace_pos = -1;

        int opening_braces_encountered = 0;

        for (int index = 0; index < expression.length(); index++) {
            if (Arrays.asList("(", "[", "{").contains(String.valueOf(expression.charAt(index)))) {
                opening_brace_pos = index;
                opening_braces_encountered += 1;
                break;
            }
        }
        for (int index = opening_brace_pos; index < expression.length(); index++) {
            if (Arrays.asList("(", "[", "{").contains(String.valueOf(expression.charAt(index)))) {
                opening_braces_encountered += 1;
                continue;
            }

            if (Arrays.asList(")", "]", "}").contains(String.valueOf(expression.charAt(index)))) {
                opening_braces_encountered -= 1;
                if (opening_braces_encountered == 1) {
                    closing_brace_pos = index;
                    break;
                }
            }
        }

        if (opening_brace_pos == -1 && closing_brace_pos == -1) {
            return null;
        }

        return new NamedTuples.ExprSlice(expression.substring(opening_brace_pos + 1, closing_brace_pos), opening_brace_pos, closing_brace_pos - 1);

    }

    public static NamedTuples.Calculation getOperandsAndOperationFromIndex (String expression, int _index) {
        String operation = String.valueOf(expression.charAt(index));

        int left_boundary = -1;
        int right_boundary = -1;

        for (int index = _index - 1; index >= -1; index--) {
            if (PATTERN.matcher(String.valueOf(expression.charAt(index))).matches()) {
                left_boundary = index;
            } else {
                break;
            }
        }

        for (int index = _index + 1; index < expression.length(); index++) {
            if (PATTERN.matcher(String.valueOf(expression.charAt(index))).matches()) {
                right_boundary = index + 1;
            } else {
                break;
            }
        }

        int MAGIC_CONSTANT;

        
    }

    public static void main (String[] args) throws Exception {
        System.out.println(getContentInsideBraces("3 + (2 - 2)").toString());
    }
}

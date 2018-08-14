//import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.regex.*;

public class SearchExprs {
    private static Pattern PATTERN = Pattern.compile("[\\$0-9.]");

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
        String operation = String.valueOf(expression.charAt(_index));

        int left_boundary = -10;
        int right_boundary = -10;

        for (int index = _index - 1; index > -1; index--) {
            if (!PATTERN.matcher(String.valueOf(expression.charAt(index))).matches() || index == 0) {
                left_boundary = index;
                break;
            }
        }

        for (int index = _index; index < expression.length(); index++) {
            if (!PATTERN.matcher(String.valueOf(expression.charAt(index))).matches()) {
                right_boundary = index + 2;
                break;
            }
        }

        System.out.println(left_boundary + ", " + right_boundary);

        int MAGIC_CONSTANT;

        if (expression.substring(_index + 1, right_boundary).contains(".") || expression.substring(left_boundary, _index).contains(".")) {
            MAGIC_CONSTANT = 2;
        } else {
            MAGIC_CONSTANT = 1;
        }

        return new NamedTuples.Calculation(expression.substring(left_boundary, _index), operation, expression.substring(_index + 1, right_boundary), left_boundary, right_boundary - MAGIC_CONSTANT);

    }

    public static void main (String[] args) throws Exception {
        System.out.println(getOperandsAndOperationFromIndex("3.3+2*2", 3).toString());
    }
}

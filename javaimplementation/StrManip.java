
import java.util.regex.*;

public class StrManip {
    private static Pattern OPERATION = Pattern.compile("[+\\-*/^]{1}");
    private static Pattern OPERAND = Pattern.compile("[0-9]");

    public static void main (String[] args) {
        String asd = "3+-4";
        System.out.println(correctUnaryConflicts(asd));
        System.out.println(asd);
    }

    public static String replaceSlice(String target, int leftIndex, int  rightIndex, String replaceable) {
        target = target.substring(0, leftIndex) + target.substring(rightIndex - 1);
        target = target.substring(0, leftIndex) + replaceable + target.substring(rightIndex);

        return target;
    }

    public static String correctSpaces(String exp) {
        return exp.replaceAll(" ", "");
    }

    public static String replaceAlternateOperationSigns(String exp) {
        return exp.replaceAll("\\*\\*", "^");
    }

    public static String correctUnaryConflicts (String exp) {
        int conflictStart = -1;
        int conflictEnd = -1;
        boolean execBlockAfter = true;

        for (int index = 1; index < exp.length(); index++) {
            // If there are two consecutive operation chars in the exp
            if (OPERATION.matcher(String.valueOf(exp.charAt(index))).matches() && OPERATION.matcher(String.valueOf(exp.charAt(index - 1))).matches()) {
                execBlockAfter = false;
                conflictStart = index;
                break;
            }
        }

        if (execBlockAfter) {
            return exp;
        }

        execBlockAfter = true;
        for (int index = conflictStart + 1; index < exp.length(); index++) {
            if (OPERAND.matcher(String.valueOf(exp.charAt(index))).matches()) {
                continue;
            } else {
                execBlockAfter = false;
                conflictEnd = index + 1;
                break;
            }
        }

        if (execBlockAfter) {
            conflictEnd = exp.length() + 1;
        }

        exp = insert(exp, conflictStart, "(");
        exp = insert(exp, conflictEnd, ")");

        return correctUnaryConflicts(exp);

    }

    public static String insert (String target, int index, String string) {

        return string.substring(0, index) + string + target.substring(index);
    }
}

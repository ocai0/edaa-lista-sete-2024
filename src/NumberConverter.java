import java.util.Stack;

class NumberConverter {
    public static final int BINARY = 0;
    public static final int OCTAL = 1;
    public static final int HEXADECIMAL = 2;
    private static final String[] HEXADECIMAL_DICT = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C",
            "D", "E", "F" };
    private static final String[] BINARY_DICT = { "0", "1" };
    private static final String[] OCTAL_DICT = { "0", "1", "2", "3", "4", "5", "6", "7" };
    private static final String[][] DICTS = { BINARY_DICT, OCTAL_DICT, HEXADECIMAL_DICT };

    public static String toHexadecimal(int quotient, boolean printTrace) {
        return NumberConverter.convert(quotient, 16, NumberConverter.HEXADECIMAL, printTrace);
    }

    public static String toOctal(int quotient, boolean printTrace) {
        return NumberConverter.convert(quotient, 8, NumberConverter.OCTAL, printTrace);
    }

    public static String toBinary(int quotient, boolean printTrace) {
        return NumberConverter.convert(quotient, 2, NumberConverter.BINARY, printTrace);
    }

    public static String convert(int quotient, int base, int dictIndex, boolean printTrace) {
        int remaining;
        Stack<String> stack = new Stack<String>();
        do {
            remaining = quotient % base;
            quotient = quotient / base;
            stack.push(NumberConverter.translate(remaining, dictIndex));
        } while (quotient != 0);

        String result = "";
        while (!stack.empty())
            result += stack.pop();

        return result;
    }

    public static String translate(int number, int base) {
        return NumberConverter.DICTS[base][number];
    }
}
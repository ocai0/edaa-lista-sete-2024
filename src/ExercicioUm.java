import java.util.Stack;

class ExercicioUm {
    public static void resolve() {
        ExercicioUm.resolveA("ESTE EXERCÍCIO É MUITO FÁCIL");
        System.err.println("");
        ExercicioUm.resolveB("Abba");
        ExercicioUm.resolveB("ovo");
        ExercicioUm.resolveB("ovos");
        System.err.println("");
        int[] numbers = { 34, 3, 31, 98, 92, 23 };
        ExercicioUm.resolveC(numbers);
        System.err.println("");
        ExercicioUm.resolveD(numbers);
        System.err.println("");

    }

    public static void resolveA(String originalWord) {
        for (String word : originalWord.split(" "))
            System.out.printf("%s ", ExercicioUm.invertWord(word));
    }

    public static void resolveB(String originalWord) {
        int startA = 0, endA = (originalWord.length()) / 2, startB = endA, endB = originalWord.length();
        if (originalWord.length() % 2 == 1)
            endA += 1;

        System.out.printf("A palavra '%s' é um palindromo? %s\n", originalWord,
                ExercicioUm.palindromeCheck(originalWord.substring(startA, endA),
                        originalWord.substring(startB, endB)) ? "Verdadeiro" : "Falso");
    }

    public static void resolveC(int[] numbers) {
        StackOrdered stack = new StackOrdered(false);
        for (int i : numbers)
            stack.push(i);
        stack.arrangeDescending();
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    public static void resolveD(int[] numbers) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i : numbers)
            stack.push(i);

    }

    public static String invertWord(String word) {
        Stack<Character> stack = new Stack<Character>();
        for (int index = 0; index < word.length(); index++)
            stack.add(word.charAt(index));
        String result = "";
        while (stack.size() != 0)
            result += stack.pop();
        return result;
    }

    public static boolean palindromeCheck(String wordA, String wordB) {
        return ExercicioUm.invertWord(wordB.toLowerCase()).equals(wordA.toLowerCase());
    }

}
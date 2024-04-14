import java.util.Stack;

class ExercicioUm {
    public static void resolve() {
        // ExercicioUm.resolveA("ESTE EXERCÍCIO É MUITO FÁCIL");
        ExercicioUm.resolveB("Abba");
        ExercicioUm.resolveB("ovo");
        ExercicioUm.resolveB("ovos");
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

    public static void resolveC() {
    }

    public static void resolveD() {
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
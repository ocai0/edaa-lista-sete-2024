import java.util.Stack;

class ExercicioUm {
    public static void resolve() {
        // ExercicioUm.resolveA("ESTE EXERCÍCIO É MUITO FÁCIL");
        // ExercicioUm.resolveB("Abba");
        // ExercicioUm.resolveB("ovo");
        // ExercicioUm.resolveB("ovos");
        int[] numbers = { 1, 4, 8, 5, 6, 3, 3, 2, 1, 9, 7 };
        ExercicioUm.resolveC(numbers);

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
        StackOrdered stack = new StackOrdered();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
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

class StackOrdered {
    Stack<Integer> stack;

    public StackOrdered() {
        this.stack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.add(number);
        this.arrangeAscending();
        // this.arrangeDescending();

    }

    private void arrangeDescending() {
        Stack<Integer> tempStack = new Stack<Integer>();
        int temp;
        while (!stack.empty()) {
            temp = stack.pop();
            while (!tempStack.empty() && tempStack.lastElement() > temp)
                stack.add(tempStack.pop());
            tempStack.add(temp);
        }
        this.stack = tempStack;
    }

    private void arrangeAscending() {
        Stack<Integer> tempStack = new Stack<Integer>();
        int temp;
        while (!stack.empty()) {
            temp = stack.pop();
            while (!tempStack.empty() && tempStack.firstElement() < temp)
                stack.add(tempStack.pop());
            tempStack.add(temp);
        }
        this.stack = tempStack;
    }

    public int pop() {
        return this.stack.pop();
    }

    public int size() {
        return stack.size();
    }

    public boolean empty() {
        return stack.empty();
    }

}
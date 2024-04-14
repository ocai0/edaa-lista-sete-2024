import java.util.Stack;

class StackOrdered {
    Stack<Integer> stack;
    boolean autoSort = false;;

    public StackOrdered() {
        this.stack = new Stack<Integer>();
    }

    public StackOrdered(boolean autoSort) {
        this.stack = new Stack<Integer>();
        this.autoSort = autoSort;
    }

    public void push(int number) {
        stack.add(number);
        if (!autoSort)
            return;
        this.arrangeAscending();
        // this.arrangeDescending();

    }

    public void arrangeDescending() {
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

    public void arrangeAscending() {
        Stack<Integer> tempStack = new Stack<Integer>();
        while (!stack.empty()) {
            int temp = stack.pop();
            while (!tempStack.empty() && tempStack.peek() < temp) {
                stack.push(tempStack.pop());
            }
            tempStack.push(temp);
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
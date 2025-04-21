package d_stacks;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

class MyStack {
    int[] items;
    int top;
    int size;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyStack myStack = (MyStack) o;
        return top == myStack.top && size == myStack.size && Objects.deepEquals(items, myStack.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(items), top, size);
    }

    public MyStack(int size) {
        this.size = size;
        this.items = new int[size];
        this.top = 0;
    }

    public void push(int val) {
        if (top == size) throw new StackOverflowError();
        this.items[this.top] = val;
        this.top++;
    }

    public int pop() {
        if (top == 0) throw new EmptyStackException();

        top--; // Decrement top to point to the last pushed element
        int poppedValue = items[top];
        items[top] = 0; // Reset the popped element to 0
        return poppedValue;
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public int peek() {
        if (top == 0) throw new EmptyStackException();
        return items[top - 1]; // Return the top element without removing it
    }

    public int currentSize() {
        return top;
    }

    @Override
    public String toString() {
        if (top == 0) { // Check if the stack is empty
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = top - 1; i >= 0; i--) { // Iterate over the actual elements in the stack
            result.append(items[i]);
            if (i != 0) {
                result.append(", ");
            }
        }
        result.append("]");

        return result.toString();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(5);
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        System.out.println(myStack);
        System.out.println("Peek: " + myStack.peek());

        System.out.println("Pop: " + myStack.pop());
        System.out.println("After pop: " + myStack);

        System.out.println("Current stack size: " + myStack.currentSize());
    }
}

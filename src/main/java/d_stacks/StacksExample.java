package d_stacks;

import java.util.Stack;

public class StacksExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Display the stack
        System.out.println("Stack after pushes: " + stack);

        // Peek at the top element
        int topElement = stack.peek();
        System.out.println("Element at the top: " + topElement);

        // Pop elements from the stack
        int poppedElement = stack.pop();
        System.out.println("Popped element: " + poppedElement);

        // Display the stack after pop
        System.out.println("Stack after pop: " + stack);

        // Check if the stack is empty
        boolean isEmpty = stack.isEmpty();
        System.out.println("Is the stack empty? " + isEmpty);

        // Get the size of the stack
        int size = stack.size();
        System.out.println("Size of the stack: " + size);
    }
}

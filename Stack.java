/*

Jacob Kerames

Project Name: Java Postfix Converter

Project Purpose: Create a postfix converter

Algorithm Used: The project implements a stack interface and stack class to handle
operators of the infix expressions.

Program Inputs: Infix expressions are loaded from a string array.

Program Outputs: The program outputs the current infix expression being
converted and the resulting postfix expression.
    Note: The user may view the progression of the infix and postfix expressions
    during conversion by uncommenting the print lines in the convertToPostfix method.

Program Limitations: The program does not currently allow the user to enter
infix expressions.

Program Errors: The program does not contain errors.

*/

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> implements StackInterface<T>
{
    private T[] stack;
    private int topIndex;
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public Stack()
    {
        this(DEFAULT_CAPACITY);
    }

    public Stack(int initialCapacity)
    {
        integrityOK = false;
        checkCapacity(initialCapacity);

        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        integrityOK = true;
    }

    public void push(T newEntry)
    {
        checkIntegrity();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    }

    public T pop()
    {
        checkIntegrity();
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        }
    }

    public T peek()
    {
        checkIntegrity();
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return stack[topIndex];
        }
    }

    public boolean isEmpty()
    {
        return topIndex < 0;
    }

    private void checkCapacity(int capacity)
    {
        if(capacity > MAX_CAPACITY)
        {
            throw new IllegalStateException("Attempt to create a stack whose capacity exceeds allowed maximum of " + MAX_CAPACITY);
        }
    }

    private void ensureCapacity()
    {
        if(topIndex == stack.length - 1)
        {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        }
    }

    private void checkIntegrity()
    {
        if(!integrityOK)
        {
            throw new SecurityException("ArrayStack object is corrupt.");
        }
    }
}

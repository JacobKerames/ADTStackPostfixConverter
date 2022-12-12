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

public interface StackInterface<T>
{
    // Adds an entry to the top of the stack
    public void push(T newEntry);

    // Removes and returns the element at the top of the stack
    public T pop();

    // Returns the element at the top of the stack
    public T peek();

    // Checks if the stack is empty
    public boolean isEmpty();
}

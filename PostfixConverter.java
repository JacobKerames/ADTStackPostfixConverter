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

public class PostfixConverter
{
    public static int precedence(char character)
    {
        switch(character)
        {
            case '-':
                return 1;
            case '+':
                return 2;
            case '/':
                return 3;
            case '*':
                return 4;
            case '^':
                return 5;
            default:
                return -1;
        }
    }
    public static String convertToPostfix(String[] infixes, int index)
    {
        StackInterface<Character> operatorStack = new Stack<>();
        String infix = infixes[index];
        String postfix = "";
        char topOperator;

        while(infix.length() != 0)
        {
            /*System.out.println(postfix);
            System.out.println(infix);*/

            char nextChar = infix.charAt(0);
            switch(nextChar)
            {
                case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': case 'h':
                    postfix += Character.toString(nextChar);
                    infix = infix.substring(1);
                    break;
                case '^': case '(':
                    operatorStack.push(nextChar);
                    infix = infix.substring(1);
                    break;
                case '+': case '-': case '*': case '/':
                    while(!operatorStack.isEmpty() && precedence(nextChar) <= precedence(operatorStack.peek()))
                    {
                        postfix += operatorStack.peek();
                        operatorStack.pop();
                    }
                    operatorStack.push(nextChar);
                    infix = infix.substring(1);
                    break;
                case ')':
                    topOperator = operatorStack.pop();
                    while(topOperator != '(')
                    {
                        postfix += topOperator;
                        topOperator = operatorStack.pop();
                    }
                    infix = infix.substring(1);
                    break;
                default:
                    infix = infix.substring(1);
                    break;
            }
        }
        while(!operatorStack.isEmpty())
        {
            topOperator = operatorStack.pop();
            postfix += topOperator;
        }
        return postfix;
    }
    public static void main(String[] args)
    {
        String[] infixes = {"a*b/(c-d)", "(a-b*c)/(d*e*f+g)", "a/b*(c+(d-e))", "(a^b*c-d)^e+f^g^h"};
        for(int i = 0; i < infixes.length; i++)
        {
            System.out.println("Converting infix expression " + infixes[i] + " ...");
            System.out.println("Postfix expression: " + convertToPostfix(infixes, i) + "\n");
        }
    }
}

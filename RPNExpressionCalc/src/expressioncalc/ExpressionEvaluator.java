/*
 * The ExpressionEvaluator class file for the technical topics demos
 * CIT-360
 * Winter 2019
 */
package expressioncalc;

/**
 *
 * @author Drazen
 */
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Very simple RPN calculator, just to demonstrate how Deque collection
 * can be utilized as a stack.
 *
 * @author Drazen
 */
public class ExpressionEvaluator {

    /**
     * Standard Java tokenization function
     * @param expression
     * @return tokenized expression
     * @throws IOException 
     */
    private List<Token> tokenize(String expression) throws IOException {
        List<Token> tokens = new ArrayList<>();
        StringReader str = new StringReader(expression);
        StreamTokenizer tokenizer = new StreamTokenizer(str);
        tokenizer.ordinaryChar('/');
        tokenizer.ordinaryChar('-');
        while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            Token token = new Token(tokenizer);
            tokens.add(token);
        }
        return tokens;
    }

    /**
     * Performs actual evaluation of a tokenized RPN Expression
     * @param tokens
     * @return value of the expression
     */
    private double eval(List<Token> tokens) {
        Deque<Double> stack = new ArrayDeque<>();
        for (Token token : tokens) {
            if (token.getTokenType() == StreamTokenizer.TT_NUMBER) {
                // All numbers are converted to double and pushed on the stack.
                stack.addLast(Double.parseDouble(token.getTokenValue()));
            } else {
                // The operator is found and evaluated.
                double op1=stack.removeLast();
                double op2=stack.removeLast();
                switch (token.getTokenValue()) {
                    case "*":
                        stack.addLast(op1 * op2);
                        break;
                    case "+":
                        stack.addLast(op1 + op2);
                        break;
                    case "-":
                        stack.addLast(op2 - op1);
                        break;
                    case "/":
                        stack.addLast(op2 / op1);
                        break;
                }
            }
        }
        return stack.getLast();
    }

    public double evaluate(String expression) throws IOException {
        List<Token> tokens = tokenize(expression);
        return eval(tokens);
    }
}

/*
 * The ExpressionCalc class file for the technical topics demos
 * CIT-360
 * Winter 2019
 */
package expressioncalc;

import java.io.IOException;

/**
 *
 * @author Drazen
 */
public class ExpressionCalc {
    public static void evaluate(String expression) {
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        try {
            double result = evaluator.evaluate(expression);
            System.out.format("%s = %f\n", expression, result);
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        evaluate("2 3 +"); //This should be 5;
        evaluate("6 2 / 7 * 2 +"); //This should be 23;
        evaluate("1 3 6 2 - * +"); //This should be 13;
        evaluate("2 3 * 4 5 * +"); //This should be 26;
    }
}

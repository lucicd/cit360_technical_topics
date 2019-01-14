/*
 * The ReadMoviesException class file for the technical topics demos
 * CIT-360
 * Winter 2019
 */
package exceptions;

/**
 *
 * @author Drazen
 */
public class ReadMoviesException extends Exception {
    // Default constructor
    // Purpose: Initializes data members to default values
    // Parameters: none
    // Returns: none
    public ReadMoviesException() { }


    // Parameterized  constructor
    // Purpose: Initializes data members to value passed as a parameter
    // Parameters: A string containing the error message
    // Returns: none
    public ReadMoviesException(String string)
    {
        super(string);
    } 
}
/*
 * The Token class file for the technical topics demos
 * CIT-360
 * Winter 2019
 */
package expressioncalc;

import java.io.StreamTokenizer;

/**
 *
 * @author Drazen
 */
public class Token {

    public Token(StreamTokenizer tokenizer) {
        this.tokenType = tokenizer.ttype;
        switch (tokenizer.ttype) {
            case StreamTokenizer.TT_NUMBER:
                this.tokenValue = String.valueOf(tokenizer.nval);
                break;
            case StreamTokenizer.TT_WORD:
                this.tokenValue = tokenizer.sval;
                break;
            default:
                this.tokenValue = String.valueOf((char) tokenizer.ttype);
                break;
        }
    }

    private int tokenType;

    /**
     * Get the value of tokenType
     *
     * @return the value of tokenType
     */
    public int getTokenType() {
        return tokenType;
    }
    private String tokenValue;

    /**
     * Get the value of tokenValue
     *
     * @return the value of tokenValue
     */
    public String getTokenValue() {
        return tokenValue;
    }

}

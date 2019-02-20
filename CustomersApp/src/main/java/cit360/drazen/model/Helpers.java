/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360.drazen.model;

/**
 *
 * @author aed20672
 */
public class Helpers {
    public static String nullWhenEmpty(String input) {
        if (input == null || input.trim().length() == 0) {
            return null;
        } else {
            return input.trim();
        }
    }
}

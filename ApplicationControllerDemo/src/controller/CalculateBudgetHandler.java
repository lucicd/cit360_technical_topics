/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Map;
import pojos.MonthlyBudget;
import pojos.Response;
import view.ReportBudgetView;

/**
 *
 * @author Drazen
 */
public class CalculateBudgetHandler implements IHandler {
    
    private MonthlyBudget budget;
    
    private void computeTax() {
        // The tax brackets for the 2006
        // Note that this algorithm is vastly oversimplified because it does not
        // take into account deductions and other credits. Please do not use this
        // algorithm to compute your actual tax burden!
        double yearlyIncome = budget.getMonthlyIncome() * 12;
        double yearlyTax = 0;
        if (yearlyIncome >= 0 && yearlyIncome < 15100) {
            yearlyTax = yearlyIncome * 0.10;
        } else if (yearlyIncome >= 15100 && yearlyIncome < 61300) {
            yearlyTax = 1510 + 0.15 *(yearlyIncome - 15100);
        } else if (yearlyIncome >= 61300 && yearlyIncome < 123700) {
            yearlyTax = 8440 + 0.25 *(yearlyIncome - 61300);
        } else if (yearlyIncome >= 123700 && yearlyIncome < 188450) {
            yearlyTax = 24040 + 0.28 *(yearlyIncome - 123700);
        } else if (yearlyIncome >= 188450 && yearlyIncome < 336550) {
            yearlyTax = 42170 + 0.33 *(yearlyIncome - 188450);
        } else if (yearlyIncome >= 336550) {
            yearlyTax = 91043 + 0.35 *(yearlyIncome - 336550);
        }

        double monthlyTax = yearlyTax / 12;
        budget.setBudgetedTaxes(monthlyTax);
    }
    
    private void computeTithing() {
        budget.setBudgetedTithing(budget.getMonthlyIncome() * 0.1);
    }
    
    private void computeBudgetedOther() {
        double other = budget.getMonthlyIncome() - budget.getBudgetedTaxes() - 
                budget.getBudgetedTithing() - budget.getBudgetedLiving();
        budget.setBudgetedOther(other);
    }
    
    private void computeActualDiff() {
        double diff = budget.getMonthlyIncome() - budget.getActualTaxes() -
                budget.getActualTithing() - budget.getActualLiving() -
                budget.getActualOther();
        budget.setActualDiff(diff);
    }
    
    private void computeBudgetedDiff() {
        budget.setBudgetedDiff(0);
    }

    @Override
    public Response handleIt(Map<String, Object> data) {
        this.budget = (MonthlyBudget) data.get("budget");
        
        computeTax();
        computeTithing();
        computeBudgetedOther();
        computeActualDiff();
        computeBudgetedDiff();
        
        Response response = new Response();
        response.setView(new ReportBudgetView());
        response.setData(data);
        
        return response;
    }
    
}

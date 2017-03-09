package com.dbf.financialplanner;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FinancialPlannerController {
	
	FinancialPlannerService financialPlannerService = new FinancialPlannerService();
	
	@RequestMapping("/financialplanner-landing")
    public String landing() {
        return "financialplanner/financialplanner-landing";
    }
	
	@RequestMapping("/financialplanner-results")
    public String financialPlanner(@RequestParam double income, @RequestParam double housing, @RequestParam double food, @RequestParam double savings, Model model) {
		Budget budget = new Budget(income, housing, food);
		
		double amountSaved = financialPlannerService.calculateSavings(budget, savings);
		
		model.addAttribute("amountSaved", amountSaved);
		
        return "financialplanner/financialplanner-results";
    }

}
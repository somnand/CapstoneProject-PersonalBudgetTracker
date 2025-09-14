package application.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.models.Budget;
import application.service.BudgetService;

@RestController
@RequestMapping("/api/v1")
public class BudgetController 
{
	@Autowired
	public BudgetService budgetService;
	
	@PostMapping("/addBudget")
	public ResponseEntity<?> addBudgetCategory(@RequestBody Budget newCategoryBudget) 
	{
		try
		{
			budgetService.addBudgetCategory(newCategoryBudget);
		}
		catch(RuntimeException re)
		{
			return ResponseEntity.internalServerError().build();
		}
		return ResponseEntity.ok().build();
		
	}
	
	@GetMapping("/getBudgets")
	public ResponseEntity<?> getAllBudgets()
	{
		List<Budget> budgets = budgetService.getAllBudget();
		return ResponseEntity.ok(budgets);
		
	}
	
	
}

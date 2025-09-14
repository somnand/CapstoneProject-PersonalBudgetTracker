package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.models.Budget;
import application.repository.BudgetRepository;

@Service
public class BudgetService 
{
	@Autowired
	BudgetRepository budgetRepository;
	
	public void addBudgetCategory(Budget budget)
	{
		budgetRepository.save(budget);		
	}
	
	public List<Budget> getAllBudget()
	{
		return budgetRepository.findAll();
	}
}

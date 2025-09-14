package application.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.models.Budget;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Integer> 
{
	//Pre-filled by Spring
}

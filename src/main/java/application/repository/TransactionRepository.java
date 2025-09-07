package application.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import application.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID>
{
	//Prefilled by spring

}

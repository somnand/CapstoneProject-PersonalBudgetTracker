package application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.models.Transaction;
import application.repository.TransactionRepository;

/**
 * Service class which deals with Add/Edit/Delete of transactions
 * @author SomsuryaNanda
 *
 */
@Service
public class TransactionService
{
	@Autowired
	TransactionRepository transactionRepo;
	
	//GET Operations
	public List<Transaction> getAllTransactions()
	{
		return transactionRepo.findAll(); 
	}
	
	//POST Operations
	/**
	 * Adds the transaction and return the created UUID 
	 * @param txn
	 * @return Generated UUID
	 */
	public UUID addTransaction(Transaction txn)
	{
		Transaction savedTransaction = transactionRepo.save(txn);		
		return savedTransaction.getTransactionId();
	}
	
	/**
	 * Updates the transaction based on the UUID and returns the updated Transaction
	 * @param txn
	 * @return
	 */
	public Transaction editTransaction(Transaction txn)
	{
		Transaction t = new Transaction();
		t.setTransactionId(UUID.randomUUID());
		
		return t;
	}
	
	/**
	 * Removes the transaction and returns count of transactions deleted.
	 * @param txn
	 * @return
	 */
	public int deleteTransaction(UUID toDeleteId)
	{
		if(!transactionRepo.existsById(toDeleteId))
			return 0;	
		
		try 
		{
			transactionRepo.deleteById(toDeleteId);			
			return 1;			
		}
		catch(RuntimeException re)
		{
			return 0;			
		}
	}
}

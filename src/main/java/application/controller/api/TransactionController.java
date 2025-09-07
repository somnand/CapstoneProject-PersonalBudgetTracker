package application.controller.api;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.models.Transaction;
import application.service.TransactionService;

@RestController
@RequestMapping("/api/v1")
public class TransactionController
{
	@Autowired
	TransactionService transactionService;
	
	//GET Mappings
	@GetMapping("/allTransactions")
	public ResponseEntity<?> getAllTransactions()
	{
		List<Transaction> allTrans;
		allTrans = transactionService.getAllTransactions();
		
		return ResponseEntity.ok(allTrans);		
	}
	
	//POST Mappings
	@PostMapping("/addTransaction")
	public ResponseEntity<?> addTransaction(@RequestBody Transaction txn)
	{
		if(txn.getTransactionType()<0 || txn.getTransactionType()>1)
			return ResponseEntity.badRequest().body("No Transaction Type found!!");
		
		UUID newTxnId = transactionService.addTransaction(txn);		
		return ResponseEntity.ok(newTxnId);		
	}
	
//	@PostMapping("/editTransaction")
//	public ResponseEntity<?> editTransaction(@RequestBody String transactionId)
//	{
//		if(transactionId==null)
//			return ResponseEntity.badRequest().body("No Transaction Id found!!");
//		
//		transactionService. 
//		
//		return ResponseEntity.ok();		
//	}
	
	//DELETE Mappings
	@DeleteMapping("/deleteTransaction")
	public ResponseEntity<?> deleteTransaction(@RequestParam UUID toDeleteID)
	{
		int count = transactionService.deleteTransaction(toDeleteID);
		
		if(count>0)
		{
			return ResponseEntity.ok("Deleted "+toDeleteID);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}		
	}
	

}

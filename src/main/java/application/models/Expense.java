package application.models;

public class Expense extends Transaction
{
	public void setTransactionType()
	{
		transactionType = Transaction.EXPENSE;
	}
}

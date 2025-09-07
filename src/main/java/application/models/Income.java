package application.models;

public class Income extends Transaction
{
	public void setTransactionType()
	{
		transactionType = Transaction.INCOME;
	}
}

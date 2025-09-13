package application.models;

public enum TransactionType 
{
	INCOME(0),
	EXPENSE(1);
	
	private int type;
	
	TransactionType(int type){ this.type=type; }
	
	public int getType(){ return this.type; }

}

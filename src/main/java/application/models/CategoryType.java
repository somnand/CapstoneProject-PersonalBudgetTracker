package application.models;

public enum CategoryType 
{
	FOOD(0),
	TRANSPORT(1),
	MEDICAL(2),
	ENTERTAINMENT(3);
	
	private int type;
	
	CategoryType(int type){ this.type=type; }
	
	public int getType(){ return this.type; }	
}

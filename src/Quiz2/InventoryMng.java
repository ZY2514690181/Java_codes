package Quiz2;

public interface InventoryMng {
	
	public void add(House h);
	
	public void Edit(int id, double price);
	
	public int Delete(int id);
	
	public House[] HousesBelowPrice(double p); // It spells "Bellow" in the instruction. I suppose it is a mistake.
	
	public int findMin();

}

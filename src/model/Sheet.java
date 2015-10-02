package model;

import java.util.HashMap;

public class Sheet implements expr.Environment{
	private HashMap<Address, Slot> sheet;
	
	public Sheet(Address adress, Slot slot) {
		sheet = new HashMap<Address, Slot>();
	}
	
	public HashMap<Address, Slot> getSheet() {
		return sheet;
	}
	
	public void updateSheet() {
		
	}
	
	public Slot getSlot(Address address) {
		return null;
	}
	
	public void setSlot(Address address, Slot slot) {
		
	}
	
	@Override
	public double value(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

}

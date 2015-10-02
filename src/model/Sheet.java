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
	
	public void updateSheet(Sheet s) {
		sheet = s.sheet;
	}
	
	public Slot getSlot(Address address) {
		return sheet.get(address);
	}
	
	public void setSlot(Address address, Slot slot) {
		sheet.put(address, slot);
	}
	
	@Override
	public double value(String name) {
		return sheet.get(new Address(name)).getValue();
	}

}

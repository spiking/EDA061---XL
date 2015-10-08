package model;

import java.util.HashMap;

import util.XLException;

public class Sheet implements expr.Environment{
	HashMap<Address, Slot> sheet;
	SlotCreator slotCreator;
	
	public Sheet() {
		sheet = new HashMap<Address, Slot>();
		slotCreator = new SlotCreator();
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

	public void setSlot(Address address, String input) {
		Slot slot = slotCreator.createSlot(input);
		circularCheck(address, slot);
		sheet.put(address, slot);
		updateSheet(this);
	}
	
	public void circularCheck(Address address, Slot slot) {
		Slot currentSlot = sheet.get(address);
		CircularSlot circularSlot = new CircularSlot();
		sheet.put(address, circularSlot);
		try {
			slot.getValue(this); // "finally" always executes, even though this might return an exception
		} finally {
			sheet.put(address, currentSlot);
		}
	}
	
	public void clearSheet() {
		sheet.clear();
		updateSheet(this);
	}
	
	@Override
	public double value(String name) {
		Slot slot = sheet.get(new Address(name));
		
		if(slot == null) {
			throw new XLException("Empty slot");
		}

		return slot.getValue(this);	
	}

}

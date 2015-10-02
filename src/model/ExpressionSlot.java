package model;

import java.beans.Expression;

public class ExpressionSlot implements Slot {
	private Expression expr;
	
	public ExpressionSlot(Expression expr) {
		this.expr = expr;
	}
	
	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}

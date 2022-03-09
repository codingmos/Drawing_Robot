package de.tuhh.diss.plotbot.shape;

import de.tuhh.diss.plotbot.shape.Plottable;
import de.tuhh.diss.plotbot.PlotbotControl;

public class Ship implements Plottable{
	private PlotbotControl pc;
	
	public Ship (PlotbotControl pc){
		this.pc = pc;
		plot(this.pc);
		
	}
	public void plot(PlotbotControl pc){
		// put your plot routine in here
	}
}

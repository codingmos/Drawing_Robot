package de.tuhh.diss.plotbot;

import de.tuhh.diss.plotbot.shape.Ship;
import de.tuhh.diss.plotbot.shape.Rectangle;
import de.tuhh.diss.plotbot.shape.Calibration;

import de.tuhh.diss.plotbot.shape.Plottable;
import lejos.nxt.Button;
import lejos.util.TextMenu;

public class MainMenu {

	
	private static final String[] ITEMS = {"Calibration" ,"Rectangle" ,"Ship"};	//add new text menu entries here
	private	static final String TITLE = "Choose a shape to draw:";
	private TextMenu menu;

	/**
	 * Creates a new MainMenu object.
	 */
	public MainMenu() {
		menu = new TextMenu(ITEMS, 1, TITLE);
	}
	public void start(){

		int selection = -1;
		do {
			selection = menu.select();
		}while(selection < 0);

		while(Button.ENTER.isDown()) {
			}
		
		Plottable toDraw = null;
		PlotbotControl pc = new PlotbotControl();
		
		switch (selection){
			case 0: toDraw = new Calibration(pc);break;
			case 1: toDraw = new Rectangle(pc); break;
			case 2: toDraw = new Ship(pc); break;
			default: toDraw = null;
		}
			//Think about what you have to do to start the drawing routine	
	}
}

package de.tuhh.diss.plotbot;

import de.tuhh.diss.plotbot.shape.Plottable;
import lejos.nxt.Button;
import lejos.nxt.LCD;

//for test code to delete
import lejos.nxt.Motor;
import lejos.nxt.TouchSensor;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import de.tuhh.diss.plotbot.shape.Plottable;
import de.tuhh.diss.plotbot.PlotbotControl;

public class Plotbot {
	
	
	//Test Code To Delete After
	public static void resetPenHeight(){
		TouchSensor penSensor = new TouchSensor(SensorPort.S2);
		Motor.B.setSpeed(200);
		Motor.B.resetTachoCount();
		while(! penSensor.isPressed() && ! Button.ESCAPE.isDown()){
			Motor.B.rotate(-10);
			}
	}
	public static void manuallyDescend(){
		Motor.B.resetTachoCount();
		Motor.B.setSpeed(200);
		
		while(! Button.ESCAPE.isDown()){
		Button.RIGHT.waitForPressAndRelease();
		LCD.clearDisplay();
		Motor.B.rotate(10);
		LCD.drawInt(Motor.B.getTachoCount(), 0, 1);
		}
	}
	//end of test code
	public static void main(String[] args)
	{
		//resetPenHeight();
		//manuallyDescend();
		
		// Some example code to check if the build process works
		 LCD.drawString("Compiled successfully", 0, 0);
		 LCD.drawString("Good Luck!", 0, 1);
		 Button.RIGHT.waitForPressAndRelease();
		 LCD.clearDisplay();
		
		
		//Call your MainMenu from here after you deleted the example code
		
	    MainMenu myMainMenu = new MainMenu();
		myMainMenu.start();
			
	}
	
}

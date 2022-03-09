package de.tuhh.diss.plotbot.shape;

import lejos.nxt.Motor;
import lejos.util.Delay;
import lejos.util.Timer;
import lejos.util.Delay;
import lejos.nxt.TouchSensor;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import de.tuhh.diss.plotbot.shape.Plottable;
import de.tuhh.diss.plotbot.PlotbotControl;


public class Calibration implements Plottable{
	
	int maxAngleCount;
	int maxPenHeight;
	private PlotbotControl pc;
	
	
	public Calibration(PlotbotControl pc){
		this.pc = pc;
		plot(this.pc);
	}
	
	public void plot(PlotbotControl pc){
		// put your plot routine in here
		
		calibratePenHeight(pc);
		calibrateArmRotation(pc);
		goToIntitalPostion(pc);
		
		}
	
	public void calibrateArmRotation(PlotbotControl pc){
		/*Motor.A.setSpeed(400);
		while(!Button.LEFT.isDown()){
			Motor.A.rotate(-100);
		}*/
		
		// DESCEND PEN //
		
		/* Motor.B.resetTachoCount();
		Motor.B.setSpeed(200);
		LCD.clearDisplay();
		Motor.B.forward(); //descend the pen
		while(Motor.B.getTachoCount() < 299){
			LCD.drawInt(Motor.B.getTachoCount(), 0, 1);
		}
		Motor.B.stop();*/
		
		// END OF DESCEND PEN //
		
		TouchSensor armSensor = pc.getArmSensor();
		Motor.A.setSpeed(400);
		Motor.A.resetTachoCount();
		LCD.clearDisplay();
		Motor.A.backward();
		while(! armSensor.isPressed()){
			
			LCD.drawInt(Motor.A.getTachoCount(), 0, 0);
		} 
		Motor.A.stop();
		
		maxAngleCount = Motor.A.getTachoCount();
		Delay.msDelay(1000);
		
		// ASCEND PEN //
		
		/*TouchSensor penSensor = new TouchSensor(SensorPort.S2);
		Motor.B.backward();
		while(!penSensor.isPressed()){
			
		}
		Motor.B.stop(); */
		
		// END OF ASCEND PEN //
		
		Motor.A.resetTachoCount();
		Motor.A.forward();
		
		while(Motor.A.getTachoCount() < (-1 * pc.MAX_ANGLE_COUNT) ){
			
			LCD.drawInt(Motor.A.getTachoCount(), 0, 0);
		}
		Motor.A.stop();
		
	}
	
	public void calibratePenHeight(PlotbotControl pc){
		TouchSensor penSensor = pc.getPenSensor();
		Motor.B.setSpeed(200);
		Motor.B.resetTachoCount();
		while(! penSensor.isPressed()){
			Motor.B.rotate(10);
			}
		maxPenHeight = Motor.B.getTachoCount();
	}
	
	public void goToIntitalPostion(PlotbotControl pc){
		LightSensor lightSensor = pc.getLightSensor();
		LCD.clearDisplay();
		Motor.C.setSpeed(200);
		Motor.C.resetTachoCount();
		Motor.C.backward();
		Delay.msDelay(1000);
		while(lightSensor.getNormalizedLightValue() > 500){
			LCD.drawInt(lightSensor.getNormalizedLightValue(), 0, 0);
			}
		Motor.C.stop();
		
		}
}
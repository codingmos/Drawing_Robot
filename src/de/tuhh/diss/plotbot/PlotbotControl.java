package de.tuhh.diss.plotbot;

import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

/**
 * This Class is used for control of the plotting robot. A great amount of time should spend for controlling the robot.
 * Add a suitable constructor and add further methods you need for driving the motors, evaluating the sensors etc.
 */
public class PlotbotControl {
	
	private TouchSensor armSensor;
	private TouchSensor penSensor;
	private LightSensor lightSensor;
	public final int MAX_ANGLE_COUNT = -4774;
	public final int MAX_PEN_HEIGHT = 269;
	
	public final int maxPenHeight = 269;
	public final int WHEEL_DIAMETER = 56;
	
	public PlotbotControl (){
		armSensor = new TouchSensor(SensorPort.S1);
		penSensor = new TouchSensor(SensorPort.S2);
		lightSensor = new LightSensor(SensorPort.S3);
		}

	public TouchSensor getArmSensor() {
		return armSensor;
	}

	public TouchSensor getPenSensor() {
		return penSensor;
	}

	public LightSensor getLightSensor() {
		return lightSensor;
	}
	
	
	
	
	

	
	
	
	
}

package de.tuhh.diss.plotbot.shape;

import lejos.nxt.Motor;
import lejos.nxt.TouchSensor;
import lejos.util.Matrix;
import lejos.nxt.LCD;
import lejos.nxt.LightSensor;
import lejos.nxt.NXTRegulatedMotor;
import lejos.nxt.SensorPort;
import de.tuhh.diss.plotbot.shape.Plottable;
import de.tuhh.diss.plotbot.PlotbotControl;
import de.tuhh.diss.plotbot.shape.Calibration;

public class Line {

	private PlotbotControl pc;
	private Coord start;
	private Coord end;

	public Line(PlotbotControl pc, Coord start, Coord end) {
		this.pc = pc;
		this.start = start;
		this.end = end;
	}

	public void drawLine() {
		if (this.start.getX() == this.end.getX()) {
			drawVerticalLine();
		}

		else if (this.start.getY() == this.end.getY()) {
			drawHorizontalLine();
		}

		else {
			drawInclinedLine();
		}
	}

	public void drawVerticalLine() {
		
		drawHorizontalLine();
	}

	public void drawHorizontalLine() {

	}

	public void drawInclinedLine() {
	}

}

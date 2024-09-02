package leJOSProject;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;

public class colourID {

	public int ColourID(EV3ColorSensor colourSensor,float[][] ColourMap) {
		float[] sample = new float[3];
		float minRED, minBLUE, minGREEN, maxRED, maxGREEN, maxBLUE;
		minRED = 255;
		minBLUE = 255;
		minGREEN = 255;
		maxRED = 0;
		maxBLUE = 0;
		maxGREEN =0;

		for (int g = 0; g < 9; g++ ) {
		colourSensor.getRGBMode().fetchSample(sample, 0);
		

		if (sample[Color.RED]*255> maxRED) {
			maxRED = sample[Color.RED]*255;
		}if (sample[Color.RED]*255 < minRED) {
			minRED = sample[Color.RED]*255;
		}if(sample[Color.GREEN]*255> maxGREEN) {
			maxGREEN = sample[Color.GREEN]*255;
		}if (sample[Color.GREEN]*255< minGREEN) {
			minGREEN = sample[Color.GREEN]*255;
		}if (sample[Color.BLUE]*255 > maxBLUE) {
			maxBLUE = sample[Color.BLUE]*255;
		}if (sample[Color.BLUE]*255 < minBLUE) {
			minBLUE = sample[Color.BLUE]*255;
		}}
		float averageRED = minRED+((maxRED - minRED)/2);
		float averageGREEN = minGREEN+((maxGREEN - minGREEN)/2);
		float averageBLUE = minBLUE+((maxBLUE - minBLUE)/2);
		
		for (int i = 0; i < 9; i++) {
			if (averageRED > ColourMap[i][3] && averageRED < ColourMap[i][0] && averageGREEN > ColourMap[i][4] && averageGREEN < ColourMap[i][1] && averageBLUE > ColourMap[i][5] && averageBLUE < ColourMap[i][2]) {
				return(i+1);
			}else {
				
			}
		}
		return (-1);
		
	}
	
	
	
	public static void main(String[] args) {
	
	}

}
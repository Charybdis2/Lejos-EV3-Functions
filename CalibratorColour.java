package leJOSProject;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.robotics.navigation.MovePilot;
import lejos.utility.Delay;

public class CalibratorColour {

	private float minRED = 255f;
	private float minBLUE = 255f;
	private float minGREEN = 255f;
	private float maxRED = 0f;
	private float maxBLUE = 0f;
	private float maxGREEN =0f;
	
	/**Created by Marcus 
     * 
     * Good luck. it kinda works
     * 
     */
	
	
	public float[][] FillMap(EV3ColorSensor colourSensor){
	float[][] colourMap = new float[9][6];
	float[] sample = new float[3];
	
	for (int i = 0; i < 9; i++) {
		LCD.drawString("Scanning Colour ", 0, 0);
		while (!Button.ENTER.isDown()) {
			
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
			}
			
		}
		colourMap[i][0] = maxRED;
		colourMap[i][1] = maxGREEN;
		colourMap[i][2] = maxBLUE;
		colourMap[i][3] = minRED;
		colourMap[i][4] = minGREEN;
		colourMap[i][5] = minBLUE;
		LCD.drawString("Next Colour ", 0, 0);
		Delay.msDelay(200); 
		Button.ENTER.waitForPressAndRelease();
		
		
	}
	
	
	return(colourMap);
	
	
	}
	
	
	
	

}
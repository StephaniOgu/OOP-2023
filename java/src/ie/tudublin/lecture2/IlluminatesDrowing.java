package ie.tudublin.lecture2;

import processing.core.PApplet;

public class IlluminatesDrowing extends PApplet
{
	int screenSize = 500;
	
	public void settings(){
		size(500, 500);
	}

	public void setup() {
		background(255, 0, 0);
		
		
	}
	
	public void draw(){	
		noStroke();
		fill(255, 255, 0);
		circle(screenSize/2, screenSize/2, screenSize/100*90);
		fill(0, 255, 255);
		triangle(0, 400, screenSize, 400, 255, 0);
		fill(255, 255, 255);
		ellipse(screenSize/2, screenSize/2, 300, 100);
		fill(1, 1, 1);
		circle(screenSize/2, screenSize/2, screenSize/100*25);
		fill(mouseX, mouseY, mouseY);

		//circle(mouseX, mouseY, 50);
	}
}

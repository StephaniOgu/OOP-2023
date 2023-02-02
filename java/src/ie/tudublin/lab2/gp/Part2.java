package ie.tudublin.lab2.gp;
import processing.core.PApplet;

public class Part2 extends PApplet{

    int screenHeight = 500;
    int screenWeight = 500;
    int mode = 0;
    boolean lastPressed = false;

    @Override
    public void settings(){
		size(screenHeight, screenWeight);
	}

    @Override
    public void setup() {
        background(255);
	}

    @Override
    public void draw(){
	}
}

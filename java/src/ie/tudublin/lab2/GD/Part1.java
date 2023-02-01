package ie.tudublin.lab2;
import processing.core.PApplet;


public class Part1 extends PApplet{

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
		switch(mode) {
            case 0: 
                faceDraw();
                break;
            case 1: 
                circleDrow();
                break;
            case 2: 
                sqaresDraw();
                break;
            case 3: 
                amanitaDrow();
                break;
            default:
                break;
        }   

        keyPressingLogic();
        
	}

    void keyPressingLogic(){
        if(keyPressed){
            if(!lastPressed){
                mode = (mode+1) % 4;
            }
            lastPressed = true;
        } else{
            lastPressed = false;
        }
    }
    
    void faceDraw() {
        background(255);
        noStroke();
        int x = mouseX;
        int y = mouseY;
        fill(0);
        circle(x, y, 100);
        fill(x, y, 255);
        circle(x-30, y-20, 20);
        circle(x+30, y-20, 20);
        arc(x, y+20, 40, 40, 0, PI);
    }

    void circleDrow() {
        background(255);
        int x = mouseX;
        circle(screenHeight/2, screenWeight/2, x);
    }

    void sqaresDraw() {
        background(255);
        int x = mouseX;
        int y = mouseY;
        rect(screenHeight/3, screenWeight/3,screenHeight/6+x/2, screenWeight/6+y);
        rect(screenHeight/3, screenWeight/3,screenHeight/6+x/2, screenWeight/6-y);
    }


    void amanitaDrow() {
        background(255);
        int x = mouseX;
        int y = mouseY;
        arc(x, y, 320, 320, 0,  8+9, PIE);

    }
}

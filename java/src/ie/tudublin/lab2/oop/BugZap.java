package ie.tudublin.lab2.oop;
import org.w3c.dom.traversal.NodeIterator;

import processing.core.PApplet;

public class BugZap extends PApplet {
    int screenHeight = 600; 
    int screenWeight = 600;
    float playerWidth = 10;
    float playerX = 0;
    float playerY = screenWeight-playerWidth*2;
    boolean lastPressed = false;
    boolean isShooting = false;
    int bugX = 0;
    int bugY = 0;
    int playerStep = 5; 
    int bugStep = 30; 
    int score = 0;
    int lazerY2 = 0;

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
        fill(0);
        noFill();
        drawPlayer(playerX, playerY, playerWidth);
        if ((frameCount % 60) == 0) {
            bugX+=random(bugStep);
            bugY+=random(bugStep);
        }
        drawBug(bugX, bugY, 10);
        if(bugY >= screenHeight* 0.95f){
            printFinalScore();
        }
        printScore();
        keyPressed();
	}

    void printScore(){
        textSize(10);
        text("Score: " + score, 50, 50); 
    }

    void drawPlayer(float x, float y, float w){
        background(255);
        rect(x, y, playerWidth, playerWidth);
        float lineBegX = x+playerWidth/2;
        float lineEndY = y-playerWidth/2;
        line(lineBegX, y, lineBegX, lineEndY);
        
        if(isShooting){
            drawLaser(lineBegX, lineEndY);
        }
    }

    void drawLaser(float x, float y){
        line(x, y, x, lazerY2);
        isShooting = false;
    }

    void drawBug(float x, float y, float w){
        //body
        triangle(x, y, x+w, y+w, x-w, y+w);
        //face
        circle(x-w/4, y+w/2, w/4);
        circle(x+w/4, y+w/2, w/4);
        //legs
        triangle(x, y+w, x+w, y+w, x+w, y+w+w/2);
        triangle(x, y+w, x-w, y+w, x-w, y+w+w/2);

        moveBug(x);
        
    }

    void moveBug(float x) {
        if ((frameCount % 60) == 0) {
            if(x<screenHeight/100*90) {
                bugX+=random(bugStep);
            } else {
                bugX-=random(bugStep);
            }
            bugY+=random(playerStep);
        }
    }

    void printFinalScore(){
        background(255);
        textSize(30);
        fill(0);
        text("Game finished. Your score is " + score, screenHeight/100 * 20, screenHeight/100 * 20); 
    }

    void printShoot(float x, float y){
        score+=1;
        textSize(30);
        fill(0);
        text("shoot!", x, y); 
    }

    void resetBug(){
        lazerY2 = 0;
        bugX = (int)random(width);
        bugY = 50;
    }

    @Override
    public void keyPressed() {
        if(keyPressed) {
            if(!lastPressed){
                if (keyCode == LEFT) {
                    if(playerX - playerStep > 0) {
                        playerX = playerX-playerStep;
                    }
                }
                if (keyCode == RIGHT) {
                    if(playerX + playerStep < width) {
                        playerX = playerX+playerStep;
                    }
                }
                if (key == ' ') {
                    isShooting = true;
                    if(playerX > bugX - playerWidth && playerX < bugX + playerWidth ){
                        printShoot(bugX + 20, bugY + 20);
                        lazerY2 = bugY;
                        resetBug();
                    }
                }
            }
        } else {
            lastPressed = false;
        }
	}
}

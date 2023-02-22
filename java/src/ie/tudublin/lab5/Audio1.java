package ie.tudublin.lab5;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;
    float[] lerpedBuffer;

    int mode = 0;

    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    @Override
    public void keyPressed() {
		// if (key >= '0' && key <= '9') {
		// 	mode = key - '0';
		// }
		// if (keyCode == ' ') {
        //     if (ap.isPlaying()) {
        //         ap.pause();
        //     } else {
        //         ap.rewind();
        //         ap.play();
        //     }
        // }

        // if (key == '1') {
        //     mode = key - '0';
        // }
        switch(key){
            case '0':
                mode = 0;
                break;
            case '1':
                mode = 1;
                break;
            case '2':
                mode = 2;
                break;
            case '3':
                mode = 3;
                break;
            case '4':
                mode = 4;
                break;
            case '5':
                mode = 5;
                break;
        }
	}

    @Override
    public void settings()
    {
        size(1024, 1000);
        //fullScreen(P3D, SPAN);
    }

    @Override
    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        // ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        // ab = ai.mix; 

        // And comment the next two lines out
        ap = minim.loadFile("heroplanet.mp3", 1024);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[width];

    }

    float off = 0;

    @Override
    public void draw()
    {
        //background(0);
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        off += 1;
        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        for(int i = 0 ; i < ab.size() ; i ++) {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);

        }
        average= sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
        
    
        switch (mode) {
			case 0:
            //lines - done
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++) {
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = lerpedBuffer[i] * halfH * 4.0f;
                    line(i, halfH + f, halfH - f, i);                    
                }
               break;
            case 1:
            //wave forms - done
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++) {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = lerpedBuffer[i] * halfH * 4.0f;
                    line(i, halfH + f, i, halfH - f);                    
                }
                break;
            case 2:
            //wave forms all sides the screan
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++) {
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = lerpedBuffer[i] * halfH * 8.0f;
                    line(i, 0 + f, i, 0 - f);
                    line(i, height + f, i, height - f);
                    line(0 + f, i, 0 - f, i);
                    line(width + f, i, width - f, i);                  
                }
                break;
            case 3:
            //sqare - done
                float c = map(smoothedAmplitude, 0, 0.5f, 0, 255);
                background(0);
                c = map(average, 0, 1, 0, 255);
                stroke(c, 255, 255);
                strokeWeight(2);
                noFill();
                rectMode(CENTER);
                square(width / 2, height / 2, 70 + (smoothedAmplitude * 500));
                break;
            case 4:
            //circle - done
                float c1 = map(smoothedAmplitude, 0, 0.5f, 0, 255);
                background(0);
                c = map(average, 0, 1, 0, 255);
                stroke(c1, 255, 255);
                strokeWeight(2);
                noFill();
                ellipse(width / 2, height / 2, 50 + (smoothedAmplitude * 500), 50 + (smoothedAmplitude * 500));
                break;
            case 5: {
                background(0);
                strokeWeight(2);
                for(int i = 0 ; i < ab.size() ; i +=10)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float cc = map(i, 0, ab.size(), 0, 255);
                    stroke(cc, 255, 255);
                    float f = lerpedBuffer[i] * halfH * 4.0f;
                    line(i, halfH + f, i, halfH - f);
                    fill(cc);
                    circle(i, halfH + f, 5);                    
                    circle(i, halfH - f, 5);                    
                }//end for loop
                break;
            }              
        }
        
        
        // Other examples we made in the class
        /*
        stroke(255);
        fill(100, 255, 255);        
        
        circle(width / 2, halfH, lerpedA * 100);

        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);        
        circle(200, smoothedY, 50);
        */

    }        
}

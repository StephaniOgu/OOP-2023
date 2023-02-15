package ie.tudublin.lab4;

import java.util.ArrayList;
import java.util.List;

import processing.data.*;

import processing.core.PApplet;

public class StarMap extends PApplet
{
	List<Star> stars = new ArrayList<>();
	int gridCellSize = 65;
	int cellCount = 11;

	public void settings(){
		size(800, 800);
	}

	public void setup() {
		colorMode(RGB);
		background(0);
		
		smooth();
	}

	public void drawGrid(){
		strokeWeight(1);
		stroke(216,191,216);
	
		int xHorisontal = gridCellSize;
		int yVertical = xHorisontal;
		for (int i = 0, k = -5; i<cellCount; i++, k++){
			fill(255, 255, 255);
			text(k, xHorisontal, gridCellSize/2);
			text(k, gridCellSize/2, yVertical);
			
			line(xHorisontal, gridCellSize, xHorisontal, gridCellSize*11);
			line(gridCellSize, yVertical, gridCellSize*11, yVertical);

			xHorisontal += gridCellSize;
			yVertical += gridCellSize;
		}
	}

	void loadStars()
	{
		Table table = (Table) loadTable("HabHYG15ly.csv", "header");
		for(TableRow r:table.rows()){
			Star s = new Star(r);
			stars.add(s);
		}
	}

	void drawStar(Star star){
		int starCenerRadus = 3;
		//formula: 
		//output = output_start + ((output_end - output_start) / (input_end - input_start)) * (input - input_start)
		float x = gridCellSize + ((gridCellSize * cellCount - gridCellSize) / (5 - -5)) * (star.xG - -5);
		float y = gridCellSize + ((gridCellSize * cellCount - gridCellSize) / (5 - -5)) * (star.yG - -5);
		
		stroke(255,233,0);
		line(x, y-starCenerRadus, x, y+starCenerRadus);
		line(x-starCenerRadus, y, x+starCenerRadus, y);
		
		strokeWeight(1);
		stroke(255, 0, 0);
		noFill();
		circle(x, y, star.absMag);
	}
		
	public void draw()
	{	
		strokeWeight(2);		
		drawGrid();
		loadStars();
		for(int i = 0; i<stars.size(); i++){
			drawStar(stars.get(i));
		}
		
	}
}

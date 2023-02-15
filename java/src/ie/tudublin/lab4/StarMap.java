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
		stroke(0, 255, 0);
	
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
		fill(255,233,0);
		int mappedHeight = height/cellCount;
		int mappedWeight = width/cellCount;

		float x = star.xG<0 ? width/2 -1 * star.xG : star.xG + width/2;
		float y = star.zG<0 ? width/2 -1 * star.yG : star.yG + height/2;

		//float x = gridCellSize + xAdd * gridCellSize;
		//float y = gridCellSize + yAdd * gridCellSize;



		text("+", x, y);
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

package ie.tudublin.lecture2;

public class Main
{

	public static void helloProcessing() {
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing());
	}

	public static void illuminatesDrowing() {
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new IlluminatesDrowing());
    }
	public static void main(String[] args) {

		helloProcessing();
		illuminatesDrowing();

	}
	
}
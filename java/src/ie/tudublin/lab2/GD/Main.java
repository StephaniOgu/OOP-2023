package ie.tudublin.lab2;

public class Main {

    public static void part1() {
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Part1());
	}

	public static void part2() {
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Part2());
	}

	public static void main(String[] args) {
		part1();
		part2();
	}
}

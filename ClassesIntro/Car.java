public class Car {
    String color;
	String type;

    public Car (String color, String type) {
        this.color = color;
        this.type = type;
    }

	void start() {
        System.out.println ("Get Started!");
	}

    void printDescription() {
        System.out.println ("This is a " + color + " " + type);
    }

    public String getDescription() {
        String description = "This is a " + color + " " + type;
        return description;
    }
}

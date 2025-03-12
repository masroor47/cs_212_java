

public class Lab3 {
    public static void main(String[] args) {
        float fahrenheit = 98.6f;
        float centigrade = (5f/9) * (fahrenheit - 32);

        System.out.println("Fahrenheit: " + fahrenheit + ", Centigrade: " + centigrade);
        
        for (float i = 0.0f; i <= 40; i+=5) {
            System.out.println("Fahrenheit: " + i + ", Centigrade: " + (5.0 / 9.0) * (i - 32.0f));
        }

        float i = 0.0f;
        while (i <= 40) {
            System.out.println("Fahrenheit: " + i + ", Centigrade: " + (5.0 / 9.0) * (i - 32.0f));
            i += 5;
        }
    }
}
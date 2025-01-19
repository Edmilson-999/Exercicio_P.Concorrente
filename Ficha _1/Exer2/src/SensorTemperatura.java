import java.util.Random;

public class SensorTemperatura implements Runnable {
    private final int MIN_TEMP = 15;
    private final int MAX_TEMP = 35;

    public void run() {
        Random random = new Random();

        while (true) {
            int temperatura = random.nextInt(MAX_TEMP - MIN_TEMP + 1) + MIN_TEMP;
            System.out.println("Temperatura atual: " + temperatura + "°C");

            try {
                Thread.sleep(1000); // Aguarda 1 segundo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

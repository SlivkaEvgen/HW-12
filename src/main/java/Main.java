
import java.util.concurrent.BrokenBarrierException;

public class Main {
    public static void main(String[] args) {
        Water water = new Water();
        String molecule = "OHHHHOHOH";
        Runnable hydrogen = () -> System.out.print("H");
        Runnable oxygen = () -> System.out.print("O");
        for (int i = 0; i < molecule.length(); i++) {
            char letter = molecule.charAt(i);
            if (letter == 'O') {
                new Thread(() -> {
                    try {
                        try {
                            water.releaseOxygen(oxygen);
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            } else if (letter == 'H') {
                new Thread(() -> {
                    try {
                        try {
                            water.releaseHydrogen(hydrogen);
                        } catch (BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();;
            }        }
    }
}



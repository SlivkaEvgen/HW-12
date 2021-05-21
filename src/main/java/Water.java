
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Water{
    private Semaphore oxygenSemaphor = new Semaphore(1);
    private Semaphore hydragenSemaphor = new Semaphore(2);
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    public void releaseHydrogen (Runnable hydrogenActive) throws InterruptedException, BrokenBarrierException {
        hydragenSemaphor.acquire();
        cyclicBarrier.await();
        hydrogenActive.run();
        hydragenSemaphor.release();
    }
    public void releaseOxygen (Runnable oxyActive) throws InterruptedException, BrokenBarrierException {
        oxygenSemaphor.acquire();
        cyclicBarrier.await();
        oxyActive.run();
        oxygenSemaphor.release();
    }
}
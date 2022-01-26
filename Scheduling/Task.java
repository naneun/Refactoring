import java.util.concurrent.Callable;

public class Task implements Callable<PCB> {
    private PCB pcb;
    private int sliceTime;

    public Task(PCB pcb, int sliceTime) {
        this.pcb = pcb;
        this.sliceTime = sliceTime;
    }

    @Override
    public PCB call() {
        try {
            Thread.sleep(sliceTime);
            this.pcb.update(sliceTime >> 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.pcb;
    }
}

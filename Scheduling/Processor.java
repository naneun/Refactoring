import java.util.PriorityQueue;
import java.util.concurrent.ExecutionException;

public class Processor {
    private Process[] processes;
    private PriorityQueue<Process> readyQueue;
    private int sliceTime;

    public Processor(int sliceTime) {
        this.processes = new Process[]{
                new Process("ProcessA", "ready", 3, (int) (Math.random() * 10) + 1)
                , new Process("ProcessB", "ready", 5, (int) (Math.random() * 10) + 1)
                , new Process("ProcessC", "ready", 7, (int) (Math.random() * 10) + 1)
                , new Process("ProcessD", "ready", 10, (int) (Math.random() * 10) + 1)
                , new Process("ProcessE", "ready", 15, (int) (Math.random() * 10) + 1)
        };
        this.readyQueue = new PriorityQueue<>();
        this.sliceTime = sliceTime;
    }

    public void run() {
        int count = 3, idx = (int) (Math.random() * count) + 1;
        for (int i = idx - 1; count-- > 0; i = (i + idx) % 5) {
            processes[i].setState("waitting");
            readyQueue.add(processes[i]);
        }
    }

    public void execute() throws InterruptedException, ExecutionException {
        Process curProcess = readyQueue.poll();
        curProcess.setState("running");
        System.out.println("% Running Process");
        System.out.println(curProcess);
        curProcess.run(sliceTime);
        if (curProcess.isTerminated()) {
            curProcess.setState("terminated");
            System.out.println("% Terminated Process");
            System.out.println(curProcess);
            return;
        }
        curProcess.setState("waitting");
        readyQueue.add(curProcess);
    }

    public boolean nextProcess() {
        return !readyQueue.isEmpty();
    }

    public void printReadyQueue() {
        System.out.println(">>> Ready Queue State");
        System.out.println(readyQueue);
        System.out.println();
    }
}

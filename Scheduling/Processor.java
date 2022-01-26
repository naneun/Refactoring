import java.util.*;
import java.util.concurrent.ExecutionException;

public class Processor {
    private List<Process> targets;
    private PriorityQueue<Process> readyQueue;
    private int sliceTime;

    public Processor(Process[] processes, int sliceTime) {
        this.targets = new ArrayList<>();
        this.readyQueue = new PriorityQueue<>();
        this.sliceTime = sliceTime;
        this.push(processes);
    }

    private void push(Process[] processes) {
        int count = 3, idx = (int) (Math.random() * count) + 1;
        for (int i = idx - 1; count-- > 0; i = (i + idx) % 5) {
            processes[i].setState(PCB.State.WAITTING);
            targets.add(processes[i]);
            readyQueue.add(processes[i]);
        }
        showInfo();
        System.out.println(">> let's start!\n");
    }

    public void operate() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                if (!nextProcess()) {
                    timer.cancel();
                    return;
                }
                Process curProcess = readyQueue.poll();
                curProcess.setState(PCB.State.RUNNING);
                try {
                    curProcess.run(sliceTime);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                updateTarget(curProcess);
                showInfo();
                if (curProcess.isTerminated()) {
                    curProcess.setState(PCB.State.TERMINATED);
                    updateTarget(curProcess);
                    showInfo();
                    elapsedTime(startTime);
                    return;
                }
                curProcess.setState(PCB.State.WAITTING);
                readyQueue.add(curProcess);
                elapsedTime(startTime);
            }
        };
        timer.schedule(timerTask, sliceTime, sliceTime);
    }

    private boolean nextProcess() {
        return !readyQueue.isEmpty();
    }

    private void updateTarget(Process process) {
        targets.stream().filter((target) -> target.equals(process))
                .forEach((target) -> target = process);
    }

    private void showInfo() {
        String result = targets.stream().map(Process::toString)
                .reduce("", (a, b) -> String.format("%s%s\n", a, b));

        System.out.println(result);
    }

    private void elapsedTime(long startTime) {
        System.out.println("Elapsed Time: " + (System.currentTimeMillis() - startTime) + " ms\n");
    }
}

import java.util.concurrent.*;

public class Process implements Comparable<Process> {
    private ScheduledExecutorService scheduledExecutorService;
    private CompletionService<PCB> completionService;
    private PCB pcb;

    public Process(String name) {
        pcb = new PCB(name);
    }

    public void setState(PCB.State state) {
        pcb.state = state;
    }

    public void run(int sliceTime) throws ExecutionException, InterruptedException {
        scheduledExecutorService = Executors.newScheduledThreadPool(
                Runtime.getRuntime().availableProcessors()
        );
        completionService = new ExecutorCompletionService(scheduledExecutorService);
        int threadCount = pcb.totalTime >> 1;
        Task[] tasks = new Task[threadCount];
        Future<PCB>[] futures = new Future[threadCount];
        for (int idx = 0; idx < threadCount; ++idx) {
            tasks[idx] = new Task(pcb, sliceTime);
            futures[idx] = completionService.submit(tasks[idx]);
            scheduledExecutorService.submit((Runnable) () -> {
                while (true) {
                    try {
                        Future<PCB> future = completionService.take();
                        pcb = future.get();
                        System.out.println(Thread.currentThread() + " complete");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        for (int idx = 0; idx < threadCount; ++idx) {
            pcb = futures[idx].get();
        }
        scheduledExecutorService.shutdown();
    }

    public boolean isTerminated() {
        return pcb.operatingTime == pcb.totalTime;
    }

    @Override
    public int compareTo(Process obj) {
        return Integer.compare(obj.pcb.priority, this.pcb.priority);
    }

    @Override
    public String toString() {
        return String.format("%s(%s), %d / %d sec, ThreadCount: %d, Priority: %d"
                , pcb.name, pcb.state, pcb.operatingTime, pcb.totalTime, pcb.totalTime >> 1, pcb.priority);
    }
}

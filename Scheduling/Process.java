import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Process implements Comparable<Process> {
    private ProcessInfo processInfo;

    public Process(String name, String state, int totalTime, int priority) {
        processInfo = new ProcessInfo(name, state, totalTime, priority);
    }

    public void setState(String state) {
        processInfo.state = state;
    }

    public void run(int sliceTime) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );
        int threadCount = processInfo.totalTime >> 1;
        Task[] tasks = new Task[threadCount];
        Future<ProcessInfo>[] futures = new Future[threadCount];
        for (int idx = 0; idx < threadCount; ++idx) {
            tasks[idx] = new Task(processInfo, sliceTime);
            futures[idx] = executorService.submit(tasks[idx], processInfo);
        }
        for (int idx = 0; idx < threadCount; ++idx) {
            processInfo = futures[idx].get();
        }
        executorService.shutdown();
    }

    public boolean isTerminated() {
        return processInfo.operatingTime == processInfo.totalTime;
    }

    @Override
    public int compareTo(Process obj) {
        return Integer.compare(obj.processInfo.priority, this.processInfo.priority);
    }

    @Override
    public String toString() {
        return "Process { " +
                "name='" + processInfo.name + '\'' +
                ", state='" + processInfo.state + '\'' +
                ", totalTime=" + processInfo.totalTime +
                ", operatingTime=" + processInfo.operatingTime +
                ", threadCount=" + (processInfo.totalTime >> 1) +
                ", priority=" + processInfo.priority +
                " }\n";
    }
}

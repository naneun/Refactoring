public class Task implements Runnable {
    private ProcessInfo processInfo;
    private int sliceTime;

    public Task(ProcessInfo processInfo, int sliceTime) {
        this.processInfo = processInfo;
        this.sliceTime = sliceTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(sliceTime);
            processInfo.operate(sliceTime << 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ProcessInfo {
    String name;
    String state;
    int totalTime;
    int operatingTime;
    int priority;

    public ProcessInfo(String name, String state, int totalTime, int priority) {
        this.name = name;
        this.state = state;
        this.totalTime = totalTime;
        this.priority = priority;
    }

    public void operate(int sliceTime) {
        synchronized (this) {
            if ((this.operatingTime += sliceTime / 1000) >= this.totalTime) {
                this.operatingTime = this.totalTime;
            }
        }
    }
}

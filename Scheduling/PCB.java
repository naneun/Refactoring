public class PCB {
    String name;
    State state;
    int totalTime;
    int operatingTime;
    int priority;

    enum State {
        READY, RUNNING, WAITTING, TERMINATED;
    }

    public PCB(String name) {
        this.name = name;
        this.state = State.READY;
        this.totalTime = (int) (Math.random() * 15) + 1;
        this.priority = (int) (Math.random() * 10) + 1;
    }

    public void update(int sliceTime) {
        synchronized (this) {
            if ((this.operatingTime += sliceTime / 1000) >= this.totalTime) {
                this.operatingTime = this.totalTime;
            }
        }
    }
}

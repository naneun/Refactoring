public class MainMemory {
    private Process[] processes;

    public MainMemory() {
        this.processes = new Process[] { new Process("A")
                , new Process("B"), new Process("C")
                , new Process("D"), new Process("E")
        };
    }

    public Process[] dispatch() {
        return this.processes;
    }
}

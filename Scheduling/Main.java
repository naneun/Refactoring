public class Main {
    public static void main(String[] args) {
        MainMemory memory = new MainMemory();
        Processor processor = new Processor(memory.dispatch(), 2000);
        processor.operate();
    }
}

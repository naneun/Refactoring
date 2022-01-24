import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) {
        Processor processor = new Processor(1000);
        processor.run();
        try {
            while (processor.nextProcess()) {
                processor.printReadyQueue();
                processor.execute();
            }
            processor.printReadyQueue();
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

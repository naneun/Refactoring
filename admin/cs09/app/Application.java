package cs09.app;

import cs09.controller.SeatController;
import cs09.model.User;
import cs09.response.SeatResponse;
import cs09.util.InputView;
import cs09.util.OutputView;
import cs09.util.Parser;
import cs09.util.WaitingQueue;

import java.io.IOException;

public class Application {
    private InputView inputView;
    private OutputView outputView;
    private SeatController seatController;
    private WaitingQueue waitingQueue;

    private enum COMMAND {
        NEW, STOP
    }

    public Application(WaitingQueue waitingQueue) {
        this.inputView = InputView.getInstance();
        this.outputView = OutputView.getInstance();
        this.seatController = SeatController.getInstance();
        this.waitingQueue = waitingQueue;
    }

    public void run() {
        seatController.init(); /* seat reset */

        outputView.notice();
        outputView.showEmptySeats(seatController.getEmptySeats());
        while (!waitingQueue.isEmpty()) {
            try {
                inputView.CLI();
                String input = inputView.readLine().toUpperCase();
                String[] str = Parser.parse(input);
                switch (COMMAND.valueOf(str[0])) {
                    case NEW:
                        User user = waitingQueue.callUser();
                        SeatResponse response = seatController.use(user);
                        outputView.notice(response);
                        break;
                    case STOP:
                        int userId = Integer.parseInt(str[1]);
                        int seatId = seatController.endUse(userId);
                        outputView.notice(seatId);
                        break;
                    default:
                }
                outputView.showEmptySeats(seatController.getEmptySeats());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

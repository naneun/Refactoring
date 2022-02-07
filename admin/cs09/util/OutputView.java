package cs09.util;

import cs09.model.Seat;
import cs09.response.SeatResponse;

import java.util.List;

public class OutputView {
    private static OutputView outputView;

    private OutputView() {}

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void notice() {
        System.out.println("빈자리는 다음과 같습니다.");
    }

    public void notice(SeatResponse response) {
        System.out.println(response.getSeatId() + "번 자리에 앉으세요 : #" + response.getUserId());
    }

    public void notice(int seatId) {
        System.out.println("이제 " + seatId + "번 자리가 비었습니다.");
    }

    public void showEmptySeats(List<Seat> vacancy) {
        System.out.printf("%s\n%n", vacancy);
    }
}

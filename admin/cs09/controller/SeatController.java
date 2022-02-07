package cs09.controller;

import cs09.model.Seat;
import cs09.model.User;
import cs09.response.SeatResponse;
import cs09.service.SeatService;

import java.util.List;

public class SeatController {
    private static SeatController controller;
    private SeatService seatService;

    private SeatController() {
        this.seatService = seatService.getInstance();
    }

    public static SeatController getInstance() {
        if (controller == null) {
            controller = new SeatController();
        }
        return controller;
    }

    public void init() {
        seatService.init();
    }

    public SeatResponse use(User user) {
        int userId = user.getId();
        int seatId = seatService.use(userId);
        return new SeatResponse(seatId, userId);
    }

    public int endUse(int userId) {
        int seatId = seatService.getSeatId(userId);
        seatService.endUse(seatId);
        return seatId;
    }

    public List<Seat> getEmptySeats() {
        return seatService.getEmptySeats();
    }
}

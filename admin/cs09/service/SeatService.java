package cs09.service;

import cs09.model.Seat;
import cs09.model.User;
import cs09.repository.SeatDao;

import java.util.List;

public class SeatService {
    private static SeatService service;
    private SeatDao seatDao;

    private SeatService() {
        seatDao = SeatDao.getInstance();
    }

    public static SeatService getInstance() {
        if (service == null) {
            service = new SeatService();
        }
        return service;
    }

    public void init() {
        seatDao.init();
    }

    public int getSeatId(int userId) {
        return seatDao.getSeatId(userId);
    }

    public int use(int userId) {
        List<Seat> seats = seatDao.getEmptySeats();
        Seat target = seats.get((int) (Math.random() * (seats.size() - 1)));
        int seatId = target.getId();
        seatDao.use(seatId, userId);
        return seatId;
    }

    public void endUse(int seatId) {
        seatDao.endUse(seatId);
    }

    public List<Seat> getEmptySeats() {
        return seatDao.getEmptySeats();
    }
}

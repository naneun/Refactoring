package cs09.response;

public class SeatResponse {
    private int seatId;
    private int userId;

    public SeatResponse(int seatId, int userId) {
        this.seatId = seatId;
        this.userId = userId;
    }

    public int getSeatId() {
        return seatId;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "SeatResponse{" +
                "seatId=" + seatId +
                ", userId=" + userId +
                '}';
    }
}

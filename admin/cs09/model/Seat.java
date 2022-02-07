package cs09.model;

import java.util.Date;

public class Seat {
    private int id;
    private int user_id;
    private Date start_time;
    private Date end_time;

    public Seat(int id, int user_id, Date start_time, Date end_time) {
        this.id = id;
        this.user_id = user_id;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}

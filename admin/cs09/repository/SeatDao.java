package cs09.repository;

import cs09.model.Seat;
import cs09.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeatDao {
    private static SeatDao dao;

    private SeatDao() {}

    public static SeatDao getInstance() {
        if (dao == null) {
            dao = new SeatDao();
        }
        return dao;
    }

    public void init() {
        String sql = "update seat set user_id = 0";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public int getSeatId(int userId) {
        String sql = "select id from seat where user_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, String.valueOf(userId));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public void use(int seatId, int userId) {
        String sql = "update seat set user_id = ?, start_time = now(), end_time = null where id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, String.valueOf(userId));
            ps.setString(2, String.valueOf(seatId));
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void endUse(int seatId) {
        String sql = "update seat set user_id = 0, end_time = now() where id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, String.valueOf(seatId));
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Seat> getEmptySeats() {
        List<Seat> seats = new ArrayList<>();
        String sql = "select * from seat where user_id = 0 order by 1";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    seats.add(new Seat(rs.getInt(1), rs.getInt(2)
                            , rs.getDate(3), rs.getDate(4)));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return seats;
    }
}

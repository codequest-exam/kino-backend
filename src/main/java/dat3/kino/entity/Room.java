package dat3.kino.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Room {
    @Id
    private Long id;
    @ManyToOne
    private Cinema cinema;
    private int roomNumber;
    private boolean supports3d;
    private boolean supportsImax;
    private int rows;
    private int seatsPerRow;

    public Room(Long id, Cinema cinema, int roomNumber, boolean supports3d, boolean supportsImax, int rows, int seatsPerRow) {
        this.id = id;
        this.cinema = cinema;
        this.roomNumber = roomNumber;
        this.supports3d = supports3d;
        this.supportsImax = supportsImax;
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
    }

    public Room() {
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isSupports3d() {
        return supports3d;
    }

    public void setSupports3d(boolean supports3d) {
        this.supports3d = supports3d;
    }

    public boolean isSupportsImax() {
        return supportsImax;
    }

    public void setSupportsImax(boolean supportsImax) {
        this.supportsImax = supportsImax;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public void setSeatsPerRow(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

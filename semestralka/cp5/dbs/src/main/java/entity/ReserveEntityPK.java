package entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class ReserveEntityPK implements Serializable {
    @Column(name = "readerforreserve")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int readerforreserve;
    @Column(name = "bookreserve")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookreserve;
    @Column(name = "reservationtype")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationtype;

    public int getReaderforreserve() {
        return readerforreserve;
    }

    public void setReaderforreserve(int readerforreserve) {
        this.readerforreserve = readerforreserve;
    }

    public int getBookreserve() {
        return bookreserve;
    }

    public void setBookreserve(int bookreserve) {
        this.bookreserve = bookreserve;
    }

    public int getReservationtype() {
        return reservationtype;
    }

    public void setReservationtype(int reservationtype) {
        this.reservationtype = reservationtype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReserveEntityPK that = (ReserveEntityPK) o;

        if (readerforreserve != that.readerforreserve) return false;
        if (bookreserve != that.bookreserve) return false;
        if (reservationtype != that.reservationtype) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = readerforreserve;
        result = 31 * result + bookreserve;
        result = 31 * result + reservationtype;
        return result;
    }
}

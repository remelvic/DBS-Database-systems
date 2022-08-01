package entity;

import javax.persistence.*;

@Entity
@Table(name = "reserve", schema = "public", catalog = "remelvic")
@IdClass(ReserveEntityPK.class)
public class ReserveEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "readerforreserve")
    private int readerforreserve;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "bookreserve")
    private int bookreserve;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reservationtype")
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

        ReserveEntity that = (ReserveEntity) o;

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

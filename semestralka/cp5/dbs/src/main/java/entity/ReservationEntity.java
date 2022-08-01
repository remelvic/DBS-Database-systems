package entity;

import javax.persistence.*;

@Entity
@Table(name = "reservation", schema = "public", catalog = "remelvic")
public class ReservationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "numberofreservation")
    private int numberofreservation;
    @Basic
    @Column(name = "reservedate")
    private String reservedate;
    @Basic
    @Column(name = "returndate")
    private String returndate;

    public int getNumberofreservation() {
        return numberofreservation;
    }

    public void setNumberofreservation(int numberofreservation) {
        this.numberofreservation = numberofreservation;
    }

    public String getReservedate() {
        return reservedate;
    }

    public void setReservedate(String reservedate) {
        this.reservedate = reservedate;
    }

    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationEntity that = (ReservationEntity) o;

        if (numberofreservation != that.numberofreservation) return false;
        if (reservedate != null ? !reservedate.equals(that.reservedate) : that.reservedate != null) return false;
        if (returndate != null ? !returndate.equals(that.returndate) : that.returndate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numberofreservation;
        result = 31 * result + (reservedate != null ? reservedate.hashCode() : 0);
        result = 31 * result + (returndate != null ? returndate.hashCode() : 0);
        return result;
    }
}

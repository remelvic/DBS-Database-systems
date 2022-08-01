package entity;

import javax.persistence.*;

@Entity
@Table(name = "penalty", schema = "public", catalog = "remelvic")
public class PenaltyEntity {

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "readerpenalty")
    private int readerpenalty;
    @Basic
    @Column(name = "penalize")
    private Integer penalize;

    public int getReaderpenalty() {
        return readerpenalty;
    }

    public void setReaderpenalty(int readerpenalty) {
        this.readerpenalty = readerpenalty;
    }

    public Integer getPenalize() {
        return penalize;
    }

    public void setPenalize(Integer penalize) {
        this.penalize = penalize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PenaltyEntity that = (PenaltyEntity) o;

        if (readerpenalty != that.readerpenalty) return false;
        if (penalize != null ? !penalize.equals(that.penalize) : that.penalize != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = readerpenalty;
        result = 31 * result + (penalize != null ? penalize.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PenaltyEntity{" +
                "readerpenalty=" + readerpenalty +
                ", penalize=" + penalize +
                '}';
    }

}

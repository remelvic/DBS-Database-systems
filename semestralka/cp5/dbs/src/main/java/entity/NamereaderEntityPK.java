package entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class NamereaderEntityPK implements Serializable {
    @Column(name = "readernamecode")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int readernamecode;
    @Column(name = "firstname")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String firstname;
    @Column(name = "lastname")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String lastname;

    public int getReadernamecode() {
        return readernamecode;
    }

    public void setReadernamecode(int readernamecode) {
        this.readernamecode = readernamecode;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NamereaderEntityPK that = (NamereaderEntityPK) o;

        if (readernamecode != that.readernamecode) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = readernamecode;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
}

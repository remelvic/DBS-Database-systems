package entity;

import javax.persistence.*;

@Entity
@Table(name = "namereader", schema = "public", catalog = "remelvic")
@IdClass(NamereaderEntityPK.class)
public class NamereaderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "readernamecode")
    private int readernamecode;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "firstname")
    private String firstname;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "lastname")
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

        NamereaderEntity that = (NamereaderEntity) o;

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

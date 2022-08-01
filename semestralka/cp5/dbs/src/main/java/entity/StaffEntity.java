package entity;

import javax.persistence.*;

@Entity
@Table(name = "staff", schema = "public", catalog = "remelvic")
public class StaffEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "staffid")
    private int staffid;
    @Basic
    @Column(name = "staffname")
    private String staffname;
    @Basic
    @Column(name = "readerstuff")
    private int readerstuff;
    @Basic
    @Column(name = "book")
    private Integer book;

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public int getReaderstuff() {
        return readerstuff;
    }

    public void setReaderstuff(int readerstuff) {
        this.readerstuff = readerstuff;
    }

    public Integer getBook() {
        return book;
    }

    public void setBook(Integer book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaffEntity that = (StaffEntity) o;

        if (staffid != that.staffid) return false;
        if (readerstuff != that.readerstuff) return false;
        if (staffname != null ? !staffname.equals(that.staffname) : that.staffname != null) return false;
        if (book != null ? !book.equals(that.book) : that.book != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = staffid;
        result = 31 * result + (staffname != null ? staffname.hashCode() : 0);
        result = 31 * result + readerstuff;
        result = 31 * result + (book != null ? book.hashCode() : 0);
        return result;
    }
}

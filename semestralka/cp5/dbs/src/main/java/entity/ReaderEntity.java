package entity;

import javax.persistence.*;

@Entity
@Table(name = "reader")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class ReaderEntity {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "readerid")
    private int readerid;
    @Basic
    @Column(name = "namereader")
    private String namereader;
    @Basic
    @Column(name = "mail")
    private String mail;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "numberofbooksavailabel")
    private int numberofbooksavailabel;

    public int getReaderid() {
        return readerid;
    }

    public void setReaderid(int readerid) {
        this.readerid = readerid;
    }

    public String getNamereader() {
        return namereader;
    }

    public void setNamereader(String namereader) {
        this.namereader = namereader;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberofbooksavailabel() {
        return numberofbooksavailabel;
    }

    public void setNumberofbooksavailabel(int numberofbooksavailabel) {
        this.numberofbooksavailabel = numberofbooksavailabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReaderEntity that = (ReaderEntity) o;

        if (readerid != that.readerid) return false;
        if (numberofbooksavailabel != that.numberofbooksavailabel) return false;
        if (namereader != null ? !namereader.equals(that.namereader) : that.namereader != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = readerid;
        result = 31 * result + (namereader != null ? namereader.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + numberofbooksavailabel;
        return result;
    }

    @Override
    public String toString() {
        return "readerid = " + readerid +
                ", namereader = '" + namereader + '\'' +
                ", mail = '" + mail + '\'' +
                ", address = '" + address + '\'' +
                ", numberofbooksavailabel = " + numberofbooksavailabel;
    }
}

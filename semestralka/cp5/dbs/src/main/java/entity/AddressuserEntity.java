package entity;

import javax.persistence.*;

@Entity
@Table(name = "addressuser", schema = "public", catalog = "remelvic")
@IdClass(AddressuserEntityPK.class)
public class AddressuserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "readeraddresscode")
    private int readeraddresscode;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "street")
    private String street;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "postalcode")
    private String postalcode;

    public int getReaderaddresscode() {
        return readeraddresscode;
    }

    public void setReaderaddresscode(int readeraddresscode) {
        this.readeraddresscode = readeraddresscode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressuserEntity that = (AddressuserEntity) o;

        if (readeraddresscode != that.readeraddresscode) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (postalcode != null ? !postalcode.equals(that.postalcode) : that.postalcode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = readeraddresscode;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (postalcode != null ? postalcode.hashCode() : 0);
        return result;
    }
}

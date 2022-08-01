package entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class AddresslibraryEntityPK implements Serializable {
    @Column(name = "street")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String street;
    @Column(name = "postalcode")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String postalcode;
    @Column(name = "codelibraryaddress")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codelibraryaddress;

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

    public int getCodelibraryaddress() {
        return codelibraryaddress;
    }

    public void setCodelibraryaddress(int codelibraryaddress) {
        this.codelibraryaddress = codelibraryaddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddresslibraryEntityPK that = (AddresslibraryEntityPK) o;

        if (codelibraryaddress != that.codelibraryaddress) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (postalcode != null ? !postalcode.equals(that.postalcode) : that.postalcode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (postalcode != null ? postalcode.hashCode() : 0);
        result = 31 * result + codelibraryaddress;
        return result;
    }
}

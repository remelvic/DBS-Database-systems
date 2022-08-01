package entity;

import javax.persistence.*;

@Entity
@Table(name = "addresslibrary", schema = "public", catalog = "remelvic")
@IdClass(AddresslibraryEntityPK.class)
public class AddresslibraryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "street")
    private String street;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "postalcode")
    private String postalcode;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codelibraryaddress")
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

        AddresslibraryEntity that = (AddresslibraryEntity) o;

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

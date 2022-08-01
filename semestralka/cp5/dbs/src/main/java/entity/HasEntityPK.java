package entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class HasEntityPK implements Serializable {
    @Column(name = "codelibraryhas")
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codelibraryhas;
    @Column(name = "hasnumberbook")
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hasnumberbook;

    public int getCodelibraryhas() {
        return codelibraryhas;
    }

    public void setCodelibraryhas(int codelibraryhas) {
        this.codelibraryhas = codelibraryhas;
    }

    public int getHasnumberbook() {
        return hasnumberbook;
    }

    public void setHasnumberbook(int hasnumberbook) {
        this.hasnumberbook = hasnumberbook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HasEntityPK that = (HasEntityPK) o;

        if (codelibraryhas != that.codelibraryhas) return false;
        if (hasnumberbook != that.hasnumberbook) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codelibraryhas;
        result = 31 * result + hasnumberbook;
        return result;
    }
}

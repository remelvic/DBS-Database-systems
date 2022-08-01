package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "has", schema = "public", catalog = "remelvic")
@IdClass(HasEntityPK.class)
public class HasEntity {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "codelibraryhas")
    private int codelibraryhas;
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "hasnumberbook")
    private int hasnumberbook;
//    @ManyToMany(mappedBy="bookReserve")
//    private Set<HasEntity> has_ = new HashSet<>();

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

        HasEntity hasEntity = (HasEntity) o;

        if (codelibraryhas != hasEntity.codelibraryhas) return false;
        if (hasnumberbook != hasEntity.hasnumberbook) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codelibraryhas;
        result = 31 * result + hasnumberbook;
        return result;
    }

    @Override
    public String toString() {
        return "HasEntity{ " +
                "codelibraryhas = " + codelibraryhas +
                ", hasnumberbook = " + hasnumberbook +
                " }";
    }
}

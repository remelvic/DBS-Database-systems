package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "library", schema = "public", catalog = "remelvic")
public class LibraryEntity {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "librarycode")
    private int librarycode;
    @Basic
    @Column(name = "namelibrary")
    private String namelibrary;
    @Basic
    @Column(name = "capacity")
    private Integer capacity;

    @ManyToMany
    @JoinTable(name="has",
            joinColumns = @JoinColumn(name="codelibraryhas"),
            inverseJoinColumns = @JoinColumn(name="hasnumberbook"))
    private Set<BookEntity> bookSet = new HashSet<>();

    public Set<BookEntity> getBookSet(){
        return bookSet;
    }

    public int getLibrarycode() {
        return librarycode;
    }

    public void setLibrarycode(int librarycode) {
        this.librarycode = librarycode;
    }

    public String getNamelibrary() {
        return namelibrary;
    }

    public void setNamelibrary(String namelibrary) {
        this.namelibrary = namelibrary;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibraryEntity that = (LibraryEntity) o;

        if (librarycode != that.librarycode) return false;
        if (namelibrary != null ? !namelibrary.equals(that.namelibrary) : that.namelibrary != null) return false;
        if (capacity != null ? !capacity.equals(that.capacity) : that.capacity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = librarycode;
        result = 31 * result + (namelibrary != null ? namelibrary.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        return result;
    }
}

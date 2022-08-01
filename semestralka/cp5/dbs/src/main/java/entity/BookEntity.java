package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book", schema = "public", catalog = "remelvic")
public class BookEntity {
    @Id
    @Column(name = "numberbook")
    private int numberbook;
    @Basic
    @Column(name = "statebook")
    private String statebook;
    @Basic
    @Column(name = "category")
    private String category;
    @Basic
    @Column(name = "title")
    private String title;

//    @ManyToMany(mappedBy="book")
//    private
//    @ManyToMany
//    @JoinTable(name="reserve",
//            joinColumns = @JoinColumn(name="readerforreserve"),
//            inverseJoinColumns = @JoinColumn(name="bookreserve"))
//    private Set<BookEntity> bookReserve = new HashSet<>();

    public int getNumberbook() {
        return numberbook;
    }

    public void setNumberbook(int numberbook) {
        this.numberbook = numberbook;
    }

    public String getStatebook() {
        return statebook;
    }

    public void setStatebook(String statebook) {
        this.statebook = statebook;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (numberbook != that.numberbook) return false;
        if (statebook != null ? !statebook.equals(that.statebook) : that.statebook != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numberbook;
        result = 31 * result + (statebook != null ? statebook.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BookEntity{ " + "numberbook = " + numberbook + ", statebook = '" + statebook + '\'' +
                ", category = '" + category + '\'' +
                ", title = '" + title + '\'' +
                " }";
    }
}

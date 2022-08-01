package entity;

import javax.persistence.*;

@Entity
@Table(name = "publisher", schema = "public", catalog = "remelvic")
public class PublisherEntity {
    @Basic
    @Column(name = "publishes")
    private String publishes;
    @Basic
    @Column(name = "yearofpublication")
    private String yearofpublication;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "publicationid")
    private int publicationid;

    public String getPublishes() {
        return publishes;
    }

    public void setPublishes(String publishes) {
        this.publishes = publishes;
    }

    public String getYearofpublication() {
        return yearofpublication;
    }

    public void setYearofpublication(String yearofpublication) {
        this.yearofpublication = yearofpublication;
    }

    public int getPublicationid() {
        return publicationid;
    }

    public void setPublicationid(int publicationid) {
        this.publicationid = publicationid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PublisherEntity that = (PublisherEntity) o;

        if (publicationid != that.publicationid) return false;
        if (publishes != null ? !publishes.equals(that.publishes) : that.publishes != null) return false;
        if (yearofpublication != null ? !yearofpublication.equals(that.yearofpublication) : that.yearofpublication != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = publishes != null ? publishes.hashCode() : 0;
        result = 31 * result + (yearofpublication != null ? yearofpublication.hashCode() : 0);
        result = 31 * result + publicationid;
        return result;
    }
}

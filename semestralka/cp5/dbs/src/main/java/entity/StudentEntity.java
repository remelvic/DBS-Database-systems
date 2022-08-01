package entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class StudentEntity extends ReaderEntity{

    @Basic
    @Column(name = "degree")
    private String degree;

    public String getDegree(){
        return degree;
    }

    public void setDegree(String degree){
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "ReaderEntity{ " +super.toString() +", degree= '" + degree + '\'' + " }";
    }
}

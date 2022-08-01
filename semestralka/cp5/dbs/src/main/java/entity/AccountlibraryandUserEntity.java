package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "\"accountlibraryandUser\"", schema = "public", catalog = "remelvic")
public class AccountlibraryandUserEntity implements Serializable {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "accountnumber")
    private int accountnumber;
    @Basic
    @Column(name = "owner")
    private Integer owner;
    @Basic
    @Column(name = "balance")
    private Integer balance;

    public int getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(int accountnumber) {
        this.accountnumber = accountnumber;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountlibraryandUserEntity that = (AccountlibraryandUserEntity) o;

        if (accountnumber != that.accountnumber) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountnumber;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        return result;
    }
}

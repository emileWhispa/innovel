package models;

import com.avaje.ebean.Expr;
import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Noel on 6/18/2017.
 */

@Entity
public class Debts extends Model {
    @Id
    public long id;
    public String fromu = "";
    public int amount;
    public String motif = "";

    @ManyToOne(cascade = CascadeType.ALL)
    public Users doneby;

    public String date = "";

    public String deleteStatus = "";

    public static Model.Finder<Long, Debts> find = new Model.Finder<Long, Debts>(Long.class, Debts.class);

    public static List<Debts> all(){
        return find.where().not(Expr.eq("delete_status", "1")).orderBy("id desc").findList();
    }
    public static List<Debts> finderByFk(Long id){
        return find.where().not(Expr.eq("delete_status", "1")).like("id",String.valueOf(id)).orderBy("id desc").findList();
    }
    public static Debts finderById(long id){
        return find.ref(id);
    }
    public static int total(){
        int num = 0;
        for( Debts i : all() ){
            num += i.amount;
        }
        return num;
    }
    public static Debts findByDebtsname(String name) {
        return find.where().eq("username", name ).findUnique();
    }
    public static Debts findByPhone(String phone) {
        return find.where().eq("phone", phone ).findUnique();
    }
    public static Debts findByEmail(String email) {
        return find.where().eq("email", email ).findUnique();
    }
}

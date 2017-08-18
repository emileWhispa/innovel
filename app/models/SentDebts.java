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
public class SentDebts extends Model {
    @Id
    public long id;
    public String sendto = "";
    public int amount;
    public String motif = "";

    @ManyToOne(cascade = CascadeType.ALL)
    public Users doneby;

    public String date = "";

    public String deleteStatus = "";

    public static Model.Finder<Long, SentDebts> find = new Model.Finder<Long, SentDebts>(Long.class, SentDebts.class);

    public static List<SentDebts> all(){
        return find.where().not(Expr.eq("delete_status", "1")).findList();
    }
    public static SentDebts finderById(long id){
        return find.ref(id);
    }
    public static int total(){
        int num = 0;
        for( SentDebts i : all() ){
            num += i.amount;
        }
        return num;
    }
    public static SentDebts findBySentDebtsname(String name) {
        return find.where().eq("username", name ).findUnique();
    }
    public static SentDebts findByPhone(String phone) {
        return find.where().eq("phone", phone ).findUnique();
    }
    public static SentDebts findByEmail(String email) {
        return find.where().eq("email", email ).findUnique();
    }
}

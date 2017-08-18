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
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * Created by Noel on 6/18/2017.
 */
@Entity
public class Cashout extends Model {
    @Id
    public long id;
    public String sendto = "";
    public int amount;
    public String motif = "";
    public String upload = "";

    @ManyToOne(cascade = CascadeType.ALL)
    public Users doneby;

    public String date = "";

    public String deleteStatus = "";
    private static EntityManager em;

    public static Model.Finder<Long, Cashout> find = new Model.Finder<Long, Cashout>(Long.class, Cashout.class);

    public static List<Cashout> all(){
        return find.where().not(Expr.eq("delete_status", "1")).findList();
    }
    public static Cashout finderById(long id){
        return find.ref(id);
    }
    public static Cashout findByCashoutname(String shout ) {
        return find.where().eq("username", shout ).findUnique();
    }
    public static int total(){
        int num = 0;
        for( Cashout i : all() ){
            num += i.amount;
        }
        return num;
    }
    public static Cashout findByPhone(String phone) {
        return find.where().eq("phone", phone).findUnique();
    }
    public static Cashout findByEmail(String email) {
        return find.where().eq("email", email).findUnique();
    }
}

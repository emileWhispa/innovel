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
public class Payed extends Model {
    @Id
    public long id;
    public int amount;

    @ManyToOne(cascade = CascadeType.ALL)
    public SentDebts sent;

    public String date = "";

    public String deleteStatus = "";

    public static Model.Finder<Long, Payed> find = new Model.Finder<Long, Payed>(Long.class, Payed.class);

    public static List<Payed> all(){
        return find.where().not(Expr.eq("delete_status", "1")).findList();
    }
    public static Payed finderById(long id){
        return find.ref(id);
    }
    public static List<Payed> finderByFk(long id){
        return find.where().like("sent",String.valueOf(id)).findList();
    }
    public static int total(){
        int num = 0;
        for( Payed i : all() ){
            num += i.amount;
        }
        return num;
    }
}

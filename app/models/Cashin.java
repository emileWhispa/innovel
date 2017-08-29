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
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Noel on 6/18/2017.
 */

@Entity
public class Cashin extends Model {
    @Id
    public long id;
    public String fromu = "";
    public int amount;
    public String motif = "";
    public String receipt = "";

    @ManyToOne(cascade = CascadeType.ALL)
    public Users doneby;
    public String receiptCategory = "";
    public String vatCategory = "";
    public String mode = "";
    public String otherInfo = "";

    public String date = "";

    public String deleteStatus = "";

    public static Model.Finder<Long, Cashin> find = new Model.Finder<Long, Cashin>(Long.class, Cashin.class);

    public static List<Cashin> all(){
        return find.where().not(Expr.eq("delete_status", "1")).orderBy("id desc").findList();
    }
    public static Cashin finderById(long id){
        return find.ref(id);
    }
    public static List<Cashin> allUp(){
        return find.where().not(Expr.eq("delete_status", "1")).orderBy("id asc").findList();
    }
    public static int total(){
        int num = 0;
        for( Cashin i : all() ){
            num += i.amount;
        }
        return num;
    }
    public static String asString(int number){
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        String formated = numberFormat.format(number);
        return formated;
    }
    public static String lastId(){
        Long num = null;
        for (Cashin i : allUp() ) {
            num = i.id;
        }
        return String.valueOf(num);
    }
    public static Cashin findByCashinname(String Cashinname) {
        return find.where().eq("username", Cashinname).findUnique();
    }
    public static Cashin findByPhone(String phone) {
        return find.where().eq("phone", phone).findUnique();
    }
    public static Cashin findByEmail(String email) {
        return find.where().eq("email", email).findUnique();
    }
}

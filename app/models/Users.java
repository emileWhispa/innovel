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
public class Users extends Model {
    @Id
    public long id;
    public String firstName = "";
    public String lastName = "";
    public String role = "";
    public String phone = "";
    public String dob = "";
    public String age = "";
    public String email = "";
    public String photo = "";
    public String username = "";
    public String password ="";

    public boolean deleteStatus = false;
    public String deleteReason = "";
    public String doneBy = "";

    public static Model.Finder<Long, Users> find = new Model.Finder<Long, Users>(Long.class, Users.class);

    public static List<Users> all(){
        return find.where().not(Expr.eq("delete_status", "1")).findList();
    }
    public static List<Users> uList(String me,String data ){
        if( data.equals("false") ){
            return find.where().not(Expr.eq("delete_status", "1")).not(Expr.eq("id", me )).findList();
        }else{
            return find.where().not(Expr.eq("delete_status", "1")).not(Expr.eq("id", me )).like("username","%"+data+"%").findList();
        }
    }
    public static List<Users> allD(){
        return find.where().not(Expr.eq("delete_status", "1")).like("role", "Developer").findList();
    }
    public static List<Users> allM(){
        return find.where().not(Expr.eq("delete_status", "1")).like("role", "Manager").findList();
    }
    public static List<Users> allU(){
        return find.where().not(Expr.eq("delete_status", "1")).like("role", "Client").findList();
    }
    public static List<Users> allEx(String u){
        return find.where().not(Expr.eq("delete_status", "1")).not(Expr.eq("id", u)).findList();
    }
    public static List<Users> allben(){
        return find.where().not(Expr.eq("delete_status", "1")).findList();
    }
    public static Users finderById(long id){
        return find.ref(id);
    }
    public static Users findByUsersname(String Usersname) {
        return find.where().eq("username", Usersname).findUnique();
    }
    public static Users findByPhone(String phone) {
        return find.where().eq("phone", phone).findUnique();
    }
    public static Users findByEmail(String email) {
        return find.where().eq("email", email).findUnique();
    }
}

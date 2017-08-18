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
public class Department extends Model {
    @Id
    public Long id;
    public String departmentName = "";
    public String departmentDetails = "";
    public String departmentLogo = "";
    public String delete_status = "";
    public static Model.Finder<Long, Department> find = new Model.Finder<Long, Department>(Long.class, Department.class);
    public static List<Department> all(){
        return find.where().not(Expr.eq("delete_status", "1")).orderBy("id desc").findList();
    }
    public static Department finderById(long id){
        return find.ref(id);
    }
}
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

@Entity
public class Tasks extends Model {
	@Id
	public Long id;
	public String taskName = "";
	public int complete;

    public String deleteStatus = "";

    public static Model.Finder<Long, Tasks> find = new Model.Finder<Long, Tasks>(Long.class, Tasks.class);
    public static List<Tasks> all(){
        return find.where().not(Expr.eq("delete_status", "1")).findList();
    }
    public static List<Tasks> allByCertain(Long id){
        return find.where().not(Expr.eq("delete_status", "1")).orderBy("id='"+id+"' desc").findList();
    }
    public static Tasks finderById(long id){
        return find.ref(id);
    }
}
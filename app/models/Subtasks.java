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
public class Subtasks extends Model {
	@Id
	public Long id;
	public String subName = "";

	public String subDetail = "";
    public int complete = 0;
	public String deleteStatus = "";

	@ManyToOne(cascade = CascadeType.ALL)
    public Tasks task;

    public static Model.Finder<Long, Subtasks> find = new Model.Finder<Long, Subtasks>(Long.class, Subtasks.class);
    public static List<Subtasks> all(){
        return find.where().not(Expr.eq("delete_status", "1")).findList();
    }
    public static List<Subtasks> finderByFk( Long id ){
        return find.where().like("task",String.valueOf(id)).findList();
    }
    public static Subtasks finderById(Long id){
        return find.ref(id);
    }
    public static List<Subtasks> findAll(Long id){
        return find.where().not(Expr.eq("delete_status", "1")).like("task",String.valueOf(id)).findList();
    }
    public static List<Subtasks> findDone(Long id){
        return find.where().not(Expr.eq("delete_status", "1")).like("task",String.valueOf(id)).like("complete","1").findList();
    }
}
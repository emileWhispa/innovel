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
public class Details extends Model {
	@Id
	public Long id;
	public String name = "";
	public String deleteStatus = "";
	public String content = "";

	@ManyToOne(cascade = CascadeType.ALL)
    public Projects project;
    public static Model.Finder<Long, Details> find = new Model.Finder<Long, Details>(Long.class, Details.class);
    public static List<Details> all(){
        return find.where().not(Expr.eq("delete_status", "1")).findList();
    }
    public static List<Details> finderByFk( Long id ){
        return find.where().like("project",String.valueOf(id)).findList();
    }
    public static Details finderById(long id){
        return find.ref(id);
    }
}
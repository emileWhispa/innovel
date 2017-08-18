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
public class Forums extends Model {
	@Id
	public Long id;
	public String forumName = "";
	
	@ManyToOne(cascade = CascadeType.ALL)
    public Users admin;

	public String time = "";
    public String deleteStatus = "";

    public static Model.Finder<Long, Forums> find = new Model.Finder<Long, Forums>(Long.class, Forums.class);
    public static List<Forums> all(){
        return find.where().not(Expr.eq("delete_status", "1")).findList();
    }
    public static Forums finderById(long id){
        return find.ref(id);
    }
}
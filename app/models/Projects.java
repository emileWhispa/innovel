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
public class Projects extends Model {
	@Id
	public Long id;
	public String projectName = "";
	
	@ManyToOne(cascade = CascadeType.ALL)
    public Users developer;

	public String projectLink = "";
	public String projectLogo = "";
	public String deleteStatus = "";
    public int done = 0;

	@ManyToOne(cascade = CascadeType.ALL)
    public Department depart;

    public static Model.Finder<Long, Projects> find = new Model.Finder<Long, Projects>(Long.class, Projects.class);
    public static List<Projects> all(){
        return find.where().not(Expr.eq("delete_status", "1")).orderBy("id desc").findList();
    }
    public static List<Projects> allDone(){
        return find.where().not(Expr.eq("delete_status", "1")).like("done","0").findList();
    }
    public static List<Projects> finderByFk( Long id ){
        return find.where().like("depart",String.valueOf(id)).findList();
    }
    public static List<Projects> finderByFkAndDone( Long id ,int dn){
        return find.where().like("depart",String.valueOf(id)).like("done",String.valueOf(dn)).findList();
    }
    public static Projects finderById(long id){
        return find.ref(id);
    }
}
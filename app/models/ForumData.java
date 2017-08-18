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
public class ForumData extends Model {
	@Id
	public Long id;
	
    public String content = "";

    @ManyToOne(cascade = CascadeType.ALL)
    public Forums forum;

    @ManyToOne(cascade = CascadeType.ALL)
    public Users member;

    public String status = "";
    public String type = "";
	public String date = "";
    public String deleteStatus = "";

    public static Model.Finder<Long, ForumData> find = new Model.Finder<Long, ForumData>(Long.class, ForumData.class);
    public static List<ForumData> all(){
        return find.where().not(Expr.eq("delete_status", "1")).findList();
    }
    public static List<ForumData> finderByFk( long id ){
        return find.where().not(Expr.eq("delete_status", "1")).like("forum_id",String.valueOf(id)).findList();
    }
    public static ForumData finderById(long id){
        return find.ref(id);
    }
}
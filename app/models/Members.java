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
public class Members extends Model {
	@Id
	public Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    public Users member;

    @ManyToOne(cascade = CascadeType.ALL)
    public Forums forum;

	public String date = "";
    public String deleteStatus = "";

    public static Model.Finder<Long, Members> find = new Model.Finder<Long, Members>(Long.class, Members.class);
    public static List<Members> all(){
        return find.where().not(Expr.eq("delete_status", "1")).findList();
    }
    public static List<Members> amIn( String me){
        return find.where().not(Expr.eq("delete_status", "1")).like("member_id",me).findList();
    }
    public static Members finderById(long id){
        return find.ref(id);
    }
}
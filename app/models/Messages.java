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
public class Messages extends Model {
	@Id
	public Long id;
	public String message = "";
	public String deleteStatus = "";
	public String status = "";

	@ManyToOne(cascade = CascadeType.ALL)
    public Users sendto;

    @ManyToOne(cascade = CascadeType.ALL)
    public Users fromu;

    public String type = "";

    public static Model.Finder<Long, Messages> find = new Model.Finder<Long, Messages>(Long.class, Messages.class);
    public static List<Messages> all(){
        return find.where().not(Expr.eq("delete_status", "1")).findList();
    }
    public static List<Messages> finderByFk( Long id , String me ){
        List<Messages> data = find.where("sendto="+String.valueOf(id)+" and fromu="+me+" or fromu="+String.valueOf(id)+" and sendto="+me).findList();
            for ( Messages i : data ) {
                i.status = "read";
                i.update();
            }
        return data;
    }
    public static List<Messages> newMessages( String me ){
        return find.where("sendto='"+me+"' and status='unread' group by fromu").findList();
    }
    public static Messages finderById(long id){
        return find.ref(id);
    }
}
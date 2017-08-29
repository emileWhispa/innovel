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
public class ProjectAssignment extends Model {
	@Id
	public Long id;

	@ManyToOne(cascade = CascadeType.ALL)
    public Projects proj;

    @ManyToOne(cascade = CascadeType.ALL)
    public Tasks task;

    @ManyToOne(cascade = CascadeType.ALL)
    public Subtasks subtask;

    @ManyToOne(cascade = CascadeType.ALL)
    public Users developer;

    public String deleteStatus = "";
    public String status = "";

    public static Model.Finder<Long, ProjectAssignment> find = new Model.Finder<Long, ProjectAssignment>(Long.class, ProjectAssignment.class);
    public static List<ProjectAssignment> all(){
        return find.where().not(Expr.eq("delete_status", "1")).orderBy("id desc").findList();
    }
    public static List<ProjectAssignment> byPro(Long id){
        return find.where().not(Expr.eq("delete_status", "1")).like("proj_id",String.valueOf(id)).orderBy("id desc").findList();
    }
    public static List<ProjectAssignment> finderByFk(Long id,Long pro){
        return find.where().not(Expr.eq("delete_status", "1")).like("task_id",String.valueOf(id)).like("proj_id",String.valueOf(pro)).orderBy("id desc").findList();
    }
    public static List<ProjectAssignment> byDev(Long id){
        return find.where().not(Expr.eq("delete_status", "1")).like("developer_id",String.valueOf(id)).orderBy("id desc").findList();
    }
    public static List<ProjectAssignment> byStatus(String str){
        return find.where().not(Expr.eq("delete_status", "1")).like("status",str).orderBy("id desc").findList();
    }
    public static List<ProjectAssignment> findDone(Long id,Long pro){
        return find.where().not(Expr.eq("delete_status", "1")).like("task_id",String.valueOf(id)).like("status","approved").like("proj_id",String.valueOf(pro)).orderBy("id desc").findList();
    }
    public static int findDoneSum(Long id,Long pro){
        int i = 0;
        for ( ProjectAssignment d : findDone(id,pro) ) {
            i += d.subtask.subMarks;
        }
        return i;
    }
    public static int findAllSum(Long id,Long pro){
        int i = 0;
        for ( ProjectAssignment d : findAll(id,pro) ) {
            i += d.subtask.subMarks;
        }
        return i;
    }
    public static List<ProjectAssignment> findAll(Long id,Long pro){
        return find.where().not(Expr.eq("delete_status", "1")).like("task_id",String.valueOf(id)).like("proj_id",String.valueOf(pro)).orderBy("id desc").findList();
    }
    public static int allNumber(Long sub,Long pro){
        List<ProjectAssignment> a = find.where().not(Expr.eq("delete_status", "1")).like("subtask_id",String.valueOf(sub)).like("proj_id",String.valueOf(pro)).findList();
        return a.size();
    }
    public static ProjectAssignment finderById(long id){
        return find.ref(id);
    }
}
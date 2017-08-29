package controllers;

import play.*;
import play.mvc.*;
import play.data.Form;
import models.*;
import views.html.*;
import java.io.File;
import java.util.Date;
import java.util.List;
import play.libs.Json;
import java.util.Map;

public class Application extends Controller {
    Application(){
        
    }
    public static Result turn(){
        return ok(t.render());
    }
    public static Result cashIn(){
        Users user = Users.finderById(Long.parseLong(session("userId")));
        if( user.role.equals("Manager") ){
            return ok( cashin.render() );
        }else{
            return ok("error");
        }
    }
    public static Result approve(){
        Users user = Users.finderById(Long.parseLong(session("userId")));
        if( user.role.equals("Administrator") ){
            return ok( approve.render(user) );
        }else{
            return ok("error");
        }
    }
    public static Result approver(Long id){
        Users user = Users.finderById(Long.parseLong(session("userId")));
        if( user.role.equals("Administrator") ){
            ProjectAssignment pro = ProjectAssignment.finderById(id);
            pro.status = "approved";
            pro.update();
            return ok("ok");
        }else{
            return ok("error");
        }
    }
    public static Result deny(Long id){
        Users user = Users.finderById(Long.parseLong(session("userId")));
        if( user.role.equals("Administrator") ){
            ProjectAssignment pro = ProjectAssignment.finderById(id);
            pro.status = "denied";
            pro.update();
            return ok("ok");
        }else{
            return ok("error");
        }
    }
    public static Result runMark(Long id){
        Users user = Users.finderById(Long.parseLong(session("userId")));
        if( user.role.equals("Developer") ){
            ProjectAssignment d = ProjectAssignment.finderById(id);
            d.status = "requested";
            d.update();
            return ok( "requested" );
        }else{
            return ok("error");
        }
    }
    public static Result viewMine(){
        Users user = Users.finderById(Long.parseLong(session("userId")));
        if( user.role.equals("Developer") ){
            return ok( viewmine.render(user) );
        }else{
            return ok("error");
        }
    }
    public static Result cashInReport(){
        Users user = Users.finderById(Long.parseLong(session("userId")));
        if( user.role.equals("Manager") ){
            return ok( cashInReport.render() );
        }else{
            return ok("error");
        }
    }
    public static Result cashOutReport(){
        Users user = Users.finderById(Long.parseLong(session("userId")));
        if( user.role.equals("Manager") ){
            return ok( cashOutReport.render() );
        }else{
            return ok("error");
        }
    }
    public static Result balanceDebt(){
        Users user = Users.finderById(Long.parseLong(session("userId")));
        if( user.role.equals("Manager") ){
            return ok( balanceDebt.render() );
        }else{
            return ok("error");
        }
    }
    public static Result coveredReport(){
        Users user = Users.finderById(Long.parseLong(session("userId")));
        if( user.role.equals("Manager") ){
            return ok( coveredReport.render() );
        }else{
            return ok("error");
        }
    }
    public static Result debtReport(){
        Users user = Users.finderById(Long.parseLong(session("userId")));
        if( user.role.equals("Manager") ){
            return ok( debtReport.render() );
        }else{
            return ok("error");
        }
    }
    public static Result cashOut(){
        Users user = Users.finderById(Long.parseLong(session("userId")));
        if( user.role.equals("Manager") ){
            return ok( cashout.render() );
        }else{
            return ok("error");
        }
    }
    public static Result covered(){
        Users user = Users.finderById(Long.parseLong(session("userId")));
        if( user.role.equals("Manager") ){
            return ok( covered.render() );
        }else{
            return ok("error");
        }
    }
    public static Result payed(){
        Users user = Users.finderById(Long.parseLong(session("userId")));
        if( user.role.equals("Manager") ){
            return ok( payed.render() );
        }else{
            return ok("error");
        }
    }
    public static Result sentDebts(){
        Users user = Users.finderById(Long.parseLong(session("userId")));
        if( user.role.equals("Manager") ){
            return ok( sentD.render() );
        }else{
            return ok("error");
        }
    }
    public static Result debts(){
        Users user = Users.finderById(Long.parseLong(session("userId")));
        if( user.role.equals("Manager") ){
            return ok( debts.render() );
        }else{
            return ok("error");
        }
    }
    public static Result receipt(Long id){
        Users user = Users.finderById(Long.parseLong(session("userId")));
        Cashin cash = Cashin.finderById(id);
        if( user.role.equals("Manager") ){
            return ok( receipt.render(cash) );
        }else{
            return ok("error");
        }
    }
    public static Result balance(){
        Users user = Users.finderById(Long.parseLong(session("userId")));
        if( user.role.equals("Manager") ){
            return ok( balance.render() );
        }else{
            return ok("error");
        }
    }
    public static Result index() {
    if( session("userId") != null ){
    	Users user = Users.finderById(Long.parseLong(session("userId")));
        return ok(index.render(user));
    }else{
        Users user = Users.findByUsersname(session("userId"));
        return ok(index.render(user));
    }
    }
    public static Result signup() {
        if( session("admin") != null ){
            Users user = Users.finderById(Long.parseLong(session("admin")));
            return ok(account.render(user.role));
        }else{
            return ok(account.render("user"));
        }
    }
    public static Result arrange() {
        if( session("admin") != null ){
            Users user = Users.finderById(Long.parseLong(session("admin")));
            return ok(arrange.render(user));
        }else{
            return ok("login");
        }
    }
    public static Result interchange(String str) {
        if( session("admin") != null ){
            String string[] = str.split(":");
            String sting = "";
            for( String ix : string ){
                sting +=ix;
                String data[] = ix.split("=");
                Long id = Long.parseLong( data[0] );
                String pos = data[data.length-1];
                Department das = Department.finderById( id );
                das.level = Integer.valueOf( pos );
                das.update();
            }
            return ok(sting);
        }else{
            return ok("login");
        }
    }
    public static Result signout() {
    	session().clear();
    	Users user = Users.findByUsersname(session("userId"));
        return redirect("/");
    }
    public static Result form() {
        return ok(form.render());
    }
    public static Result fetchPro(Long id) {
        List<Projects> detList = Projects.finderByFkAndDone(id,1);
        return ok(Json.toJson(detList));
    }
    public static Result read() {
        if( session("userId") != null ){
            List<Messages> detList = Messages.newMessages(session("userId"));
            return ok(Json.toJson(detList));
        }else{
            return ok("errorX");
        }
    }
    public static Result viewUsers( String name ) {
        if( session("userId") != null ){
            List<Users> detList = Users.uList(session("userId"),name);
            return ok(Json.toJson(detList));
        }else{
            return ok("errorX");
        }
    }
    public static Result updateDep() {
        if(session("admin") != null ){
            Form<Department> userForm = Form.form(Department.class).bindFromRequest();
            Long id = Long.parseLong( userForm.field("id").value() );
            Department dx = userForm.get();
            Department dep = Department.finderById( id );
            dep.departmentName = userForm.field("name").value();
            dep.departmentDetails = userForm.field("details").value();
            String vx = userForm.field("photo").value();
            String img = uploadImage();
            if( !img.equals("logo.png") ) dep.departmentLogo = img;
            dep.update();
            return ok("ok");
        }else{
            return ok("Error Login");
        }
    }
    public static Result updateTask() {
        if(session("admin") != null ){
            Form<Tasks> userForm = Form.form(Tasks.class).bindFromRequest();
            Long id = Long.parseLong( userForm.field("id").value() );
            //Department dx = userForm.get();
            Tasks dep = Tasks.finderById( id );
            dep.taskName = userForm.field("name").value();
            dep.complete = Integer.valueOf(userForm.field("details").value());
            
            dep.update();
            return ok("ok");
        }else{
            return ok("Error Login");
        }
    }
    public static Result updateSub() {
        if(session("admin") != null ){
            Form<Subtasks> userForm = Form.form(Subtasks.class).bindFromRequest();
            Long id = Long.parseLong( userForm.field("id").value() );
            //Subtasks dx = userForm.get();
            Subtasks dep = Subtasks.finderById( id );
            dep.subName = userForm.field("name").value();
            dep.subMarks = Double.valueOf(userForm.field("details").value());
            Long task = Long.parseLong( userForm.field("task").value() );
            dep.task = Tasks.finderById(task);
            
            dep.update();
            return ok("ok");
        }else{
            return ok("Error Login");
        }
    }
    public static Result updateDetails() {
        if(session("admin") != null ){
            Form<Details> userForm = Form.form(Details.class).bindFromRequest();
            Long id = Long.parseLong( userForm.field("id").value() );
            Details dx = userForm.get();
            Details dep = Details.finderById( id );
            dep.content = userForm.field("details").value();
            dep.update();
            return ok("ok");
        }else{
            return ok("Error Login");
        }
    }
    public static Result updateCashin() {
        if(session("userId") != null ){
            Form<Cashin> userForm = Form.form(Cashin.class).bindFromRequest();
            Long id = Long.parseLong( userForm.field("id").value() );
            Cashin dx = userForm.get();
            Cashin dep = Cashin.finderById( id );
            dep.fromu = userForm.field("fromu").value();
            dep.amount = Integer.valueOf(userForm.field("amount").value());
            dep.motif = userForm.field("details").value();
            dep.update();
            return ok("ok");
        }else{
            return ok("Error Login");
        }
    }
    public static Result updateCovered() {
        if(session("userId") != null ){
            Form<Covered> userForm = Form.form(Covered.class).bindFromRequest();
            Long id = Long.parseLong( userForm.field("id").value() );
            Covered dx = userForm.get();
            Covered dep = Covered.finderById( id );
            dep.amount = Integer.valueOf(userForm.field("amount").value());
            dep.update();
            return ok("ok");
        }else{
            return ok("Error Login");
        }
    }
    public static Result updateCashout() {
        if(session("userId") != null ){
            Form<Cashout> userForm = Form.form(Cashout.class).bindFromRequest();
            Long id = Long.parseLong( userForm.field("id").value() );
            Cashout dx = userForm.get();
            Cashout dep = Cashout.finderById( id );
            dep.sendto = userForm.field("sendto").value();
            dep.amount = Integer.valueOf(userForm.field("amount").value());
            dep.motif = userForm.field("details").value();
            dep.update();
            return ok("ok");
        }else{
            return ok("Error Login");
        }
    }
    public static Result updatePro() {
        if(session("admin") != null ){
            Form<Projects> userForm = Form.form(Projects.class).bindFromRequest();
            Long id = Long.parseLong( userForm.field("id").value() );
            Projects dx = userForm.get();
            Projects dep = Projects.finderById( id );
            dep.projectName = userForm.field("name").value();
            String user = userForm.field("dev").value();
            dep.developer = Users.finderById( Long.parseLong(user) );
            String deper = userForm.field("dep").value();
            dep.depart = Department.finderById( Long.parseLong(deper) );
            dep.projectDetails = userForm.field("details").value();
            String img = uploadImage();
            dep.projectLink = userForm.field("link").value();
            if( !img.equals("logo.png") ) dep.projectLogo = img;
            dep.update();
            return ok("ok");
        }else{
            return ok("Error Login");
        }
    }
    public static Result depart() {
        if(session("admin") != null ){
            return ok(departement.render());
        }else
            return ok("Error Login");
    }
    public static Result home() {
        return ok(homepage.render());
    }
    public static Result viewPro(String data ) {
        if(session("admin") != null )
            return ok(projectReg.render(data));
        else
        return ok("Error Log in");
    }

    public static Result tasks() {
        if(session("admin") != null )
            return ok(tasksPage.render());
        else
            return ok("Error Login");
    }
    public static Result messages(Long id) {
        if( session("userId") != null ){
            List<Messages> detList = Messages.finderByFk(id,session("userId"));
            return ok(Json.toJson(detList));
        }else{
            return ok("fail");
        }
    }
    public static Result fMessages(Long id) {
        if( session("userId") != null ){
            List<ForumData> detList = ForumData.finderByFk(id);
            return ok(Json.toJson(detList));
        }else{
            return ok("fail");
        }
    }
    public static Result sendMessage() {
        if( session("userId") != null ){
        Form<Messages> userForm = Form.form(Messages.class).bindFromRequest();
        //Messages dep = userForm.get();
        Messages d = new Messages();
        d.message = userForm.field("text").value();
        d.status = "unread";
        d.type = "text";
        Long send = Long.parseLong( userForm.field("sendto").value() );
        Users sendto = Users.finderById( send );
        d.sendto = sendto;

        Long fromu = Long.parseLong( session("userId") );
        if( send == fromu ){
            return ok("not allowed");
        }else{
        Users froms = Users.finderById( fromu );
        d.fromu = froms;

        d.save();
        return ok(session("userId"));
        }
        }else{
            return ok("fail");
        }
        
    }
    public static Result sendForum() {
        if( session("userId") != null ){
        Form<ForumData> userForm = Form.form(ForumData.class).bindFromRequest();
        //Messages dep = userForm.get();
        ForumData d = new ForumData();
        d.content = userForm.field("text").value();
        d.status = "unread";
        d.type = "text";
        Long frm = Long.parseLong( userForm.field("forum").value() );
        Forums sendto = Forums.finderById( frm );
        d.forum = sendto;

        Long fromu = Long.parseLong( session("userId") );
        
        Users froms = Users.finderById( fromu );
        d.member = froms;

        d.save();
        return ok(session("userId"));
        
        }else{
            return ok("fail");
        }
        
    }
    public static Result regDep() {
        Form<Department> userForm = Form.form(Department.class).bindFromRequest();
        Department dep = userForm.get();
        Department d = new Department();
        d.departmentLogo = uploadImage();
        d.departmentName = userForm.field("depart").value();
        d.departmentDetails = userForm.field("details").value();
        d.save();
        return ok("ok");
    }
    public static Result saveForum() {
        Form<Forums> userForm = Form.form(Forums.class).bindFromRequest();
        Forums dep = userForm.get();
        Forums d = new Forums();
        d.forumName = userForm.field("name").value();
        Long adm = Long.parseLong(session("userId")); 
        d.admin = Users.finderById(adm);
        d.save();
        Long idX = null;
        for ( Forums f : Forums.all() ) {
            idX = f.id;
        }
        addMember( adm , idX );
        return ok(String.valueOf(idX));
    }
    public static Result addTask() {
        Form<Tasks> form = Form.form(Tasks.class).bindFromRequest();
        //Tasks dep = form.get();
        Tasks d = new Tasks();
        d.taskName = form.field("names").value();
        int o = Integer.valueOf(form.field("complete").value());
        d.complete = o;

        d.save();
        return ok("ok");
    }
    public static Result uploadProfile(){
        if( session("userId") != null ){
            Long id = Long.parseLong( session("userId") );
            Users d = Users.finderById(id);
            d.photo = uploadImage();
            d.update(); 
            return ok("ok");
        }else{
            return ok("login");
        }
    }
    public static Result regPro() {
        Form<Projects> userForm = Form.form(Projects.class).bindFromRequest();
        //Projects pro = userForm.get();
        Projects d = new Projects();
        d.projectLogo = uploadImage();
        Map<String, String[]> map = request().body().asFormUrlEncoded();
        String checkedVal = userForm.field("done").value();
        if( checkedVal != null ){
            d.done = Integer.valueOf( checkedVal );
        }
        d.projectName = userForm.field("names").value();
        d.projectLink = userForm.field("link").value();
        d.projectDetails = userForm.field("details").value();
        String userId = userForm.field("developer").value();
        Long user = Long.parseLong(userId);
        d.developer = Users.finderById(user);
        String depa = userForm.field("depart").value();
        Long depart = Long.parseLong(depa);
        d.depart = Department.finderById(depart);
        d.save();
        return ok("ok");
    }
    public static Result details(){
        if(session("admin") != null )
            return ok(details.render());
        else
            return ok("Error Login");
    }
    public static Result myTasks(){
        if(session("admin") != null ){
            Users user = Users.finderById(Long.parseLong(session("userId")));
            return ok(mytasks.render(user));
        }else
            return ok("Error Login");
    }
    public static Result subTasks(){
        if(session("admin") != null ){
            Users user = Users.finderById(Long.parseLong(session("userId")));
            return ok(subtasks.render(user));
        }else
            return ok("Error Login");
    }
    public static Result viewSubtasks(Long id,Long project){
        List<ProjectAssignment> sub = ProjectAssignment.finderByFk(id,project);
        return ok(Json.toJson(sub));
    }
    public static Result updateSubtasks(Long id){
        Subtasks d = Subtasks.finderById(id);
        d.complete = 1;
        d.update();
        return ok("ok");
    }
    public static Result myPro(Long user,String str){
        if( session("userId") != null || !str.equals("0") ){
            String stx = ( session("userId") != null ) ? session("userId") : "0";
            Users userx = Users.finderById(Long.parseLong(stx));
            return ok(assigned.render(userx,str));
        }else{
            return ok("error");
        }
    }
    public static Result assign(){
        if( session("userId") != null ){
            return ok(assign.render());
        }else{
            return ok("Error Login");
        }
    }
    public static Result checker(){
        Form<ProjectAssignment> paperForm = Form.form(ProjectAssignment.class).bindFromRequest();
        ProjectAssignment paper = paperForm.get();

        // get request value from submitted form
        Map<String, String[]> map = request().body().asFormUrlEncoded();
        String[] checkedVal = map.get("check");
        String[] users = map.get("select");

        Long val = null;
        int zero = 0;
        Long idea = Long.parseLong( paperForm.field("project").value() );
        Projects project = Projects.finderById( idea );
        for( String up : users ){
            if( up != "" ){
                val = Long.parseLong( checkedVal[zero] );
                ProjectAssignment p = new ProjectAssignment();
                Subtasks sub = Subtasks.finderById( val );
                p.subtask = sub;
                String gigo = up;
                p.task = sub.task;
                Users u = Users.finderById(Long.valueOf(gigo));
                p.developer = u;
                p.proj = project;
                p.status = "pending";
                if( ProjectAssignment.allNumber(val,idea) <= 0 ){
                    p.save();
                }
            zero++;
            }
        }
        return redirect("/");
    }
    public static Result update(Long id,String var){
        if( session("userId") != null ){
            if( var.equals("dep")){
                Department dep = Department.finderById(id);
                return ok(updateDep.render(dep));
            }else if( var.equals("pro") ){
                Projects dep = Projects.finderById(id);
                return ok(updatePro.render(dep));
            }else if( var.equals("cashin") ){
                Cashin dep = Cashin.finderById(id);
                return ok(updateCashin.render(dep));
            }else if( var.equals("cashout") ){
                Cashout dep = Cashout.finderById(id);
                return ok(updateCashout.render(dep));
            }else if( var.equals("debt") ){
                Debts deb = Debts.finderById(id);
                return ok(updateDebt.render(deb));
            }else if( var.equals("cover") ){
                Covered deb = Covered.finderById(id);
                return ok(updateCover.render(deb));
            }else if( var.equals("assign") ){
                Projects deb = Projects.finderById(id);
                return ok(proAssign.render(deb));
            }else if( var.equals("det") ){
                Details deb = Details.finderById(id);
                return ok(updateDetails.render(deb));
            }else if( var.equals("sub") ){
                Subtasks deb = Subtasks.finderById(id);
                return ok(updateSub.render(deb));
            }else if( var.equals("tasks") ){
                Tasks deb = Tasks.finderById(id);
                return ok(updateTask.render(deb));
            }else{
                return ok("ok");
            }
        }else{
            return ok("Error Login");
        }
    }
    public static Result assignPro(){
        if( session("userId") != null ){
            Form<Owned> userForm = Form.form(Owned.class).bindFromRequest();
            Owned d = new Owned();
            String owner = userForm.field("user").value();
            d.owner = Users.finderById( Long.parseLong( owner ) );
            String pro = userForm.field("pro").value();
            d.project = Projects.finderById( Long.parseLong( pro ) );
            if( Owned.check(owner,pro) <= 0 ){
                d.save();
            }
            return ok("ok");
        }else{
            return ok("Error Login");
        }
    }
    public static Result delete(Long id, String var){
        if( session("userId") != null ){
        if( var.equals("dep") ){
            Department ds = Department.finderById(id);
            ds.delete_status = "1";
            ds.update();
        }else if( var.equals("proj") ){
            Projects ds = Projects.finderById(id);
            ds.deleteStatus = "1";
            ds.update();
        }else if( var.equals("tasks") ){
            Tasks ds = Tasks.finderById(id);
            ds.deleteStatus = "1";
            ds.update();
        }else if( var.equals("det") ){
            Details ds = Details.finderById(id);
            ds.deleteStatus = "1";
            ds.update();
        }else if( var.equals("cashin") ){
            Cashin ds = Cashin.finderById(id);
            ds.deleteStatus = "1";
            ds.update();
        }else if( var.equals("cashout") ){
            Cashout ds = Cashout.finderById(id);
            ds.deleteStatus = "1";
            ds.update();
        }else if( var.equals("debt") ){
            Debts ds = Debts.finderById(id);
            ds.deleteStatus = "1";
            ds.update();
        }else if( var.equals("cover") ){
            Covered ds = Covered.finderById(id);
            ds.deleteStatus = "1";
            ds.update();
        }else if( var.equals("sub") ){
            Subtasks ds = Subtasks.finderById(id);
            ds.deleteStatus = "1";
            ds.update();
        }
    }
        return ok("ok");
    }
    public static Result regsubTasks(){
        if(session("admin") != null ){
             Form<Subtasks> userForm = Form.form(Subtasks.class).bindFromRequest();
             //Projects pro = userForm.get();
             Subtasks d = new Subtasks();
             d.subName = userForm.field("names").value();
             d.subMarks = Double.valueOf( userForm.field("content").value() );
             Long task = Long.parseLong( userForm.field("task").value() );
             d.task = Tasks.finderById( task );
             d.save();
            return ok("ok");
        }else
            return ok("Error Login");
    }
    public static Result inDetails(Long id){
        List<Details> detList = Details.finderByFk(id);
        return ok(Json.toJson(detList));
    }
    public static Result regDetails(){
        Form<Details> uForm = Form.form(Details.class).bindFromRequest();
        //Details pro = uForm.get();
        Details det = new Details();
        det.content = uForm.field("content").value();
        String proj = uForm.field("project").value();
        Long project = Long.parseLong(proj);
        det.project = Projects.finderById(project);
        det.save();
        return ok("ok");
    }
    public static Result contact(Long id){
        if( session("userId") == null ){
            session("clear",String.valueOf(id));
            return ok("ok");
        }else{
            List<Users> detList = Users.allEx(session("userId"));
            return ok(Json.toJson(detList));
        }
    }
    public static Result viewForums(){
        if( session("userId") == null ){
            return ok("ok");
        }else{
            List<Members> detList = Members.amIn(session("userId"));
            return ok(Json.toJson(detList));
        }
    }
    public static Result addMember(Long id,Long forum){
        if( session("userId") == null ){
            session("clear",String.valueOf(id));
            return ok("error");
        }else{
            Members m = new Members();
            m.forum = Forums.finderById(forum);
            m.member = Users.finderById( id );
            m.save();
            return ok("ok");
        }
    }
    private static String uploadImage(){
        Http.MultipartFormData body = request().body().asMultipartFormData();
        Http.MultipartFormData.FilePart picture = body.getFile("photo");
        if (picture != null) {
            String fileName = picture.getFilename();
            String contentType = picture.getContentType();
            File file = picture.getFile();
            String text=(new Date().getTime())+ fileName;
            file.renameTo(new File("public/upload",text));

            return text;
        } else {
            flash("error", "Missing file");
            return "logo.png";
        }
    }
    public static Result saveTransaction() {
        Form<Cashin> userForm = Form.form(Cashin.class).bindFromRequest();
        Cashin cash = new Cashin();
        cash.fromu = userForm.field("fromu").value();
        cash.amount = Integer.valueOf(userForm.field("amount").value());
        cash.motif = userForm.field("motif").value();
        Users userX = Users.finderById(Long.parseLong(userForm.field("done").value()));
        cash.receipt = 0+Cashin.lastId()+userX.username.substring(0, 1)+userX.firstName.substring(0, 1)+"2017";
        cash.doneby = userX;
        cash.mode = userForm.field("mode").value();
        cash.otherInfo = userForm.field("other").value();
        cash.receiptCategory = userForm.field("receipt_category").value();
        cash.vatCategory = userForm.field("vat_category").value();
        cash.date = userForm.field("date").value();
        cash.deleteStatus = "0";
        cash.save();
        return ok("ok");
    }
    public static Result saveOut() {
        Form<Cashout> userForm = Form.form(Cashout.class).bindFromRequest();
        Cashout cash = new Cashout();
        cash.sendto = userForm.field("sendto").value();
        cash.amount = Integer.valueOf(userForm.field("amount").value());
        cash.motif = userForm.field("motif").value();
        cash.upload = userForm.field("receipt").value();
        Users userX = Users.finderById(Long.parseLong(userForm.field("done").value()));
        cash.doneby = userX;
        cash.date = userForm.field("date").value();
        cash.deleteStatus = "0";
        cash.save();
        return ok("ok");
    }
    public static Result coverDebt() {
        Form<Covered> userForm = Form.form(Covered.class).bindFromRequest();
        Covered cash = new Covered();
        cash.amount = Integer.valueOf(userForm.field("amount").value());
        Debts deb = Debts.finderById(Long.parseLong(userForm.field("debt").value()));
        cash.debt = deb;
        cash.date = userForm.field("date").value();
        cash.deleteStatus = "0";
        cash.save();
        return ok("ok");
    }
    public static Result savePayed() {
        Form<Payed> userForm = Form.form(Payed.class).bindFromRequest();
        Payed cash = new Payed();
        cash.amount = Integer.valueOf(userForm.field("amount").value());
        SentDebts deb = SentDebts.finderById(Long.parseLong(userForm.field("debt").value()));
        cash.sent = deb;
        cash.date = userForm.field("date").value();
        cash.deleteStatus = "0";
        cash.save();
        return ok("ok");
    }
    public static Result saveDebts() {
        Form<Debts> userForm = Form.form(Debts.class).bindFromRequest();
        Debts cash = new Debts();
        cash.fromu = userForm.field("fromu").value();
        cash.amount = Integer.valueOf(userForm.field("amount").value());
        cash.motif = userForm.field("motif").value();
        Users userX = Users.finderById(Long.parseLong(userForm.field("done").value()));
        cash.doneby = userX;
        cash.date = userForm.field("date").value();
        cash.deleteStatus = "0";
        cash.save();
        return ok("ok");
    }
    public static Result saveSent() {
        Form<SentDebts> userForm = Form.form(SentDebts.class).bindFromRequest();
        SentDebts cash = new SentDebts();
        cash.sendto = userForm.field("sendto").value();
        cash.amount = Integer.valueOf(userForm.field("amount").value());
        cash.motif = userForm.field("motif").value();
        Users userX = Users.finderById(Long.parseLong(userForm.field("done").value()));
        cash.doneby = userX;
        cash.date = userForm.field("date").value();
        cash.deleteStatus = "0";
        cash.save();
        return ok("ok");
    }
    public static Result regUser() {
     if( session("admin") != null ){
        Form<Users> userForm = Form.form(Users.class).bindFromRequest();
        Users user = new Users();
        user.username = userForm.field("username").value();
        user.firstName = userForm.field("firstname").value();
        user.lastName = userForm.field("lastname").value();
        user.dob = userForm.field("day").value()+"/" +userForm.field("month").value()+"/"+userForm.field("year").value();
        user.role = userForm.field("utype").value();
        user.password = userForm.field("password").value();
        user.save();
     }
        return ok("ok");
    }
    public static Result selfReg() {
        Form<Users> userForm = Form.form(Users.class).bindFromRequest();
        Users user = new Users();
        user.username = userForm.field("username").value();
        user.firstName = userForm.field("firstname").value();
        user.lastName = userForm.field("lastname").value();
        user.dob = userForm.field("day").value()+"/" +userForm.field("month").value()+"/"+userForm.field("year").value();
        user.role = "Client";
        user.password = userForm.field("password").value();
        user.save();
        Long idX = null;
        for ( Users f : Users.all() ) {
            idX = f.id;
        }
        session("userId",String.valueOf(idX));
        return ok("ok");
    }
    public static Result signin() {
        Form<Users> userForm = Form.form(Users.class).bindFromRequest();
        Users user = userForm.get();
        boolean Auth = false;
        boolean adm = false;
        String us = null;
        session().clear();
        for (Users u : Users.find.where().like("username", user.username).findList()){
            if (u.password.equals(user.password)){
                Auth = true;
                us = String.valueOf( u.id );
                if(u.role.equals("Administrator"))
                	adm = true;
            }
        }
        if (Auth){
            System.out.println("---------------- \n user log in in successfully!");
            session("userId", us);
            if( adm ) session("admin",us);
            return ok("ok");
        }else {
            return ok("error");
        }
    }

}

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
        return ok(account.render());
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
    public static Result depart() {
        if(session("admin") != null )
            return ok(departement.render());
        else
            return ok("Error Login");
    }
    public static Result home() {
        return ok(homepage.render());
    }
    public static Result viewPro() {
        if(session("admin") != null )
            return ok(projectReg.render());
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
        Long ow = Long.parseLong(form.field("owner").value());
        d.owner = Users.finderById(ow);

        Long pro = Long.parseLong(form.field("project").value());
        d.proj = Projects.finderById(pro);
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
    public static Result viewSubtasks(Long id){
        List<Subtasks> sub = Subtasks.finderByFk(id);
        return ok(Json.toJson(sub));
    }
    public static Result updateSubtasks(Long id){
        Subtasks d = Subtasks.finderById(id);
        d.complete = 1;
        d.update();
        return ok("ok");
    }
    public static Result myPro(Long user){
        if( session("userId") != null ){
            Users userx = Users.finderById(Long.parseLong(session("userId")));
            return ok(assigned.render(userx));
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
    public static Result update(Long id,String var){
        if( session("userId") != null ){
            if( var.equals("dep")){
                Department dep = Department.finderById(id);
                return ok(updateDep.render(dep));
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
            d.owner = Users.finderById( Long.parseLong( userForm.field("user").value() ) );
            d.project = Projects.finderById( Long.parseLong( userForm.field("pro").value() ) );
            d.save();
            return ok("ok");
        }else{
            return ok("Error Login");
        }
    }
    public static Result delete(Long id, String var){
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
        }
        return ok("ok");
    }
    public static Result regsubTasks(){
        if(session("admin") != null ){
             Form<Subtasks> userForm = Form.form(Subtasks.class).bindFromRequest();
             //Projects pro = userForm.get();
             Subtasks d = new Subtasks();
             d.subName = userForm.field("names").value();
             d.subDetail = userForm.field("content").value();
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
        det.name = uForm.field("names").value();
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
        cash.receipt = userForm.field("receipt").value();
        Users userX = Users.finderById(Long.parseLong(userForm.field("done").value()));
        cash.doneby = userX;
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
        Form<Users> userForm = Form.form(Users.class).bindFromRequest();
        Users user = new Users();
        user.username = userForm.field("username").value();
        user.firstName = userForm.field("firstname").value();
        user.lastName = userForm.field("lastname").value();
        user.dob = userForm.field("day").value()+"/" +userForm.field("month").value()+"/"+userForm.field("year").value();
        user.role = userForm.field("utype").value();
        user.password = userForm.field("password").value();
        user.save();
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
            if( adm ) session("admin",user.username);
            return ok("ok");
        }else {
            return ok("error");
        }
    }

}

package models;

import java.util.Date;

import java.io.File;
import java.util.Date;
import java.util.List;
import play.libs.Json;
import java.util.Map;
import views.html.*;
import play.*;
import play.mvc.*;
import play.data.Form;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @author codemiles.
 *
 */
public class Native extends Controller {
    public static EntityManager entityManager;

    /**
     * @param args
     */
    public void insertTopic(){
    EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("persistenceUnitName");
    entityManager = factory.createEntityManager();
    entityManager.getTransaction().begin();
    insertTopic(1,"Ree",new Date());
    entityManager.getTransaction().commit();
    entityManager.close();
    factory.close();

    }
 
    /**
     * @param id
     *   id of the new topic.
     * @param title
     *   title of the new topic.
     * @param creationDate
     *   creation date of the topic.
     */
    public void insertTopic(int id,String title,Date creationDate){
    Query query = entityManager.createNativeQuery("INSERT INTO topic (ID, TITLE,CREATION_DATE) " +
            " VALUES(?,?,?)");
        query.setParameter(1, id);
        query.setParameter(2, title);
        query.setParameter(3, creationDate);
        query.executeUpdate();
    }
    public static List select(String queryGivenIn ){
        List selected = entityManager.createNativeQuery("SELECT users.*  FROM Department WHERE users.id='2'").getResultList();
        return selected;
    }
    public static boolean sendSMS() throws IOException{
        String getphone = "250726703568";
        String sms = "Dear student freind your seat No is:  Don't miss out!";

        
        if (!getphone.equals("")){
            String url = "http://121.241.242.114:8080/bulksms/bulksms?username="+ URLEncoder.encode("umur-innovel")+"&password="+ URLEncoder.encode("123456")+"&type=0&dlr=1&destination="+getphone+"&source=AUCA&message="+URLEncoder.encode(sms);

            org.apache.http.client.HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(url);

            // add request header
            request.addHeader("User-Agent", USER_AGENT);

            HttpResponse response = client.execute(request);

            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " +
                    response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            System.out.println(result.toString());
    }
    return true;
}

}

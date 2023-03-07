package assignment;

import com.api.commonVariables.GlobalVars;
import com.api.apis.API_Methods;
import com.api.utilities.ConfigFileReader;
import com.api.utilities.DataFileReader;
import io.restassured.path.json.JsonPath;
import org.apache.logging.log4j.*;
import org.testng.annotations.Test;


import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Assignment2 extends GlobalVars {
    DataFileReader testDataReader = new DataFileReader("TC_01_TestData");
    ConfigFileReader configFileReader = new ConfigFileReader();
    API_Methods api_methods = new API_Methods();
   private static Logger logger = LogManager.getLogger(Assignment2.class.getName());
        @Test
        public void data(){
            //System.out.println(System.getProperty("user.dir"));
           // System.out.println(testDataReader.getId());
           // System.out.println(testDataReader.getTCName());
           // System.out.println("Todays Date = "+timeStamp);
           // System.out.println("Assignment 2");
           // logger.info("Logger successfull implemented");
            //logger.info("Good job Logger successfull");
            //logger.info("Better job Logger successfull");
            //Payload.createNewPost("abc","");
           // JSONObject user = PayloadReader.createNewUser();
           // System.out.println(user);
            System.out.println(configFileReader.getBaseURI());
        }

        @Test
        public void taskA(){
            JsonPath jsonPath = api_methods.getAllPosts(configFileReader.getBaseURI(),endPoints.getPostEndPoint());
            
           /* String title =  jsonPath.getString("title");
            String[] titles = PageLevelMethods.splitString(title);*/
            List title =  jsonPath.getList("title");
            for(int i=0;i<title.size();i++)
            {
                System.out.println("titles["+i+"] = "+title.get(i));
            }

            List id =  jsonPath.getList("id");
            for(int i=0;i<id.size();i++)
            {
                System.out.println("id["+i+"] = "+id.get(i));
            }

            List body =  jsonPath.getList("body");
            for(int i=0;i<body.size();i++)
            {
                System.out.println("body["+i+"] = "+body.get(i));
            }
            /*String id =  jsonPath.getString("id");
            String[] ids = PageLevelMethods.splitString(id);

            String body =  jsonPath.getString("body");
            String[] bodys = PageLevelMethods.splitString(body);*/

            Dictionary dictionary = new Hashtable();

            for(int i=0;i<title.size();i++) {
                System.out.println("Title["+i+"] = "+title.get(i));
                System.out.println("Body["+i+"] = "+body.get(i));
                dictionary.put(title.get(i),body.get(i));}

            String data = API_Methods.fetchDataUsingID(testDataReader.getId());
            System.out.println("Data fetched using id = testDataReader.getId() "+data);
    }

    @Test
    public void taskB(){
        JsonPath jsonPath = api_methods.getAllPosts(configFileReader.getBaseURI(), endPoints.getUserEndPoint());
        
        String name =  jsonPath.getString("name");
        System.out.println(name);
        String email =  jsonPath.getString("email");
        System.out.println(email);
        String address =  jsonPath.getString("address");
        System.out.println(address);
        String phone =  jsonPath.getString("phone");
        System.out.println(phone);

        String emailData = API_Methods.fetchDataUsingEmail(testDataReader.getEmail());
        System.out.println("Data fetched using email = "+emailData);

    }

    @Test
    public void taskC(){
        JsonPath jsonPath = api_methods.createNewPost(configFileReader.getBaseURI(),endPoints.getPostEndPoint(),testDataReader.getTitle(),testDataReader.getBody());

        String id = jsonPath.getString("id");
        System.out.println("id = "+id);

        String res = API_Methods.fetchDataUsingID(Integer.parseInt(id));
        System.out.println(res);
    }

    @Test
    public void taskD(){
        JsonPath jsonPath =  API_Methods.updatePost(configFileReader.getBaseURI(),endPoints.getPostEndPoint(),testDataReader.getId(),testDataReader.getUserId(),testDataReader.getUpdatedTitle(),testDataReader.getBody());

        int id =  jsonPath.getInt("id");
        System.out.println("Id = " +id);

        String res = API_Methods.fetchDataUsingID(id);
        System.out.println("Put Response using id = "+res);

        String title = jsonPath.getString("title");
        String body = jsonPath.getString("body");
        Dictionary dictionary = new Hashtable();
        dictionary.put(title,body);
    }
}

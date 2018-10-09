package sample;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIConnection {
    private String ConnectionKey;
    private static final String BASE_PATH="http://api.openweathermap.org/data/2.5/weather?q=";
    private String Path;

    public String getPath(){
        return Path;
    }

    public APIConnection(String key){
        ConnectionKey = key;
    }
    public void FormRequestQuery(String City, String Country) {
        Path =  BASE_PATH+City+','+Country + "&APPID=" + ConnectionKey;
    }
    public void FormRequestQuery(String query){
        Path = BASE_PATH+query + "&APPID=" + ConnectionKey;

    }
    public Response SendRequest() throws IOException {
        //Send GET request
        //int status;
        URL query = new URL(Path);
        HttpURLConnection connection = (HttpURLConnection) query.openConnection();
        connection.setRequestMethod("GET");
        StringBuffer content = new StringBuffer();
        ///status = connection.getResponseCode();
       try( BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))) {
           String inputLine;
           while ((inputLine = in.readLine()) != null) {
               content.append(inputLine);
           }

       }finally {
           connection.disconnect();
       }
       return mapper.readValue(content.toString(), Response.class);
    }
    private static final ObjectMapper mapper = new ObjectMapper();
}

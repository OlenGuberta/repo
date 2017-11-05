import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class Api {
    public static void main(String[] args) throws Exception {

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://jsonblob.com/api/jsonBlob/537a43bfe4b047fa2ef5f15d");
        request.addHeader("accept", "application/json");
        HttpResponse response = client.execute(request);

        String json = EntityUtils.toString(response.getEntity());
        System.out.println("response is: "+json);
        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            System.out.println("the id is {}" + object.getInt("id"));
            System.out.println("the insertDate is {}"+ object.getString("insertDate"));
            System.out.println("read is {}"+ object.getBoolean("read"));
            System.out.println("the site is {}"+ object.getString("site"));
            System.out.println("the Email is {}"+ object.getString("Email"));
            System.out.println("the location is {}"+ object.getString("location"));
        }
    }
}


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class Api {
    public static void main(String[] args) throws Exception {

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://jsonplaceholder.typicode.com/posts");
        request.addHeader("accept", "application/json");
        HttpResponse response = client.execute(request);

        String json = EntityUtils.toString(response.getEntity());

        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            System.out.println("the title" + object.get("title"));

        }
///////////////////////////post//////////////////////////////////////
        StringEntity requestEntity = new StringEntity(
                "some json?",
                ContentType.APPLICATION_ATOM_XML.APPLICATION_JSON);

        HttpPost postMethod = new HttpPost("http://example.com/action");
        postMethod.setEntity(requestEntity);

        HttpResponse rawResponse = client.execute(postMethod);

    }
}


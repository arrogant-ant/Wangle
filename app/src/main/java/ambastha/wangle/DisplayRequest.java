package ambastha.wangle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayRequest extends AppCompatActivity {

    String json;
    JSONObject jsonObject;
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_request);
        json = getIntent().getExtras().toString();
        try {
            jsonObject = new JSONObject(json);
            jsonArray = jsonObject.getJSONArray("Array name");
            int count = 0;
            JSONObject j;
            String siteManager, resType, resNo;
            while (count < jsonArray.length()) {
                j = jsonArray.getJSONObject(count);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

package ambastha.wangle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplayRequest extends AppCompatActivity {

    String json;
    JSONObject jsonObject;
    JSONArray jsonArray;
    RequestAdapter rAdapter;
    ListView listview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listview = (ListView) findViewById(R.id.listView);
        setContentView(R.layout.activity_display_request);
        rAdapter = new RequestAdapter(this, R.layout.row_layout);
        listview.setAdapter(rAdapter);
        json = getIntent().getExtras().toString();
        try {
            jsonObject = new JSONObject(json);
            jsonArray = jsonObject.getJSONArray("Array name");
            int count = 0;
            JSONObject j;
            String siteManager, resType, resNo;
            while (count < jsonArray.length()) {
                j = jsonArray.getJSONObject(count);
                siteManager = j.getString("name");
                resType = j.getString("resType");
                resNo = j.getString("resNo");
                Request request = new Request(siteManager, resType, resNo);
                rAdapter.add(request);
                count++;
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

package ambastha.wangle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DisplayRequest extends AppCompatActivity {

    String json;
    JSONObject jsonObject;
    JSONArray jsonArray;
    RequestAdapter rAdapter;
    ListView listview;
    List<Request> list = new ArrayList<Request>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listview = (ListView) findViewById(R.id.listView);
        setContentView(R.layout.activity_display_request);
        Log.d("check 1", "adapter");


        Log.d("check 2", "adapter");
        json = getIntent().getExtras().toString();
        try {
            jsonObject = new JSONObject(json);
            jsonArray = jsonObject.getJSONArray("server_response");
            int count = 0;
            JSONObject j;
            String siteManager, resType, resNo;
            while (count < jsonArray.length()) {
                j = jsonArray.getJSONObject(count);
                siteManager = j.getString("empid");
                resType = j.getString("password");
                resNo = j.getString("emailid");
                Request request = new Request(siteManager, resType, resNo);
                list.add(request);
                count++;
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        rAdapter = new RequestAdapter(getApplicationContext(), R.layout.row_layout, list);
        listview.setAdapter(rAdapter);
    }
}

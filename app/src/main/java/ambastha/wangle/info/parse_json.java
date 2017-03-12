package ambastha.wangle.info;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import ambastha.wangle.R;

/**
 * Created by shubham on 3/11/2017.
 */

public class parse_json extends Activity {
String showinformat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parse_json);

        new Getjason().execute();
        show_jason();

    }
    class Getjason extends AsyncTask<String,String,String>
    {
        String json_string;
       String json_url;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            json_url="http://www.wangle.16mb.com/try.php";

        }

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url=new URL(json_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
                InputStream is=httpURLConnection.getInputStream();
                BufferedReader bf=new BufferedReader(new InputStreamReader(is));
                StringBuilder sb=new StringBuilder();
                while((json_string=bf.readLine())!=null)
                {
                 sb.append(json_string+"\n");

                }
               bf.close();
                is.close();
                httpURLConnection.disconnect();
                return sb.toString().trim();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
           return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            TextView tv=(TextView)findViewById(R.id.textjason);
            tv.setText(s);
            showinformat=s;

        }
    }
    public void show_jason()
    {
      if(showinformat==null)
        {
            Toast.makeText(this,"no json",Toast.LENGTH_LONG);
        }
        else
      {
          JSONObject jsonObject;
          JSONArray jsonArray;
          ListView lv=(ListView)findViewById(R.id.list_view);
          parse_adapter ps=new parse_adapter(this,R.layout.individual_layout);

          lv.setAdapter(ps);

          try {
              jsonObject=new JSONObject(showinformat);
             jsonArray =jsonObject.getJSONArray("server_response");
              int count=0;
              String empid,emailid,phone_no,password;
              while(count<jsonArray.length())
              {
                  JSONObject jo=jsonArray.getJSONObject(count);
                  empid=jo.getString("empid");
                  password=jo.getString("password");
                  emailid=jo.getString("emailid");
                  phone_no=jo.getString("phone_no");
                Information information=new Information(empid,password,emailid,phone_no);
                  ps.add(information);

                  count++;


              }

          } catch (JSONException e) {
              e.printStackTrace();
          }

      }

    }


}

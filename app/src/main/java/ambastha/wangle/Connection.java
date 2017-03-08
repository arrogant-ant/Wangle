package ambastha.wangle;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Connection extends AppCompatActivity {

    private TextView connectText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);
        Button connect = (Button)findViewById(R.id.connect);
       connectText = (TextView)findViewById(R.id.connectText);

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JSONTask().execute("http://wangle.16mb.com/demo.php");
            }
        });

    }
    public class JSONTask extends AsyncTask<String,String,String>
    {

        @Override
        protected String doInBackground(String... params) {

                HttpURLConnection connection =null;
                BufferedReader reader=null;
                URL url = null;
                try {
                    url = new URL(params[0]);
                    connection=(HttpURLConnection)url.openConnection();
                    connection.connect();

                    InputStream stream = connection.getInputStream();
                    reader= new BufferedReader(new InputStreamReader(stream));
                    String line="";
                    StringBuffer buffer= new StringBuffer();
                    while((line=reader.readLine())!=null)
                    {
                        buffer.append(line);
                    }
                    return  buffer.toString();


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(connection!=null  )
                        connection.disconnect();
                    try {
                        if(reader!=null)
                            reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            connectText.setText(result);
        }
    }

}


package ambastha.wangle;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by shubham on 3/8/2017.
 */

public class BackgroundTask extends AsyncTask<String,String,String> {
    Context ctx;
    AlertDialog alertDialog;
    String method;

    BackgroundTask(Context ctx) {
        ctx = this.ctx;


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
       alertDialog= new AlertDialog.Builder(ctx).create();
        alertDialog.setTitle("Login Info");
    }

    @Override
    protected String doInBackground(String... params) {

        Log.d("check 3", "login: ");
        HttpURLConnection connection = null;
        String loginURL = "http://wangle.16mb.com/login.php";
        method = params[0];
        if (method.equals("Login")) {
            Log.d("check 4", "login: ");
            String empId = params[1];
            String pass = params[2];
            try {

                URL url = new URL(loginURL);

                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setDoOutput(true);
                connection.setDoInput(true);
                connection.connect();

                // writing to the server

                OutputStream outputStream = connection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("empID", "UTF-8") + "=" + URLEncoder.encode(empId, "UTF-8") + "&" + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                // reading from the server

                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                StringBuffer buffer = new StringBuffer();
                while ((line = bufferedReader.readLine()) != null) {
                    buffer.append(line);
                }
                bufferedReader.close();
                inputStream.close();
                connection.disconnect();
                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;


    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        //if (method.equals("Login")) {
           alertDialog.setMessage(result);
           // Toast.makeText(this.ctx,result,Toast.LENGTH_LONG).show();

        //}
    }
}


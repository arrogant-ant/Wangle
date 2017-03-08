package ambastha.wangle;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by shubham on 3/8/2017.
 */

public class BackGroundTask extends AsyncTask<String,String,String>{
   Context ctx;
    BackGroundTask(Context ctx)
    {
     ctx=this.ctx;


    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}

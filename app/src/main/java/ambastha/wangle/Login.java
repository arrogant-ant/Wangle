package ambastha.wangle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Sabita_Sant on 09/03/17.
 */

public class Login extends AppCompatActivity {

    String loginID, loginPass;
    EditText empID , pass;
    String JSON, status;
    TextView res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        empID=(EditText)findViewById(R.id.empID);
        pass=(EditText)findViewById(R.id.password);
        res= (TextView)findViewById(R.id.result);
    }

    public void logIn(View view) {
        Log.d("check 1", "login: ");
        Toast.makeText(this,"button clicked",Toast.LENGTH_LONG).show();
        loginID= empID.getText().toString();
        loginPass=pass.getText().toString();
        String method="Login";
        Log.d("check 1.5", "login: ");
        BackgroundTask backgroundTask= new BackgroundTask(this,this);
        backgroundTask.execute(method,loginID,loginPass);
        checkLogin();
        Log.d("check 2", "login: ");
    }

    public void parseJSON() {
        if (JSON == null) {
            Toast.makeText(this, "NO data received", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(getApplicationContext(), DisplayRequest.class);
            intent.putExtra("json_data", JSON);
            startActivity(intent);
        }
    }

    public void checkLogin() {
        if (JSON == null) {
            Toast.makeText(this, "NO data received", Toast.LENGTH_LONG).show();
        } else {
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(JSON);
                // JSONArray jsonArray = jsonObject.getJSONArray("Array name");
                //JSONObject j = jsonArray.getJSONObject(0);
                if (jsonObject.getString("status").equals("successful")) {
                    if (jsonObject.get("is_admin").equals("true"))
                        res.setText("hey pc");

                    else
                        res.setText("hey site manager");
                } else
                    res.setText("login failed");
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }



}

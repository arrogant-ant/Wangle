package ambastha.wangle;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Sabita_Sant on 09/03/17.
 */

public class Login extends AppCompatActivity {

    String loginID, loginPass;
    EditText empID , pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        empID=(EditText)findViewById(R.id.empID);
        pass=(EditText)findViewById(R.id.password);

    }

    public void logIn(View view) {
        Log.d("check 1", "login: ");
        Toast.makeText(this,"button clicked",Toast.LENGTH_LONG).show();
        loginID= empID.getText().toString();
        loginPass=pass.getText().toString();
        String method="Login";
        BackgroundTask backgroundTask= new BackgroundTask(this);
        backgroundTask.execute(method,loginID,loginPass);
        Log.d("check 2", "login: ");
    }
}

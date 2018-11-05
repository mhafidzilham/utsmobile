package id.ac.poltek.mhafidzilham.uts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class ActivityLogin extends AppCompatActivity {
    AlertDialogManager alert = new AlertDialogManager();
    SessionManagement session;
    Button btnLogout, btnDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionManagement(getApplicationContext());
        TextView tvUsername = (TextView) findViewById(R.id.tvUsername);
        btnDatabase = (Button) findViewById(R.id.buttonDatabase);
        btnLogout = (Button) findViewById(R.id.buttonLogout);
        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();

        session.checkLogin();

        HashMap<String, String> user = session.getUserDetails();
        String username = user.get(SessionManagement.KEY_USERNAME);

        tvUsername.setText("Selamat Datang, " + username);

        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                session.logoutUser();
                Intent i = new Intent(ActivityLogin.this, MainActivity.class);
                startActivity(i);
            }
        });

        btnDatabase.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(ActivityLogin.this, DBActivity.class);
                startActivity(i);
            }
        });
    }

}
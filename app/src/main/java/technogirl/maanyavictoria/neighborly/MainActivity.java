package technogirl.maanyavictoria.neighborly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void login_activity(View view) {
        //Starts a new activity where the user can login
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void register_acitivity(View view) {
        //Starts a new activity where the user can register
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}

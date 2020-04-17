package technogirl.maanyavictoria.neighborly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    Button btn_login;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //creates a method for when the button is clicked
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString(); //gets the password and username from the textbox

                if(TextUtils.isEmpty(txt_email)|| TextUtils.isEmpty(txt_password)){ //verifies that all boxes are filled in
                    Toast.makeText(LoginActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                }
                else
                    auth.signInWithEmailAndPassword(txt_email, txt_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) { //if all fields are filled, then it starts a new activity to the first page (will change to the home page)
                                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }
                            else //if the fields are incorrect (aka not a user) then it fails and allows them to retry
                                Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                            //in the future, may need to add a "forgot password" feature
                        }
                    });
            }
        });
    }
}

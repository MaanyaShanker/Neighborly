package technogirl.maanyavictoria.neighborly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    EditText username, password;
    Button btn_register;
    RadioGroup community;
    FirebaseAuth auth;
    String test_username;
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        final EditText temp_name = findViewById(R.id.full_name);
        final EditText phone_number = findViewById(R.id.phone);
        btn_register = findViewById(R.id.register);

        community = findViewById(R.id.community_choice);

        auth = FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_username = username.getText().toString();
                test_username = txt_username;
                String txt_password = password.getText().toString();
                String name =  temp_name.getText().toString();
                String phone = phone_number.getText().toString();

                if(TextUtils.isEmpty(txt_username) || TextUtils.isEmpty(txt_password) ||  TextUtils.isEmpty(name) ||  TextUtils.isEmpty(phone)){
                    //checks if all fields are filled in
                    Toast.makeText(RegisterActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                }
                else if(txt_password.length() < 6) //checks to see if the password is at least 6 characters for security's sake
                    Toast.makeText(RegisterActivity.this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
                else { //creates the user
                    register(txt_username, txt_password, name, phone);
                }
            }
        });
    }
    protected void register(final String username, final String password, final String name, final String phone_number){
        //creates the user in google firebase
        auth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(!task.isSuccessful()){ //if it doesn't work, allows user to try again
                    Toast.makeText(RegisterActivity.this, "Sign Up unsuccessful, Please try again", Toast.LENGTH_SHORT).show();
                }
                else{
                    //creates a new user and the name is stored in the user object
                    String string_user = username.replace(".", "");
                    User temp_user = new User(name, username, phone_number);

                    Toast.makeText(RegisterActivity.this, "Successfully Signed Up!", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = auth.getCurrentUser();
                    UserProfileChangeRequest userProfileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(name).build();
                    user.updateProfile(userProfileChangeRequest);

                    // Write a message to the database
                    database = FirebaseDatabase.getInstance();
                    myRef = database.getReference("Users/").child(string_user);
                    myRef.setValue(temp_user);

                    switch (community.getCheckedRadioButtonId()){
                        case R.id.join:
                            Intent join_intent = new Intent(RegisterActivity.this, JoinCommunityActivity.class);
                            startActivity(join_intent);
                            finish();
                            break;
                        case R.id.create:
                            Intent create_intent = new Intent(RegisterActivity.this, CreateCommunityActivity.class);
                            startActivity(create_intent);
                            finish();
                            break;
                    }
                }
            }
        }); }
}

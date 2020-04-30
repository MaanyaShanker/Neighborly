package technogirl.maanyavictoria.neighborly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

import technogirl.maanyavictoria.neighborly.Materials.MaterialsItem;
import technogirl.maanyavictoria.neighborly.Money.MoneyItem;
import technogirl.maanyavictoria.neighborly.Time.TimeItem;

public class CreateCommunityActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_community);
    }

    public void createCommunity(View view) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        final String email = user.getEmail().replace(".", "");

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        EditText editText = findViewById(R.id.code);
        final String code = editText.getText().toString();

        if (TextUtils.isEmpty(code))
            Toast.makeText(CreateCommunityActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
        else if(code.length() < 5)
            Toast.makeText(CreateCommunityActivity.this, "Code must be at least 5 characters!", Toast.LENGTH_SHORT).show();
        else {
            myRef.child("Users/").child(email).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    try {
                        if (dataSnapshot.getValue() != null) {
                            try {
                                User temp_user;
                                Log.i("TAG", "" + dataSnapshot.getValue()); // your name values you will get here
                                temp_user = dataSnapshot.getValue(User.class);
                                Log.i("TAG", temp_user.getName());
                                temp_user.setCommunity(code);
                                temp_user.setHead(Boolean.TRUE);

                                myRef.child("Users/").child(email).setValue(temp_user);
                                myRef.child("Communities/").child(code).setValue(new Community(temp_user));
                                Intent intent = new Intent(CreateCommunityActivity.this, HomeActivity.class);
                                startActivity(intent);
                                finish();
                            } catch (Exception e) {
                                Toast.makeText(CreateCommunityActivity.this, "Please try again!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(CreateCommunityActivity.this, "Please try again!", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(CreateCommunityActivity.this, "Please try again!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(CreateCommunityActivity.this, "Please try again!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

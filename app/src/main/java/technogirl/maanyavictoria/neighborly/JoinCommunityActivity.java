package technogirl.maanyavictoria.neighborly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class JoinCommunityActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef, CommunityRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_community);
    }

    public void joinCommunity(View view) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        final String email = user.getEmail().replace(".", "");

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        CommunityRef = database.getReference("Communities/");

        EditText editText = findViewById(R.id.code);
        final String code = editText.getText().toString();

        if (TextUtils.isEmpty(code))
            Toast.makeText(JoinCommunityActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
        else {
            myRef.child("Users/").child(email).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    try {
                        if (dataSnapshot.getValue() != null) {
                            try {
                                final User temp_user;
                                Log.i("TAG", "" + dataSnapshot.getValue()); // your name values you will get here
                                temp_user = dataSnapshot.getValue(User.class);
                                Log.i("TAG", temp_user.getName());
                                CommunityRef.orderByKey().equalTo(code).addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        if(dataSnapshot.exists()) {
                                            //Key exists
                                            temp_user.setCommunity(code);
                                            temp_user.setHead(false);
                                            myRef.child("Users/").child(email).setValue(temp_user);
                                            Intent intent = new Intent(JoinCommunityActivity.this, HomeActivity.class);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            Toast.makeText(JoinCommunityActivity.this, "This code does not exist!", Toast.LENGTH_LONG).show();
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {
                                        Toast.makeText(JoinCommunityActivity.this, "Please try again!", Toast.LENGTH_LONG).show();
                                    }
                                });
                            } catch (Exception e) {
                                Toast.makeText(JoinCommunityActivity.this, "Please try again!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(JoinCommunityActivity.this, "Please try again!", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(JoinCommunityActivity.this, "Please try again!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(JoinCommunityActivity.this, "Please try again!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}


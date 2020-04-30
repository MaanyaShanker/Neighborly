package technogirl.maanyavictoria.neighborly;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import technogirl.maanyavictoria.neighborly.Home.HomeFragment;
import technogirl.maanyavictoria.neighborly.Materials.MaterialsFragment;
import technogirl.maanyavictoria.neighborly.Materials.MaterialsItem;
import technogirl.maanyavictoria.neighborly.Money.MoneyFragment;
import technogirl.maanyavictoria.neighborly.Money.MoneyItem;
import technogirl.maanyavictoria.neighborly.Time.TimeFragment;
import technogirl.maanyavictoria.neighborly.Time.TimeItem;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "Neighborly";
    Fragment materials_fragment, time_fragment, money_fragment, home_fragment;
    FragmentManager fm;
    Fragment active;
    ArrayList<MaterialsItem> materialsItemsList;
    ArrayList<TimeItem> timeItemsList;
    ArrayList<MoneyItem> moneyItemsList;
    ArrayList<Object> homeItemList;
    FirebaseDatabase database;
    DatabaseReference myRef, CommunityRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        final String email = user.getEmail().replace(".", "");

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        CommunityRef = database.getReference("Communities/");

        myRef.child("Users/").child(email).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                try {
                    if (dataSnapshot.getValue() != null) {
                        try {
                            User temp_user;
                            Log.i("TAG", "" + dataSnapshot.getValue()); // your name values you will get here
                            temp_user = dataSnapshot.getValue(User.class);
                            final String c = temp_user.getCommunity();
                            CommunityRef.child(c).addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    Community community = dataSnapshot.getValue(Community.class);
                                    Log.i(TAG, "WHAT?");
                                    materialsItemsList = community.getMaterialsItem();
                                    timeItemsList = community.getTimeItem();
                                    moneyItemsList = community.getMoneyItem();
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                    Log.i(TAG, "Error!");
                                }
                            });
                        } catch (Exception e) {
                            Log.i(TAG, "Did not load");
                        }
                    } else {
                        Log.i(TAG, "Did not load");
                    }
                } catch (Exception e) {
                    Log.i(TAG, "Did not load");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.i(TAG, "Did not load");            }
        });

        homeItemList = new ArrayList<>();
        home_fragment = new HomeFragment(homeItemList);
        materials_fragment = new MaterialsFragment(materialsItemsList);
        time_fragment = new TimeFragment(timeItemsList);
        money_fragment = new MoneyFragment(moneyItemsList);

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.main_container, home_fragment, "0").commit();
        fm.beginTransaction().add(R.id.main_container, materials_fragment, "1").hide(materials_fragment).commit();
        fm.beginTransaction().add(R.id.main_container, time_fragment, "2").hide(time_fragment).commit();
        fm.beginTransaction().add(R.id.main_container, money_fragment, "3").hide(money_fragment).commit();

        active = home_fragment;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Log.i(TAG, "HomeTab");
                    fm.beginTransaction().hide(active).commit();
                    fm.beginTransaction().show(home_fragment).commit();
                    active = home_fragment;
                    return true;
                case R.id.navigation_materials:
                    fm.beginTransaction().hide(active).commit();
                    fm.beginTransaction().show(materials_fragment).commit();
                    active = materials_fragment;
                    return true;
                case R.id.navigation_time:
                    fm.beginTransaction().hide(active).commit();
                    fm.beginTransaction().show(time_fragment).commit();
                    active = time_fragment;
                    return true;
                case R.id.navigation_money:
                    fm.beginTransaction().hide(active).commit();
                    fm.beginTransaction().show(money_fragment).commit();
                    active = money_fragment;
                    return true;
            }
            return false;
        }
    };

}

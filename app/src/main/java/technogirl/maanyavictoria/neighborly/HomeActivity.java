package technogirl.maanyavictoria.neighborly;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import technogirl.maanyavictoria.neighborly.Materials.MaterialsFragment;
import technogirl.maanyavictoria.neighborly.Time.TimeFragment;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "Neighborly";
    private TextView mTextMessage;
    Fragment materials_fragment, time_fragment;
//    final FragmentManager fm = getSupportFragmentManager();
    FragmentManager fm;
    Fragment active = materials_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        materials_fragment = new MaterialsFragment();
        time_fragment = new TimeFragment();
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.main_container, materials_fragment, "1").hide(materials_fragment).commit();
        fm.beginTransaction().add(R.id.main_container, time_fragment, "2").hide(time_fragment).commit();
        active = materials_fragment;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    mTextMessage.setVisibility(View.VISIBLE);
                    fm.beginTransaction().hide(active).commit();
                    return true;
                case R.id.navigation_materials:
                    mTextMessage.setVisibility(View.GONE);
                    fm.beginTransaction().hide(active).commit();
                    fm.beginTransaction().show(materials_fragment).commit();
                    active = materials_fragment;
                    return true;
                case R.id.navigation_time:
                    mTextMessage.setVisibility(View.GONE);
                    fm.beginTransaction().hide(active).commit();
                    fm.beginTransaction().show(time_fragment).commit();
                    active = time_fragment;
                    return true;
                case R.id.navigation_money:
                    mTextMessage.setText(R.string.title_money);
                    mTextMessage.setVisibility(View.VISIBLE);
                    fm.beginTransaction().hide(active).commit();
                    return true;
            }
            return false;
        }
    };

}

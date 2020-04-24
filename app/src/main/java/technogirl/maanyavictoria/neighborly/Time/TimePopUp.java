package technogirl.maanyavictoria.neighborly.Time;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import technogirl.maanyavictoria.neighborly.R;

public class TimePopUp extends AppCompatActivity {
    TextView header, date, desc;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_pop_up);

        intent = getIntent();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*0.8), (int) (height*0.6));

        header = findViewById(R.id.popuptimeheader);
        date = findViewById(R.id.popuptimedate);
        desc = findViewById(R.id.popuptimedesc);

        String[] temp = intent.getStringArrayExtra("TimeItem");
        header.setText(temp[0].toString());
        date.setText(temp[1].toString());
        desc.setText(temp[3].toString());

    }
}

package technogirl.maanyavictoria.neighborly.Materials;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import technogirl.maanyavictoria.neighborly.R;

public class MaterialsPopUp extends AppCompatActivity {
    TextView header, date, desc;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials_pop_up);

        intent = getIntent();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*0.8), (int) (height*0.6));

        header = findViewById(R.id.popupmaterialsheader);
        date = findViewById(R.id.popupmaterialsdate);
        desc = findViewById(R.id.popupmaterialsdesc);

        String[] temp = intent.getStringArrayExtra("MaterialItem");
        header.setText(temp[0].toString());
        date.setText(temp[1].toString());
        desc.setText(temp[3].toString());
    }
}

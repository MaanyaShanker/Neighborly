package technogirl.maanyavictoria.neighborly.Money;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ProgressBar;
import android.widget.TextView;

import technogirl.maanyavictoria.neighborly.R;

public class MoneyPopUp extends AppCompatActivity {
    TextView header, date, desc, raised;
    Intent intent;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_pop_up);

        intent = getIntent();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*0.8), (int) (height*0.6));

        header = findViewById(R.id.popupmoneyheader);
        date = findViewById(R.id.popupmoneydate);
        progressBar = findViewById(R.id.popupmoneyprogress);
        raised = findViewById(R.id.popupmoneyraised);
        desc = findViewById(R.id.popupmoneydesc);

        String[] temp = intent.getStringArrayExtra("MoneyItem");
        header.setText(temp[0]);
        date.setText(temp[1]);
        desc.setText(temp[3]);
        int max = Integer.parseInt(temp[5]);
        int progress = Integer.parseInt(temp[4]);
        raised.setText("$"+temp[4] + "/$" + temp[5]);
        progressBar.setMax(max);
        progressBar.setProgress(progress);

//        String[] materialItemDesc = {moneyItemList.get(position).getHeader(),
//                moneyItemList.get(position).getDate(),
//                moneyItemList.get(position).getShort_description(),
//                moneyItemList.get(position).getLong_description(),
//                ""+moneyItemList.get(position).getProgress(),
//                ""+moneyItemList.get(position).getMax()};
    }
}

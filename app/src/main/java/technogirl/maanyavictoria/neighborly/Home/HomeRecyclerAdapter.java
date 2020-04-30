package technogirl.maanyavictoria.neighborly.Home;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import technogirl.maanyavictoria.neighborly.Materials.MaterialsItem;
import technogirl.maanyavictoria.neighborly.Money.MoneyItem;
import technogirl.maanyavictoria.neighborly.R;
import technogirl.maanyavictoria.neighborly.Time.TimeItem;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {
    List<Object> homeItemList;
    Context mContext;
    private static final String TAG = "Adapter";
    TextView header, date, raised, description;
    ProgressBar popup_pb;
    Dialog myDialog;

    public HomeRecyclerAdapter(List<Object> homeItemList, Context mContext) {
        this.homeItemList = homeItemList;
        this.mContext = mContext;
        Log.i(TAG, "Adapter instantiated");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "OnCreateViewHolder: Reached");
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.i(TAG, "OnBindViewHolder");

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.activity_home_pop_up);
        header = myDialog.findViewById(R.id.popuphomeheader);
        date = myDialog.findViewById(R.id.popuphomedate);
        raised = myDialog.findViewById(R.id.popuphomeraised);
        description = myDialog.findViewById(R.id.popuphomedesc);
        popup_pb = myDialog.findViewById(R.id.popuphomeprogress);

        final Object temp = homeItemList.get(position);
        if(temp instanceof MaterialsItem){
            holder.header.setText(((MaterialsItem) temp).getHeader());
            holder.date.setText(((MaterialsItem) temp).getDate());
            holder.description.setText(((MaterialsItem) temp).getShort_description());
            holder.pb.setVisibility(View.GONE);
            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    header.setText(((MaterialsItem) temp).getHeader());
                    date.setText(((MaterialsItem) temp).getDate());
                    description.setText(((MaterialsItem) temp).getLong_description());
                    popup_pb.setVisibility(View.GONE);
                    raised.setVisibility(View.GONE);
                    myDialog.show();
                }
            });
        }
        else if(temp instanceof TimeItem){
            holder.header.setText(((TimeItem) temp).getHeader());
            holder.date.setText(((TimeItem) temp).getDate());
            holder.description.setText(((TimeItem) temp).getShort_description());
            holder.pb.setVisibility(View.GONE);
            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    header.setText(((TimeItem) temp).getHeader());
                    date.setText(((TimeItem) temp).getDate());
                    description.setText(((TimeItem) temp).getLong_description());
                    popup_pb.setVisibility(View.GONE);
                    raised.setVisibility(View.GONE);
                    myDialog.show();
                }
            });

        }
        else{
            holder.header.setText(((MoneyItem) temp).getHeader());
            holder.date.setText(((MoneyItem) temp).getDate());
            holder.description.setText(((MoneyItem) temp).getShort_description());
            holder.pb.setMax(((MoneyItem) temp).getMax());
            holder.pb.setProgress(((MoneyItem) temp).getProgress());
            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    header.setText(((MoneyItem) temp).getHeader());
                    date.setText(((MoneyItem) temp).getDate());
                    description.setText(((MoneyItem) temp).getLong_description());
                    String r = "$" + ((MoneyItem) temp).getProgress() + "/$" + ((MoneyItem) temp).getMax();
                    raised.setText(r);
                    popup_pb.setMax(((MoneyItem) temp).getMax());
                    popup_pb.setMax(((MoneyItem) temp).getProgress());
                    myDialog.show();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return homeItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView header, date, description;
        ProgressBar pb;
        ConstraintLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.i(TAG, "ViewHolder");
            header = itemView.findViewById(R.id.home_item_name);
            date = itemView.findViewById(R.id.home_item_date);
            description = itemView.findViewById(R.id.home_item_desc);
            pb = itemView.findViewById(R.id.pb);
            parentLayout = itemView.findViewById(R.id.home_parent_layout);
        }
    }
}

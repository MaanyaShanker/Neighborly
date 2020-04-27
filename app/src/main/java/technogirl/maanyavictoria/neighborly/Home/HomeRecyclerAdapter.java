package technogirl.maanyavictoria.neighborly.Home;

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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.i(TAG, "OnBindViewHolder");
        Object temp = homeItemList.get(position);
        if(temp instanceof MaterialsItem){
            holder.header.setText(((MaterialsItem) temp).getHeader());
            holder.date.setText(((MaterialsItem) temp).getDate());
            holder.description.setText(((MaterialsItem) temp).getShort_description());
            holder.pb.setVisibility(View.GONE);
        }
        else if(temp instanceof TimeItem){
            holder.header.setText(((TimeItem) temp).getHeader());
            holder.date.setText(((TimeItem) temp).getDate());
            holder.description.setText(((TimeItem) temp).getShort_description());
            holder.pb.setVisibility(View.GONE);
        }
        else{
            holder.header.setText(((MoneyItem) temp).getHeader());
            holder.date.setText(((MoneyItem) temp).getDate());
            holder.description.setText(((MoneyItem) temp).getShort_description());
            holder.pb.setMax(((MoneyItem) temp).getMax());
            holder.pb.setProgress(((MoneyItem) temp).getProgress());
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

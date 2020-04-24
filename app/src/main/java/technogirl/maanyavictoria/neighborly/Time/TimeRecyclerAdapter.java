package technogirl.maanyavictoria.neighborly.Time;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import technogirl.maanyavictoria.neighborly.Materials.MaterialsRecyclerAdapter;
import technogirl.maanyavictoria.neighborly.R;

public class TimeRecyclerAdapter extends RecyclerView.Adapter<TimeRecyclerAdapter.ViewHolder>{
    List<TimeItem> timeItemList;
    Context mContext;

    public TimeRecyclerAdapter(List<TimeItem> timeItemList, Context mContext) {
        this.timeItemList = timeItemList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public TimeRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.request_item_recycler_view, parent, false);
        return new TimeRecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TimeRecyclerAdapter.ViewHolder holder, int position) {
        holder.description.setText(timeItemList.get(position).getDescription());
        holder.date.setText(timeItemList.get(position).getDate());
        holder.header.setText(timeItemList.get(position).getHeader());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.header.setText("Clicked!");
            }
        });
    }

    @Override
    public int getItemCount() {
        return timeItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView header, date, description;
        ConstraintLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.item_name);
            date = itemView.findViewById(R.id.item_date);
            description = itemView.findViewById(R.id.item_desc);
            parentLayout = itemView.findViewById(R.id.parentLayout);
            Log.i("Adapter", "ViewHolderClass: Created");
        }
    }
}

package technogirl.maanyavictoria.neighborly.Money;

import android.content.Context;
import android.content.Intent;
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

import technogirl.maanyavictoria.neighborly.R;


public class MoneyRecyclerAdapter extends RecyclerView.Adapter<MoneyRecyclerAdapter.ViewHolder> {
    List<MoneyItem> moneyItemList;
    Context mContext;

    public MoneyRecyclerAdapter(List<MoneyItem> moneyItemList, Context mContext) {
        this.moneyItemList = moneyItemList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.request_money_recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.progressBar.setMax(moneyItemList.get(position).getMax());
        holder.progressBar.setProgress(moneyItemList.get(position).getProgress());
        holder.description.setText(moneyItemList.get(position).getShort_description());
        holder.date.setText(moneyItemList.get(position).getDate());
        holder.header.setText(moneyItemList.get(position).getHeader());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] materialItemDesc = {moneyItemList.get(position).getHeader(),
                        moneyItemList.get(position).getDate(),
                        moneyItemList.get(position).getShort_description(),
                        moneyItemList.get(position).getLong_description(),
                        ""+moneyItemList.get(position).getProgress(),
                        ""+moneyItemList.get(position).getMax()};
                Intent intent = new Intent(mContext, MoneyPopUp.class);
                intent.putExtra("MoneyItem", materialItemDesc);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return moneyItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView header, date, description;
        ProgressBar progressBar;
        ConstraintLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            header = itemView.findViewById(R.id.item_name);
            date = itemView.findViewById(R.id.item_date);
            description = itemView.findViewById(R.id.item_desc);
            progressBar = itemView.findViewById(R.id.moneypb);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            Log.i("Adapter", "ViewHolderClass: Created");
        }
    }
}

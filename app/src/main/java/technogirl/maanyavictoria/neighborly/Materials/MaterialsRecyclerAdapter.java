package technogirl.maanyavictoria.neighborly.Materials;

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

import technogirl.maanyavictoria.neighborly.R;

public class MaterialsRecyclerAdapter extends RecyclerView.Adapter<MaterialsRecyclerAdapter.ViewHolder> {
    List<MaterialsItem> materialsItemList;
    Context mContext;

    public MaterialsRecyclerAdapter(List<MaterialsItem> materialsItemList, Context context) {
        Log.i("Adapter", "Created");
        this.materialsItemList = materialsItemList;
        this.mContext = context;
        Log.i("Adapter", "" + getItemCount());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("Adapter", "OnCreateViewHolder: Created");
        View view = LayoutInflater.from(mContext).inflate(R.layout.request_item_recycler_view, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Log.i("Adapter", "OnBindViewHolder Created");

        holder.description.setText(materialsItemList.get(position).getDescription());
        holder.date.setText(materialsItemList.get(position).getDate());
        holder.header.setText(materialsItemList.get(position).getHeader());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.header.setText("Clicked!");
            }
        });
    }

    @Override
    public int getItemCount() {
        return materialsItemList.size();
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

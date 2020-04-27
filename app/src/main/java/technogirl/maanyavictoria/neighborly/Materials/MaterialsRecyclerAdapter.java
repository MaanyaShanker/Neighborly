package technogirl.maanyavictoria.neighborly.Materials;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

import technogirl.maanyavictoria.neighborly.R;

public class MaterialsRecyclerAdapter extends RecyclerView.Adapter<MaterialsRecyclerAdapter.ViewHolder> {
    List<MaterialsItem> materialsItemList;
    private final Context mContext;
    TextView header, date, description;
    Dialog myDialog;

    public MaterialsRecyclerAdapter(List<MaterialsItem> materialsItemList, Context context) {
        Log.i("Adapter", "Created");
        this.materialsItemList = materialsItemList;
        mContext = context;
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Log.i("Adapter", "OnBindViewHolder Created");

        holder.description.setText(materialsItemList.get(position).getShort_description());
        holder.date.setText(materialsItemList.get(position).getDate());
        holder.header.setText(materialsItemList.get(position).getHeader());

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.activity_materials_pop_up);
        header = myDialog.findViewById(R.id.popupmaterialsheader);
        date = myDialog.findViewById(R.id.popupmaterialsdate);
        description = myDialog.findViewById(R.id.popupmaterialsdesc);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                header.setText(materialsItemList.get(position).getHeader());
                date.setText(materialsItemList.get(position).getDate());
                description.setText(materialsItemList.get(position).getLong_description());
                myDialog.show();
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

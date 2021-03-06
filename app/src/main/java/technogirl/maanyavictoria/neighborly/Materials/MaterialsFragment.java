package technogirl.maanyavictoria.neighborly.Materials;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import technogirl.maanyavictoria.neighborly.R;

public class MaterialsFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private List<MaterialsItem> materialsItemsList;
    private RecyclerView recyclerView;


    public MaterialsFragment() {
        // Required empty public constructor
        Log.i("MaterialsFragment", "Initialized");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("MaterialsFragment", "OnCreateViewMade");
        View view = inflater.inflate(R.layout.fragment_materials, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        materialsItemsList = new ArrayList<>();
        materialsItemsList.add(new MaterialsItem("Groceries", "4/20/2020", "I need a few things picked up", "I need eggs, milk, potatoes, and some medicine."));
        materialsItemsList.add(new MaterialsItem("Medicine", "4/23/2020", "I need medicine", "I need my sugar medicine."));
        materialsItemsList.add(new MaterialsItem("Clothes", "4/27/2020", "I need clothes", "I need some sweaters and some socks"));
        MaterialsRecyclerAdapter mAdapter = new MaterialsRecyclerAdapter(materialsItemsList, container.getContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        mAdapter.notifyDataSetChanged();
        return view;
    }
}
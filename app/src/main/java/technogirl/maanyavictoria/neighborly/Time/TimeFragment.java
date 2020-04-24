package technogirl.maanyavictoria.neighborly.Time;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import technogirl.maanyavictoria.neighborly.Materials.MaterialsItem;
import technogirl.maanyavictoria.neighborly.Materials.MaterialsRecyclerAdapter;
import technogirl.maanyavictoria.neighborly.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeFragment extends Fragment {
    private List<TimeItem> timeItemList;
    private RecyclerView recyclerView;

    public TimeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_time, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        timeItemList = new ArrayList<>();
        timeItemList.add(new TimeItem("Volunteer", "4/20/2020", "I need a few things picked up"));
        timeItemList.add(new TimeItem("Volunteer", "4/20/2020", "I need a few things picked up"));
        timeItemList.add(new TimeItem("Volunteer", "4/20/2020", "I need a few things picked up"));
        TimeRecyclerAdapter mAdapter = new TimeRecyclerAdapter(timeItemList, container.getContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter.notifyDataSetChanged();
        return view;
    }

}

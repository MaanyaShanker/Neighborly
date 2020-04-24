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
        timeItemList.add(new TimeItem("Installation", "4/20/2020", "I need a TV set built", "I recently bought a TV that I haven't installed, but now I am injured, and I would appreciate the help."));
        timeItemList.add(new TimeItem("Babysitting", "4/20/2020", "I need someone to watch my kids for a night", "I have 2 kids: a 5 year old and a 2 year old. My husband and I wanted to go out for a break, and we would appreciate it if someone watched our kids. We're willing to pay!"));
        timeItemList.add(new TimeItem("Plumbing", "4/20/2020", "I need some plumbing work done", "My toilet stopped working for some reason, and I would love if someone could help out!"));
        TimeRecyclerAdapter mAdapter = new TimeRecyclerAdapter(timeItemList, container.getContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter.notifyDataSetChanged();
        return view;
    }

}

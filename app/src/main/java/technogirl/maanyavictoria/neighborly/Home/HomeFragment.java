package technogirl.maanyavictoria.neighborly.Home;


import android.nfc.Tag;
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

import technogirl.maanyavictoria.neighborly.Materials.MaterialsItem;
import technogirl.maanyavictoria.neighborly.Money.MoneyItem;
import technogirl.maanyavictoria.neighborly.R;
import technogirl.maanyavictoria.neighborly.Time.TimeItem;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private List<Object> homeItemList;
    private RecyclerView recyclerView;
    private static final String TAG = "Fragment";


    public HomeFragment() {
        // Required empty public constructor
        Log.i(TAG, "Fragment Instantiated");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        homeItemList = new ArrayList<>();
        homeItemList.add(new MaterialsItem("Groceries", "4/20/2020", "I need a few things picked up", "I need eggs, milk, potatoes, and some medicine."));
        homeItemList.add(new MaterialsItem("Medicine", "4/23/2020", "I need medicine", "I need my sugar medicine."));
        homeItemList.add(new MaterialsItem("Clothes", "4/27/2020", "I need clothes", "I need some sweaters and some socks"));
        homeItemList.add(new TimeItem("Installation", "4/20/2020", "I need a TV set built", "I recently bought a TV that I haven't installed, but now I am injured, and I would appreciate the help."));
        homeItemList.add(new TimeItem("Babysitting", "4/20/2020", "I need someone to watch my kids for a night", "I have 2 kids: a 5 year old and a 2 year old. My husband and I wanted to go out for a break, and we would appreciate it if someone watched our kids. We're willing to pay!"));
        homeItemList.add(new TimeItem("Plumbing", "4/20/2020", "I need some plumbing work done", "My toilet stopped working for some reason, and I would love if someone could help out!"));
        homeItemList.add(new MoneyItem("Dance", "4/25/2020", "I need some money to pay for dance", "I fell a few dollars short, what should i do?", 10, 100));
        homeItemList.add(new MoneyItem("Dance", "4/25/2020", "I need some money to pay for dance", "I fell a few dollars short, what should i do?", 50, 100));
        homeItemList.add(new MoneyItem("Dance", "4/25/2020", "I need some money to pay for dance", "I fell a few dollars short, what should i do?", 90, 100));

        HomeRecyclerAdapter mAdapter = new HomeRecyclerAdapter(homeItemList, container.getContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        mAdapter.notifyDataSetChanged();
        Log.i(TAG, "Created View");
        return view;
    }

}

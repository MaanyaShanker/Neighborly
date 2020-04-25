package technogirl.maanyavictoria.neighborly.Money;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import technogirl.maanyavictoria.neighborly.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoneyFragment extends Fragment {
    private List<MoneyItem> moneyItemList;
    private RecyclerView recyclerView;
    public MoneyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_money, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        moneyItemList = new ArrayList<>();
        moneyItemList.add(new MoneyItem("Dance", "4/25/2020", "I need some money to pay for dance", "I fell a few dollars short, what should i do?", 10, 100));
        moneyItemList.add(new MoneyItem("Dance", "4/25/2020", "I need some money to pay for dance", "I fell a few dollars short, what should i do?", 50, 100));
        moneyItemList.add(new MoneyItem("Dance", "4/25/2020", "I need some money to pay for dance", "I fell a few dollars short, what should i do?", 90, 100));
        MoneyRecyclerAdapter mAdapter = new MoneyRecyclerAdapter(moneyItemList, container.getContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        mAdapter.notifyDataSetChanged();
        return view;
    }

}

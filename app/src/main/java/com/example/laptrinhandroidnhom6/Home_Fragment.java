package com.example.laptrinhandroidnhom6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.laptrinhandroidnhom6.custom.Custom_Adapter_Home;
import com.example.laptrinhandroidnhom6.model.ItemOfListOrder;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Home_Fragment newInstance(String param1, String param2) {
        Home_Fragment fragment = new Home_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ArrayList<ItemOfListOrder> listItem;

    public void createListItemOrder() {
        listItem = new ArrayList<>();
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_, container, false);
        GridView listView = view.findViewById(R.id.listHome);
        createListItemOrder();
        Custom_Adapter_Home adapter_home = new Custom_Adapter_Home(listItem,getActivity());
        listView.setAdapter(adapter_home);
        return view;
    }
}
package com.example.laptrinhandroidnhom6.list_order;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;

import com.example.laptrinhandroidnhom6.R;
import com.example.laptrinhandroidnhom6.custom.Custom_AdapterView_Order;
import com.example.laptrinhandroidnhom6.model.ItemOfListOrder;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderFagment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderFagment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OrderFagment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderFagment.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderFagment newInstance(String param1, String param2) {
        OrderFagment fragment = new OrderFagment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_fagment, container, false);
        ListView listView = view.findViewById(R.id.listOrder);
        createListItemOrder();
        Custom_AdapterView_Order adapter = new Custom_AdapterView_Order(listItem, getActivity());
        listView.setAdapter(adapter);


        return view;
    }

    //tạo list Items
    public void createListItemOrder() {
        listItem = new ArrayList<>();
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200));

    }
}
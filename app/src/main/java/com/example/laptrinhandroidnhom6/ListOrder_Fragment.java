package com.example.laptrinhandroidnhom6;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.laptrinhandroidnhom6.list_order.OrderFagment;
import com.example.laptrinhandroidnhom6.list_order.PagerAdepterOrder;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListOrder_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListOrder_Fragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View view;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListOrder_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListOrder_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListOrder_Fragment newInstance(String param1, String param2) {
        ListOrder_Fragment fragment = new ListOrder_Fragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      view = inflater.inflate(R.layout.fragment_list_order_, container, false);
        tabLayout = view.findViewById(R.id.taborderList);
        viewPager = view.findViewById(R.id.listOrderPager);
        PagerAdepterOrder adepterOrder = new PagerAdepterOrder(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adepterOrder);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}
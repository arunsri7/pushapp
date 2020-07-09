package com.example.pushapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;



public class PushappFragment extends Fragment {

    TextView countTv;
    FrameLayout increment;
    Button reset;
    int count = 0;

    public PushappFragment() {
        // Required empty public constructor
    }

    public static PushappFragment newInstance(String param1, String param2) {
        PushappFragment fragment = new PushappFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pushapp, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
                //Pull to Refresh
        final SwipeRefreshLayout pullToRefresh = view.findViewById(R.id.pullToRefresh);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                count = 0;
                countTv.setText(String.valueOf(count));
                pullToRefresh.setRefreshing(false);
            }
        });

        //Initialization.
        countTv = view.findViewById(R.id.count_tv);
        increment = view.findViewById(R.id.increment);

        increment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                count++;//increment the count
                countTv.setText(String.valueOf(count));// view in the text
            }

        });
        super.onViewCreated(view, savedInstanceState);
    }
}
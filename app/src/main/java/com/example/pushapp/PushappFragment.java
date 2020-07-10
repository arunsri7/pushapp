package com.example.pushapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;


public class PushappFragment extends Fragment {

    TextView countTv;
    RelativeLayout increment;
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
        increment = view.findViewById(R.id.pushup_fragment_rlayout);

        List<SliderItem> items = new ArrayList<>();
        SliderItem item = new SliderItem("Spotify","https://storage.googleapis.com/pr-newsroom-wp/1/2020/03/Header.png");
        SliderItem item2 = new SliderItem("Amazon Music","https://images-na.ssl-images-amazon.com/images/G/01/AmazonMusic/2019/LandingPages/2019DevicesLandingPageUpdate/1.Header_Desktop.jpg");
        SliderItem item3 = new SliderItem("Jio Saavn","https://entrackr.com/wp-content/uploads/2019/09/Jiosaavn.jpg");
        items.add(item);
        items.add(item2);
        items.add(item3);
        SliderView sliderView = view.findViewById(R.id.imageSlider);
        SliderAdapterExample adapter = new SliderAdapterExample(this);
        adapter.renewItems(items);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.THIN_WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.setSliderAnimationDuration(1);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();

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
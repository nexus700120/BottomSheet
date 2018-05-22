package com.tinkoff.bottom.sheet;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private final static int PEEK_HEIGHT = UiUtils.dpToPx(300);

    private View bottomSheet;
    private CinemaBottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.show_bottom_sheet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        bottomSheet = findViewById(R.id.bottom_sheet);

        bottomSheetBehavior = new CinemaBottomSheetBehavior();
        bottomSheetBehavior.setPeekHeight(PEEK_HEIGHT);
        bottomSheetBehavior.setHideable(true);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        CoordinatorLayout.LayoutParams bottomSheetParams = (CoordinatorLayout.LayoutParams) bottomSheet.getLayoutParams();
        bottomSheetParams.setBehavior(bottomSheetBehavior);

        RecyclerView horizontalRecyclerView1 = findViewById(R.id.horizontal_recycler1);
        horizontalRecyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        horizontalRecyclerView1.setAdapter(new ColorsAdapter(false));

        RecyclerView horizontalRecyclerView2 = findViewById(R.id.horizontal_recycler2);
        horizontalRecyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        horizontalRecyclerView2.setAdapter(new ColorsAdapter(false));

        RecyclerView verticalRecyclerView = findViewById(R.id.vertical_recycler);
        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        verticalRecyclerView.setAdapter(new ColorsAdapter(true));
    }
}

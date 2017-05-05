package com.wnascimento.com.me_adote_mob.presentation.timeline;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.wnascimento.com.me_adote_mob.R;
import com.wnascimento.com.me_adote_mob.domain.pet.model.Pet;

import java.util.ArrayList;
import java.util.List;

public class TimelineActivity extends AppCompatActivity implements TimelineContract.View {

    private RecyclerView recyclerViewTimeline;
    private TimelineAdapter timelineAdapter;
    private Toolbar toolbar;

    private TimelineContract.Presenter timelinePresenter;

    public static Intent startIntent(Context context) {
        return new Intent(context, TimelineActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        TimelinePresenterFactory.make(this);

        initComponents();
        initToolbar();
        initTimeline();
    }

    private void initComponents() {
        recyclerViewTimeline = (RecyclerView) findViewById(R.id.recycler_view_timeline);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setLogo(R.drawable.ic_small_text_meadote);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setElevation(8);
        }

    }


    private void initTimeline() {
        List<Pet> timeline = new ArrayList<>();
        timelineAdapter = new TimelineAdapter(timeline);
        recyclerViewTimeline.setHasFixedSize(true);
        recyclerViewTimeline.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTimeline.setAdapter(timelineAdapter);
        timelinePresenter.getAvailablePets();
    }

    @Override
    protected void onStart() {
        super.onStart();
        timelinePresenter.reload();
    }

    @Override
    protected void onStop() {
        super.onStop();
        timelinePresenter.close();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerViewTimeline.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            recyclerViewTimeline.setLayoutManager(new LinearLayoutManager(this));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public void attachPresenter(TimelineContract.Presenter presenter) {
        timelinePresenter = presenter;
    }

    @Override
    public void updateTimeline(Pet pet) {
        timelineAdapter.updateList(pet);
    }

    @Override
    public void showLoadError() {

    }
}

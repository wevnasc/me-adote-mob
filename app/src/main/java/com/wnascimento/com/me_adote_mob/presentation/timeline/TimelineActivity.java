package com.wnascimento.com.me_adote_mob.presentation.timeline;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.wnascimento.com.me_adote_mob.R;
import com.wnascimento.com.me_adote_mob.domain.timeline.model.AvailablePet;

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
        initTimeline();
    }

    private void initComponents() {
        recyclerViewTimeline = (RecyclerView) findViewById(R.id.recycler_view_timeline);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    private void initTimeline() {
        List<AvailablePet> timeline = new ArrayList<>();
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
    public void attachPresenter(TimelineContract.Presenter presenter) {
        timelinePresenter = presenter;
    }

    @Override
    public void updateTimeline(AvailablePet availablePet) {
        timelineAdapter.updateList(availablePet);
    }

    @Override
    public void showLoadError() {

    }
}

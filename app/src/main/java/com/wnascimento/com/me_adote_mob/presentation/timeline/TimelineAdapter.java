package com.wnascimento.com.me_adote_mob.presentation.timeline;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.wnascimento.com.me_adote_mob.R;
import com.wnascimento.com.me_adote_mob.domain.timeline.model.AvailablePet;

import java.util.List;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder> {

    private List<AvailablePet> timeline;

    public TimelineAdapter(List<AvailablePet> timeline) {
        this.timeline = timeline;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_timeline, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        AvailablePet availablePet = timeline.get(position);
        holder.textName.setText(availablePet.getName());
        holder.textDescription.setText(availablePet.getNotes());

        Glide.with(context)
                .load(availablePet.getImage())
                .crossFade(1000)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.imagePet);

    }

    @Override
    public int getItemCount() {
        return timeline != null ? timeline.size() : 0;
    }

    public void updateList(AvailablePet availablePet) {
        insertItem(availablePet);
    }

    private void insertItem(AvailablePet availablePet) {
        if (!timeline.contains(availablePet)) {
            timeline.add(availablePet);
            notifyItemInserted(getItemCount());
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textName;
        private TextView textDescription;
        private ImageView imagePet;

        public ViewHolder(View itemView) {
            super(itemView);
            initComponents(itemView);
        }

        private void initComponents(View itemView) {
            textName = (TextView) itemView.findViewById(R.id.text_name);
            textDescription = (TextView) itemView.findViewById(R.id.text_description);
            imagePet = (ImageView) itemView.findViewById(R.id.image_pet);
        }
    }
}

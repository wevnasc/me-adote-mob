package com.wnascimento.com.me_adote_mob.presentation.timeline;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wnascimento.com.me_adote_mob.R;
import com.wnascimento.com.me_adote_mob.domain.pet.PetContract;
import com.wnascimento.com.me_adote_mob.util.DateHelper;
import com.wnascimento.com.me_adote_mob.util.ImageHelper;
import com.wnascimento.com.me_adote_mob.util.MeasuresHelper;

import java.util.List;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.ViewHolder> {

    private List<PetContract> timeline;

    public TimelineAdapter(List<PetContract> timeline) {
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
        PetContract pet = timeline.get(position);

        ImageHelper.showImageCircle(context, holder.imageOwner, pet.getOwner().getImage());
        ImageHelper.showImage(context, holder.imagePet, pet.getImage());

        switch (pet.getGender()) {
            case PetContract.MALE:
                holder.imageGender.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_gender_male));
                break;
            case PetContract.FEMALE:
                holder.imageGender.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_gender_female));
                break;
        }

        holder.textPetName.setText(pet.getName());
        holder.textOwnerName.setText(pet.getOwner().getName());
        holder.textWeight.setText(MeasuresHelper.formatToWeight(pet.getWeight()));
        holder.textBreed.setText(pet.getBreed());
        holder.textAge.setText(DateHelper.getPeriodInYearsOrMonths(context, pet.getDateBirth(),
                System.currentTimeMillis()));

    }

    @Override
    public int getItemCount() {
        return timeline != null ? timeline.size() : 0;
    }

    public void updateList(PetContract pet) {
        insertItem(pet);
    }

    private void insertItem(PetContract pet) {
        timeline.add(pet);
        notifyItemInserted(getItemCount());
    }

    public void cleanList() {
        int size = timeline.size();
        timeline.clear();
        notifyItemRangeRemoved(0, size);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textPetName;
        private TextView textOwnerName;
        private TextView textBreed;
        private TextView textWeight;
        private TextView textAge;
        private ImageView imageGender;
        private ImageView imagePet;
        private ImageView imageOwner;

        public ViewHolder(View itemView) {
            super(itemView);
            initComponents(itemView);
        }

        private void initComponents(View itemView) {
            textPetName = (TextView) itemView.findViewById(R.id.text_pet_name);
            textOwnerName = (TextView) itemView.findViewById(R.id.text_owner_name);
            textBreed = (TextView) itemView.findViewById(R.id.text_breed);
            textWeight = (TextView) itemView.findViewById(R.id.text_weight);
            textAge = (TextView) itemView.findViewById(R.id.text_age);

            imageGender = (ImageView) itemView.findViewById(R.id.image_gender);
            imagePet = (ImageView) itemView.findViewById(R.id.image_pet);
            imageOwner = (ImageView) itemView.findViewById(R.id.image_owner);
        }
    }
}

package com.example.user.starwars.mvp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.starwars.pojo.Planets;
import com.example.user.starwars.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by user on 08.07.2016.
 */
public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsAdapter.PlanetsViewHolder>{

    private List<Planets> items;
    LayoutInflater layoutInflater;
    PlanetsClickListener callback;

    public interface PlanetsClickListener {
        void onPersonClick(Planets item);
    }


    public PlanetsAdapter(List<Planets> items) {
        this.items = items;
    }

    @Override
    public PlanetsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.people_list_row, parent, false);
        return new PlanetsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PlanetsViewHolder holder, int position) {
        final Planets person = items.get(position);
        holder.nameView.setText(person.getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Planets> list){
        items = list;
        notifyDataSetChanged();
    }

    public void setOnClickListener(PlanetsClickListener callback) {
        this.callback = callback;
    }

    class PlanetsViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.text1)
         TextView nameView;

        public PlanetsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.text1)
        public void onItemClick() {
            if(callback != null) {
                callback.onPersonClick(items.get(getAdapterPosition()));
            }
        }
    }

}

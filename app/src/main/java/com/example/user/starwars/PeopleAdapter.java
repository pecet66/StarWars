package com.example.user.starwars;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 08.07.2016.
 */
public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>{

    private ArrayList<Person> people;
    LayoutInflater layoutInflater;

    public PeopleAdapter() {
    }

    public PeopleAdapter(Context context, ResultSet people) {
        this.people = people.result;
        this.layoutInflater= layoutInflater;

        //super(context, R.layout.people_list_row, people);
    }

    @Override
    public PeopleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.people_list_row, parent, false);
        return new PeopleViewHolder(row);
        //return null;
    }

    @Override
    public void onBindViewHolder(PeopleViewHolder holder, int position) {
        holder.setPerson(people.get(position));
    }

    @Override
    public int getItemCount() {
        return people.size();
    }

    public class PeopleViewHolder extends RecyclerView.ViewHolder {
        private Person person;
        private TextView nameView;

        public PeopleViewHolder(View itemView) {
            super(itemView);
        }
        public void setPerson(Person person) {
            this.person = person;
            nameView.setText(person.name);
        }

    }
}

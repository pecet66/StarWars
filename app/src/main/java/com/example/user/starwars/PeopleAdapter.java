package com.example.user.starwars;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    public PeopleAdapter(ArrayList<Person> people, LayoutInflater layoutInflater) {
        this.people = people;
        this.layoutInflater= layoutInflater;
    }

    public void add(ArrayList<Person> list){
        people = list;
        notifyDataSetChanged();
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
            nameView = (TextView) itemView.findViewById(R.id.textView);
            nameView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.i("asd", (person.name));

                }
            });
        }
        public void setPerson(Person person) {
            this.person = person;
            nameView.setText(person.name);
        }

    }
}

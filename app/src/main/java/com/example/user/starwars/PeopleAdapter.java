package com.example.user.starwars;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 08.07.2016.
 */
public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>{

    private ArrayList<Person> people;
    LayoutInflater layoutInflater;


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
        private TextView nameTextView;
        private TextView birthTextView;

        public PeopleViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.textView);
            birthTextView = (TextView) itemView.findViewById(R.id.textView2);
            nameTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Context context = view.getContext();
                    Intent details = new Intent(context, DetailsActivity.class);
                    details.putExtra("Person", person);
                    context.startActivity(details);
                }
            });
        }
        public void setPerson(Person person) {
            this.person = person;
            nameTextView.setText(person.name);
            birthTextView.setText(person.birthYear);
        }

    }
}

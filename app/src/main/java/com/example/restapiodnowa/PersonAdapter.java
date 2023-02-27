package com.example.restapiodnowa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private ArrayList<Person> people;
    public PersonAdapter(ArrayList<Person> people) {
        this.people = people;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView photo;
        private TextView name;
        private TextView age;
        private TextView address;
        private TextView email;
        private TextView gender;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            photo = (ImageView) itemView.findViewById(R.id.personImage);
            name = (TextView) itemView.findViewById(R.id.nameSurname);
            age = (TextView) itemView.findViewById(R.id.age);
            address = (TextView) itemView.findViewById(R.id.address);
            email = (TextView) itemView.findViewById(R.id.email);
            gender = (TextView) itemView.findViewById(R.id.gender);
        }
    }
    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {
        holder.name.setText(people.get(position).getName());
        holder.age.setText(people.get(position).getAge());
        holder.address.setText(people.get(position).getAddress());
        holder.email.setText(people.get(position).getEmail());
        holder.gender.setText(people.get(position).getGender());
        Picasso.get()
                .load(people.get(position).getPicture())
                .resize(500, 500)
                .centerCrop()
                .into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return people.size();
    }


}

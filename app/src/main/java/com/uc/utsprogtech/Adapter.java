package com.uc.utsprogtech;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ExampleViewHolder> {
    private ArrayList<AdapterUser> ArrayUser;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public TextView displayname;
        public TextView displayage;
        public TextView displayaddress;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            displayname = itemView.findViewById(R.id.name);
            displayage = itemView.findViewById(R.id.age);
            displayaddress = itemView.findViewById(R.id.address);
        }
    }

    public Adapter(ArrayList<AdapterUser> ArrayUser){
        this.ArrayUser = ArrayUser;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ArrayUser.get(position);
        holder.displayname.setText(ArrayUser.get(position).getmName());
        holder.displayage.setText(ArrayUser.get(position).getmAge() + " years old.");
        holder.displayaddress.setText(ArrayUser.get(position).getmAddress());
    }

    @Override
    public int getItemCount() {
        return ArrayUser.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView name, age, address;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.name);
            age = itemView.findViewById(R.id.age);
            address = itemView.findViewById(R.id.address);
        }
    }
}

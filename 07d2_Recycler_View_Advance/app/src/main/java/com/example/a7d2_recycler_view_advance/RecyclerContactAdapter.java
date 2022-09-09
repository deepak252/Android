package com.example.a7d2_recycler_view_advance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {
    ArrayList<Contact> contacts;
    Context context;
    RecyclerContactAdapter(Context context, ArrayList<Contact> contacts){
        this.context = context;
        this.contacts=contacts;
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        TextView txtName,txtPhone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.txtName);
            txtPhone = itemView.findViewById(R.id.txtPhone);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(contacts.get(position).name);
        holder.txtPhone.setText(contacts.get(position).phone);

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}

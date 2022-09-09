package com.example.a7b_custom_adapter_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyCustomAdapter extends ArrayAdapter<User> {
    private User[] users;
    private Context context;
    public MyCustomAdapter(@NonNull Context context, int resource, @NonNull User[] users) {
        super(context, resource, users);
        this.users=users;
        this.context=context;
    }

    @Nullable
    @Override
    public User getItem(int position) {
//        return super.getItem(position);
        return users[position];
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        convertView = LayoutInflater.from(context).inflate(R.layout.list_tile_layout,parent,false);
        TextView textName = convertView.findViewById(R.id.text_title);
        TextView textDescription = convertView.findViewById(R.id.text_description);
        final User user = getItem(position);
        textName.setText(user.name);
        textDescription.setText(user.email);
        //Show Phone No. in Snackbar
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText( getContext(),user.phone, Toast.LENGTH_SHORT).show();
                Toast.makeText( context,user.phone, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}

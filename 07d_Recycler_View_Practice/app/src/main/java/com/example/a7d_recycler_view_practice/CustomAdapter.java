

package com.example.a7d_recycler_view_practice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    final Contact[] contacts;
    private TextView textViewSno;
    private TextView textViewName;
    private TextView textViewPhone;

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        public ViewHolder(View view){
            super(view);
        }
    }

    public CustomAdapter(Contact[] contacts){
        this.contacts = contacts;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.item_contact,
                viewGroup,
                false
        );
        textViewSno = view.findViewById(R.id.text_sno);
        textViewName = view.findViewById(R.id.text_name);
        textViewPhone = view.findViewById(R.id.text_phone);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position){
        textViewSno.setText(String.valueOf(contacts[position].sno));
        textViewName.setText(contacts[position].name);
        textViewPhone.setText(contacts[position].phone);
    }

    @Override
    public int getItemCount() {
        return contacts.length;
    }
}
//
//
//
//
//public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
//    final Contact[] contacts;
//
//    public static class ViewHolder extends  RecyclerView.ViewHolder{
//
//        private final TextView textViewSno;
//        private final TextView textViewName;
//        private final TextView textViewPhone;
//
//        public ViewHolder(View view){
//            super(view);
//            textViewSno = (TextView) view.findViewById(R.id.text_sno);
//            textViewName = (TextView)view.findViewById(R.id.text_name);
//            textViewPhone = (TextView)view.findViewById(R.id.text_phone);
//        }
//        public TextView getTextViewSno(){
//            return textViewSno;
//        };
//        public TextView getTextViewName(){
//            return textViewName;
//        };
//        public TextView getTextViewPhone(){
//            return textViewPhone;
//        };
//    }
//
//    public CustomAdapter(Contact[] contacts){
//        this.contacts = contacts;
//    }
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
//                R.layout.item_contact,
//                viewGroup,
//                false
//        );
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder viewHolder, final int position){
//        viewHolder.getTextViewSno().setText(contacts[position].sno);
//        viewHolder.getTextViewName().setText(contacts[position].name);
//        viewHolder.getTextViewPhone().setText(contacts[position].phone);
//    }
//
//    @Override
//    public int getItemCount() {
//        return contacts.length;
//    }
//}

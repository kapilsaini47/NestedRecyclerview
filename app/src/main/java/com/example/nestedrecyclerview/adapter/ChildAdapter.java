package com.example.nestedrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedrecyclerview.R;
import com.example.nestedrecyclerview.model.ChildModel;

import java.util.List;

// Adapter for displaying a list of ChildModel items in a Child RecyclerView
public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> {

    // List of ChildModel items to display
    List<ChildModel> childItemsList;

    // Context of the adapter
    Context context;

    // Constructor to initialize the adapter with data and context
    public ChildAdapter(List<ChildModel> childItemsList, Context context) {
        this.childItemsList = childItemsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChildAdapter.ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for a single item view and create a new ChildViewHolder
        return new ChildViewHolder(LayoutInflater.from(context).inflate(R.layout.single_item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChildAdapter.ChildViewHolder holder, int position) {
        // Bind the ChildModel item at the specified position to the view holder
        holder.bind(childItemsList.get(position));
    }

    // Return total number of items in the list
    @Override
    public int getItemCount() {
        return childItemsList.size();
    }


    // ViewHolder class to hold views for individual child items
    public static class ChildViewHolder extends RecyclerView.ViewHolder {

        // TextView to display the item's string
        TextView itemString;

        // Bind data from a ChildModel to the view holder's views
        private void bind(ChildModel childModel){
            itemString.setText(childModel.getItem());
        }

        // Constructor for the view holder, initializing views
        public ChildViewHolder(@NonNull View itemView) {
            super(itemView);
            itemString = itemView.findViewById(R.id.tvString);
        }
    }

}

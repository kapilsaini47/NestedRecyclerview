package com.example.nestedrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nestedrecyclerview.R;
import com.example.nestedrecyclerview.model.ParentModel;

import java.util.List;

// Adapter for displaying a list of ChildModel items in a Parent RecyclerView
public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.ParentViewHolder> {

    // List of Parent Model items to display
    List<ParentModel> parentModelList;
    //Context of the Parent adapter
    Context context;

    // Constructor to initialize the adapter with data and context
    public ParentAdapter(List<ParentModel> parentModelList,Context context) {
        this.parentModelList = parentModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ParentAdapter.ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for a child recycler view and create a new ParentViewHolder
        return new ParentViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.child_rv,null,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ParentAdapter.ParentViewHolder holder, int position) {

        // Bind the title of the parent item at the given position to the ViewHolder
        holder.title.setText(parentModelList.get(position).getTitle());

        // Create a new ChildAdapter instance for the current parent item's data
        ChildAdapter childAdapter;
        childAdapter = new ChildAdapter(parentModelList.get(position).getData(),context);

        // Set up a horizontal LinearLayoutManager for the child RecyclerView
        holder.rvChild.setLayoutManager(
                new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));

        // Set the child adapter for the child RecyclerView
        holder.rvChild.setAdapter(childAdapter);

        // Notify the child adapter that the data set has changed
        childAdapter.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        // Return the total number of parent items
        return parentModelList.size();
    }

    // ViewHolder class to hold views for individual parent items
    public static class ParentViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rvChild; //Child Recycler View for child item
        TextView title; //Text view for child item's title

        // Constructor for the parent ViewHolder, initializing views
        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);
           rvChild = itemView.findViewById(R.id.child_rv);
           title = itemView.findViewById(R.id.tv_title);
        }
    }
}

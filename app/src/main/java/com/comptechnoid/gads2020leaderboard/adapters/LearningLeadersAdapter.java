package com.comptechnoid.gads2020leaderboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.comptechnoid.gads2020leaderboard.R;
import com.comptechnoid.gads2020leaderboard.service.LearningLeader;

import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder> {

    private Context ctx;
    private List<LearningLeader> data;

    public LearningLeadersAdapter(Context ctx, List<LearningLeader> data) {
        this.ctx = ctx;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.learnin_leaders_vh, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
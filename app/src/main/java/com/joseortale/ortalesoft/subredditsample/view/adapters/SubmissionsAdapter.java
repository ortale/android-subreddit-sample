package com.joseortale.ortalesoft.subredditsample.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joseortale.ortalesoft.subredditsample.R;
import com.joseortale.ortalesoft.subredditsample.model.Submission;

import java.util.List;

public class SubmissionsAdapter extends RecyclerView.Adapter<SubmissionsAdapter.ViewHolder> {
    private List<Submission> data;
    private LayoutInflater inflater;
    private Context context;

    public SubmissionsAdapter(Context context, List<Submission> data) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);

        context = recyclerView.getContext();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.submission_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Submission submission = data.get(position);
        holder.bind(submission);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView tvTitle;
        private final TextView tvAuthorName;

        ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvAuthorName = itemView.findViewById(R.id.tv_author_name);
            itemView.setOnClickListener(this);
        }

        public void bind(Submission submission) {
            tvTitle.setText(submission.getTitle());
            tvAuthorName.setText(submission.getAuthorName());
        }

        @Override
        public void onClick(View view) {
            Submission submission = data.get(getBindingAdapterPosition());

            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(submission.getUrl()));
            context.startActivity(browserIntent);
        }
    }
}

package com.joseortale.ortalesoft.subredditsample.view.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.joseortale.ortalesoft.subredditsample.R;
import com.joseortale.ortalesoft.subredditsample.model.Submission;
import com.joseortale.ortalesoft.subredditsample.view.adapters.SubmissionsAdapter;
import com.joseortale.ortalesoft.subredditsample.viewmodel.SubmissionsViewModel;

import java.util.ArrayList;
import java.util.List;

public class SubmissionsFragment extends Fragment {
    private Context context;

    private List<Submission> submissionArrayList = new ArrayList<>();
    private RecyclerView.Adapter submissionsAdapter;
    private RecyclerView rvSubmissions;
    private SubmissionsViewModel submissionsViewModel;
    private LinearLayoutManager layoutManager;

    public static SubmissionsFragment newInstance() {
        SubmissionsFragment fragment = new SubmissionsFragment();

        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_submissions, container, false);

        rvSubmissions = view.findViewById(R.id.rv_submissions);

        layoutManager = new LinearLayoutManager(context);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvSubmissions.getContext(), layoutManager.getOrientation());
        rvSubmissions.addItemDecoration(dividerItemDecoration);

        submissionsViewModel = ViewModelProviders.of(this).get(SubmissionsViewModel.class);
        submissionsViewModel.init(context);
        submissionsViewModel.getSubmissionsRepository().observe(this, albumArrayList -> {
            this.submissionArrayList = albumArrayList;
            refreshRecyclerView();
        });

        refreshRecyclerView();

        return view;
    }

    private void refreshRecyclerView() {
        submissionsAdapter = new SubmissionsAdapter(context, submissionArrayList);

        rvSubmissions.setLayoutManager(new LinearLayoutManager(context));
        rvSubmissions.setAdapter(submissionsAdapter);
        rvSubmissions.setItemAnimator(new DefaultItemAnimator());
        rvSubmissions.setNestedScrollingEnabled(true);
        submissionsAdapter.notifyDataSetChanged();
    }
}

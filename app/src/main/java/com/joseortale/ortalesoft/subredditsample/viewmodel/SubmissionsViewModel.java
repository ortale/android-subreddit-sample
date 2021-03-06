package com.joseortale.ortalesoft.subredditsample.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.joseortale.ortalesoft.subredditsample.data.api.SubmissionsRepository;
import com.joseortale.ortalesoft.subredditsample.model.Submission;

import java.util.List;

public class SubmissionsViewModel extends ViewModel {
    private MutableLiveData<List<Submission>> mutableLiveData;
    private SubmissionsRepository submissionsRepository;

    public void init(Context context) {
        submissionsRepository = SubmissionsRepository.getInstance(context);
        mutableLiveData = submissionsRepository.getAllSubmissions();
    }

    public void getAllSubmissionsByPage(Context context, String page) {
        submissionsRepository = SubmissionsRepository.getInstance(context);
        mutableLiveData = submissionsRepository.getAllSubmissionsByPage(page);
    }

    public LiveData<List<Submission>> getSubmissionsRepository() {
        return mutableLiveData;
    }
}

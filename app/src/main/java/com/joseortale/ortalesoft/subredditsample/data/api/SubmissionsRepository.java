package com.joseortale.ortalesoft.subredditsample.data.api;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import com.joseortale.ortalesoft.subredditsample.data.database.AppDatabase;
import com.joseortale.ortalesoft.subredditsample.data.database.SubmissionDao;
import com.joseortale.ortalesoft.subredditsample.model.Submission;
import com.joseortale.ortalesoft.subredditsample.model.apiresponse.ApiResponse;
import com.joseortale.ortalesoft.subredditsample.model.apiresponse.Children;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmissionsRepository {
    private static SubmissionsRepository instance;

    private final ApiEndpoints apiEndpoints;
    private AppDatabase database;
    private SubmissionDao submissionDao;
    private List<Submission> submissions;

    private SubmissionsRepository(Context context) {
        apiEndpoints = RetrofitClient.getClient();
        database = Room.databaseBuilder(context, AppDatabase.class, "submissions").allowMainThreadQueries().build();
        submissionDao = database.submissionDao();
    }

    public static SubmissionsRepository getInstance(Context context) {
        if (instance == null) {
            instance = new SubmissionsRepository(context);
        }

        return instance;
    }

    private boolean doesAlbumExists(Submission submission) {
        submissions = submissionDao.getAll();

        for (Submission existingAlbum : submissions) {
            if (existingAlbum.getId().equals(submission.getId())) {
                return true;
            }
        }

        return false;
    }

    private void insertSubmissions(List<Submission> submissions) {
        for (Submission submission : submissions) {
            if (!doesAlbumExists(submission)) {
                submissionDao.insertAll(submission);
            }

            else {
                submissionDao.update(submission);
            }
        }
    }

    public MutableLiveData<List<Submission>> getAllSubmissions() {
        MutableLiveData<List<Submission>> submissionsData = new MutableLiveData<>();
        submissions = new ArrayList<>();

        apiEndpoints.getAll().enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    ApiResponse apiResponse = response.body();

                    if (apiResponse != null) {
                        List<Children> childrenList = apiResponse.getResponseData().getChildren();

                        submissions = new ArrayList<>();
                        for (Children children : childrenList) {
                            submissions.add(children.getSubmission());
                        }

                        submissionsData.setValue(submissions);
                        insertSubmissions(submissions);
                    }

                    else {
                        Log.v("SubmissionsRepository", "Error status " + response.code());
                    }
                }

                else {
                    submissions = submissionDao.getAll();
                    submissionsData.setValue(submissions);
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                submissions = submissionDao.getAll();
                submissionsData.setValue(submissions);
            }
        });

        return submissionsData;
    }

    public MutableLiveData<List<Submission>> getAllSubmissionsByPage(String after) {
        MutableLiveData<List<Submission>> submissionsData = new MutableLiveData<>();
        submissions = new ArrayList<>();

        apiEndpoints.getAllByPage(after).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    ApiResponse apiResponse = response.body();

                    if (apiResponse != null) {
                        List<Children> childrenList = apiResponse.getResponseData().getChildren();

                        submissions = new ArrayList<>();
                        for (Children children : childrenList) {
                            submissions.add(children.getSubmission());
                        }

                        submissionsData.setValue(submissions);
                        insertSubmissions(submissions);
                    }

                    else {
                        Log.v("SubmissionsRepository", "Error status " + response.code());
                    }
                }

                else {
                    submissions = submissionDao.getAll();
                    submissionsData.setValue(submissions);
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                submissions = submissionDao.getAll();
                submissionsData.setValue(submissions);
            }
        });

        return submissionsData;
    }
}

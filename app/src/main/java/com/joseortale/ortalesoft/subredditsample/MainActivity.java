package com.joseortale.ortalesoft.subredditsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.joseortale.ortalesoft.subredditsample.data.api.SubmissionsRepository;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SubmissionsRepository repository = SubmissionsRepository.getInstance(this);
        repository.getAllSubmissions();
    }
}
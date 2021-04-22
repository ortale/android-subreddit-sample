package com.joseortale.ortalesoft.subredditsample.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.joseortale.ortalesoft.subredditsample.model.Submission;

@Database(entities = {Submission.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SubmissionDao submissionDao();
}

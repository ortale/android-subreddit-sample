package com.joseortale.ortalesoft.subredditsample.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.joseortale.ortalesoft.subredditsample.model.Submission;

import java.util.List;

@Dao
public interface SubmissionDao {
    @Query("SELECT * FROM submission")
    List<Submission> getAll();

    @Query("SELECT * FROM submission WHERE id IN (:id)")
    List<Submission> loadAllById(int id);

    @Insert
    void insertAll(Submission... submissions);

    @Update
    void update(Submission submission);
}

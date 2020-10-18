package com.example.testpproject.jobservice;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

public class JobSchedulerService extends JobService {

    private static final String TAG = JobSchedulerService.class.getSimpleName();

    @Override
    public boolean onStartJob(JobParameters params) {

        Log.e("=====", "onstartJob");
        jobFinished(params, true);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {

        Log.e("=====", "onstopJob");


        return false;
    }


}

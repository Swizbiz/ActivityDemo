package com.swizbiz.activitydemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.swizbiz.activitydemo.utils.DataGenerator;

import java.util.Arrays;
import java.util.Random;

public class Account extends Activity {
    private static final String SAVED_PARCEL_TEST_MODEL = "PARCEL";
    private TestModel testModel;

    private TextView accountNameTextView;
    private TextView accountLastNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        accountNameTextView = findViewById(R.id.text_view_account_name);
        accountLastNameTextView = findViewById(R.id.text_view_account_last_name);

        if (savedInstanceState == null) {
            testModel = new TestModel();
            DataGenerator.fillTestModel(testModel);
            accountNameTextView.setText(testModel.getName());
            accountLastNameTextView.setText(testModel.getLastName());
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(SAVED_PARCEL_TEST_MODEL, testModel);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        testModel = savedInstanceState.getParcelable(SAVED_PARCEL_TEST_MODEL);
        if (testModel != null) {
            accountNameTextView.setText(testModel.getName());
            accountLastNameTextView.setText(testModel.getLastName());
        }
        super.onRestoreInstanceState(savedInstanceState);
    }
}

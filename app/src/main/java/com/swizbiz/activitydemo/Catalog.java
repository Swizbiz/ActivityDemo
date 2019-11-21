package com.swizbiz.activitydemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.swizbiz.activitydemo.utils.DataGenerator;

import java.util.Arrays;
import java.util.Random;

public class Catalog extends Activity {
    private static final String SAVED_PARCEL_TEST_MODEL = "PARCEL";
    private TestModel testModel;

    private TextView catalogNameTextView;
    private TextView catalogLastNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        catalogNameTextView = findViewById(R.id.text_view_catalog_name);
        catalogLastNameTextView = findViewById(R.id.text_view_catalog_last_name);

        if (savedInstanceState == null) {
            testModel = new TestModel();
            DataGenerator.fillTestModel(testModel);
            catalogNameTextView.setText(testModel.getName());
            catalogLastNameTextView.setText(testModel.getLastName());
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
            catalogNameTextView.setText(testModel.getName());
            catalogLastNameTextView.setText(testModel.getLastName());
        }
        super.onRestoreInstanceState(savedInstanceState);
    }
}

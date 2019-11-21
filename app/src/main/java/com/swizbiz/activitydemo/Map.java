package com.swizbiz.activitydemo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.swizbiz.activitydemo.utils.DataGenerator;

import java.util.Arrays;
import java.util.Random;

public class Map extends AppCompatActivity {
    private static final String SAVED_PARCEL_TEST_MODEL = "PARCEL";
    private TestModel testModel;
    private TextView mapNameTextView;
    private TextView mapLastNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mapNameTextView = findViewById(R.id.text_view_map_name);
        mapLastNameTextView = findViewById(R.id.text_view_map_last_name);

        if (savedInstanceState == null) {
            testModel = new TestModel();
            DataGenerator.fillTestModel(testModel);
            mapNameTextView.setText(testModel.getName());
            mapLastNameTextView.setText(testModel.getLastName());
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
            mapNameTextView.setText(testModel.getName());
            mapLastNameTextView.setText(testModel.getLastName());
        }
        super.onRestoreInstanceState(savedInstanceState);
    }
}

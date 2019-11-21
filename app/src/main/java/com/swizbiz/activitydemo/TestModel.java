package com.swizbiz.activitydemo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class TestModel implements Parcelable {
    public TestModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    private String name;
    private String lastName;

    private List<String> numbers;
    private List<String> addresses;

    protected TestModel(Parcel in) {
        name = in.readString();
        lastName = in.readString();
        numbers = in.createStringArrayList();
        addresses = in.createStringArrayList();
    }

    public static final Creator<TestModel> CREATOR = new Creator<TestModel>() {
        @Override
        public TestModel createFromParcel(Parcel in) {
            return new TestModel(in);
        }

        @Override
        public TestModel[] newArray(int size) {
            return new TestModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lastName);
        dest.writeStringList(numbers);
        dest.writeStringList(addresses);
    }
}

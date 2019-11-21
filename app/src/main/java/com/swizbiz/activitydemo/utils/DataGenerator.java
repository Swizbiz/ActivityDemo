package com.swizbiz.activitydemo.utils;

import com.swizbiz.activitydemo.TestModel;

import java.util.Arrays;
import java.util.Random;

public class DataGenerator {
    private static String generateString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";

        StringBuilder result = new StringBuilder();
        Random random = new Random();
        while(length > 0) {
            result.append(characters.charAt(random.nextInt(characters.length())));
            length--;
        }
        return result.toString();
    }

    public static TestModel fillTestModel(TestModel testModel) {
        Random rand = new Random();
        String generatedNameString = DataGenerator.generateString(rand.nextInt(15));
        testModel.setName(generatedNameString);
        String generatedLastNameString = DataGenerator.generateString(rand.nextInt(15));
        testModel.setLastName(generatedLastNameString);
        testModel.setNumbers(Arrays.asList(generatedNameString, generatedLastNameString));
        testModel.setAddresses(Arrays.asList(generatedLastNameString, generatedNameString));
        return testModel;
    }
}

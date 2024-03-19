package com.nhnacademy.quiz;

import org.json.JSONArray;
import org.json.JSONObject;

public class Quiz06 {
    public static void main(String[] args) {
        String[] birds = { "갈매기", "참새", "펭귄" };
        JSONArray birdArray = new JSONArray(birds);
        JSONObject birdObject = new JSONObject();
        birdObject.put("조류", birdArray);

        String[] mammals = { "사자", "호랑이", "말" };
        JSONArray mammalArray = new JSONArray(mammals);
        JSONObject mammalObject = new JSONObject();
        mammalObject.put("포유류", mammalArray);

        JSONArray animalArray = new JSONArray();
        animalArray.put(birdObject);
        animalArray.put(mammalObject);
        JSONObject animalObject = new JSONObject();
        animalObject.put("동물", animalArray);

        System.out.println(animalObject);
    }
}

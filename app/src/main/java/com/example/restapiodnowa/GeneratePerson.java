package com.example.restapiodnowa;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class GeneratePerson extends AsyncTask {
    String TAG = "restapi";
    InputStream inputStream;
    URL url = null;
    String[] array = new String[3];

    Context context;

    ArrayList<Person> people;

    public GeneratePerson(Context context, ArrayList<Person> people) {
        this.context = context;
        this.people = people;
    }

    @Override
    protected void onPreExecute() {
        Log.v(TAG, "Start onPreExecute()");
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        Log.v(TAG, "Start doInBackground()");
        try{
            url = new URL("https://randomuser.me/api");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try{
            inputStream = url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] buffer = new byte[4096];
        StringBuilder stringBuilder = new StringBuilder("");
        while(true){
            try {
                if(!(inputStream.read(buffer) > 0)) break;
            } catch (IOException e){
                e.printStackTrace();
            }
            stringBuilder.append(new String(buffer));
        }
        try {
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("results");

            JSONObject person = jsonArray.getJSONObject(0);
            JSONObject name = person.getJSONObject("name");
            String stringName = name.getString("title")
                    + " " + name.getString("first")
                    + " " + name.getString("last");
            String email = person.getString("email");
            String gender = person.getString("gender");

            JSONObject images = person.getJSONObject("picture");
            String pictureLink = images.getString("large");

            JSONObject dob = person.getJSONObject("dob");
            String age = dob.getString("age");

            JSONObject location = person.getJSONObject("location");
            String address = location.getString("country");

            publishProgress(stringName, 0);
            publishProgress(age, 1);
            publishProgress(address, 2);
            publishProgress(email, 3);
            publishProgress(gender, 4);
            publishProgress(pictureLink, 5);
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        publishProgress(stringBuilder.toString());
        return null;
    }

    public String getValues(int index){
        return array[index];
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        Log.v(TAG, "Start onProgressUpdate()");
        Log.v(TAG, values[0].toString());
        Log.v(TAG, "values[1] = " + values[1]);
        Person person = new Person();
        switch (Integer.parseInt(values[1]+"")){
            case 0:
                person.setName(values[0].toString());
            case 1:
                person.setAge(Integer.parseInt(values[0].toString()));
            case 2:
                person.setAddress(values[0].toString());
            case 3:
                person.setEmail(values[0].toString());
            case 4:
                person.setGender(values[0].toString());
            case 5:
                person.setPicture(values[0].toString());
            super.onProgressUpdate(values);
        }
        Log.i("personString", person.toString());
        people.add(person);

    }
    @Override
    protected void onPostExecute(Object o) {
        Log.v(TAG, "Start onPostExecute()");
        super.onPostExecute(o);
    }
}

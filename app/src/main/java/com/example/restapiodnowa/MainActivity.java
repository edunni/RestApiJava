package com.example.restapiodnowa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<Person> people = new ArrayList<Person>();
        GeneratePerson generatePerson = new GeneratePerson(getApplicationContext(), people);
        generatePerson.execute();

        //TODO:
        //return arraylist of people
        //adapter


//        Picasso.get()
//                .load(values[0].toString())
//                .resize(500, 500)
//                .centerCrop()
//                .into(Timage);
    }
}
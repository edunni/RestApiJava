package com.example.restapiodnowa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button button;
    PersonAdapter pAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.addPersonButton);
        recyclerView = findViewById(R.id.recyclerV);

        ArrayList<Person> people = new ArrayList<Person>();


        button.setOnClickListener(click->{
            GeneratePerson generatePerson = new GeneratePerson(MainActivity.this, people);
            generatePerson.execute();
            Log.i("peopleArray", people.toString());
            pAdapter = new PersonAdapter(people);
            recyclerView.setAdapter(pAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        });


    }
}
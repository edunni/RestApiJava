package com.example.restapiodnowa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageButton buttonAdd;
    ImageButton buttonReset;
    PersonAdapter pAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.addPersonButton);
        buttonReset = findViewById(R.id.resetAll);
        recyclerView = findViewById(R.id.recyclerV);

        ArrayList<Person> people = new ArrayList<Person>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonAdd.setOnClickListener(click->{
            GeneratePerson generatePerson = new GeneratePerson(MainActivity.this, people);
            generatePerson.execute();
//            Log.i("peopleArray", people.toString());
            pAdapter = new PersonAdapter(people);
            recyclerView.setAdapter(pAdapter);
        });

        buttonReset.setOnClickListener(click->{
            people.clear();
            pAdapter = new PersonAdapter(people);
            recyclerView.setAdapter(pAdapter);
        });

    }
}
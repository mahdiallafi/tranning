package com.example.tranning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      recyclerView=findViewById(R.id.recycle);
      /////Add list of items
        ArrayList<Contact> contacts=new ArrayList<>();
        contacts.add(new Contact("Mahdi",671586,"data:image/jpeg;base64,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"));
        contacts.add(new Contact("ta",32564,"data:image/jpeg;base64,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"));
        ContactAdapter servicesAdapter=new ContactAdapter( this);
        servicesAdapter.setContacts(contacts);
        recyclerView.setAdapter(servicesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));






    }
}
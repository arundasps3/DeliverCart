package com.arundas.delivercart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.arundas.delivercart.R;

import java.util.Arrays;
import java.util.List;

public class Walmart extends AppCompatActivity implements RecyclerAdapter.OnNoteListner {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    List<String>list;

    RecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walmart);

        recyclerView= findViewById(R.id.recyclerview);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

   list= Arrays.asList(getResources().getStringArray(R.array.WalmartItems));
   adapter=new RecyclerAdapter(list);
   recyclerView.setHasFixedSize(true);
   recyclerView.setAdapter(adapter);






    }


    @Override
    public void OnNoteClick(int position) {



    }
}

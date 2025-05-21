package thebao.edu.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import thebao.edu.noteapp.Adapters.NotesListAdapter;
import thebao.edu.noteapp.DataBase.RoomDB;
import thebao.edu.noteapp.Models.Notes;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NotesListAdapter notesListAdapter;
    List<Notes> notes = new ArrayList<>();
     RoomDB database;
     FloatingActionButton fab_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        fab_btn = findViewById(R.id.fab_add_btn);

        database = RoomDB.getInstance(this);
        notes= database.dao().getAll();
        updateRecycler(notes);


        fab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             Intent intent = new Intent(MainActivity.this, NotesActivity.class);
             startActivityForResult(intent, 101);
            }
        });

    }
    private void updateRecycler(List<Notes> notes){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL));

        notesListAdapter = new NotesListAdapter(MainActivity.this, notes,notesClick);

        recyclerView.setAdapter(notesListAdapter);

    }
    private final NotesClick notesClick = new NotesClick() {
        @Override
        public void onClick(Notes notes) {

        }

        @Override
        public void onLongClick(Notes notes, CardView cardView) {

        }
    };
}

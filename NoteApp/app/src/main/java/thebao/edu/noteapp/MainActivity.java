package thebao.edu.noteapp;

import static java.util.Locale.filter;

import static thebao.edu.noteapp.R.id.pin;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.core.view.GravityCompat;
import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    RecyclerView recyclerView;
    NotesListAdapter notesListAdapter;
    List<Notes> notes = new ArrayList<>();
     RoomDB database;
     FloatingActionButton fab_btn;
     SearchView searchView;

     Notes selected_notes;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        fab_btn = findViewById(R.id.fab_add_btn);
        searchView= findViewById(R.id.search_view);

        database = RoomDB.getInstance(this);
        notes= database.dao().getAll();
        updateRecycler(notes);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

// Mở Navigation Drawer khi nhấn nút Home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu); // icon menu

// Xử lý khi chọn item trong Navigation Drawer
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_settings) {
                showBackgroundPickerDialog();
            } else if (id == R.id.nav_share) {
                Toast.makeText(this, "Chia sẻ", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_about) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            } else if (id == R.id.nav_exit) {
                finish();
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });


        fab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             Intent intent = new Intent(MainActivity.this, NotesActivity.class);
             startActivityForResult(intent, 101);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                filter(newText);
                return false;
            }
        });

        int savedBg = getSharedPreferences("settings", MODE_PRIVATE).getInt("background", -1);
        if (savedBg != -1) {
            applyBackground(savedBg);
        }

    }

    private void filter(String newText) {

        List<Notes> filter_list = new ArrayList<>();
        for (Notes single_notes : notes){
            if (single_notes.getTittle().toLowerCase().contains(newText.toLowerCase())
            || single_notes.getNotes().toLowerCase().contains(newText.toLowerCase())){
                filter_list.add(single_notes);

            }

        }
        notesListAdapter.filtered_list(filter_list);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==101){
            if (resultCode == Activity.RESULT_OK){
                Notes new_notes = (Notes) data.getSerializableExtra("note");
                database.dao().insert(new_notes);
                notes.clear();
                notes.addAll(database.dao().getAll());
                notesListAdapter.notifyDataSetChanged();


            }
        }
        else if(requestCode==102)
            if (resultCode == Activity.RESULT_OK){
                Notes new_notes = (Notes) data.getSerializableExtra("note");
                database.dao().update(new_notes.getID(),new_notes.getTittle(),new_notes.getNotes());
                notes.clear();
                notes.addAll(database.dao().getAll());
                notesListAdapter.notifyDataSetChanged();

            }

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
            Intent intent = new Intent(MainActivity.this, NotesActivity.class);
            intent.putExtra("old_note", notes);
            startActivityForResult(intent,102);
        }

        @Override
        public void onLongClick(Notes notes, CardView cardView) {
        selected_notes = new Notes();
        selected_notes = notes;
        showPopup(cardView);


        }
    };

    private void showPopup(CardView cardView) {

        PopupMenu popupMenu = new PopupMenu(this, cardView);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.pop_up);
        popupMenu.show();

    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.pin) {
            if (selected_notes.isPinned()) {
                database.dao().pin(selected_notes.getID(), false);
                Toast.makeText(this, "Gỡ ghim", Toast.LENGTH_LONG).show();
            } else {
                database.dao().pin(selected_notes.getID(), true);
                Toast.makeText(this, "Đã ghim", Toast.LENGTH_LONG).show();
            }

            notes.clear();
            notes.addAll(database.dao().getAll());
            notesListAdapter.notifyDataSetChanged();
            return true;

        } else if (id == R.id.del) {
            database.dao().delete(selected_notes);
            notes.remove(selected_notes);
            notesListAdapter.notifyDataSetChanged();
            Toast.makeText(this, "Đã Xóa ghi chú !!!", Toast.LENGTH_LONG).show();
            return true;
        }

        return false;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showBackgroundPickerDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialog_background_picker, null);
        LinearLayout container = view.findViewById(R.id.background_container);

        // Danh sách các ảnh nền (tên trong drawable)
        int[] backgrounds = { R.drawable.bg1, R.drawable.bg2, R.drawable.bg3,
                              R.drawable.bg4, R.drawable.bg5 };

        for (int bg : backgrounds) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(bg);
            imageView.setAdjustViewBounds(true);
            imageView.setPadding(0, 20, 0, 20);

            imageView.setOnClickListener(v -> {
                saveBackgroundPreference(bg);
                applyBackground(bg);
            });

            container.addView(imageView);
        }

        builder.setView(view);
        builder.setTitle("Chọn ảnh nền");
        builder.setNegativeButton("Đóng", null);
        builder.show();
    }
    private void saveBackgroundPreference(int bgResId) {
        getSharedPreferences("settings", MODE_PRIVATE)
                .edit()
                .putInt("background", bgResId)
                .apply();
    }

    private void applyBackground(int bgResId) {
        RelativeLayout layout = findViewById(R.id.layout_nen); // bạn cần gán id cho layout
        layout.setBackgroundResource(bgResId);
    }
}


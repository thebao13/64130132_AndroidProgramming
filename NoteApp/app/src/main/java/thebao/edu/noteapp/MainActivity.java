package thebao.edu.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    private NoteAdapter noteAdapter;
    private ArrayList<Note> noteList;
    private NoteDatabaseHelper dbHelper;
    private EditText editTextSearch;
    private FloatingActionButton fabAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);
        editTextSearch = findViewById(R.id.editTextSearch);
        fabAdd = findViewById(R.id.fabAdd);

        dbHelper = new NoteDatabaseHelper(this);
        noteList = dbHelper.getAllNotes();

        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));
      //  noteAdapter = new NoteAdapter(noteList, this, dbHelper);
        recyclerViewNotes.setAdapter(noteAdapter);

        noteAdapter = new NoteAdapter(this, noteList, new NoteAdapter.OnNoteClickListener() {
            @Override
            public void onNoteClick(Note note) {
                // Khi click vào ghi chú -> sửa ghi chú
                Intent intent = new Intent(MainActivity.this, EditNoteActivity.class);
                intent.putExtra("note_id", note.getId());
                startActivity(intent);
            }

            @Override
            public void onNoteLongClick(Note note) {
                // Xử lý nhấn giữ (ví dụ: xóa ghi chú)
                dbHelper.deleteNote(note.getId());
                noteList.clear();
                noteList.addAll(dbHelper.getAllNotes());
                noteAdapter.notifyDataSetChanged();
            }
        });


        // Tìm kiếm ghi chú
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                noteAdapter.filter(s.toString());
            }
            @Override public void afterTextChanged(Editable s) {}
        });

        // Nhấn nút + để thêm ghi chú
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditNoteActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Cập nhật lại dữ liệu khi quay lại màn hình chính
        noteList.clear();
        noteList.addAll(dbHelper.getAllNotes());
        noteAdapter.notifyDataSetChanged();
    }
}

package thebao.edu.noteapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    EditText editTextNote;
    Button buttonSave;
    ListView listViewNotes;
    ArrayList<String> noteList;
    ArrayAdapter<String> adapter;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextNote = findViewById(R.id.editTextNote);
        buttonSave = findViewById(R.id.buttonSave);
        listViewNotes = findViewById(R.id.listViewNotes);

        sharedPreferences = getSharedPreferences("notes", Context.MODE_PRIVATE);

        // Khởi tạo danh sách
        noteList = new ArrayList<>();
        HashSet<String> savedNotes = (HashSet<String>) sharedPreferences.getStringSet("noteList", null);
        if (savedNotes != null) {
            noteList.addAll(savedNotes);
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, noteList);
        listViewNotes.setAdapter(adapter);

        // Nút lưu
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = editTextNote.getText().toString().trim();
                if (!note.isEmpty()) {
                    noteList.add(note);
                    adapter.notifyDataSetChanged();
                    editTextNote.setText("");

                    // Lưu lại
                    HashSet<String> set = new HashSet<>(noteList);
                    sharedPreferences.edit().putStringSet("noteList", set).apply();
                } else {
                    Toast.makeText(MainActivity.this, "Ghi chú trống!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Nhấn giữ để xóa ghi chú
        listViewNotes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                noteList.remove(position);
                adapter.notifyDataSetChanged();
                HashSet<String> set = new HashSet<>(noteList);
                sharedPreferences.edit().putStringSet("noteList", set).apply();
                return true;
            }
        });
    }
}
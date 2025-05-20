package thebao.edu.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditNoteActivity extends AppCompatActivity {
    EditText editText;
    Button buttonSave;
    NoteDatabaseHelper dbHelper;
    int noteId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        dbHelper = new NoteDatabaseHelper(this);
        editText = findViewById(R.id.editTextNote);
        buttonSave = findViewById(R.id.buttonSave);

        Intent intent = getIntent();
        noteId = intent.getIntExtra("note_id", -1);
        String content = intent.getStringExtra("note_content");

        if (content != null) {
            editText.setText(content);
        }

        buttonSave.setOnClickListener(v -> {
            String text = editText.getText().toString().trim();
            if (!text.isEmpty()) {
                if (noteId == -1) {
                    dbHelper.insertNote(text);
                } else {
                    dbHelper.updateNote(noteId, text);
                }
                finish();
            } else {
                Toast.makeText(this, "Nội dung trống!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


package thebao.edu.noteapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

import thebao.edu.noteapp.Models.Notes;

public class NotesActivity extends AppCompatActivity {

    EditText editText_tittle, editText_notes;
    ImageView image_save;
    Notes notes;
    boolean is_old_note = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notes);

        image_save = findViewById(R.id.image_view_save);
        editText_tittle = findViewById(R.id.edit_text_tittle);
        editText_notes = findViewById(R.id.ed_notes);

        // Nhận ghi chú cũ (nếu có)
        notes = (Notes) getIntent().getSerializableExtra("old_note");
        if (notes != null) {
            is_old_note = true;
            editText_tittle.setText(notes.getTittle());
            editText_notes.setText(notes.getNotes());
        } else {
            notes = new Notes(); // Nếu không có ghi chú cũ thì tạo mới
        }

        image_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tittle = editText_tittle.getText().toString();
                String description = editText_notes.getText().toString();

                if (description.isEmpty()) {
                    Toast.makeText(NotesActivity.this, "Hãy thêm ghi chú !!!", Toast.LENGTH_LONG).show();
                    return;
                }

                SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm a");
                Date date = new Date();

                notes.setTittle(tittle);
                notes.setNotes(description);
                notes.setDate(format.format(date));

                Intent intent = new Intent();
                intent.putExtra("note", notes);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}

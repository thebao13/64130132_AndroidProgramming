package thebao.edu.noteapp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import thebao.edu.noteapp.Models.Notes;

public class NotesActivity extends AppCompatActivity {

    EditText editText_tittle, editText_notes;
    ImageView image_save;
    Notes notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notes);


        image_save = findViewById(R.id.image_view_save);
        editText_tittle= findViewById(R.id.edit_text_tittle);
        editText_notes = findViewById(R.id.ed_notes);
    }
}
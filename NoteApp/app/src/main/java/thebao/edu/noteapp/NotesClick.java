package thebao.edu.noteapp;

import androidx.cardview.widget.CardView;

import thebao.edu.noteapp.Models.Notes;

public interface NotesClick {
    void onClick(Notes notes);
    void onLongClick (Notes notes, CardView cardView);
}

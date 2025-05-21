package thebao.edu.noteapp.Adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import thebao.edu.noteapp.R;

public class NotesListAdapter {
}

class NotesViewHolder extends RecyclerView.ViewHolder{

    CardView notes_container;
    TextView textView_tittle, textView_notes, textView_date;
    ImageView pin_image;
    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);

        notes_container= itemView.findViewById(R.id.note_card_container);
        textView_tittle= itemView.findViewById(R.id.title_text);
        textView_notes= itemView.findViewById(R.id.textview_notes);
        textView_date= itemView.findViewById(R.id.textview_date);
        pin_image= itemView.findViewById(R.id.image_view_pin);
    }
}
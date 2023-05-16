package homi.frontend.homiandroidfrontend.Models;

import android.widget.Button;

public class AnimalNoteWithButtonModel extends AnimalNotesModel
{
    public Button DeleteButton;

    public AnimalNoteWithButtonModel(Button _button, String _note, int _id, int _tiere_id)
    {
        DeleteButton = _button;
        id = _id;
        notiz = _note;
        tiere_id = _tiere_id;
    }
}

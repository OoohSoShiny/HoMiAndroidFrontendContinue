package homi.frontend.homiandroidfrontend.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import homi.frontend.homiandroidfrontend.Models.AnimalNotesModel;
import homi.frontend.homiandroidfrontend.R;
import homi.frontend.homiandroidfrontend.databinding.NotesRowlayoutBinding;

public class GeneralNotesAdapter extends ArrayAdapter<AnimalNotesModel>
{
    LayoutInflater inflater;
    private ArrayList<AnimalNotesModel> _notes;

    public GeneralNotesAdapter(Context context, List<AnimalNotesModel> standardNotes)
    {
        super(context, R.layout.notes_rowlayout);

        _notes = new ArrayList<AnimalNotesModel>();
        inflater = (LayoutInflater.from(context));

        if(standardNotes != null)
        {
            addAll(standardNotes);
        }
    }
    @Override public View getView(int i, View view, ViewGroup viewGroup)
    {
        NotesRowlayoutBinding binding;

        if (view == null)
        {
            binding = NotesRowlayoutBinding.inflate(inflater);
        }
        else
        {
            binding = NotesRowlayoutBinding.bind(view);
        }

        AnimalNotesModel currentNote = getItem(i);

        binding.noteLayoutnote.setText(currentNote.notiz);
        binding.noteLayoutid.setText(String.valueOf(currentNote.id));
        return binding.getRoot();
    }
}
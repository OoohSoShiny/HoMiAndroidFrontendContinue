package homi.frontend.homiandroidfrontend.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import homi.frontend.homiandroidfrontend.Models.AnimalNotesModel;
import homi.frontend.homiandroidfrontend.Models.PregnancyCheckupModel;
import homi.frontend.homiandroidfrontend.R;
import homi.frontend.homiandroidfrontend.databinding.NotesRowlayoutBinding;

public class NotesAdapter extends ArrayAdapter<String>
{
    LayoutInflater inflater;

    public NotesAdapter(Context context, List<String> standardNotes)
    {
        super(context, R.layout.notes_rowlayout);

        inflater = (LayoutInflater.from(context));

        if(standardNotes != null)
        {
            addAll(standardNotes);
        }
    }
    public NotesAdapter(Context context, List<PregnancyCheckupModel> pregnancyNotes, int counter)
    {
        super(context, R.layout.notes_rowlayout);

        inflater = (LayoutInflater.from(context));

        if(pregnancyNotes != null)
        {
            addAll(String.valueOf(pregnancyNotes));
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

        String currentNote = getItem(i);

        binding.noteLayout.setText(currentNote);

        return binding.getRoot();
    }
}
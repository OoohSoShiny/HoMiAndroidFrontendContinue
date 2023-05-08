package homi.frontend.homiandroidfrontend.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import homi.frontend.homiandroidfrontend.Models.CheckupNoteModel;
import homi.frontend.homiandroidfrontend.R;
import homi.frontend.homiandroidfrontend.databinding.CheckupnotesRowlayoutBinding;

public class PregnancyNotesAdapter extends ArrayAdapter<CheckupNoteModel>
{
    LayoutInflater inflater;
    private ArrayList<CheckupNoteModel> _notes;


    public PregnancyNotesAdapter(Context context, List<CheckupNoteModel> pregnancyNotes)
    {
        super(context, R.layout.checkupnotes_rowlayout);

        _notes = new ArrayList<CheckupNoteModel>();
        inflater = (LayoutInflater.from(context));

        if(pregnancyNotes != null)
        {
            addAll(pregnancyNotes);
        }
    }

    @Override public View getView(int i, View view, ViewGroup viewGroup)
    {
        CheckupnotesRowlayoutBinding binding;

        if (view == null)
        {
            binding = CheckupnotesRowlayoutBinding.inflate(inflater);
        }
        else
        {
            binding = CheckupnotesRowlayoutBinding.bind(view);
        }

        CheckupNoteModel currentNote = getItem(i);
        binding.TvNoteValue.setText(currentNote.notiz);
        binding.TvDateValue.setText(String.valueOf(currentNote.termin));
        return binding.getRoot();
    }
}

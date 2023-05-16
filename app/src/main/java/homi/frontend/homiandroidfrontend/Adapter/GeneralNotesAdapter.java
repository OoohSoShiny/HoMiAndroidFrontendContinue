package homi.frontend.homiandroidfrontend.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import homi.frontend.homiandroidfrontend.Globals;
import homi.frontend.homiandroidfrontend.Models.AnimalNotesModel;
import homi.frontend.homiandroidfrontend.Models.AnimalNoteWithButtonModel;
import homi.frontend.homiandroidfrontend.R;
import homi.frontend.homiandroidfrontend.Service.ApiCaller;
import homi.frontend.homiandroidfrontend.databinding.NotesRowlayoutBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GeneralNotesAdapter extends ArrayAdapter<AnimalNoteWithButtonModel>
{
    LayoutInflater inflater;
    boolean colorSet = false;

    public GeneralNotesAdapter(Context context, List<AnimalNoteWithButtonModel> standardNotes)
    {
        super(context, R.layout.notes_rowlayout);

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

        AnimalNoteWithButtonModel currentNote = getItem(i);

        binding.noteLayoutnote.setText(currentNote.notiz);
        binding.noteLayoutid.setText(String.valueOf(currentNote.tiere_id));


        if (colorSet)
        {
            colorSet = false;
            binding.noteLayoutid.setBackgroundColor(Globals.FirstRowColor);
            binding.noteLayoutnote.setBackgroundColor(Globals.FirstRowColor);
        }

        else
        {
            colorSet = true;
            binding.noteLayoutid.setBackgroundColor(Globals.SecondRowColor);
            binding.noteLayoutnote.setBackgroundColor(Globals.SecondRowColor);
        }
        return binding.getRoot();
    }
}
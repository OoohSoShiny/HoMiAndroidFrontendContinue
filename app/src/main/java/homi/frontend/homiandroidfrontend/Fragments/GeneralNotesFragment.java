package homi.frontend.homiandroidfrontend.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import homi.frontend.homiandroidfrontend.Adapter.GeneralNotesAdapter;
import homi.frontend.homiandroidfrontend.Globals;
import homi.frontend.homiandroidfrontend.Models.AnimalNotesModel;
import homi.frontend.homiandroidfrontend.Models.AnimalNoteWithButtonModel;
import homi.frontend.homiandroidfrontend.databinding.FragmentGeneralNotesBinding;


public class GeneralNotesFragment extends Fragment
{
    FragmentGeneralNotesBinding binding;
    static GeneralNotesAdapter adapter;

    public GeneralNotesFragment()
    {
    }

    public static GeneralNotesFragment newInstance()
    {
        GeneralNotesFragment fragment = new GeneralNotesFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        List<AnimalNoteWithButtonModel> listWithButtons = new ArrayList<>();
        for(AnimalNotesModel animalNote : Globals.GlobalAnimalNotes)
        {
            listWithButtons.add(new AnimalNoteWithButtonModel(new Button(getContext()),
                    animalNote.notiz, animalNote.tiere_id, animalNote.id));
        }

        adapter = new GeneralNotesAdapter(getContext(), listWithButtons);
        binding = FragmentGeneralNotesBinding.inflate(inflater, container, false);

        binding.generalNotesListLayout.setAdapter(adapter);


        // Inflate the layout for this fragment
        return binding.getRoot();
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

    }
}
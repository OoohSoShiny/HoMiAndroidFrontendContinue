package homi.frontend.homiandroidfrontend.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import homi.frontend.homiandroidfrontend.Adapter.PregnancyNotesAdapter;
import homi.frontend.homiandroidfrontend.Globals;
import homi.frontend.homiandroidfrontend.databinding.FragmentCheckupNotesSingleAnimalBinding;

import homi.frontend.homiandroidfrontend.R;

public class CheckupNotesSingleAnimalFragment extends Fragment
{
    FragmentCheckupNotesSingleAnimalBinding binding;
    PregnancyNotesAdapter adapter;
    public CheckupNotesSingleAnimalFragment()
    {
        // Required empty public constructor
    }

    public static CheckupNotesSingleAnimalFragment newInstance()
    {
        CheckupNotesSingleAnimalFragment fragment = new CheckupNotesSingleAnimalFragment();
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
        adapter = new PregnancyNotesAdapter(getContext(), Globals.GlobalCheckupNotes);
        binding = FragmentCheckupNotesSingleAnimalBinding.inflate(inflater, container, false);
        binding.CheckupList.setAdapter(adapter);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
    }
}
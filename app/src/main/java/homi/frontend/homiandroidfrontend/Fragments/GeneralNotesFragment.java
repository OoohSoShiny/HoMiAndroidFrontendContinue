package homi.frontend.homiandroidfrontend.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import homi.frontend.homiandroidfrontend.Adapter.GeneralNotesAdapter;
import homi.frontend.homiandroidfrontend.Globals;
import homi.frontend.homiandroidfrontend.R;
import homi.frontend.homiandroidfrontend.databinding.FragmentGeneralNotesBinding;
import homi.frontend.homiandroidfrontend.databinding.FragmentHomeBinding;


public class GeneralNotesFragment extends Fragment
{
    FragmentGeneralNotesBinding binding;
    GeneralNotesAdapter adapter;

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
        adapter = new GeneralNotesAdapter(getContext(), Globals.GlobalAnimalNotes);
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
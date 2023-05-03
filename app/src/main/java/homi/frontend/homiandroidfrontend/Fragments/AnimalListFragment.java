package homi.frontend.homiandroidfrontend.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import homi.frontend.homiandroidfrontend.R;

public class AnimalListFragment extends Fragment
{

    public AnimalListFragment()
    {
        // Required empty public constructor
    }

    public static AnimalListFragment newInstance()
    {
        AnimalListFragment fragment = new AnimalListFragment();
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
        return inflater.inflate(R.layout.fragment_animal_list, container, false);
    }
}
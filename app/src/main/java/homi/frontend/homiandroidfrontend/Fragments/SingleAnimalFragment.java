package homi.frontend.homiandroidfrontend.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import homi.frontend.homiandroidfrontend.Adapter.AnimalsSimpleAdapter;
import homi.frontend.homiandroidfrontend.Adapter.NotesAdapter;
import homi.frontend.homiandroidfrontend.Globals;
import homi.frontend.homiandroidfrontend.Models.CompleteSingleAnimalModel;
import homi.frontend.homiandroidfrontend.Response.AnimalSimpleResponse;
import homi.frontend.homiandroidfrontend.Response.CompleteSingleAnimalResponse;
import homi.frontend.homiandroidfrontend.Service.ApiCaller;
import homi.frontend.homiandroidfrontend.databinding.FragmentSingleanimalBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleAnimalFragment extends Fragment
{

    private FragmentSingleanimalBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        ApiCaller.getInstance().completeSingleAnimalResponseCall(Globals.id).enqueue(new Callback<CompleteSingleAnimalModel>()
        {
            //Getting answer
            @Override
            public void onResponse(Call<CompleteSingleAnimalModel> call, Response<CompleteSingleAnimalModel> response)
            {
                //Fill Adapter with body of the Api-Response
                if(response.body().allgnotizen.size() != 0)
                {
                    NotesAdapter noteAdapter = new NotesAdapter(getContext(), response.body().allgnotizen);
                    binding.LVNotes.setAdapter(noteAdapter);
                }

                if(response.body().tunotizen.size() != 0)
                {
                    NotesAdapter CheckupAdapter = new NotesAdapter(getContext(), response.body().tunotizen, 0);
                    binding.LVCheckupNotes.setAdapter(CheckupAdapter);
                }




                binding.TvBirthDayValue.setText(response.body().geboren.toString());

            }
            //Getting no answer
            @Override
            public void onFailure(Call<CompleteSingleAnimalModel> call, Throwable t)
            {
                Log.e("Verbindung konnte nicht hergestellt werden.", "Empty Body.", t);
            }
        });

        binding = FragmentSingleanimalBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}
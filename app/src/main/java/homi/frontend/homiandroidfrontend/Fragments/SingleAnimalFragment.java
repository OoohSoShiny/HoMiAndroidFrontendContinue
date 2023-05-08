package homi.frontend.homiandroidfrontend.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import homi.frontend.homiandroidfrontend.Globals;
import homi.frontend.homiandroidfrontend.Models.CompleteSingleAnimalModel;
import homi.frontend.homiandroidfrontend.R;
import homi.frontend.homiandroidfrontend.Response.CompleteSingleAnimalResponse;
import homi.frontend.homiandroidfrontend.Service.ApiCaller;
import homi.frontend.homiandroidfrontend.databinding.FragmentSingleanimalBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingleAnimalFragment extends Fragment
{

    private FragmentSingleanimalBinding binding;
    private GeneralNotesFragment generalNotesFragment = new GeneralNotesFragment();
    private CheckupNotesSingleAnimalFragment checkupNotesSingleAnimalFragment = new CheckupNotesSingleAnimalFragment();


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        ApiCaller.getInstance().animalCompleteModels(Globals.Id).enqueue(new Callback<CompleteSingleAnimalResponse>()
        {
            //Getting answer
            @Override
            public void onResponse(Call<CompleteSingleAnimalResponse> call, Response<CompleteSingleAnimalResponse> response)
            {
                if(response.body() != null)
                {
                    CompleteSingleAnimalModel _animalCompleteModels = response.body().animalCompleteModels.get(0);

                    Globals.GlobalAnimalNotes = _animalCompleteModels.allgNotizen;
                    Globals.GlobalCheckupNotes = _animalCompleteModels.tuNotizen;
                    binding.TvBirthDayValue.setText(_animalCompleteModels.geboren);
                    binding.TvSingleAnimalHeaderValue.setText(_animalCompleteModels.ohrmarkennummer);
                    binding.TvSingleAnimalEarNumberValue.setText(_animalCompleteModels.stallnummer);
                }
            }

            //Getting no answer
            @Override
            public void onFailure(Call<CompleteSingleAnimalResponse> call, Throwable t)
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
        binding.Buttonback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                NavHostFragment.findNavController(SingleAnimalFragment.this)
                        .navigate(R.id.action_SingleAnimal_To_HomeFragment);
            }
        });

        binding.ButtonCheckupList.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                NavHostFragment.findNavController(SingleAnimalFragment.this)
                        .navigate(R.id.action_SingleAnimal_to_checkupNotesSingleAnimalFragment);
            }
        });

        binding.ButtonGeneralList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                NavHostFragment.findNavController(SingleAnimalFragment.this)
                        .navigate(R.id.action_SingleAnimal_to_generalNotesFragment);
            }
        });
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}
package homi.frontend.homiandroidfrontend.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import homi.frontend.homiandroidfrontend.Globals;
import homi.frontend.homiandroidfrontend.Models.CheckupNoteModel;
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


                    binding.TvSingleAnimalHeaderValue.setText(_animalCompleteModels.ohrmarkennummer);
                    binding.TvSingleAnimalEarNumberValue.setText(_animalCompleteModels.stallnummer);
                    binding.TvOrderTypeValue.setText(_animalCompleteModels.ordnungsgruppe);
                    String birthday = FormatStringToDate(_animalCompleteModels.geboren);
                    binding.TvBirthDayValue.setText(birthday);


                    //This Area calculates the next and last Pregnancy Checkup
                    Date today = new Date();
                    ArrayList<Date> datelist = new ArrayList<Date>();
                    SimpleDateFormat formatter = new SimpleDateFormat(Globals.DateTimeFormat);

                    for (CheckupNoteModel noteModel : _animalCompleteModels.tuNotizen)
                    {
                        try
                        {
                            datelist.add(formatter.parse(noteModel.termin.substring(0,9) + " " + noteModel.termin.substring(11, 15)));
                        }
                        catch (ParseException e)
                        {

                        }
                    }
                    Collections.sort(datelist);

                    for (int i = 0; i < datelist.size(); i++)
                    {
                        if (datelist.get(i).compareTo(today) < 0)
                        {
                            binding.TvLastCheckupValue.setText(String.valueOf(datelist.get(i)));
                        }
                        else
                        {
                            binding.TvNextCheckupValue.setText(String.valueOf(datelist.get(i)));
                            break;
                        }
                    }

                    if(datelist.isEmpty())
                    {
                        binding.TvLastCheckupValue.setText(R.string.StringNoAppointment);
                        binding.TvNextCheckupValue.setText(R.string.StringNoAppointment);
                    }


                    //Placeholder Values
                    binding.TvPregnantValue.setText(getResources().getString(R.string.StringNo));
                    binding.TvPregnancyValue.setText(getResources().getString(R.string.StringDashes));
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

    public String FormatStringToDate(String oldDate)
    {
        return oldDate.substring(5, 7) + "." + oldDate.substring(8,10) + "." + oldDate.substring(0,4) +
                " " + oldDate.substring(11,16);
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}
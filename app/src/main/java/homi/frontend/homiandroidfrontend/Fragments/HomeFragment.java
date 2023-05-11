package homi.frontend.homiandroidfrontend.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import java.util.ArrayList;
import android.widget.TextView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;
import java.util.List;

import homi.frontend.homiandroidfrontend.Adapter.AnimalsSimpleAdapter;
import homi.frontend.homiandroidfrontend.Globals;
import homi.frontend.homiandroidfrontend.Models.AnimalSimpleModel;
import homi.frontend.homiandroidfrontend.R;
import homi.frontend.homiandroidfrontend.Response.AnimalSimpleResponse;
import homi.frontend.homiandroidfrontend.Service.ApiCaller;
import homi.frontend.homiandroidfrontend.databinding.FragmentHomeBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    AnimalsSimpleAdapter adapter;
    String enteredString;
    List<AnimalSimpleModel> queryResult;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        //ApiCaller to access Calls
        ApiCaller.getInstance().animalsSimple().enqueue(new Callback<AnimalSimpleResponse>()
        {
            //Getting answer
            @Override
            public void onResponse(Call<AnimalSimpleResponse> call, Response<AnimalSimpleResponse> response)
            {
                Globals.SimpleAnimalList = new ArrayList<>();
                if(response.body() != null)
                {
                    Globals.SimpleAnimalList = response.body().animalsSimple;
                    adapter = new AnimalsSimpleAdapter(getContext(), response.body().animalsSimple);
                    binding.homeList.setAdapter(adapter);
                }
            }
            //Getting no answer
            @Override
            public void onFailure(Call<AnimalSimpleResponse> call, Throwable t)
            {
                Log.e("Verbindung konnte nicht hergestellt werden.", "Empty Body.", t);
            }
        });

        //Inflating = actually building the UI
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        binding.homeList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {

                Globals.Id =  adapter.GetAnimalId(position);
                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(R.id.action_HomeFragment_to_SingleAnimal);
            }
        });

        binding.EtHomeUserInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                //Not Used
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                queryResult = new ArrayList<>();
                enteredString = binding.EtHomeUserInput.getText().toString();
                for(AnimalSimpleModel wholeEntry : Globals.SimpleAnimalList)
                {
                    if(wholeEntry.ohrmarkennummer.contains(enteredString) || Integer.toString(wholeEntry.id).contains(enteredString)
                    || wholeEntry.stallnummer.contains(enteredString))
                    {
                        queryResult.add(wholeEntry);
                    }
                }
                adapter.clear();
                adapter.addAll(queryResult);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void afterTextChanged(Editable s)
            {
                //Not used
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
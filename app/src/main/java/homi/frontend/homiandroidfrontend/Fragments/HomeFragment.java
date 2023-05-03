package homi.frontend.homiandroidfrontend.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import homi.frontend.homiandroidfrontend.Adapter.AnimalsSimpleAdapter;
import homi.frontend.homiandroidfrontend.Globals;
import homi.frontend.homiandroidfrontend.R;
import homi.frontend.homiandroidfrontend.Response.AnimalSimpleResponse;
import homi.frontend.homiandroidfrontend.Service.ApiCaller;
import homi.frontend.homiandroidfrontend.databinding.FragmentHomeBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

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
                //Fill Adapter with body of the Api-Response
                AnimalsSimpleAdapter adapter = new AnimalsSimpleAdapter(getContext(), response.body().animalsSimple);
                binding.homeList.setAdapter(adapter);

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
                Globals.id = position;
                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(R.id.action_HomeFragment_to_SingleAnimal);
            }
        });
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
    //Click listener for the listview


}
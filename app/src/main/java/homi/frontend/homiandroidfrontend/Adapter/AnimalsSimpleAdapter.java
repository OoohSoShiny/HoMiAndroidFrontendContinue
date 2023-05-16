package homi.frontend.homiandroidfrontend.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import homi.frontend.homiandroidfrontend.Globals;
import homi.frontend.homiandroidfrontend.Models.AnimalSimpleModel;
import homi.frontend.homiandroidfrontend.R;
import homi.frontend.homiandroidfrontend.databinding.AnimalRowlayoutBinding;


public class AnimalsSimpleAdapter extends ArrayAdapter<AnimalSimpleModel>
{
    LayoutInflater inflater;
    boolean colorSet = false;
    private ArrayList<AnimalSimpleModel> _animals;

    public AnimalsSimpleAdapter(Context context, List<AnimalSimpleModel> animals)
    {
        super(context, R.layout.animal_rowlayout);

        _animals = new ArrayList<>();
        inflater = (LayoutInflater.from(context));

        if(animals != null)
        {
            addAll(animals);
            _animals.addAll(animals);
        }
    }

    @Override public View getView(int i, View view, ViewGroup viewGroup)
    {
        AnimalRowlayoutBinding binding;

        if (view == null)
        {
            binding = AnimalRowlayoutBinding.inflate(inflater);
        }
        else
        {
            binding = AnimalRowlayoutBinding.bind(view);
        }

        AnimalSimpleModel animal = getItem(i);

        binding.animalRowId.setText(String.valueOf(animal.id));
        binding.animalRowEarNumber.setText(String.valueOf(animal.ohrmarkennummer));
        binding.animalStableNumber.setText(String.valueOf(animal.stallnummer));

        if(!colorSet)
        {
            colorSet = true;
            binding.animalRowId.setBackgroundColor(Globals.FirstRowColor);
            binding.animalStableNumber.setBackgroundColor(Globals.FirstRowColor);
            binding.animalRowEarNumber.setBackgroundColor(Globals.FirstRowColor);
        }
        else
        {
            colorSet = false;
            binding.animalRowId.setBackgroundColor(Globals.SecondRowColor);
            binding.animalRowEarNumber.setBackgroundColor(Globals.SecondRowColor);
            binding.animalStableNumber.setBackgroundColor(Globals.SecondRowColor);
        }
        return binding.getRoot();
    }
}

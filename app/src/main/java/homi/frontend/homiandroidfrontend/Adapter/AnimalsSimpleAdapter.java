package homi.frontend.homiandroidfrontend.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import homi.frontend.homiandroidfrontend.Models.AnimalSimpleModel;
import homi.frontend.homiandroidfrontend.R;
import homi.frontend.homiandroidfrontend.databinding.AnimalRowlayoutBinding;


public class AnimalsSimpleAdapter extends ArrayAdapter<AnimalSimpleModel>
{
    LayoutInflater inflater;

    public AnimalsSimpleAdapter(Context context, List<AnimalSimpleModel> animals)
    {
        super(context, R.layout.animal_rowlayout);

        inflater = (LayoutInflater.from(context));

        if(animals != null)
        {
            addAll(animals);
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

        return binding.getRoot();
    }
}
package com.example.myapplication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class AnimalViewModel extends ViewModel {

    MutableLiveData<List<Animal>> animales;

    public AnimalViewModel() {
        this.animales = new MutableLiveData<>();
        this.animales.setValue(new ArrayList<>());

        this.addAnimal(new Animal(1, "León", "El rey de la jungla", R.drawable.leon));
        this.addAnimal(new Animal(2, "Elefante", "Es enorme", R.drawable.elefante));
    }

    public void addAnimal(Animal a){
        List<Animal> ans = animales.getValue();

        assert ans != null;
        ans.add(a);
        animales.setValue(ans);
    }

}

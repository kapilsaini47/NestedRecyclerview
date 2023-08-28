package com.example.nestedrecyclerview.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nestedrecyclerview.model.ChildModel;
import com.example.nestedrecyclerview.model.ParentModel;

import java.util.ArrayList;
import java.util.List;

public class RvViewModel extends ViewModel {

    ArrayList<ChildModel> Books, Mobiles, Toys, RecentlyViewed;
    ArrayList<ParentModel> parentModels;

    /*
     * Initialize private mutable Livedata list for parent model
     * and public Livedata list to observe live changes from ViewModel that gets data
     * from mutable Livedata
     */
    private final MutableLiveData<List<ParentModel>> parentMutableData = new  MutableLiveData<>();
    public LiveData<List<ParentModel>> getParentModelLiveData(){
        return  parentMutableData;
    }

    /*
     * Initialize private mutable live data list for Child model
     * and public Livedata list to observe live changes from ViewModel that gets data
     * from mutable Livedata
     */
    private final MutableLiveData<List<ChildModel>> childMutableData = new  MutableLiveData<>();
    public LiveData<List<ChildModel>> getChildModelLiveData(){
        return childMutableData;
    }

    /*
     * Initialize child and parent model class's variables
     * and add data to child model
     */
    public void rvData(){

        Books = new ArrayList<>();
        Mobiles = new ArrayList<>();
        Toys = new ArrayList<>();
        RecentlyViewed = new ArrayList<>();

        parentModels = new ArrayList<>();

        //Add data to child models
        Books.add(new ChildModel("Book 1"));
        Books.add(new ChildModel("Book 2"));
        Books.add(new ChildModel("Book 3"));
        Books.add(new ChildModel("Book 4"));

        Mobiles.add(new ChildModel("Mobile 1"));
        Mobiles.add(new ChildModel("Mobile 2"));
        Mobiles.add(new ChildModel("Mobile 3"));
        Mobiles.add(new ChildModel("Mobile 4"));

        Toys.add(new ChildModel("Toy 1"));
        Toys.add(new ChildModel("Toy 2"));
        Toys.add(new ChildModel("Toy 3"));
        Toys.add(new ChildModel("Toy 4"));

        RecentlyViewed.add(new ChildModel("Product 1"));
        RecentlyViewed.add(new ChildModel("Product 2"));
        RecentlyViewed.add(new ChildModel("Product 3"));
        RecentlyViewed.add(new ChildModel("Product 4"));

        //Add parent model's data
        parentModels.add(new ParentModel(Books,"Books"));
        parentModels.add(new ParentModel(Mobiles,"Mobiles"));
        parentModels.add(new ParentModel(Toys,"Toys"));
        parentModels.add(new ParentModel(RecentlyViewed,"Recently Viewed"));

        //Set child mutable Livedata value
        childMutableData.setValue(Books);
        childMutableData.setValue(Mobiles);
        childMutableData.setValue(Toys);
        childMutableData.setValue(RecentlyViewed);

        //Set Parent mutable Livedata value
        parentMutableData.setValue(parentModels);

    }

}

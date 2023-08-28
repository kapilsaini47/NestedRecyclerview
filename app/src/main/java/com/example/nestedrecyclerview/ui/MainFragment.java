package com.example.nestedrecyclerview.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.nestedrecyclerview.R;
import com.example.nestedrecyclerview.adapter.ParentAdapter;
import com.example.nestedrecyclerview.databinding.MainFragmentBinding;
import com.example.nestedrecyclerview.model.ChildModel;
import com.example.nestedrecyclerview.model.ParentModel;
import com.example.nestedrecyclerview.vm.RvViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    MainFragmentBinding binding;
    RvViewModel rvViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = MainFragmentBinding.bind(LayoutInflater.from(requireContext())
                .inflate(R.layout.main_fragment,container,false));

        //Initialize the ViewModel associated with RecyclerView data
        rvViewModel = new ViewModelProvider(requireActivity()).get(RvViewModel.class);

        //Load data into the ViewModel
        rvViewModel.rvData();

        /*
         * Observe changes in parent model live data from the ViewModel.
         * Using a lambda expression to directly pass the observed list to the setupRv method.
         */
        rvViewModel.getParentModelLiveData().observe(getViewLifecycleOwner(), this::setupRv);

        // Return fragment's binding
        return binding.getRoot();
    }

    /*
     * Initialize the RecyclerView adapter, set it to the fragment's RecyclerView,
     * and apply a vertical LinearLayoutManager.
     */
    private void setupRv(List<ParentModel> parentModels){
        ParentAdapter parentAdapter = new ParentAdapter(parentModels,requireContext());
        binding.rvMain.setAdapter(parentAdapter);
        binding.rvMain.setLayoutManager(new LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false));
    }

}
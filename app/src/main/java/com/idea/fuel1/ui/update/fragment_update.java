package com.idea.fuel1.ui.update;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.idea.fuel1.R;

public class fragment_update extends Fragment {

    private FragmentUpdateViewModel mViewModel;

    public static fragment_update newInstance() {
        return new fragment_update ( );
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_update, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);
        mViewModel = ViewModelProviders.of (this).get (FragmentUpdateViewModel.class);
        // TODO: Use the ViewModel
    }

}

package com.idea.fuel1.ui.share;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.idea.fuel1.R;

public class fragment_share extends Fragment {

    private FragmentShareViewModel mViewModel;

    public static fragment_share newInstance() {
        return new fragment_share ( );
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_share, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);
        mViewModel = ViewModelProviders.of (this).get (FragmentShareViewModel.class);
        // TODO: Use the ViewModel
    }

}

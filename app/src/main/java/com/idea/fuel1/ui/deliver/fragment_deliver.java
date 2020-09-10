package com.idea.fuel1.ui.deliver;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.idea.fuel1.R;

public class fragment_deliver extends Fragment {

    private FragmentDeliverViewModel mViewModel;

    public static fragment_deliver newInstance() {
        return new fragment_deliver ( );
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_deliver, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);
        mViewModel = ViewModelProviders.of (this).get (FragmentDeliverViewModel.class);
        // TODO: Use the ViewModel
    }

}

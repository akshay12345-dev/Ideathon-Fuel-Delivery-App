package com.idea.fuel1.ui.send;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.idea.fuel1.R;

public class fragment_send extends Fragment {

    private FragmentSendViewModel mViewModel;

    public static fragment_send newInstance() {
        return new fragment_send ( );
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_send, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated (savedInstanceState);
        mViewModel = ViewModelProviders.of (this).get (FragmentSendViewModel.class);
        // TODO: Use the ViewModel
    }

}

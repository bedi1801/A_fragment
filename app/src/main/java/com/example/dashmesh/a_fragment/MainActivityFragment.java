package com.example.dashmesh.a_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    //empty constructor
    }

    public interface OnButtonClick {
        void onButtonClick();
    }
    private OnButtonClick mListener;

    public static MainActivityFragment newInstance() {
        return new MainActivityFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof OnButtonClick) {
            mListener = (OnButtonClick) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement OnRageComicSelected.");
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

      //Button  btn = (Button) container.findViewById(R.id.button);
        //btn.setOnClickListener(this);
        //return inflater.inflate(R.layout.fragment_main, container, false);

        View rootView = inflater.inflate(R.layout.fragment_main, container,false);

        Button btn = (Button) rootView.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                mListener.onButtonClick();
                }
        });
        return rootView;
    }

}

package com.tp.gexogen.lesson1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * author s.titaevskiy on 23.02.15.
 */
public class LetterFragment extends Fragment {

    private final static String LETTER = "letter";

    public LetterFragment() {
        Log.e("LetterFragment","Constructor");
    }

    public static LetterFragment getInstance(String letter) {
        LetterFragment fragment = new LetterFragment();
        Bundle bundle = new Bundle();
        bundle.putString(LETTER, letter);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_letter, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.letter_place);

        Bundle bundle = getArguments();
        String s;
        if (bundle != null)
            s = bundle.getString(LETTER);
        else
            s = "#";

        textView.setText(s);
    }
}

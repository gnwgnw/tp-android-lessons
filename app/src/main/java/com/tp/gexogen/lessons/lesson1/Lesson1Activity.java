package com.tp.gexogen.lessons.lesson1;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.TextView;

import com.tp.gexogen.lessons.R;

public class Lesson1Activity extends FragmentActivity implements Lesson1ListFragment.OnItemSelectedListener {

    private boolean dualPane;

    public Lesson1Activity() {
        Log.e("Lesson1Activity", "Constructor");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson1_activity);

        dualPane = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    @Override
    public void onArticleSelected(String s) {
        if (dualPane) {
            ((TextView) findViewById(R.id.lesson1_activity_letter_text)).setText(s);
        }
        else {
            Lesson1LetterFragment fragment = Lesson1LetterFragment.getInstance(s);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.add(R.id.lesson1_activity_fragment_container, fragment);
            transaction.commit();
        }

    }
}

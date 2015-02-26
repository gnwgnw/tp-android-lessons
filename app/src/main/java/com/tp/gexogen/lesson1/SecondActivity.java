package com.tp.gexogen.lesson1;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class SecondActivity extends FragmentActivity implements NewListFragment.OnItemSelectedListener {

    private boolean dualPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        dualPane = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    @Override
    public void onArticleSelected(String s) {
        LetterFragment fragment = LetterFragment.getInstance(s);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (dualPane) {
            transaction.replace(R.id.fragment_details, fragment);
        }
        else {
            transaction.addToBackStack(null);
            transaction.add(R.id.fragment_second, fragment);
        }

        transaction.commit();
    }
}

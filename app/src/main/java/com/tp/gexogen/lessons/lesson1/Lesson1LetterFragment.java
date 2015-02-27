package com.tp.gexogen.lessons.lesson1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tp.gexogen.lessons.R;

/**
 * author s.titaevskiy on 23.02.15.
 */
public class Lesson1LetterFragment extends Fragment {

	private final static String LETTER = "letter";

	public static Lesson1LetterFragment getInstance(String letter) {
		Lesson1LetterFragment fragment = new Lesson1LetterFragment();
		Bundle bundle = new Bundle();
		bundle.putString(LETTER, letter);
		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.lesson1_activity_letter, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);

		String s;
		Bundle bundle = getArguments();
		if (bundle != null) {
			s = bundle.getString(LETTER);
		}
		else {
			s = "#";
		}

		TextView textView = (TextView) view.findViewById(R.id.lesson1_activity_letter_text);
		textView.setText(s);

		Button button = (Button) view.findViewById(R.id.lesson1_activity_letter_button_ok);
		if (button != null) {
			button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					getActivity().getSupportFragmentManager().beginTransaction().remove(Lesson1LetterFragment.this).commit();
				}
			});
		}
	}
}

package opensource.awesomejokes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Rajan Maurya on 30/10/16.
 */

public class JokeFragment extends Fragment {

    View rootView;

    String joke;

    public JokeFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        joke = getActivity().getIntent().getStringExtra(JokeActivity.JOKE_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_joke, container, false);

        TextView tv_joke = (TextView) rootView.findViewById(R.id.tv_joke);
        if (joke != null && joke.length() != 0) {
            tv_joke.setText(joke);
        }

        return rootView;
    }
}

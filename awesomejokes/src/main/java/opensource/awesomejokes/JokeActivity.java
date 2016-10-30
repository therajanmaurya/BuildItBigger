package opensource.awesomejokes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Rajan Maurya on 30/10/16.
 */

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "joke_key";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
    }
}

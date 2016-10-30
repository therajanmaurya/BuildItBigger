package opensource.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Jokes;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_show_joke)
    TextView tv_show_jokes;

    Jokes joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        joke = new Jokes();

        tv_show_jokes.setText(joke.getJoke());
    }

    @OnClick(R.id.btn_joke)
    void showJoke() {
        Toast.makeText(this, joke.getJoke(), Toast.LENGTH_SHORT).show();
    }
}

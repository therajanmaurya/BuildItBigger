package opensource.builditbigger;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import opensource.awesomejokes.JokeActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
    }

    @OnClick(R.id.btn_joke)
    void showJoke() {
        if (isConnected()){
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage(getString(R.string.loading));
            progressDialog.show();
            ApiServices apiServices = ApiServices.Creator.newService();
            Call<Pojo> call = apiServices.getJokes();
            call.enqueue(new Callback<Pojo>() {
                @Override
                public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();

                    if (response.isSuccessful()){
                        Pojo jokesResponse = response.body();
                        startJokeView(jokesResponse.getData());
                    }
                }

                @Override
                public void onFailure(Call<Pojo> call, Throwable t) {
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                }
            });
        } else {
            Toast.makeText(this, R.string.nointernet,Toast.LENGTH_LONG).show();
        }
    }


    public void startJokeView(String joke) {
        Intent jokeIntent = new Intent(this, JokeActivity.class);
        jokeIntent.putExtra(JokeActivity.JOKE_KEY, joke);
        startActivity(jokeIntent);
    }

    public boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager)this.getSystemService(
                Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null)
            return activeNetworkInfo.isConnected();
        else
            return false;
    }

}

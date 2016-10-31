package opensource.builditbigger;

import org.junit.Assert;
import org.junit.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rajan Maurya on 31/10/16.
 */

public class JokeApiTest {

    @Test
    public void jokeValidator() {
        ApiServices apiServices = ApiServices.Creator.newService();
        Call<Pojo> call = apiServices.getJokes();
        call.enqueue(new Callback<Pojo>() {
            @Override
            public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                if (response.isSuccessful()) {
                    Pojo jokesResponse = response.body();
                    junit.framework.Assert.assertFalse(jokesResponse.getData().length() == 0);
                } else {
                    Assert.fail();
                }
            }

            @Override
            public void onFailure(Call<Pojo> call, Throwable t) {

            }
        });
    }
}

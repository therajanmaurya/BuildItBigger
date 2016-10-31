package opensource.builditbigger;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

/**
 * Created by Rajan Maurya on 31/10/16.
 */

public interface ApiServices {

    String ENDPOINT = "https://backend-148107.appspot.com/_ah/api/myApi/v1/";

    @POST("sayHi/xyz")
    Call<Pojo> getJokes();

    /******** Helper class that sets up a new services *******/
    class Creator {
        public static ApiServices newService() {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(ApiServices.class);
        }
    }
}

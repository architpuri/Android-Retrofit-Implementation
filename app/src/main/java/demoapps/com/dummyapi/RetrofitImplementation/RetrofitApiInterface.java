package demoapps.com.dummyapi.RetrofitImplementation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitApiInterface {

    //Two seperate methods to specify different paths to return or do something
    @GET("movie/top_rated")
    Call<RetrofitData> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<RetrofitData> getMovieDetails(@Path("id")int id,@Query("api_key") String apikey);
}

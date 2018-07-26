package demoapps.com.dummyapi.RetrofitImplementation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import demoapps.com.dummyapi.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitExample extends AppCompatActivity{
    private static final String api_key="7e8f60e325cd06e164799af1e317d7a7";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_example);

        final RecyclerView retrofitRecycler= findViewById(R.id.recyclerRetrofit);
        retrofitRecycler.setLayoutManager(new LinearLayoutManager(this));

        RetrofitApiInterface retrofitService = RetrofitApiClient.getClient().create(RetrofitApiInterface.class);

        retrofit2.Call<RetrofitData> call = retrofitService.getTopRatedMovies(api_key);
        call.enqueue(new Callback<RetrofitData>() {
            @Override
            public void onResponse(Call<RetrofitData> call, Response<RetrofitData> response) {
                int statusCode = response.code();
                List<RetrofitMovieData> retrofitmovies = response.body().getResults();
                retrofitRecycler.setAdapter(new RetrofitAdapter(retrofitmovies,getApplicationContext()));
            }

            @Override
            public void onFailure(Call<RetrofitData> call, Throwable t) {
                Log.e("Exception in Retrofit",t.toString());
            }
        });
    }
}
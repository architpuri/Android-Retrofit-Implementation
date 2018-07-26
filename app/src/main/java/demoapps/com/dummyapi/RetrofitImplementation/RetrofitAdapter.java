package demoapps.com.dummyapi.RetrofitImplementation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import demoapps.com.dummyapi.R;

public class RetrofitAdapter extends RecyclerView.Adapter<RetrofitAdapter.RetrofitViewHolder> {

    private List<RetrofitMovieData> movieDataList;
    private Context context;
    public static class RetrofitViewHolder extends RecyclerView.ViewHolder{
        public TextView movieTitle;
        public TextView movieDescription;

        public RetrofitViewHolder(View itemView) {
            super(itemView);
            movieTitle=itemView.findViewById(R.id.text_movieTitle);
            movieDescription = itemView.findViewById(R.id.text_movieDesciption);
        }
    }

    public RetrofitAdapter(List<RetrofitMovieData> movieDataList,Context context) {
        this.movieDataList = movieDataList;
        this.context = context;
    }

    @Override
    public RetrofitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_retrofit_example,parent,false);
        return new RetrofitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RetrofitViewHolder holder, int position) {
        holder.movieTitle.setText(movieDataList.get(position).getTitle());
        holder.movieDescription.setText(movieDataList.get(position).getOverview());
    }

    @Override
    public int getItemCount() {
        return movieDataList.size();
    }
}

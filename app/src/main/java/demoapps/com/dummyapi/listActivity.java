package demoapps.com.dummyapi;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;
import butterknife.BindView;

public class listActivity extends AppCompatActivity {
    ArrayList<listData> items;
    RecyclerView itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        itemList = findViewById(R.id.list_Recycler);
        items = listData.createItemList(20);
        ItemAdapter itemAdapter = new ItemAdapter(items);
        //itemList.setLayoutManager(new LinearLayoutManager(this));here or in layout file
        itemList.setAdapter(itemAdapter);
        itemAdapter.setOnItemClickListener(new ItemAdapter.OnItemClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onItemClick(int pos) {
                Log.d("onItemClick in activity==", pos + "");
            }
        });
    }
}



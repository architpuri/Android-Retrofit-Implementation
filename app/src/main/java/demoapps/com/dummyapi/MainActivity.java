package demoapps.com.dummyapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import demoapps.com.dummyapi.RetrofitImplementation.RetrofitExample;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.textView) TextView txtView;
    private ImageView imageView;
    private TextView text_response;
    private Button btn_hit;
    private Button btn_dialog;
    private String s = null;
    private Button btn_json;
    private Button btn_recycler;
    private Button btn_retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        txtView.setText("Butterknife used");
        imageView = findViewById(R.id.img_picasso);
        Picasso.get().load("https://preview.ibb.co/eo9KXo/fire.jpg").resize(200, 200).centerCrop().into(imageView);

        text_response = findViewById(R.id.text_response);
        btn_hit = findViewById(R.id.btn_Hit);

        btn_hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataJson dJ = new dataJson();
                dJ.execute("https://jsonparsingdemo-cec5b.firebaseapp.com/jsonData/moviesDemoItem.txt");
                s = dJ.outputResult();
                text_response.setText(s);
                if (s == null) {
                    Log.v("PROBLEM", "Solve This");
                }
            }
        });
        btn_dialog = findViewById(R.id.btn_dialog);
        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                selectionDialogFragement sdf = new selectionDialogFragement();
                sdf.show(fm, "fragment_select_btns");
            }
        });
        btn_json = findViewById(R.id.btn_jsona);
        test();
        btn_recycler=findViewById(R.id.btn_Recycler);
        btn_recycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,listActivity.class));
            }
        });
        btn_retrofit=findViewById(R.id.btn_Retrofit);
        btn_retrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RetrofitExample.class));
            }
        });
    }

    private void test() {
        btn_json.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gson gson = new Gson();
                dataConverter dc;
                dc = gson.fromJson(s, dataConverter.class);
                String msg = dc.movieName;
                if (msg != null) {
                    text_response.setText(msg);
                } else {
                    text_response.setText("null");
                }
            }
        });
    }

}

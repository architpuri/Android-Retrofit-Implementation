package demoapps.com.dummyapi;
import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class dataJson extends AsyncTask<String,String,String> {
    String result;
    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;
        try {
            Log.v("Working inner task","Work");
            URL url = new URL(params[0]);
            connection= (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer buffer = new StringBuffer();
            String inputLine="";
            while((inputLine = bufferedReader.readLine())!=null){
                buffer.append(inputLine);
            }
            result=buffer.toString();
            Log.v("Working inner answer",result);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(connection!=null)
                connection.disconnect();
            try {
                if(bufferedReader!=null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String outputResult()
    {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(result==null)
        Log.v("output result","null");
        return result;
    }
}

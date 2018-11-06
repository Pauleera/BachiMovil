package cl.uach.inf.bachimovil;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DataRequest extends AsyncTask<String,Integer,String> {

    public AsyncResponse delegate = null;



    private AlertDialog alertDialog;

    private WeakReference<Activity> activityWeakReference;



    public DataRequest(Activity activity) {

        activityWeakReference = new WeakReference<>(activity);

    }





    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override

    protected void onPreExecute() {

        super.onPreExecute();

        AlertDialog.Builder builder=new AlertDialog.Builder(activityWeakReference.get());

        builder.setTitle(R.string.dialog_wait);

        builder.setView(R.layout.dialog_wait);

        builder.setCancelable(true);

        alertDialog = builder.create();

        alertDialog.show();

    }



    @Override

    protected String doInBackground(String... strings) {

        try{

            //Script URL
            String script = strings[0];
            URL url = new URL(script);

            //Init HTTPS Connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setDoInput(true);



            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream)
            );



            String line = "";

            StringBuilder data = new StringBuilder();



            while (line != null) {

                line = bufferedReader.readLine();

                data.append(line).append("\n");

            }

            inputStream.close();

            return data.toString().substring(data.indexOf("["), data.lastIndexOf("]") + 1);





        }catch(Exception e){

            e.printStackTrace();

            return "Error";

        }

    }



    @Override

    protected void onPostExecute(String result) {

        super.onPostExecute(result);



        //Parsing

        try{

            JSONArray jsonArray = new JSONArray(result);

            JSONObject jsonObject = (JSONObject) jsonArray.get(0);



            alertDialog.dismiss();

            delegate.processFinish(jsonObject);

        } catch (JSONException e) {

            e.printStackTrace();

        }

    }





}
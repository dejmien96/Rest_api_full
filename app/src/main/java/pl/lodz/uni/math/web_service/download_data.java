package pl.lodz.uni.math.web_service;

import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class download_data extends AsyncTask<Void,Void,Void> {
    String data = "";
    String dataParsed="";
    String singleParsed="";
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.myjson.com/bins/sgzi0");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA = new JSONArray(data);

            for (int i=0; i<JA.length() ; i++){
                JSONObject JO = (JSONObject) JA.get(i);

                    singleParsed = "Imie: "+ JO.get("imię")+ "\n"+
                            "Nazwisko: "+ JO.get("nazwisko")+ "\n"+
                            "Numer tel.: "+ JO.get("telefon")+ "\n"+
                            "Miasto: "+ JO.get("miasto")+ "\n"+
                            "E-mail: "+ JO.get("e-mail")+ "\n";

                    dataParsed = dataParsed + singleParsed + "\n";
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.data.setText(this.dataParsed);
    }
}


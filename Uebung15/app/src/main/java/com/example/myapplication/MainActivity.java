package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.net.http.HttpResponseCache;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    private HttpResponseCache httpCache = null;
    private TextView textView;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        try {
            httpCache = HttpResponseCache.install(getCacheDir(), 10000000L);
        } catch (IOException e) {
            Log.e(TAG, "Failed to create HttpResponseCache", e);
        }
    }

    public void onClickButtonCall(View v) {
        Log.d(TAG,"starting GithubTask");
        new GithubTask().execute();
    }

    private class GithubTask extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Calling github ...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
            URL github = new URL("https://api.github.com/users");
            HttpsURLConnection githubConnection = (HttpsURLConnection) github.openConnection();
            githubConnection.setRequestProperty("User-Agent", "com.dasgrau.uebung15");
            githubConnection.setRequestProperty("Accept", "application/vnd.github.v3+json");
            githubConnection.setRequestProperty("Contact-Me", "crow@mail.de");
            BufferedReader reader = new BufferedReader(new InputStreamReader(githubConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            for (String line; (line = reader.readLine()) != null; )
                stringBuilder.append(line).append('\n');

            String jsonString = stringBuilder.toString();

            return jsonString;
            
            } catch (Exception e) {
            e.printStackTrace();
            return "";
            }

        @Override
        protected void onPostExecute(String response) {
            try {
                JSONObject user = new JSONObject(response);
                int id = user.getInt("id");
                textView.setText("User ID is " + id);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
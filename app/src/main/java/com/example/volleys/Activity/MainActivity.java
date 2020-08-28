package com.example.volleys.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.VolleyError;
import com.example.volleys.Interface.GetThyrocarePackageDetailsAPICallback;
import com.example.volleys.Model.PackageDetails;
import com.example.volleys.Utils.ApiParams;
import com.example.volleys.Interface.GetAllPackagesAPICallback;
import com.example.volleys.Model.ModelClass;
import com.example.volleys.Interface.OnClickListenerRecyclerView;
import com.example.volleys.Adapter.PackageAdapter;
import com.example.volleys.R;
import com.example.volleys.Volley.VolleyNetworkUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class MainActivity  extends AppCompatActivity implements View.OnClickListener,OnClickListenerRecyclerView, GetAllPackagesAPICallback {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerViewPackage;
    private ArrayList<ModelClass> modelClassArrayList = new ArrayList<>();
    private PackageAdapter packageAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        initRecyclerView();

        setListeners();
        getValuesFromIntent();
    }

    private void bindViews() {
        recyclerViewPackage = findViewById(R.id.recyclerview_package);
    }

    private void initRecyclerView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerViewPackage.setHasFixedSize(true);
        recyclerViewPackage.setLayoutManager(layoutManager);
        packageAdapter = new PackageAdapter(MainActivity.this, modelClassArrayList, this);
        recyclerViewPackage.setAdapter(packageAdapter);


    }

    private void setListeners() {
    }

    private void getValuesFromIntent() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAllData();
    }

    private void getAllData() {
        getAllPackagesAPICall();
    }

    private void getAllPackagesAPICall() {
        String url = ApiParams.GET_PACKAGES;

        HashMap<String, String> params = new HashMap<>();
        Log.e(TAG, "params\n" + params.toString());
        String requestTag = "getAllPackages";
        VolleyNetworkUtil.getAllPackagesAPICall(this, url, params, requestTag, this);
    }

    @Override
    public void getAllPackagesAPISuccessCallback(String response) {
        Log.e(TAG, "PACKAGE_RESPONSE: " + response);
        try {
            JSONObject jsonObject = new JSONObject(response);
            String result = jsonObject.getString("status");

            if (result.equalsIgnoreCase("1")) {

                JSONArray jsonArray = jsonObject.getJSONArray("data");
                Gson gson = new Gson();
                Type listType = new TypeToken<List<ModelClass>>() {
                }.getType();
                modelClassArrayList = gson.fromJson(jsonArray.toString(), listType);


                packageAdapter.refreshList(modelClassArrayList);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAllPackagesAPIFailureCallback(VolleyError error) {
        Log.e(TAG, "PACKAGE_ERROR: " + error.getMessage());

    }


    @Override
    public void onClickRecyclerView(View view, int position) {
        ModelClass modelClass = new ModelClass();
        if (modelClassArrayList != null && modelClassArrayList.size() > 0) {
            modelClass = modelClassArrayList.get(position);
        }
        if (view.getId() == R.id.test_discount) {
            Intent intent = new Intent(this, PackageDetails.class);
            intent.putExtra("Profileid", modelClass.getThyro_profile_id());
            startActivity(intent);

        }
        if (view.getId() == R.id.test_amount) {
            Intent intent = new Intent(this, PackageDetails.class);
            intent.putExtra("Profileid", modelClass.getThyro_profile_id());
            startActivity(intent);
        }
        if (view.getId() == R.id.name) {
            Intent myIntent = new Intent(MainActivity.this, DetailedActivity.class);
            myIntent.putExtra("PROFILEID", modelClass.getThyro_profile_id());
            startActivity(myIntent);

        }

    }
}








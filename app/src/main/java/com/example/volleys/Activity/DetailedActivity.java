package com.example.volleys.Activity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.VolleyError;
import com.example.volleys.Adapter.PackageAdapter;
import com.example.volleys.Interface.GetThyrocarePackageDetailsAPICallback;
import com.example.volleys.Model.Info;
import com.example.volleys.Model.PackageDetails;
import com.example.volleys.Model.Test;
import com.example.volleys.R;
import com.example.volleys.Utils.ApiParams;
import com.example.volleys.Volley.VolleyNetworkUtil;
import com.google.android.material.dialog.MaterialDialogs;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DetailedActivity extends AppCompatActivity implements View.OnClickListener,  GetThyrocarePackageDetailsAPICallback {
    private static final String TAG = PackageDetails.class.getSimpleName();
    TextView text_test_name;
    TextView package_test_count;
    TextView text_price;
    TextView package_discount;
    TextView cartcount_test;
    TextView text_price1;
    TextView cartcount;

    TextView txtv_precau;
    TextView test_detail;


    private Info detailmodel = new Info();

    private String name;
    private String dicount;
    private String imagepath;
    private String discription;
    private String preparation;
    private ImageView Imv_thyro;
    private String profileID = "";


    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_detailed);
        bindViews();
        getValuesFromIntent();


    }

    private void bindViews() {
        Imv_thyro = findViewById(R.id.image);
        text_test_name = findViewById(R.id.namedetails);
        package_test_count = findViewById(R.id.discountdetails);

        txtv_precau = findViewById(R.id.txtv_precau);
        test_detail = findViewById(R.id.test_detail);


    }

    private void getValuesFromIntent() {
        Intent intent = getIntent();
        if (intent != null) {

            profileID = intent.getStringExtra("PROFILEID");


        }
    }

    private void getThyrocarePackageDetailsAPICall() {

        String url = ApiParams.GET_DETAILS;

        HashMap<String, String> params = new HashMap<>();
        params.put("thyro_profile_id", profileID);
        params.put("thyro_profile_id", "2001");


        Log.e(TAG, "params\n" + params.toString());
        String requestTag = "getThyrocarePackageDetails";
        VolleyNetworkUtil.getThyrocarePackageDetailsAPICall(this, url, params, requestTag, this);
    }

    @Override
    public void getThyrocarePackageDetailsAPISuccessCallback(String response) {
        Log.e(TAG, "PACKAGE_Detail_THYRO\n" + response);
        try {

            JSONObject jsonObject = new JSONObject(response);
            int result = jsonObject.getInt("status");
            if (result == 1) {

                discription = jsonObject.getString("description");
                preparation = jsonObject.getString("preparation");
                imagepath = jsonObject.getString("profile_img");

                JSONArray jsonArray = jsonObject.getJSONArray("info");
                Gson gson = new Gson();
                Type listType = new TypeToken<List<Info>>() {
                }.getType();
                ArrayList<Info> thyropackDetailArrayList = gson.fromJson(jsonArray.toString(), listType);


                    for (int i = 0; i < thyropackDetailArrayList.size(); i++) {
                        text_test_name.setText(detailmodel.getProfile_name());
                        package_test_count.setText("Includes " + detailmodel.getTest_count() + " test");
                        if (preparation.equals("Null") && discription.equals("Null")) {
                            txtv_precau.setText("Details not available");
                            test_detail.setText("Details not available");
                        } else {
                            txtv_precau.setText((Html.fromHtml(preparation)));
                            test_detail.setText((Html.fromHtml(discription)));
                        }
                        Picasso.get().load(imagepath).into(Imv_thyro);
                    }

                    if (!(detailmodel.getZiffy_discount() == 0)) {
                        text_price.setText((detailmodel.getZiffy_profile_price()));
                        text_price1.setText((detailmodel.getTest_discount_price()));
                    } else {
                        text_price.setText((detailmodel.getZiffy_profile_price()));
                        text_price.setTextSize(16);
                        text_price.setTypeface(null, Typeface.BOLD);
                        text_price1.setVisibility(View.GONE);
                    }

                }
                else{
                }
            }
             catch(JSONException e) {
                e.printStackTrace();
            }
        }

    @Override
    public void getThyrocarePacakageDetailsAPIFailure(VolleyError error) {

    }



        @Override
        protected void onResume() {
            super.onResume();
            getThyrocarePackageDetailsAPICall();
        }


        @Override
        public void onClick(View view) {

        }
    }
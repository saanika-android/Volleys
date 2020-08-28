package com.example.volleys.Interface;

import android.view.View;

import com.android.volley.VolleyError;

public interface GetThyrocarePackageDetailsAPICallback {
   void getThyrocarePackageDetailsAPISuccessCallback(String response);
   void getThyrocarePacakageDetailsAPIFailure(VolleyError error);




}

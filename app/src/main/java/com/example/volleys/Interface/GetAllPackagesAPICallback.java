package com.example.volleys.Interface;

import android.view.View;

import com.android.volley.VolleyError;

public interface GetAllPackagesAPICallback {
    void getAllPackagesAPISuccessCallback(String response);
    void getAllPackagesAPIFailureCallback(VolleyError error);


    void onClickRecyclerView(View view, int position);
}

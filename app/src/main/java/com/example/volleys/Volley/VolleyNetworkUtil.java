package com.example.volleys.Volley;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.volleys.Interface.GetAllPackagesAPICallback;
import com.example.volleys.Interface.GetThyrocarePackageDetailsAPICallback;

import java.util.HashMap;
import java.util.Map;

public class VolleyNetworkUtil {
    private static final String TAG = VolleyNetworkUtil.class.getSimpleName();

    private static Map<String, String> getWithoutheader(Map<String, String> params) {
        if (params == null) {
            params = new HashMap<>();
        }
        return params;
    }

    public static void getAllPackagesAPICall(Context context, String url,
                                             final Map<String, String> params,
                                             String requestTag,
                                             final GetAllPackagesAPICallback callback) {
        StringRequest getAllPackagesRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.getAllPackagesAPISuccessCallback(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.getAllPackagesAPIFailureCallback(error);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                return getWithoutheader(params);
            }
        };

        int socketTimeout = 10000;//10 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        getAllPackagesRequest.setRetryPolicy(policy);
        VolleyHelper.getInstance(context).addToRequestQueue(getAllPackagesRequest, requestTag);
    }
    public static void getThyrocarePackageDetailsAPICall(Context context, String url,
                                                         final Map<String, String> params, String requestTag,
                                                         final GetThyrocarePackageDetailsAPICallback callback) {
        StringRequest getThyrocarePackageDetailsRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.getThyrocarePackageDetailsAPISuccessCallback(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.getThyrocarePacakageDetailsAPIFailure(error);
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                return getWithoutheader(params);
            }
        };

        int socketTimeout = 10000;//10 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        getThyrocarePackageDetailsRequest.setRetryPolicy(policy);
        VolleyHelper.getInstance(context).addToRequestQueue(getThyrocarePackageDetailsRequest, requestTag);
    }

}




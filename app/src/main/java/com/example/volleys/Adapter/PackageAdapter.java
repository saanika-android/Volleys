package com.example.volleys.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.volleys.Activity.DetailedActivity;
import com.example.volleys.Activity.MainActivity;
import com.example.volleys.Model.ModelClass;
import com.example.volleys.Interface.OnClickListenerRecyclerView;
import com.example.volleys.R;


import java.util.ArrayList;

public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.ViewHolder> {
    private static final String TAG = PackageAdapter.class.getSimpleName();
    private ArrayList<ModelClass> modelArrayList;
    private Context context;
    private OnClickListenerRecyclerView onClickListerRecyclerView;




    public PackageAdapter(Context context, ArrayList<ModelClass> names, MainActivity onClickListenerRecyclerView) {
        this.context = context;
        this.modelArrayList = names;


    }


    public void refreshList(ArrayList<ModelClass> names) {
        this.modelArrayList = names;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final ModelClass model = modelArrayList.get(position);

        holder.textViewName.setText(model.getName());
        holder.textAmount.setText(model.getActual_amount());
        holder.textDiscount.setText(model.getTest_discount_price());

        holder.textDiscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClickListenerRecyclerView.onClickRecyclerView(v, position);
            }
        });

        holder.textViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClickListenerRecyclerView.onClickRecyclerView(v, position);
            }
        });


    }

    public int getItemCount() {
        return modelArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textAmount;
        private  TextView textDiscount;
        private RelativeLayout relativeLayout;
        private ImageView imageView;


        ViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.name);
            textAmount = itemView.findViewById(R.id.test_amount);
            textDiscount=itemView.findViewById(R.id.test_discount);
            relativeLayout=itemView.findViewById(R.id.rel_parent);





        }

    }


}

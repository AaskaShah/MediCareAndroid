package com.neha.appathon2;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

// Main Page Names

/**
 * Created by Edwin on 18/01/2015.
 */

public class DiseaseAdapter extends RecyclerView.Adapter<DiseaseAdapter.ViewHolder>   {

    List<Disease> mItems;
    Context context;

    //SharedPreferences sharedPreferences;
    public DiseaseAdapter(Context context) {
        super();

        this.context = context;
        mItems = new ArrayList<Disease>();
        Disease nature = new Disease();
        nature.setName("Malaria");
        mItems.add(nature);

        nature = new Disease();
        nature.setName("Dengue");
        mItems.add(nature);

        nature = new Disease();
        nature.setName("Cancer");
        mItems.add(nature);

        nature = new Disease();
        nature.setName("Tuberculosis");
        mItems.add(nature);


        nature = new Disease();
        nature.setName("Chickenpox");
        mItems.add(nature);

        nature = new Disease();
        nature.setName("Cholera");
        mItems.add(nature);

        nature = new Disease();
        nature.setName("Typhoid");
        mItems.add(nature);



    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {



        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_view_disease, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);


        return viewHolder;

    }



    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Disease nature = mItems.get(i);
        viewHolder.tvDesNature.setText(nature.getName());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvDesNature;

        public ViewHolder(final View itemView) {
            super(itemView);

            CardView cardView = (CardView) itemView.findViewById(R.id.card_view_disease);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Toast.makeText(context,"HAAA",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(context, Onedisease.class);

                    i.putExtra("code", mItems.get(getAdapterPosition()).getName());
                    Bundle bndlanimation =
                            null;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        // bndlanimation = ActivityOptions.makeCustomAnimation(context, R.anim.zoom_in, R.anim.zoom_in).toBundle();
                        context.startActivity(i, bndlanimation);
                    }
                    else{
                        context.startActivity(i);
                    }                 // i.putExtra("code", mItems.get(getAdapterPosition()).getName());

                }
            });
            tvDesNature = (TextView) itemView.findViewById(R.id.disease_name);

        }

    }

}

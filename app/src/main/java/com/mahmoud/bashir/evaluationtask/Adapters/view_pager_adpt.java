package com.mahmoud.bashir.evaluationtask.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.mahmoud.bashir.evaluationtask.R;
import com.mahmoud.bashir.evaluationtask.ui.MainActivity;
import com.mahmoud.bashir.evaluationtask.ui.intro_Activity;

public class view_pager_adpt  extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;

    public view_pager_adpt(Context context) {
        this.context = context;
    }


    //list of images
    public int[] lst_imgs={
            R.drawable.intro1,
            R.drawable.intro2,
            R.drawable.intro3
    };

    //list of main text with Questions
    public String[] lst_mainQ={
            "What is it?",
            "We are not the same but equivalent.",
            "We are not the same but equivalent."

    };

    //lis of descriptions
    public String[] lst_desc={
            "   Enneagram is the powerful and \n" +
                    "defining categories of person's emotions,\n" +
                    "            ideas, and actions.",
            "Find out how harmonious you are with\n" +
                    "   your friends. Check out advises on \n" +
                    "   your daily routines and your attitude in \n" +"       "+
                    "                      relationships.",
            "   Enneagram is the powerful and \n" +
                    "defining categories of person's emotions,\n" +
                    "            ideas, and actions."

    };


    @Override
    public int getCount() {
        return lst_imgs.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(RelativeLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v=layoutInflater.inflate(R.layout.slide_intro,container,false);

        RelativeLayout slide_relative=v.findViewById(R.id.slide_Relative);
        ImageView intro_logo=v.findViewById(R.id.img_v);
        TextView txt_1=v.findViewById(R.id.txt_1);
        TextView txt_2=v.findViewById(R.id.txt_2);
        Button skip=v.findViewById(R.id.skip);
        dotsLayout=v.findViewById(R.id.layoutDots);

        //set btn INVISIBLE by GONE
        skip.setVisibility(View.GONE);



        addBottomDots(0);


        intro_logo.setImageResource(lst_imgs[position]);
        txt_1.setText(lst_mainQ[position]);
        txt_2.setText(lst_desc[position]);

        if (position==0){
            addBottomDots(0);
        }else if (position == 1){
            addBottomDots(1);
        }else if (position==2){

            addBottomDots(2);

            skip.setVisibility(View.VISIBLE);
            skip.setOnClickListener(V -> {
                Intent intent=new Intent(context, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                ((intro_Activity)context).finish();
            });
        }else {
            Intent intent=new Intent(context, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            ((intro_Activity)context).finish();
        }

        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }

    @SuppressLint("ResourceAsColor")
    private void addBottomDots(int currentPage) {
        dots = new TextView[lst_imgs.length];

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(context);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.GRAY);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.RED);
    }
}

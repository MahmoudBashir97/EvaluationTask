package com.mahmoud.bashir.evaluationtask.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.mahmoud.bashir.evaluationtask.R;
import com.squareup.picasso.Picasso;

public class discount_pager_adpt extends PagerAdapter {


    Context context;
    LayoutInflater layoutInflater;

    private LinearLayout dotsLayout;
    private TextView[] dots;

    public discount_pager_adpt(Context context) {
        this.context = context;
    }

    public int[] lst_imgs={
            R.drawable.pizza_1,
            R.drawable.pasta_1,
            R.drawable.pasta_2,
            R.drawable.pasta_3
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
        View v=layoutInflater.inflate(R.layout.discount_item,container,false);

        ImageView discount_img=v.findViewById(R.id.discount_img);
        dotsLayout=v.findViewById(R.id.layoutDots);

        Picasso.get().load(lst_imgs[position]).into(discount_img);

        addBottomDots(position);


        /*if (position==0){
            addBottomDots(0);
        }else if (position == 1){
            addBottomDots(1);
        }else if (position==2){
            addBottomDots(2);
        }else
        {
            addBottomDots(0);
        }*/

        container.addView(v);
        return v;
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


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}

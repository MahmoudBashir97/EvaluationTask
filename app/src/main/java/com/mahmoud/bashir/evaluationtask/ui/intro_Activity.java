package com.mahmoud.bashir.evaluationtask.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.mahmoud.bashir.evaluationtask.Adapters.view_pager_adpt;
import com.mahmoud.bashir.evaluationtask.R;

public class intro_Activity extends AppCompatActivity {

    private ViewPager viewPager;
    private view_pager_adpt pager_adpt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_layout);

        viewPager=findViewById(R.id.v_pager);

        pager_adpt=new view_pager_adpt(this);

        viewPager.setAdapter(pager_adpt);
    }
}

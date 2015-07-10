package com.suyonoion.customdrawereasyviewpagerui;

/**
 * Created by Suyono on 7/2/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ExpandedViewpagerUI extends ViewPager {

    private PagerTabStrip Tempat_Judul;
    private List<String> Mengisi_Tempat_judul;

    public int setResource(String name, String Type)
    {
        return getContext().getResources().getIdentifier(name, Type, getContext().getPackageName());
    }

    public ExpandedViewpagerUI (Context context){
        super(context);
        if (!isInEditMode()) {
            kode();
        }
    }

    public ExpandedViewpagerUI (Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            kode();
        }
    }

    private void kode() {
        Tempat_Judul = (PagerTabStrip) findViewById(setResource("id_judul_drawer","id"));
        Mengisi_Tempat_judul = new ArrayList<String>();
        Mengisi_Tempat_judul.add(getResources().getString(setResource("anu1","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("anu2","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("anu3","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("anu4","string")));
        Mengisi_Tempat_judul.add(getResources().getString(setResource("anu5","string")));

        AdapterExpandedViewpagerUI adapter = new AdapterExpandedViewpagerUI(Mengisi_Tempat_judul);
        final ViewPager EasyExpandedViewPagerUI = (ViewPager) this.findViewById(setResource("id_viewpager_drawer","id"));
        EasyExpandedViewPagerUI.setAdapter(adapter);
        EasyExpandedViewPagerUI.setOffscreenPageLimit(5);

        EasyExpandedViewPagerUI.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                View page1 = findViewById(setResource("id_page1", "id"));
                View page2 = findViewById(setResource("id_page2", "id"));
                View page3 = findViewById(setResource("id_page3", "id"));
                View page4 = findViewById(setResource("id_page4", "id"));
                View page5 = findViewById(setResource("id_page5", "id"));
                switch (position){
                    case 0:
                        ION.with(Techniques.SlideInFromRight)
                                .duration(700)
                                .playOn(page1);
                    case 1:
                        ION.with(Techniques.SlideInFromRight)
                                .duration(700)
                                .playOn(page2);
                    case 2:
                        ION.with(Techniques.SlideInFromRight)
                                .duration(700)
                                .playOn(page3);
                    case 3:
                        ION.with(Techniques.SlideInFromRight)
                                .duration(700)
                                .playOn(page4);
                    case 4:
                        ION.with(Techniques.SlideInFromRight)
                                .duration(700)
                                .playOn(page5);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public class AdapterExpandedViewpagerUI extends PagerAdapter {
        private List<String> adapterMengisi_Tempat_judul;
        public AdapterExpandedViewpagerUI(List<String> adapterMengisi_Tempat_judul) {
            this.adapterMengisi_Tempat_judul = adapterMengisi_Tempat_judul;
        }
        @Override
        public int getCount () {
            return 5;
        }

        @Override
        public Object instantiateItem (ViewGroup container,int position){
            int tampilkanMenurutId = 0;
            switch (position) {
                case 0:
                    tampilkanMenurutId = setResource("id_page1","id");
                    break;
                case 1:
                    tampilkanMenurutId = setResource("id_page2","id");
                    break;
                case 2:
                    tampilkanMenurutId = setResource("id_page3","id");
                    break;
                case 3:
                    tampilkanMenurutId = setResource("id_page4","id");
                    break;
                case 4:
                    tampilkanMenurutId = setResource("id_page5","id");
                    break;
            }
            return findViewById(tampilkanMenurutId);
        }

        @Override
        public CharSequence getPageTitle ( int position){
            return adapterMengisi_Tempat_judul.get(position);
        }

        @Override
        public boolean isViewFromObject (View arg0, Object arg1){
            return arg0 ==  arg1;
        }

        @Override
        public Parcelable saveState () {
            return null;
        }
    }
}
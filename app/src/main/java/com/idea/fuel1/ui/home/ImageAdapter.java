package com.idea.fuel1.ui.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.idea.fuel1.R;

class ImageAdapter extends PagerAdapter {
    Context mContext;

    ImageAdapter(Context context) {
        mContext = context;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    private int[] sliderImageId = new int[]{
            R.drawable.fuels2, R.drawable.fuels3, R.drawable.fuels5,R.drawable.safe
    };

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(sliderImageId[position]);
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }

    @Override
    public int getCount() {
        return sliderImageId.length;
    }
}

package com.suyonoion.customdrawereasyviewpagerui;

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;

/**
 * Created by Suyono on 7/3/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */

public class SlideInFromRight extends BaseViewAnimator {
    @Override
    public void prepare(View target) {
        float x = target.getWidth() - target.getPaddingRight();
        float y = target.getHeight() - target.getPaddingBottom();
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "rotation", 90, 0),
                ObjectAnimator.ofFloat(target, "alpha", 0, 1),
                ObjectAnimator.ofFloat(target, "pivotX", x, x),
                ObjectAnimator.ofFloat(target, "pivotY", y, y)
        );
    }

}
package com.suyonoion.customdrawereasyviewpagerui;

/**
 * Created by Suyono on 7/2/2015.
 * Copyright (c) 2015 by Suyono (ion).
 * All rights reserved.
 * This product is protected by copyright and distributed under
 * licenses restricting copying, distribution and decompilation.
 */

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;

public class Berputar extends BaseViewAnimator {
    @Override
    public void prepare(View target) {
        getAnimatorAgent().playTogether(
                ObjectAnimator.ofFloat(target, "rotationY", 0, 180, 0)
        );
    }
}

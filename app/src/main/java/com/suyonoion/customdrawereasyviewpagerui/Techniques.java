package com.suyonoion.customdrawereasyviewpagerui;

public enum Techniques {

    Berputar(Berputar.class),
    SlideInFromRight(SlideInFromRight.class);

    private Class animatorClazz;
    private Techniques(Class clazz) {
        animatorClazz = clazz;
    }
    public BaseViewAnimator getAnimator() {
        try {
            return (BaseViewAnimator) animatorClazz.newInstance();
        } catch (Exception e) {
            throw new Error("Can not init animatorClazz instance");
        }
    }
}

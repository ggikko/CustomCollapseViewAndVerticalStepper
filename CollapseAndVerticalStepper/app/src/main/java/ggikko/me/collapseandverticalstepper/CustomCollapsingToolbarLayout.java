package ggikko.me.collapseandverticalstepper;

import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by admin on 16. 5. 3..
 */
public class CustomCollapsingToolbarLayout extends CollapsingToolbarLayout {

    Context mContext;

    public CustomCollapsingToolbarLayout(Context context) {
        super(context);
        this.mContext = context;
    }

    public CustomCollapsingToolbarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;

    }

    public CustomCollapsingToolbarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        int scrollY = getScrollY();
        final float scale = getContext().getResources().getDisplayMetrics().density;
        int height = (int)((int)(scrollY - 0.5f)/scale);
        ((MainActivity)mContext).scrolling(height);
        Log.e("ggikko", "hoho0");
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(target, dx, dy, consumed);

        int scrollY = getScrollY();
        final float scale = getContext().getResources().getDisplayMetrics().density;
        int height = (int)((int)(dy - 0.5f)/scale);
        ((MainActivity)mContext).scrolling(height);
        Log.e("ggikko","hoho1");
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);

        int scrollY = getScrollY();
        final float scale = getContext().getResources().getDisplayMetrics().density;
        int height = (int)((int)(dyConsumed- 0.5f)/scale);
        ((MainActivity)mContext).scrolling(height);
        Log.e("ggikko", "hoho2");

    }
}

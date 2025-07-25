package com.wefika.horizontalpicker;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.wefika.horizontalpicker.R;

public class HPickerLayoutManager extends LinearLayoutManager {

    private final String TAG = "bahri" + getClass().getSimpleName();
    private float scaleDownBy = 0.99f;//0.66f;
    private float scaleDownDistance = 0.8f;//0.9f;
    private boolean changeAlpha = true;

    private onScrollStopListener scrollStopListener;

    public HPickerLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        scaleDownView();
    }

    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int orientation = getOrientation();
        if (orientation == HORIZONTAL) {
            int scrolled = super.scrollHorizontallyBy(dx, recycler, state);
            scaleDownView();
            return scrolled;
        }
        return 0;
    }

    private int cnt = 0;

    @Override
    public void onScrollStateChanged(int state) {
        super.onScrollStateChanged(state);
        Log.d(TAG, "onScrollStateChanged: child size: " + getChildCount());
        Log.d(TAG, "onScrollStateChanged: state: " + state);
        if (state == 2) {
            cnt += 1;
        }
        if (state == 0) {
            if (cnt == 2) {
                if (scrollStopListener != null) {
                    int selected = 0;
                    float lastHeight = 0f;
                    for (int i = 0; i < getChildCount(); i++) {
                        if (lastHeight < getChildAt(i).getScaleY()) {
                            lastHeight = getChildAt(i).getScaleY();
                            selected = i;
                        }
                    }
                    scrollStopListener.onSelect(getChildAt(selected), selected);
                }
                cnt = 0;
            }

        }
    }

    private void scaleDownView() {
        float middle = getWidth() / 2.0f;
        float unitScaleDownDistance = scaleDownDistance * middle;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            float middleChild = (getDecoratedLeft(child) + getDecoratedRight(child)) / 2.0f;
            float scale = 1.0f + (-1 * scaleDownBy) * (Math.min(unitScaleDownDistance, Math.abs(middle - middleChild))) / unitScaleDownDistance;
            child.setScaleX(scale);
            child.setScaleY(scale);
            if (changeAlpha) {
                child.setAlpha(scale);
            }
        }
    }

    public void setOnScrollStopListener(onScrollStopListener scrollStopListener) {
        this.scrollStopListener = scrollStopListener;
    }

//    public float getScaleDownBy() {
//        return scaleDownBy;
//    }
//
//    public void setScaleDownBy(float scaleDownBy) {
//        this.scaleDownBy = scaleDownBy;
//    }
//
//    public float getScaleDownDistance() {
//        return scaleDownDistance;
//    }
//
//    public void setScaleDownDistance(float scaleDownDistance) {
//        this.scaleDownDistance = scaleDownDistance;
//    }
//
//    public boolean isChangeAlpha() {
//        return changeAlpha;
//    }
//
//    public void setChangeAlpha(boolean changeAlpha) {
//        this.changeAlpha = changeAlpha;
//    }

}

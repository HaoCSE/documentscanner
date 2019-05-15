package com.haotran.documentscanner.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import com.haotran.documentscanner.R;
import com.haotran.sectionedrecyclerview.SectionedRecyclerViewAdapter;


public class GridDividerDecoration extends RecyclerView.ItemDecoration {

    private final Paint dividerPaint;

    private final float dividerHeight;

    public GridDividerDecoration(Context context) {
        this.dividerPaint = new Paint();
//        this.dividerPaint.setColor(ContextCompat.getColor(context, R.color.dividerColor));
        this.dividerHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1f, context.getResources().getDisplayMetrics());
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {

        final SectionedRecyclerViewAdapter adapter = (SectionedRecyclerViewAdapter) parent.getAdapter();

        for (int i = 0; i < parent.getChildCount(); i++) {

            final View child = parent.getChildAt(i);

            final int adapterPosition = parent.getChildAdapterPosition(child);

            if (adapterPosition != RecyclerView.NO_POSITION && i != 0 && adapter.isSubheaderAtPosition(adapterPosition)) {
                c.drawRect(child.getLeft(), child.getTop(), child.getRight(), child.getTop() + dividerHeight, dividerPaint);
            }

        }

    }


}

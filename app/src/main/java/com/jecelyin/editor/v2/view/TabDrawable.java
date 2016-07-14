package com.jecelyin.editor.v2.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;

import com.jecelyin.editor.v2.R;


public class TabDrawable extends BitmapDrawable {

    private final int toolbarBgColor;
    private String text;
    private final Paint paint;
    private float textWidth;

    public TabDrawable(Context context, Bitmap bitmap, String text, float textSize) {
        super(context.getResources(), bitmap);

        this.paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(textSize);
        paint.setAntiAlias(true);
        paint.setFakeBoldText(false);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);

        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        toolbarBgColor = typedValue.data;

        setText(text);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getIntrinsicWidth();
        int height = getIntrinsicHeight();

        float x = width - textWidth / 2;
        float y = height * 0.2f;

        paint.setColor(Color.WHITE);
        canvas.drawCircle(x, y, textWidth, paint);
        paint.setColor(toolbarBgColor);
        canvas.drawText(text, x, y + 10, paint);
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
        super.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        paint.setColorFilter(cf);
        super.setColorFilter(cf);
    }

//    @Override
//    public int getOpacity() {
//        return PixelFormat.TRANSLUCENT;
//    }

    public void setText(String text) {
        this.text = text.length() > 2 ? ".." : text;
        textWidth = paint.measureText(text) + 5;
        invalidateSelf();
    }
}

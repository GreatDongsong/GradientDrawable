package dawson.com.gradientdrawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

// Created by Dawson.Gao on 2018/4/20.
public class ColorGradientDrawable extends Drawable {
    private final float mWidth;
    private final float mHeight;
    private final int[] mColors;

    public ColorGradientDrawable(float width, float height, int[] colors) {
        mWidth = width;
        mHeight = height;
        mColors = colors;
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        float startX;
        float startY;
        float endX;
        float endY;
        if (mHeight <= mWidth) {
            startX = mWidth;
            startY = 0;
            endX = 0;
            endY = mHeight;
        } else {
            startX = 2 * mWidth / 3;
            startY = mHeight / 3;
            endX = mWidth / 3;
            endY = 2 * mHeight / 3;
        }
        LinearGradient linearGradient = new LinearGradient(startX, startY, endX, endY, mColors, null, Shader.TileMode.CLAMP);
        Matrix localM = new Matrix();
        linearGradient.setLocalMatrix(localM);

        Paint paint = new Paint();
        paint.setShader(linearGradient);
        canvas.drawRect(0, 0, mWidth, mHeight, paint);
    }

    @Override
    public void setAlpha(int alpha) {
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }
}

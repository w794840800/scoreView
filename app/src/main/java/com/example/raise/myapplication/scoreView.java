package com.example.raise.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by raise on 17-11-16.
 */

public class scoreView extends View {
    Paint mPaint1,mPaint2,mPaint3;
    int mCurrent = 70;
    int mRadius;
    String text1 = "分";
    String text2 = "本次考试成绩";
    public scoreView(Context context) {
        super(context);

    }

    public void init() {
    mPaint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint1.setStyle(Paint.Style.STROKE);
    mPaint1.setColor(Color.YELLOW);
    mPaint1.setStrokeWidth(10);
        mPaint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint2.setStyle(Paint.Style.STROKE);
        mPaint2.setColor(Color.GREEN);
        mPaint2.setStrokeWidth(10);
        mPaint3 = new Paint();

    }

    public scoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
     init();
    }

    public scoreView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int size = width>height ?height:width;
        setMeasuredDimension(size,size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRadius = (getWidth()-10)/2;
        canvas.save();

        drawOutRound(canvas);
        drawProgressRound(canvas);
        drawText(canvas);
        canvas.restore();


    }
    public void setCurrentScore(int a){
        mCurrent = a;
        text1 = a+"分";
        postInvalidate();

    }
    private void drawText(Canvas canvas) {
        //canvas.drawText();
        canvas.save();
        mPaint3.setStrokeWidth(10);
        mPaint3.setTextSize(30);
        Rect rect = new Rect();
        mPaint3.getTextBounds(text1,0,text1.length(),rect);
        int dx1 = getWidth()/2-rect.width()/2;
        int dy1 = getHeight()/2-rect.height()/2;
        canvas.drawText(text1,dx1,dy1,mPaint3);
        Rect rect1 = new Rect();
        mPaint3.getTextBounds(text2,0,text2.length(),rect);
        int dx2 = getWidth()/2-rect.width()/2;
        int dy2 = getHeight()/2-rect.height()/2+40;
        canvas.drawText(text2,dx2,dy2,mPaint3);
        canvas.restore();
    }


    private void drawProgressRound(Canvas canvas){

        canvas.save();

        int current = (int) (mCurrent/100.0*270);
        RectF rectF = new RectF(10,10,getWidth()-10,getHeight()-10);
        canvas.drawArc(rectF,135,current,false,mPaint2);

        canvas.restore();

    }
    private void drawOutRound(Canvas canvas) {

    canvas.save();
    RectF rectF = new RectF(10,10,getWidth()-10,getHeight()-10);
    canvas.drawArc(rectF,135,270,false,mPaint1);

    canvas.restore();
    }
}

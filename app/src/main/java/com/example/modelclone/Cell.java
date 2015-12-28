/**
 * Project Name:ModelClone
 * File Name:Cell.java
 * Package Name:com.example.modelclone
 * Copyright (c) 2015, www.qianjing.com All Rights Reserved.
 *
*/

package com.example.modelclone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;



public class Cell extends View implements Cloneable {
    
    private DisplayMetrics displayMetrics;
    private ViewCollection viewColl;
    Handler mHandler = new Handler();
    private float currentX = 0;
    private float currentY = 0;
    private MyCircle myCircle;
    private float offsetX = 30;
    private float offsetY = 30;
    private float widthSize = 20;
    private float heightSize = 20;
    private int alpha = 255;
    private int red = 0;
    private int blue = 0;
    private int green = 0;
    
    @SuppressLint("NewApi")
    public Cell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }
    
    public Cell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public Cell(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }
    
    public Cell(Context context) {
        super(context);
        initView(context);
    }
    
    private void initView(Context context){
        paint = new Paint();
        paint.setColor(Color.argb(alpha, red, blue, green));
        displayMetrics = context.getResources().getDisplayMetrics();
        offsetX = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,offsetX , displayMetrics);
        offsetY = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,offsetY , displayMetrics);
        viewColl = new ViewCollection();
        
        myCircle = new MyCircle(context,currentX,currentY,widthSize,heightSize,new PointF(currentX,currentY),Color.argb(alpha, red, blue, green));
        viewColl.add(myCircle);
        mHandler.postDelayed(new TimeWork(), 1000);
    }
    
    class TimeWork implements Runnable{
        @Override
        public void run() {
            
            MyCircle cloneC;
            try {
                moveRlue();
                cloneC = myCircle.clone();
                cloneC.moveBound(currentX, currentY);
                cloneC.changeColor(Color.argb(alpha, red, blue, green));
                viewColl.add(cloneC);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            invalidate();
            mHandler.postDelayed(this, 1);
        }
    }
    
    boolean down = true;
    boolean right = true;
    private Paint paint;
    
    
    private void moveRlue() {
        
        Log.e("cloneSetting", "getWidth():"+getWidth()+",currentX:"+currentX);
        
        
//        if(red>=255){
//            red = 255;
//            if(blue>=255){
//                blue = 255;
//                if(green>=255){
//                    green = 255;
//                }else{
//                    green++;
//                }
//            }else{
//                blue++;
//            }
//        }else{
//            red++;
//        }
        alpha = (int)(Math.random()*255);
        red = (int)(Math.random()*255);
        blue = (int)(Math.random()*255);
        green = (int)(Math.random()*255);
        
        paint.setColor(Color.argb(alpha, red, blue, green));
        
        if(currentX>=getWidth()-TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,widthSize , displayMetrics)){
            right = false;
        }
        
        if(currentX<=0){
            right = true;
        }
        
        if(currentY>=getHeight()-TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,heightSize , displayMetrics)){
            down = false;
        }
        
        if(currentY<=0){
            down = true;
        }
        
        if(down){
            currentY += offsetY;
        }else{
            currentY -= offsetY;
        }
        
        if(right){
            currentX += offsetX;
        }else{
            currentX -= offsetX;
        }
        
    }
    
    /**
     * @see android.view.View#onDraw(android.graphics.Canvas)
     */
    @Override
    protected void onDraw(Canvas canvas) {
        viewColl.draw(canvas,paint);
    }
    
}


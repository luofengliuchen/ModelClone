/**
 * Project Name:ModelClone
 * File Name:MyCircle.java
 * Package Name:com.example.modelclone
 * Date:2015��10��23������10:04:29
 * Copyright (c) 2015, www.qianjing.com All Rights Reserved.
 *
*/

package com.example.modelclone;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * ClassName:ViewCollection <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * @author   liuchen
 * @version
 * @see
 */
public class MyCircle extends Object implements Cloneable {

    private DisplayMetrics displayMetrics;
    PointF pointF;
    private int color;
    public MyCircle(Context context) {
        displayMetrics = context.getResources().getDisplayMetrics();
    }
    
    public MyCircle(Context context ,float posx,float posy,float width,float height,PointF pointF,int color) {
        this.posx = posx;
        this.posy = posy;
        this.height = height;
        this.width = width;
        this.color = color;
        this.pointF = new PointF(pointF.x, pointF.y);
        displayMetrics = context.getResources().getDisplayMetrics();
    }
    
    public void changeColor(int color){
        this.color = color;
    }

    public void draw(Canvas canvas,Paint paint) {
        canvas.save();
        paint.setColor(color);
        Rect rect = new Rect((int)posx,(int)posy,(int)posx+(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,width , displayMetrics)
                ,(int)posy+(int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,height , displayMetrics));
        canvas.drawRect(rect, paint);
        canvas.restore();
    }
    
    public MyCircle clone() throws CloneNotSupportedException{
        
        MyCircle myCircle = (MyCircle)super.clone();
        if(pointF!=null){
            myCircle.pointF = new PointF(pointF.x, pointF.y);
        }
        return myCircle;
    }
    
    /**
     * @see com.example.modelclone.Object#offSetPointF()
     */
    @Override
    void offSetPointF(float offsetX,float offsetY) {
        if(pointF!=null){
            pointF.offset(offsetX, offsetY);
        }
    }
}


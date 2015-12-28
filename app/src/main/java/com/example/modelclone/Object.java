/**
 * Project Name:ModelClone
 * File Name:BaseView.java
 * Package Name:com.example.modelclone
 * Date:2015��10��23������12:13:10
 * Copyright (c) 2015, www.qianjing.com All Rights Reserved.
 *
*/

package com.example.modelclone;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * ClassName:ViewCollection <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * @author   liuchen
 * @version
 * @see
 */

public abstract class Object implements Cloneable{  
    protected float posx = 0;     
    protected float posy =0;  
    protected float width = 0;  
    protected float height = 0;  
      
    public Object() {  
        posx = 0;  
        posy =0;  
        width = 0;  
        height = 0;  
    }  
  
    public Object(float posx,float posy,float width,float height){  
        this.posx = posx;  
        this.posy = posy;  
        this.width = width;  
        this.height = height;         
    }  
      
    public void moveBound(float posXOffset,float posYOffset) {  
        this.posx += posXOffset;  
        this.posy += posYOffset;  
    }
    
    abstract  void draw(Canvas canvas,Paint paint);
    abstract  void offSetPointF(float offsetX,float offsetY);
    
    public Object clone() throws CloneNotSupportedException {    
        return (Object) super.clone();    
    }    
}  


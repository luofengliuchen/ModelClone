/**
 * Project Name:ModelClone
 * File Name:ViewCollection.java
 * Package Name:com.example.modelclone
 * Date:2015��10��23������11:51:41
 * Copyright (c) 2015, www.qianjing.com All Rights Reserved.
 *
*/

package com.example.modelclone;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * ClassName:ViewCollection <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * @author   liuchen
 * @version  
 * @see 	 
 */

public class ViewCollection {

    ArrayList<MyCircle> viewList ;
    public ViewCollection() {
        viewList = new ArrayList<MyCircle>();
    }
    
    public void add(MyCircle myCircle){
        viewList.add(myCircle);
    }
    
    public void draw(Canvas canvas,Paint paint){
        
        for (int i = 0; i < viewList.size(); i++) {
            MyCircle myCircle = viewList.get(i);
            myCircle.draw(canvas,paint);
        }
        
    }
    
}


package com.example.candiescll.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;


public class MainActivity extends Activity implements OnTouchListener {
    ImageView iv;
     int screenWidth,screenHeight;
    int lastX,lastY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv=(ImageView) findViewById(R.id.imageView1);
              iv.setOnTouchListener(this);
             Display dis=this.getWindowManager().getDefaultDisplay();
              screenWidth=dis.getWidth();
            screenHeight=dis.getHeight();

    }

    @Override
      public boolean onTouch(View v, MotionEvent event) {

              switch(event.getAction())
              {
                  case MotionEvent.ACTION_DOWN:
                        lastX=(int)event.getRawX();
                          lastY=(int)event.getRawY();

                          break;

                 case MotionEvent.ACTION_MOVE:
                        int dx=(int)event.getRawX()-lastX;
                         int dy=(int)event.getRawY()-lastY;

                         int top=v.getTop()+dy;

                        int left=v.getLeft()+dx;


                         if(top<=0)
                               {
                              top=0;
                         }
                     if(top>=screenHeight-iv.getHeight())
                         {
                              top=screenHeight-iv.getHeight();
                        }
                     if(left>=screenWidth-iv.getWidth())
                      {
                            left=screenWidth-iv.getWidth();
                         }

                   if(left<=0)
                         {
                             left=0;
                        }


                    v.layout(left, top, left+iv.getWidth(), top+iv.getHeight());
                     lastX=(int)event.getRawX();
                    lastY=(int)event.getRawY();

                   break;
                 case MotionEvent.ACTION_UP:

                         break;



                 }


           return false;
         }
  }



package com.ct.myzxing.utils;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

/**
 * @author ted.sun
 * @data 2023/4/14
 * @package com.ct.myzxing.utils
 * @PS
 */
public class Utils {

    /*
    2023-4-14 11:40:11
    判断是否修改
    可以由屏幕尺寸入手判断
    * */
    public static boolean modifySize(Context context) {

        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();

        Point point  = new Point(display.getWidth(), display.getHeight());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            display.getRealSize(point);
        }

        //todo 需要进一步判断
        if (point.y >= 2400){
            return true;
        }

        return false;
    }

}

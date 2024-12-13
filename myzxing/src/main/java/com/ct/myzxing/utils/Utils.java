package com.ct.myzxing.utils;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

import com.ct.myzxing.camera.CameraManager;

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

    /*
    2020-8-2 02:44:44
    判断是否是PAX设备*/
    public static boolean isPAX() {
//        LoganUtil.w("Build.BRAND:" + Build.BRAND, LoganUtil.SCAN_OTHER);
        if (Build.BRAND.equals("PAX") || Build.BRAND.equals("qcom")) {
            return true;
        } else {
            return false;
        }
    }

    //设置ROI最小区域
    public static void minWAndH(Point cameraResolution,Point screenResolution) {

        int defaultL = 300;

        if(cameraResolution.x > defaultL && cameraResolution.y > defaultL
                && screenResolution.x > defaultL && screenResolution.y > defaultL ){
            int minCameraL = Math.min(cameraResolution.x, cameraResolution.y);
            int minScreenL = Math.min(screenResolution.x, screenResolution.y);

            int minRoiWAndH = Math.min(minCameraL, minScreenL);

            CameraManager.ROI_MIN_WIDTH = minRoiWAndH/2;
            CameraManager.ROI_MIN_HEIGHT = minRoiWAndH/2;

        }
    }

}

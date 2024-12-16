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

    //设置ROI区域为3/5
    public static int roiWAndH(Point cameraResolution,Point screenResolution) {
        if(cameraResolution != null &&  screenResolution != null){
            int minCameraL = Math.min(cameraResolution.x, cameraResolution.y);
            int minScreenL = Math.min(screenResolution.x, screenResolution.y);

            int minWAndH = getValidMinValue(minCameraL,minScreenL);

            if (minWAndH > 0) {
                int minRoiWAndH = (minWAndH * 3) / 5;
                return minRoiWAndH;
            }
        }
        return CameraManager.ROI_MIN_WIDTH;
    }

    //设置ROI最小区域
    public static void minWAndH(Point cameraResolution,Point screenResolution) {
        if(cameraResolution != null &&  screenResolution != null){
            int minCameraL = Math.min(cameraResolution.x, cameraResolution.y);
            int minScreenL = Math.min(screenResolution.x, screenResolution.y);

            int minRoiWAndH = getValidMinValue(minCameraL,minScreenL);

            if (minRoiWAndH > 0) {
                CameraManager.ROI_MIN_WIDTH = minRoiWAndH/2;
                CameraManager.ROI_MIN_HEIGHT = minRoiWAndH/2;
            }
        }
    }

    public static int getValidMinValue(int value1, int value2) {
        // 忽略小于等于0的值
        if (value1 <= 0 && value2 <= 0) {
            return 0;
        }

        if (value1 <= 0) {
            return value2;
        }

        if (value2 <= 0) {
            return value1;
        }
        return Math.min(value1, value2);
    }

}

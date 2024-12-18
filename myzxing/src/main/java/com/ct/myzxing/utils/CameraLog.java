package com.ct.myzxing.utils;

import android.graphics.Point;
import android.graphics.Rect;

/**
 * @author ted.sun
 * @data 2024/12/18
 * @package com.ct.myzxing.utils
 * @PS 记录本次扫码第一次计算的结果
 */
public class CameraLog {

    //初始计算的roi区域
    private Rect framingRect;

    //转换之后的坐标
    private Rect framingRectInPreview;

    //矫正之后的ROI区域
    private Rect correctRoiRect;

    private Point cameraResolution;
    private Point screenResolution;

    //最终数据
    private String planarYUVLuminance;

    public Rect getFramingRect() {
        return framingRect;
    }

    public void setFramingRect(Rect framingRect) {
        if (this.framingRect == null) {
            this.framingRect = framingRect;
        }
    }

    public Rect getFramingRectInPreview() {
        return framingRectInPreview;
    }

    public void setFramingRectInPreview(Rect framingRectInPreview) {
        if (this.framingRectInPreview == null) {
            this.framingRectInPreview = framingRectInPreview;
        }
    }

    public Point getCameraResolution() {
        return cameraResolution;
    }

    public void setCameraResolution(Point cameraResolution) {
        if (this.cameraResolution == null) {
            this.cameraResolution = cameraResolution;
        }
    }

    public Point getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(Point screenResolution) {
        if (this.screenResolution == null) {
            this.screenResolution = screenResolution;
        }
    }

    public String getPlanarYUVLuminance() {
        return planarYUVLuminance;
    }

    public void setPlanarYUVLuminance(String planarYUVLuminance) {
        if (this.planarYUVLuminance == null) {
            this.planarYUVLuminance = planarYUVLuminance;
        }
    }


    public Rect getCorrectRoiRect() {
        return correctRoiRect;
    }

    public void setCorrectRoiRect(Rect correctRoiRect) {
        if (this.planarYUVLuminance == null) {
            this.correctRoiRect = correctRoiRect;
        }
    }

    @Override
    public String toString() {
        return "CameraLog{" +
                "framingRect=" + framingRect +
                ", framingRectInPreview=" + framingRectInPreview +
                ", correctRoiRect=" + correctRoiRect +
                ", cameraResolution=" + cameraResolution +
                ", screenResolution=" + screenResolution +
                ", planarYUVLuminance='" + planarYUVLuminance + '\'' +
                '}';
    }
}

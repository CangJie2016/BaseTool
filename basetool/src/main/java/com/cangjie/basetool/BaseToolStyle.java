package com.cangjie.basetool;


/**
 * Created by 李振强 on 2017/7/10.
 */

public class BaseToolStyle {
    public static int CONTENT_BACKGROUND_COLOR = R.color.app_main_color;
    public static int BACK_BUTTON_DRAWABLE = R.mipmap.toolbar_icon_back;
    public static float TITLE_TEXT_SIZE = 18;
    public static int TITLE_TEXT_COLOR = R.color.white_text;
    public static boolean TITLE_IS_BOLD = false;

    public static void setHeadContentBackgroundColor(int color){
        CONTENT_BACKGROUND_COLOR = color;
    }

    public static void setBackButtonDrawable(int drawable){
        BACK_BUTTON_DRAWABLE = drawable;
    }

    public static void setHeadTitleTextStyle(int size, int color, boolean isBold){
        TITLE_TEXT_SIZE = size;
        TITLE_TEXT_COLOR = color;
        TITLE_IS_BOLD = isBold;
    }

}

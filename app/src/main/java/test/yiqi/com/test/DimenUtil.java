package test.yiqi.com.test;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by moumou on 17/11/7.
 */

public class DimenUtil {
    public static int getScreenWidth(Context context){
        final Resources resources=context.getApplicationContext().getResources();
        final DisplayMetrics dm=resources.getDisplayMetrics();
        return dm.widthPixels;
    }
    public static int getScreenHeight(Context context){
        final Resources resources=context.getApplicationContext().getResources();
        final DisplayMetrics dm=resources.getDisplayMetrics();
        //ss
        return dm.heightPixels;
    }
}

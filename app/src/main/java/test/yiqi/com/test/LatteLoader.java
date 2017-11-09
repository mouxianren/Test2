package test.yiqi.com.test;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;

/**
 * Created by moumou on 17/11/7.
 */

public class LatteLoader {
    private static final int LOADER_SIZE_SCALE =8;
    private static final int LOADER_OFFSET_SCALE = 10;

    private static final String DEFAULT_LOADER = LoaderStyle.BallPulseRiseIndicator.name();

    private static final ArrayList<AppCompatDialog> LOADERS = new ArrayList<AppCompatDialog>();

    public static void showLoading(Context context, String type) {
        final AppCompatDialog dialog = new AppCompatDialog(context, R.style.dialog);
        final AVLoadingIndicatorView avLoadingIndicatorView = LoaderCreator.create(type, context);
        dialog.setContentView(avLoadingIndicatorView);
dialog.setCanceledOnTouchOutside(false);

        avLoadingIndicatorView.setIndicatorColor(context.getResources().getColor(R.color.colorAccent));
        int deviceWidth = DimenUtil.getScreenWidth(context);
        int deviceHeight = DimenUtil.getScreenHeight(context);
        final Window dialogWindow = dialog.getWindow();
        if (dialogWindow != null) {
            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = deviceWidth / LOADER_SIZE_SCALE;
            lp.height = deviceHeight / LOADER_SIZE_SCALE;
         //  lp.height = lp.height + deviceHeight / LOADER_OFFSET_SCALE;
            lp.gravity = Gravity.CENTER;
        }
        LOADERS.add(dialog);
        dialog.show();
    }

    public static void showLoading(Context context) {
        showLoading(context, DEFAULT_LOADER);
    }

    public static void stopLoading() {
        for (AppCompatDialog dialog : LOADERS) {
            if (dialog != null) {
                if (dialog.isShowing()) {
                    dialog.cancel();
                }
            }
        }
    }
}

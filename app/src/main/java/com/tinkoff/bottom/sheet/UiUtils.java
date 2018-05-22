package com.tinkoff.bottom.sheet;

import android.content.res.Resources;

/**
 * @author Vitaly Kirillov
 */
public class UiUtils {
    public static int dpToPx(float dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}

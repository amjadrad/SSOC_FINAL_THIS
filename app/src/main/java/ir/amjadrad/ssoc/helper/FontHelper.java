package ir.amjadrad.ssoc.helper;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Amjad Qasemie Rad on 3/4/2018.
 */

public class FontHelper {

    public static int fontSahel = 0;

    public Typeface getFont(Context context ,int font){
        Typeface tf = Typeface.createFromAsset(context.getAssets() , "font/sahel.ttf");

        switch (font){
            case 0:{
                break;
            }
        }
        return tf;
    }


}

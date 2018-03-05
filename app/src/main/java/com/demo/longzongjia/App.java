package com.demo.longzongjia;

import android.app.Application;
import android.content.Context;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;

import com.bilibili.magicasakura.utils.ThemeUtils;
import com.demo.longzongjia.daggerdemo.R;
import com.demo.longzongjia.daggerdemo.di.component.AppComponent;
import com.demo.longzongjia.daggerdemo.di.component.DaggerAppComponent;
import com.demo.longzongjia.daggerdemo.di.moudle.ApiMoudle;
import com.demo.longzongjia.daggerdemo.di.moudle.AppMoudle;
import com.demo.longzongjia.daggerdemo.di.moudle.UtilsModule;
import com.demo.longzongjia.daggerdemo.utils.ThemeHelper;

import javax.inject.Inject;


/**
 * Created by longzongjia on 2018/2/25.
 */

public class App extends Application implements ThemeUtils.switchColor {
    ThemeHelper themeHelper;

    private AppComponent appComponent;

    public static App getApplication(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ThemeUtils.setSwitchColor(this);
        appComponent = DaggerAppComponent.builder()
                .appMoudle(new AppMoudle(this))
                .apiMoudle(new ApiMoudle())
                .utilsModule(new UtilsModule())
                .build();
        themeHelper = appComponent.getThemeHelper();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public int replaceColorById(Context context, @ColorRes int colorId) {
        if (themeHelper.isDefaultTheme(context)) {
            return context.getResources().getColor(colorId);
        }
        String theme = getTheme(context);
        if (theme != null) {
            colorId = getThemeColorId(context, colorId, theme);
        }
        return context.getResources().getColor(colorId);
    }

    @Override
    public int replaceColor(Context context, @ColorInt int originColor) {
        if (themeHelper.isDefaultTheme(context)) {
            return originColor;
        }
        String theme = getTheme(context);
        int colorId = -1;

        if (theme != null) {
            colorId = getThemeColor(context, originColor, theme);
        }
        return colorId != -1 ? getResources().getColor(colorId) : originColor;
    }

    private String getTheme(Context context) {
        if (themeHelper.getTheme(context) == ThemeHelper.CARD_STORM) {
            return "blue";
        } else if (themeHelper.getTheme(context) == ThemeHelper.CARD_HOPE) {
            return "purple";
        } else if (themeHelper.getTheme(context) == ThemeHelper.CARD_WOOD) {
            return "green";
        } else if (themeHelper.getTheme(context) == ThemeHelper.CARD_LIGHT) {
            return "green_light";
        } else if (themeHelper.getTheme(context) == ThemeHelper.CARD_THUNDER) {
            return "yellow";
        } else if (themeHelper.getTheme(context) == ThemeHelper.CARD_SAND) {
            return "orange";
        } else if (themeHelper.getTheme(context) == ThemeHelper.CARD_FIREY) {
            return "red";
        }
        return null;
    }

    private
    @ColorRes
    int getThemeColorId(Context context, int colorId, String theme) {
        switch (colorId) {
            case R.color.theme_color_primary:
                return context.getResources().getIdentifier(theme, "color", getPackageName());
            case R.color.theme_color_primary_dark:
                return context.getResources().getIdentifier(theme + "_dark", "color", getPackageName());
            case R.color.theme_color_primary_trans:
                return context.getResources().getIdentifier(theme + "_trans", "color", getPackageName());
        }
        return colorId;
    }

    private
    @ColorRes
    int getThemeColor(Context context, int color, String theme) {
        switch (color) {
            case 0xfffb7299:
                return context.getResources().getIdentifier(theme, "color", getPackageName());
            case 0xffb85671:
                return context.getResources().getIdentifier(theme + "_dark", "color", getPackageName());
            case 0x99f0486c:
                return context.getResources().getIdentifier(theme + "_trans", "color", getPackageName());
        }
        return -1;
    }
}

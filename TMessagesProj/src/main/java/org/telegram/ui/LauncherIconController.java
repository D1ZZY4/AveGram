package org.telegram.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;

import org.telegram.messenger.ApplicationLoader;
import org.telegram.messenger.R;

public class LauncherIconController {
    public static void tryFixLauncherIconIfNeeded() {
        for (LauncherIcon icon : LauncherIcon.values()) {
            if (isEnabled(icon)) {
                return;
            }
        }

        setIcon(LauncherIcon.AVEGRAM);
    }

    public static boolean isEnabled(LauncherIcon icon) {
        Context ctx = ApplicationLoader.applicationContext;
        int i = ctx.getPackageManager().getComponentEnabledSetting(icon.getComponentName(ctx));
        return i == PackageManager.COMPONENT_ENABLED_STATE_ENABLED || i == PackageManager.COMPONENT_ENABLED_STATE_DEFAULT && icon == LauncherIcon.AVEGRAM;
    }

    public static void setIcon(LauncherIcon icon) {
        Context ctx = ApplicationLoader.applicationContext;
        PackageManager pm = ctx.getPackageManager();
        for (LauncherIcon i : LauncherIcon.values()) {
            pm.setComponentEnabledSetting(i.getComponentName(ctx), i == icon ? PackageManager.COMPONENT_ENABLED_STATE_ENABLED :
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
        }
    }

    public enum LauncherIcon {
        AVEGRAM("AveGramIcon", R.drawable.ic_launcher_avegram_background, R.mipmap.ic_launcher_avegram_foreground, R.string.AppIconAveGram),
        AVEGRAM_BLUE("AveGramBlueIcon", R.drawable.ic_launcher_avegram_blue_background, R.mipmap.ic_launcher_avegram_foreground, R.string.AppIconAveGramBlue),
        AVEGRAM_DARKBLUE("AveGramDarkBlueIcon", R.drawable.ic_launcher_avegram_dark_blue_background, R.mipmap.ic_launcher_avegram_foreground, R.string.AppIconAveGramDarkBlue),
        AVEGRAM_BLURBLUE("AveGramBlurBlueIcon", R.drawable.ic_launcher_avegram_blur_blue_background, R.mipmap.ic_launcher_avegram_foreground, R.string.AppIconAveGramBlurBlue),
        AVEGRAM_DARKGREEN("AveGramDarkGreenIcon", R.drawable.ic_launcher_avegram_darkgreen_background, R.mipmap.ic_launcher_avegram_foreground, R.string.AppIconAveGramDarkGreen),
        AVEGRAM_NEON("AveGramNeonIcon", R.drawable.ic_launcher_avegram_neon_background, R.mipmap.ic_launcher_avegram_foreground, R.string.AppIconAveGramNeon),
        AVEGRAM_COLORFUL("AveGramColorfulIcon", R.drawable.ic_launcher_avegram_colorful_background, R.mipmap.ic_launcher_avegram_foreground, R.string.AppIconAveGramColorful),
        AVEGRAM_NIELLO("AveGramNielloIcon", R.drawable.ic_launcher_avegram_niello_background, R.mipmap.ic_launcher_avegram_foreground, R.string.AppIconAveGramNiello),
        AVEGRAM_GOOGLE("AveGramGoogleIcon", R.drawable.ic_launcher_avegram_google_background, R.mipmap.ic_launcher_avegram_foreground, R.string.AppIconAveGramGoogle),
        DEFAULT("DefaultIcon", R.mipmap.ic_launcher_nagram, R.mipmap.icon_background_nagram, R.string.AppIconDefault),
        GOOGLE("GoogleIcon", R.mipmap.icon_background_google, R.mipmap.icon_foreground_google, R.string.AppIconGoogle),
        COLORFUL("ColorfulIcon", R.mipmap.icon_background_colorful, R.mipmap.icon_foreground_colorful, R.string.AppIconColorful),
        DARKGREEN("DarkGreenIcon", R.mipmap.icon_background_darkgreen, R.mipmap.icon_foreground_darkgreen, R.string.AppIconDarkGreen),
        NEON("NeonIcon", R.mipmap.icon_background_neon, R.mipmap.icon_foreground_neon, R.string.AppIconNeon),
        NIELLO("NielloIcon", R.drawable.ic_launcher_nagram_round_niello_background, R.drawable.ic_launcher_nagram_round_niello_foreground, R.string.AppIconNiello),
        BLUE("BlueIcon", R.color.nagram_block_round_background, R.drawable.ic_launcher_nagram_blue_foreground, R.string.AppIconBlue),
        DARKBLUE("DarkBlueIcon", R.color.nagram_dark_blue_background, R.drawable.ic_launcher_nagram_dark_blue_foreground, R.string.AppIconDarkBlue),
        BLURBLUE("BlurBlueIcon", R.drawable.ic_launcher_nagram_blur_blue_background, R.drawable.ic_launcher_nagram_blur_blue_foreground, R.string.AppIconBlurBlue),
        TELEGRAM("TelegramIcon", R.drawable.icon_background_sa, R.mipmap.icon_foreground_sa, R.string.AppIconTelegramOriginal),
        VINTAGE("VintageIcon", R.drawable.icon_6_background_sa, R.mipmap.icon_6_foreground_sa, R.string.AppIconVintage),
        AQUA("AquaIcon", R.drawable.icon_4_background_sa, R.mipmap.icon_foreground_sa, R.string.AppIconAqua),
        PREMIUM("PremiumIcon", R.drawable.icon_3_background_sa, R.mipmap.icon_3_foreground_sa, R.string.AppIconPremium),
        TURBO("TurboIcon", R.drawable.icon_5_background_sa, R.mipmap.icon_5_foreground_sa, R.string.AppIconTurbo),
        NOX("NoxIcon", R.mipmap.icon_2_background_sa, R.mipmap.icon_foreground_sa, R.string.AppIconNox);

        public final String key;
        public final int background;
        public final int foreground;
        public final int title;
        public final boolean premium;

        private ComponentName componentName;

        public ComponentName getComponentName(Context ctx) {
            if (componentName == null) {
                componentName = new ComponentName(ctx.getPackageName(), "org.telegram.messenger." + key);
            }
            return componentName;
        }

        LauncherIcon(String key, int background, int foreground, int title) {
            this(key, background, foreground, title, false);
        }

        LauncherIcon(String key, int background, int foreground, int title, boolean premium) {
            this.key = key;
            this.background = background;
            this.foreground = foreground;
            this.title = title;
            this.premium = premium;
        }

        public boolean isAveX() {
            return this == AVEGRAM
                    || this == AVEGRAM_BLUE
                    || this == AVEGRAM_DARKBLUE
                    || this == AVEGRAM_BLURBLUE
                    || this == AVEGRAM_DARKGREEN
                    || this == AVEGRAM_NEON
                    || this == AVEGRAM_COLORFUL
                    || this == AVEGRAM_NIELLO
                    || this == AVEGRAM_GOOGLE
                    || this == DEFAULT;
        }
    }
}

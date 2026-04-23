package org.avegram.ave;

public class DialogConfig {
    public static final String customForumTabPrefix = "customForumTabs_";

    public static String getCustomForumTabsKey(long dialogId) {
        return customForumTabPrefix + dialogId;
    }

    public static boolean isCustomForumTabsEnable(long dialogId) {
        return AveConfig.getPreferences().getBoolean(getCustomForumTabsKey(dialogId), false);
    }

    public static boolean hasCustomForumTabsConfig(long dialogId) {
        return AveConfig.getPreferences().contains(getCustomForumTabsKey(dialogId));
    }

    public static void setCustomForumTabsEnable(long dialogId, boolean enable) {
        AveConfig.getPreferences().edit().putBoolean(getCustomForumTabsKey(dialogId), enable).apply();
    }

    public static void removeCustomForumTabsConfig(long dialogId) {
        AveConfig.getPreferences().edit().remove(getCustomForumTabsKey(dialogId)).apply();
    }
}

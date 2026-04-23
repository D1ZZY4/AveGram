package org.avegram.ave.helpers;

import static org.telegram.messenger.LocaleController.getString;
import static org.telegram.ui.ProfileActivity.sendLogs;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;

import org.telegram.messenger.AndroidUtilities;
import org.telegram.messenger.R;
import org.telegram.ui.ActionBar.BaseFragment;

import java.util.ArrayList;
import java.util.Map;

import org.avegram.ave.settings.BaseAveSettingsActivity;
import org.avegram.ave.settings.BaseAveXSettingsActivity;
import org.avegram.ave.settings.AveAboutActivity;
import org.avegram.ave.settings.AveAppearanceSettingsActivity;
import org.avegram.ave.settings.AveAyuMomentsSettingsActivity;
import org.avegram.ave.settings.AveChatSettingsActivity;
import org.avegram.ave.settings.AveEmojiSettingsActivity;
import org.avegram.ave.settings.AveExperimentalSettingsActivity;
import org.avegram.ave.settings.AveGeneralSettingsActivity;
import org.avegram.ave.settings.AvePasscodeSettingsActivity;
import org.avegram.ave.settings.AveSettingsActivity;
import org.avegram.ave.settings.AveTranslatorSettingsActivity;

public class SettingsHelper {

    public static void processDeepLink(Activity activity, Uri uri, Callback callback, Runnable unknown) {
        if (uri == null) {
            unknown.run();
            return;
        }
        var segments = uri.getPathSegments();
        if (segments.isEmpty() || segments.size() > 2 || !"nasettings".equals(segments.get(0))) {
            unknown.run();
            return;
        }
        BaseFragment fragment;
        BaseAveSettingsActivity ave_fragment = null;
        BaseAveXSettingsActivity avex_fragment = null;
        if (segments.size() == 1) {
            fragment = new AveSettingsActivity();
        } else if (PasscodeHelper.getSettingsKey().equals(segments.get(1))) {
            fragment = ave_fragment = new AvePasscodeSettingsActivity();
        } else {
            switch (segments.get(1)) {
                case "about":
                    fragment = new AveAboutActivity();
                    break;
                case "chat":
                case "chats":
                case "c":
                    fragment = avex_fragment = new AveChatSettingsActivity();
                    break;
                case "appearance":
                case "a":
                    fragment = avex_fragment = new AveAppearanceSettingsActivity();
                    break;
                case "ayumoments":
                case "ayugrammoment":
                case "m":
                    fragment = avex_fragment = new AveAyuMomentsSettingsActivity();
                    break;
                case "experimental":
                case "e":
                    fragment = avex_fragment = new AveExperimentalSettingsActivity();
                    break;
                case "emoji":
                    fragment = ave_fragment = new AveEmojiSettingsActivity();
                    break;
                case "general":
                case "g":
                    fragment = avex_fragment = new AveGeneralSettingsActivity();
                    break;
                case "translator":
                case "translate":
                case "t":
                    fragment = avex_fragment = new AveTranslatorSettingsActivity();
                    break;
                case "send_logs":
                    sendLogs(activity, false);
                    return;
                default:
                    unknown.run();
                    return;
            }
        }
        callback.presentFragment(fragment);
        var row = uri.getQueryParameter("r");
        if (TextUtils.isEmpty(row)) {
            row = uri.getQueryParameter("row");
        }
        var value = uri.getQueryParameter("v");
        if (TextUtils.isEmpty(value)) {
            value = uri.getQueryParameter("value");
        }
        if (!TextUtils.isEmpty(row)) {
            var rowFinal = row;
            if (ave_fragment != null) {
                BaseAveSettingsActivity finalAve_fragment = ave_fragment;
                AndroidUtilities.runOnUIThread(() -> finalAve_fragment.scrollToRow(rowFinal, unknown));
            } else if (avex_fragment != null) {
                BaseAveXSettingsActivity finalAveX_fragment = avex_fragment;
                if (!TextUtils.isEmpty(value)) {
                    String finalValue = value;
                    AndroidUtilities.runOnUIThread(() -> finalAveX_fragment.importToRow(rowFinal, finalValue, unknown));
                } else {
                    AndroidUtilities.runOnUIThread(() -> finalAveX_fragment.scrollToRow(rowFinal, unknown));
                }
            }
        }
    }

    public interface Callback {
        void presentFragment(BaseFragment fragment);
    }

    public static ArrayList<SettingsSearchResult> onCreateSearchArray(Callback callback) {
        ArrayList<SettingsSearchResult> items = new ArrayList<>();
        ArrayList<BaseAveXSettingsActivity> fragments = new ArrayList<>();
        fragments.add(new AveGeneralSettingsActivity());
        fragments.add(new AveAppearanceSettingsActivity());
        fragments.add(new AveAyuMomentsSettingsActivity());
        fragments.add(new AveChatSettingsActivity());
        fragments.add(new AveExperimentalSettingsActivity());
        fragments.add(new AveTranslatorSettingsActivity());

        String n_title = getString(R.string.AveSettings);
        for (BaseAveXSettingsActivity fragment: fragments) {
            int uid = fragment.getBaseGuid();
            int drawable = fragment.getDrawable();
            String f_title = fragment.getTitle();
            for (Map.Entry<Integer, String> entry : fragment.getRowMapReverse().entrySet()) {
                Integer i = entry.getKey();
                String key = entry.getValue();
                if (key.equals(String.valueOf(i))) {
                    continue;
                }
                int guid = uid + i;
                String title = getString(key);
                if (title == null || title.isEmpty()) {
                    continue;
                }
                Runnable open = () -> {
                    callback.presentFragment(fragment);
                    AndroidUtilities.runOnUIThread(() -> fragment.scrollToRow(key, null));
                };
                SettingsSearchResult result = new SettingsSearchResult(
                        guid, title, n_title, f_title, drawable, open
                );
                items.add(result);
            }
        }
        return items;
    }
}

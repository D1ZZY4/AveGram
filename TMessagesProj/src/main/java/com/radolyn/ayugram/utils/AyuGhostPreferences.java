package com.radolyn.ayugram.utils;

import java.util.concurrent.ConcurrentHashMap;

import org.avegram.ave.AveConfig;

public class AyuGhostPreferences {
    public static final String ghostReadExclusionPrefix = "ghostModeReadExclusion_";
    public static final String ghostTypingExclusionPrefix = "ghostModeTypingExclusion_";
    private static final ConcurrentHashMap<Long, Boolean> ghostModeReadExclusions = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Long, Boolean> ghostModeTypingExclusions = new ConcurrentHashMap<>();

    public static void setGhostModeReadExclusion(long chatId, boolean value) {
        long key = Math.abs(chatId);
        ghostModeReadExclusions.put(key, value);
        AveConfig.getPreferences().edit().putBoolean(ghostReadExclusionPrefix + key, value).apply();
    }

    public static boolean getGhostModeReadExclusion(long chatId) {
        long key = Math.abs(chatId);
        return ghostModeReadExclusions.computeIfAbsent(key, k ->
                AveConfig.getPreferences().getBoolean(ghostReadExclusionPrefix + k, false)
        );
    }

    public static void setGhostModeTypingExclusion(long chatId, boolean value) {
        long key = Math.abs(chatId);
        ghostModeTypingExclusions.put(key, value);
        AveConfig.getPreferences().edit().putBoolean(ghostTypingExclusionPrefix + key, value).apply();
    }

    public static boolean getGhostModeTypingExclusion(long chatId) {
        long key = Math.abs(chatId);
        return ghostModeTypingExclusions.computeIfAbsent(key, k ->
                AveConfig.getPreferences().getBoolean(ghostTypingExclusionPrefix + k, false)
        );
    }

}

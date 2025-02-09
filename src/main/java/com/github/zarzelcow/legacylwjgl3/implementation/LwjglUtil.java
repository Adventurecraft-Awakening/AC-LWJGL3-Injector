package com.github.zarzelcow.legacylwjgl3.implementation;

import org.lwjgl.system.Callback;

import javax.annotation.Nullable;

public final class LwjglUtil {
    public static void tryFree(@Nullable Callback callback) {
        if (callback != null) {
            callback.free();
        }
    }
}

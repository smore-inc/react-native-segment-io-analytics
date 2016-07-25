package com.smore.RNSegmentIOAnalytics;

import com.smore.RNSegmentIOAnalytics.RNSegmentIOAnalyticsModule;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.uimanager.ViewManager;

import android.util.Log;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class RNSegmentIOAnalyticsPackage implements ReactPackage {
  @Override
  public List<NativeModule> createNativeModules(
                              ReactApplicationContext reactContext) {

    Log.d("RNSegmentIOAnalytics", "Initializing RNSegmentIOAnalyticsPackage");

    List<NativeModule> modules = new ArrayList<>();

    modules.add(new RNSegmentIOAnalyticsModule(reactContext));

    return modules;
  }

  @Override
  public List<Class<? extends JavaScriptModule>> createJSModules() {
      return Collections.emptyList();
  }

  @Override
  public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
      return Collections.emptyList();
  }
}

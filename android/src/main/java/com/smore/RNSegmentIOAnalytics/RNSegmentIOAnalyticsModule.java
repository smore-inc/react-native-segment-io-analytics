package com.smore.RNSegmentIOAnalytics;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;

import com.facebook.react.bridge.ReadableType;
import com.segment.analytics.Analytics;
import com.segment.analytics.Analytics.Builder;
import com.segment.analytics.Properties;
import com.segment.analytics.Traits;
import com.segment.analytics.Options;
import android.util.Log;
import android.content.Context;

public class RNSegmentIOAnalyticsModule extends ReactContextBaseJavaModule {
  private static boolean initialized = false;
  private boolean mEnabled = true;
  private boolean mDebug = false;

  @Override
  public String getName() {
    return "RNSegmentIOAnalytics";
  }

  private void log(String message) {
    Log.d("RNSegmentIOAnalytics", message);
  }

  public RNSegmentIOAnalyticsModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  /*
   https://segment.com/docs/libraries/android/#identify
   */
  @ReactMethod
  public void setup(String writeKey, Integer flushAt, Boolean shouldUseLocationServices) {
    if (!initialized) {
      Context context = getReactApplicationContext().getApplicationContext();
      Builder builder = new Analytics.Builder(context, writeKey);
      builder.flushQueueSize(flushAt);

      if (mDebug) {
        builder.logLevel(Analytics.LogLevel.DEBUG);
      }

      Analytics analytics = builder.build();
      Analytics.setSingletonInstance(analytics);
      initialized = true;
    } else {
      log("Segment Analytics already initialized. Refusing to re-initialize.");
    }
  }

  /*
   https://segment.com/docs/libraries/android/#identify
   */
  @ReactMethod
  public void identifyUser(String userId, ReadableMap traits) {
    if (!mEnabled) {
      return;
    }
    Analytics.with(null).identify(userId, toTraits(traits), toOptions(null));
  }

  /*
   https://segment.com/docs/libraries/android/#track
   */
  @ReactMethod
  public void track(String trackText, ReadableMap properties) {
    if (!mEnabled) {
      return;
    }
    Analytics.with(null).track(trackText, toProperties(properties));
  }

  /*
   https://segment.com/docs/libraries/android/#screen
   */
  @ReactMethod
  public void screen(String screenName, ReadableMap properties) {
    if (!mEnabled) {
      return;
    }
    Analytics.with(null).screen(null, screenName, toProperties(properties));
  }

  /*
   https://segment.com/docs/libraries/android/#flushing
   */
  @ReactMethod
  public void flush() {
    Analytics.with(null).flush();
  }

  /*
   https://segment.com/docs/libraries/android/#reset
   */
  @ReactMethod
  public void reset() {
    Analytics.with(null).reset();
  }

  /*
   https://segment.com/docs/libraries/android/#logging
   */
  @ReactMethod
  public void debug(Boolean isEnabled) {
    if (isEnabled == mDebug) {
      return;
    } else if (!initialized) {
      mDebug = isEnabled;
    } else {
      log("On Android, debug level may not be changed after calling setup");
    }
  }

  /*
   https://segment.com/docs/libraries/android/#opt-out
   */
  @ReactMethod
  public void disable() {
    mEnabled = false;
  }

  /*
   https://segment.com/docs/libraries/android/#opt-out
   */
  @ReactMethod
  public void enable() {
    mEnabled = true;
  }

  private Properties toProperties (ReadableMap map) {
    if (map == null) {
      return new Properties();
    }
    Properties props = new Properties();

    ReadableMapKeySetIterator iterator = map.keySetIterator();
    while (iterator.hasNextKey()) {
      String key = iterator.nextKey();
      ReadableType type = map.getType(key);
      switch (type){
        case Array:
          props.putValue(key, map.getArray(key));
          break;
        case Boolean:
          props.putValue(key, map.getBoolean(key));
          break;
        case Map:
          props.putValue(key, map.getMap(key));
          break;
        case Null:
          props.putValue(key, null);
          break;
        case Number:
          props.putValue(key, map.getDouble(key));
          break;
        case String:
          props.putValue(key, map.getString(key));
          break;
        default:
          log("Unknown type:" + type.name());
          break;
      }
    }
    return props;
  }

  private Traits toTraits (ReadableMap map) {
    if (map == null) {
      return new Traits();
    }
    Traits traits = new Traits();

    ReadableMapKeySetIterator iterator = map.keySetIterator();
    while (iterator.hasNextKey()) {
      String key = iterator.nextKey();
      ReadableType type = map.getType(key);
      switch (type){
        case Array:
          traits.putValue(key, map.getArray(key));
          break;
        case Boolean:
          traits.putValue(key, map.getBoolean(key));
          break;
        case Map:
          traits.putValue(key, map.getMap(key));
          break;
        case Null:
          traits.putValue(key, null);
          break;
        case Number:
          traits.putValue(key, map.getDouble(key));
          break;
        case String:
          traits.putValue(key, map.getString(key));
          break;
        default:
          log("Unknown type:" + type.name());
          break;
      }
    }
    return traits;
  }

  private Options toOptions (ReadableMap map) {
    return new Options();
  }
}

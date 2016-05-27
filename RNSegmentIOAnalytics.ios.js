/**
 * @providesModule RNSegmentIOAnalytics
 * @flow
 *
 * Created by Tal Kain <tal@kain.net>.
 * Copyright (c) 2015 Fire Place Inc. All rights reserved.
 */
'use strict';

var NativeRNSegmentIOAnalytics = require('react-native').NativeModules.RNSegmentIOAnalytics;

/**
 * RNSegmentIOAnalytics is a React Native iOS wrapper for the Segment.com Analytics SDK.
 */

var RNSegmentIOAnalytics = {
    /*
     * Setting up the Segment IO Analytics service
     *
     * @param configKey https://segment.com/docs/libraries/ios/#configuration
     * @param flushAt https://segment.com/docs/libraries/ios/#flushing
     * @param shouldUseLocationServices https://segment.com/docs/libraries/ios/#location-services
     */
    setup: function (configKey, flushAt = 20, shouldUseLocationServices = false) {
        NativeRNSegmentIOAnalytics.setup(configKey, flushAt, shouldUseLocationServices);
    },

    /*
     * https://segment.com/docs/libraries/ios/#identify
     */
    identifyUser: function (userId, traits) {
        NativeRNSegmentIOAnalytics.identifyUser(userId, traits);
    },

    /*
     * https://segment.com/docs/libraries/ios/#track
     */
    track: function (trackText, properties) {
        NativeRNSegmentIOAnalytics.track(trackText, properties);
    },

    /*
     * https://segment.com/docs/libraries/ios/#screen
     */
    screen: function (screenName, properties) {
        NativeRNSegmentIOAnalytics.screen(screenName, properties);
    },

    /*
     * https://segment.com/docs/libraries/ios/#reset
     */
    reset: function () {
        NativeRNSegmentIOAnalytics.reset();
    },

    /*
     * https://segment.com/docs/libraries/ios/#flushing
     */
    flush: function () {
        NativeRNSegmentIOAnalytics.flush();
    },

    /*
     * https://segment.com/docs/libraries/ios/#logging
     */
    debug: function (isEnabled) {
        NativeRNSegmentIOAnalytics.debug(isEnabled);
    },

    /*
     * https://segment.com/docs/libraries/ios/#opt-out
     */
    disable: function () {
        NativeRNSegmentIOAnalytics.disable();
    },

    /*
     * https://segment.com/docs/libraries/ios/#opt-out
     */
    enable: function () {
        NativeRNSegmentIOAnalytics.enable();
    },

    /*
     * https://segment.com/docs/spec/alias/
     */
    alias: function (newId) {
        NativeRNSegmentIOAnalytics.alias(newId);
    },
};

module.exports = RNSegmentIOAnalytics;

/**
 * @providesModule RNSegmentIOAnalytics
 * @flow
 *
 * Created by Tal Kain <tal@kain.net>,
 * and Ricky Reusser <rsreusser@gmail.com>,
 * and Alex Rothberg
 * Copyright (c) 2016 Fire Place Inc. All rights reserved.
 */
'use strict';

var NativeRNSegmentIOAnalytics = require('react-native').NativeModules.RNSegmentIOAnalytics;

/**
 * RNSegmentIOAnalytics is a React Native wrapper for the Segment.com Analytics SDK.
 */

var RNSegmentIOAnalytics = {
    /*
     * Setting up the Segment IO Analytics service
     *
     * @param configKey https://segment.com/docs/libraries/ios/#configuration or https://segment.com/docs/libraries/android/#customizing-the-client
     * @param flushAt https://segment.com/docs/libraries/ios/#flushing or https://segment.com/docs/libraries/android/#customizing-the-client
     * @param shouldUseLocationServices https://segment.com/docs/libraries/ios/#location-services
     */
    setup: function (configKey, flushAt = 20, shouldUseLocationServices = false) {
        NativeRNSegmentIOAnalytics.setup(configKey, flushAt, shouldUseLocationServices);
    },

    /*
     * https://segment.com/docs/libraries/ios/#identify
     * https://segment.com/docs/libraries/android/#identify
     */
    identifyUser: function (userId, traits) {
        NativeRNSegmentIOAnalytics.identifyUser(userId, traits);
    },

    /*
     * https://segment.com/docs/libraries/ios/#track
     * https://segment.com/docs/libraries/android/#track
     */
    track: function (trackText, properties) {
        NativeRNSegmentIOAnalytics.track(trackText, properties);
    },

    /*
     * https://segment.com/docs/libraries/ios/#screen
     * https://segment.com/docs/libraries/android/#screen
     */
    screen: function (screenName, properties) {
        NativeRNSegmentIOAnalytics.screen(screenName, properties);
    },

    /*
     * https://segment.com/docs/libraries/ios/#reset
     * https://segment.com/docs/libraries/android/#how-do-you-handle-unique-identifiers-
     */
    reset: function () {
        NativeRNSegmentIOAnalytics.reset();
    },

    /*
     * https://segment.com/docs/libraries/ios/#flushing
     * https://segment.com/docs/libraries/android/#how-does-the-library-queue-api-calls-
     */
    flush: function () {
        NativeRNSegmentIOAnalytics.flush();
    },

    /*
     * https://segment.com/docs/libraries/ios/#logging
     * https://segment.com/docs/libraries/android/#debugging
     */
    debug: function (isEnabled) {
        NativeRNSegmentIOAnalytics.debug(isEnabled);
    },

    /*
     * https://segment.com/docs/libraries/ios/#opt-out
     * https://segment.com/docs/libraries/android/#context
     */
    disable: function () {
        NativeRNSegmentIOAnalytics.disable();
    },

    /*
     * https://segment.com/docs/libraries/ios/#opt-out
     * https://segment.com/docs/libraries/android/#context
     */
    enable: function () {
        NativeRNSegmentIOAnalytics.enable();
    },
};

module.exports = RNSegmentIOAnalytics;

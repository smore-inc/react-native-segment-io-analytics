//
//  RNSegmentIOAnalytics
//
//  Created by Tal Kain <tal@kain.net>.
//  Copyright (c) 2015 Fire Place Inc. All rights reserved.
//

#import "RNSegmentIOAnalytics.h"
#import "RCTConvert.h"
#import "SEGAnalytics.h"
#import <Foundation/Foundation.h>

@implementation RNSegmentIOAnalytics

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(setup:(NSString*)configKey :(NSUInteger)flushAt :(BOOL)shouldUseLocationServices :(BOOL)debug)
{
    SEGAnalyticsConfiguration *configuration = [SEGAnalyticsConfiguration configurationWithWriteKey:configKey];
    configuration.flushAt = flushAt;
    configuration.shouldUseLocationServices = shouldUseLocationServices;
    [SEGAnalytics setupWithConfiguration:configuration];
    [SEGAnalytics debug:debug];
}

/*
 https://segment.com/docs/libraries/ios/#identify
 */
RCT_EXPORT_METHOD(identifyUser:(NSString*)userId traits:(NSDictionary *)traits) {
    [[SEGAnalytics sharedAnalytics] identify:userId traits:[self convertToStringDictionary:traits]];
}

/*
 https://segment.com/docs/libraries/ios/#alias
 */
RCT_EXPORT_METHOD(alias:(NSString *)newId) {
    [[SEGAnalytics sharedAnalytics] alias:newId];
}

/*
 https://segment.com/docs/libraries/ios/#track
 */
RCT_EXPORT_METHOD(track:(NSString*)trackText properties:(NSDictionary *)properties) {
    [[SEGAnalytics sharedAnalytics] track:trackText
                               properties:[self convertToStringDictionary:properties]];
}
/*
 https://segment.com/docs/libraries/ios/#screen
 */
RCT_EXPORT_METHOD(screen:(NSString*)screenName properties:(NSDictionary *)properties) {
    [[SEGAnalytics sharedAnalytics] screen:screenName properties:[self convertToStringDictionary:properties]];
}

/*
 https://segment.com/docs/libraries/ios/#flushing
 */
RCT_EXPORT_METHOD(flush) {
    [[SEGAnalytics sharedAnalytics] flush];
}

/*
 https://segment.com/docs/libraries/ios/#reset
 */
RCT_EXPORT_METHOD(reset) {
    [[SEGAnalytics sharedAnalytics] reset];
}

/*
 https://segment.com/docs/libraries/ios/#logging
 */
RCT_EXPORT_METHOD(debug: (BOOL)isEnabled) {
    [SEGAnalytics debug:isEnabled];
}

/*
 https://segment.com/docs/libraries/ios/#opt-out
 */
RCT_EXPORT_METHOD(disable) {
    [[SEGAnalytics sharedAnalytics] disable];
}

/*
 https://segment.com/docs/libraries/ios/#opt-out
 */
RCT_EXPORT_METHOD(enable) {
    [[SEGAnalytics sharedAnalytics] enable];
}

/*
 https://segment.com/docs/spec/alias/
 */
RCT_EXPORT_METHOD(alias: (NSString*)newId) {
    [[SEGAnalytics sharedAnalytics] alias:newId];
}

-(NSMutableDictionary*) convertToStringDictionary: (NSDictionary *)properties {
    /*
     According to React Native's documentation:
     
     For maps, it is the developer's responsibility to check the value types individually by manually calling RCTConvert helper methods.
     */
    NSMutableDictionary *stringDictionary = [[NSMutableDictionary alloc] init];
    for (NSString* key in [properties allKeys]) {
        id value = [RCTConvert NSString:[properties objectForKey:key]];
        [stringDictionary setObject:value forKey:[RCTConvert NSString:key]];
    }
    return stringDictionary;
}

@end

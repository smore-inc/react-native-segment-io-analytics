# RNSegmentIOAnalytics

Written by Tal Kain <tal@kain.net>

Based on SegmentIO (https://segment.com) Analytics project. 
The iOS SDK can be found here: https://github.com/segmentio/analytics-ios

## Installation
1. Download and install the npm package by running `npm install --save react-native-segment-io-analytics`
2. In your Podfile, add `pod "Analytics"` to your project.
3. Inisde Xcode, go to the project navigator and right click `Libraries` -> `Add Files to [your project's name]`
4. Go to `node_modules` -> `react-native-segment-io-analytics` -> and choose the `RNSegmentIOAnalytics.xcodeproj` file 
5. Make sure your project links to *libAnalytics.a* and *libRNSegmentIOAnalytics.a* (The libraries should be listed under "Build Phases -> Link Binary With Libraries").

## Usage sample
```javascript
var RNSegmentIOAnalytics = require('react-native-segment-io-analytics');

var segmentIOWriteKey = "SEGMENT_IO_WRITE_KEY"
var eventQueueSize = 1
RNSegmentIOAnalytics.setup(segmentIOWriteKey, eventQueueSize);
RNSegmentIOAnalytics.identifyUser("testing", {"name":"test name"});
RNSegmentIOAnalytics.track("test track", {"name":"test track with name"});
RNSegmentIOAnalytics.screen("test screen", {"screenType":"SCREEN NAME"});
RNSegmentIOAnalytics.flush();
RNSegmentIOAnalytics.reset();
```

## Documentation
https://segment.com/docs/libraries/ios/#getting-started

## Handling possible issues
### Google SDK BitCode issue
```
ld: '......./Pods/GoogleIDFASupport/Libraries/libAdIdAccessLibrary.a(TAGActualAdIdAccess.o)' does not contain bitcode. You must rebuild it with bitcode enabled (Xcode setting ENABLE_BITCODE), obtain an updated library from the vendor, or disable bitcode for this target. for architecture arm64
```
There are instructions for fixing it here: https://stackoverflow.com/questions/31395260/google-analytics-libadidaccess-a-does-not-contain-bitcode

## Deployment
Deploying the project can be done using ```npm publish``` command. 
Read more about it here: https://gist.github.com/coolaj86/1318304

## License

This project is released under the [MIT License](http://www.opensource.org/licenses/MIT).

The copyright notice from Segment's project is in the *analytics-ios.LICENSE* file



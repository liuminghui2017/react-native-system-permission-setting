#import "SystemPermissionSetting.h"
#import <UIKit/UIKit.h>


@implementation SystemPermissionSetting

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(showBrand)
{
    
}

RCT_EXPORT_METHOD(showManufacturer)
{
    
}

RCT_EXPORT_METHOD(toSettingsPage)
{
    NSURL * url = [NSURL URLWithString:UIApplicationOpenSettingsURLString];
    if ([[UIApplication sharedApplication] canOpenURL:url]) {
                NSURL*url =[NSURL URLWithString:UIApplicationOpenSettingsURLString];
                [[UIApplication sharedApplication] openURL:url];
    }
}

@end

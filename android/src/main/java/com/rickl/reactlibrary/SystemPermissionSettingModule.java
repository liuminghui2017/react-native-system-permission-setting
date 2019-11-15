package com.rickl.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;


import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.widget.Toast;

public class SystemPermissionSettingModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private final String BRAND = Build.BRAND;
    private final String MANUFACTURER = Build.MANUFACTURER;

    public SystemPermissionSettingModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "SystemPermissionSetting";
    }

    @ReactMethod
    public void showBrand() {
        Toast.makeText(reactContext, BRAND, Toast.LENGTH_LONG).show();
    }

    @ReactMethod
    public void showManufacturer() {
        Toast.makeText(reactContext, MANUFACTURER, Toast.LENGTH_LONG).show();
    }

    @ReactMethod
    public void toSettingsPage() {
        gotoAppDetailSetting();
        // switch (MANUFACTURER) {
        // case "HUAWEI":
        //     gotoHuaweiPermission();
        //     break;
        // case "Xiaomi":
        //     gotoXiaomiPermission();
        //     break;
        // case "Meizu":
        //     gotoMeizuPermission();
        //     break;
        // case "samsung":
        //     gotoSamsungPermission();
        //     break;
        // case "vivo":
        //     gotoVivoPermission();
        //     break;
        // case "OPPO":
        //     gotoOppoPermission();
        //     break;
        // default:
        //     gotoAppDetailSetting();
        // }
    }

    // 跳转华为设置
    public void gotoHuaweiPermission() {
        try {
            Intent intent = new Intent();
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ComponentName comp = new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");//华为权限管理
            intent.setComponent(comp);
            intent.setPackage(reactContext.getPackageName());
            reactContext.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            gotoAppDetailSetting();
        }
    }

    // 跳转小米设置
    public void gotoXiaomiPermission() {

    }

    // 跳转魅族设置
    public void gotoMeizuPermission() {

    }

    // 跳转三星设置
    public void gotoSamsungPermission() {

    }

    // 跳转vivo设置
    public void gotoVivoPermission() {

    }

    // 跳转oppo设置
    public void gotoOppoPermission() {

    }


    // 跳转应用详情界面
    public void gotoAppDetailSetting() {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", reactContext.getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            intent.setAction(Intent.ACTION_VIEW);
            intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            intent.putExtra("com.android.settings.ApplicationPkgName", reactContext.getPackageName());
        }
        try {
            reactContext.startActivity(intent);   
        } catch (Exception e) {
            e.printStackTrace();
            gotoSetting();
        }
    }

    // 跳转手机系统设置页面
    public void gotoSetting() {
        try {
            Intent intent = new Intent(Settings.ACTION_SETTINGS);
            reactContext.startActivity(intent);   
        } catch (Exception e) {
            Toast.makeText(reactContext, "跳转失败", Toast.LENGTH_LONG).show();
        }
    }
}

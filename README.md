# react-native-system-permission-setting



### Mostly automatic installation

`$ react-native link react-native-system-permission-setting`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-system-permission-setting` and add `SystemPermissionSetting.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libSystemPermissionSetting.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.rickl.reactlibrary.SystemPermissionSettingPackage;` to the imports at the top of the file
  - Add `new SystemPermissionSettingPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-system-permission-setting'
  	project(':react-native-system-permission-setting').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-system-permission-setting/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-system-permission-setting')
  	```


## Usage
```javascript
import SystemPermissionSetting from 'react-native-system-permission-setting';

// TODO: What to do with the module?
SystemPermissionSetting;
```

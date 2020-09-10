# KotlinBase

用kotlin代码对TwanBase库进行全面升级


##### 简要说明

已集成一些常用的第三方库,并默认附带了网络请求,底部栏等

##### 预览

![启动页](https://github.com/twangithub/KotlinBase/blob/master/image/first.png)![引导1页1](https://github.com/twangithub/KotlinBase/blob/master/image/splash1.png)![引导1页1](https://github.com/twangithub/KotlinBase/blob/master/image/splash3.png)![主页](https://github.com/twangithub/KotlinBase/blob/master/image/main.png)

##### 第三方库如下

```groovy
//工具类<br>
implementation 'com.blankj:utilcodex:1.29.0'

//rxhttp网络库<br>
implementation 'com.ljx.rxhttp:rxhttp:2.2.8'<br>
implementation 'com.squareup.okhttp3:okhttp:4.7.2' //rxhttp v2.2.2版本起，需要手动依赖okhttp<br>
kapt 'com.ljx.rxhttp:rxhttp-compiler:2.2.8' //生成RxHttp类，非kotlin项目，请使用annotationProcessor代替kapt<br>
implementation 'com.ljx.rxlife:rxlife-coroutine:2.0.0' //管理协程生命周期，页面销毁，关闭请求<br>

//eventbus<br>
implementation 'org.greenrobot:eventbus:3.2.0'

//glide图片加载库<br>
implementation 'com.github.bumptech.glide:glide:4.11.0'
annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'

//RxPermissions权限库<br>
implementation 'com.github.tbruyelle:rxpermissions:0.12'
implementation 'io.reactivex.rxjava3:rxandroid:3.0.0'
implementation 'io.reactivex.rxjava3:rxjava:3.0.4'

//swipebacklayout<br>
implementation 'me.imid.swipebacklayout.lib:library:1.1.0'

//butterknife<br>
implementation 'com.jakewharton:butterknife:10.2.1'
kapt 'com.jakewharton:butterknife-compiler:10.2.1'

//xpopup<br>
implementation 'com.lxj:xpopup:2.0.8'

//SmartRefreshLayout刷新<br>
implementation  'com.scwang.smart:refresh-layout-kernel:2.0.1'      //核心必须依赖<br>
implementation  'com.scwang.smart:refresh-header-classics:2.0.1'    //经典刷新头<br>

//banner<br>
implementation 'com.youth.banner:banner:2.1.0'

//顶部栏<br>
implementation 'com.jaeger.statusbarutil:library:1.5.1'<br>

//网页浏览<br>
implementation 'com.just.agentweb:agentweb:4.1.3'<br>

//viewpager左右滑动指示器<br>
implementation 'com.github.hackware1993:MagicIndicator:1.5.0'<br>

//漂亮的spinner<br>
implementation "com.github.skydoves:powerspinner:1.1.0"<br>

//时间选择<br>
implementation 'com.contrarywind:Android-PickerView:4.1.9'<br>

//图片选择<br>
implementation "com.zhihu.android:matisse:0.5.3-beta3"<br>
```

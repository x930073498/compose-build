package com.x930073498.plugin

object Versions {
    /**
     * kotlin 版本高于1.4.10则需要新增view-binding（需要build 版本升级3.7及以上）和kotlin-parcelize
     */
    const val kotlin = "1.5.0"
}

object Libs {
    const val activity = "androidx.activity:activity:1.2.0-beta01"
    const val activity_ktx = "androidx.activity:activity-ktx:1.2.0-beta01"
    const val room_runtime = "androidx.room:room-runtime:2.2.5"
    const val room_compiler = "androidx.room:room-compiler:2.2.5"
    const val annotation = "androidx.annotation:annotation:1.1.0"
    const val fragment = "androidx.fragment:fragment:1.3.0-beta01"
    const val fragment_ktx = "androidx.fragment:fragment-ktx:1.3.0-beta01"
    const val arch_core_common = "androidx.arch.core:core-common:2.1.0"
    const val arch_core_runtime = "androidx.arch.core:core-runtime:2.1.0"
    const val ktx_core = "androidx.core:core-ktx:1.6.0-alpha01"
    const val core = "androidx.core:core:1.3.2"
    const val appcompat = "androidx.appcompat:appcompat:1.2.0"
    const val collection_ktx = "androidx.collection:collection-ktx:1.1.0"
    const val collection = "androidx.collection:collection:1.1.0"
    const val multidex = "androidx.multidex:multidex:2.0.1"
    const val biometric = "androidx.biometric:biometric:1.0.1"
    const val palette = "androidx.palette:palette:1.0.0"
    const val media = "androidx.media:media:1.2.0-alpha01"
    const val startup = "androidx.startup:startup-runtime:1.0.0"
    const val pagingCommon = "androidx.paging:paging-common-ktx:2.1.2"
    const val pagingRuntime = "androidx.paging:paging-runtime-ktx:2.1.2"
    const val palette_ktx = "androidx.palette:palette-ktx:1.0.0"
    const val legacy = "androidx.legacy:legacy-support-v4:1.0.0"
    const val recyclerview = "androidx.recyclerview:recyclerview:1.2.0-alpha06"
    const val work = "androidx.work:work-runtime:2.4.0"
    const val work_ktx = "androidx.work:work-runtime-ktx:2.4.0"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.4"
    const val local_broadcast_manager = "androidx.localbroadcastmanager:localbroadcastmanager:1.0.0"
//constraintlayout=androidx.constraintlayout:constraintlayout:1.1.3
//lifecycle_extensions=androidx.lifecycle:lifecycle-extensions:+

    const val material = "com.google.android.material:material:1.3.0"
    const val viewpager2 = "androidx.viewpager2:viewpager2:1.1.0-alpha01"
    const val coordinatorlayout = "androidx.coordinatorlayout:coordinatorlayout:1.1.0"

    //lifecycle  2.2.0
    const val viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0"
    const val viewmodel_savedstate = "androidx.lifecycle:lifecycle-viewmodel-savedstate:2.3.0"
    const val lifecycle_compiler = "androidx.lifecycle:lifecycle-compiler:2.3.0"
    const val lifecycle_runtime = "androidx.lifecycle:lifecycle-runtime:2.3.0"
    const val lifecycle_process = "androidx.lifecycle:lifecycle-process:2.3.0"
    const val lifecycle_common_java8 = "androidx.lifecycle:lifecycle-common-java8:2.3.0"
    const val lifecycle_livedata = "androidx.lifecycle:lifecycle-livedata:2.3.0"
    const val lifecycle_runtime_ktx = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.0"
    const val lifecycle_livedata_ktx = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.0"
    const val dynamicanimation = "androidx.dynamicanimation:dynamicanimation:1.1.0-alpha03"

    //kotlin
    const val kotlin_reflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}"
    const val kotlin_stdlib_jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val kotlin_stdlib_common = "org.jetbrains.kotlin:kotlin-stdlib-common:${Versions.kotlin}"
    const val kotlinx_coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0"
    const val kotlinx_coroutines_core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0"

    //rxjava
    const val rxjava = "io.reactivex.rxjava2:rxjava:2.2.4"
    const val rxbinding = "com.jakewharton.rxbinding2:rxbinding:2.2.0"
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:2.1.0"
    const val rxlifecycle_android_lifecycle_kotlin = "com.trello.rxlifecycle2:rxlifecycle-android-lifecycle-kotlin:2.2.2"

    //refresh
    const val smart_refresh_header_classics = "com.github.scwang90.SmartRefreshLayout:refresh-footer-classics:V2.0.0"
    const val smart_refresh_layout_kernel = "com.github.scwang90.SmartRefreshLayout:refresh-layout-kernel:V2.0.0"
    const val smart_refresh_header_radar = "com.github.scwang90.SmartRefreshLayout:refresh-header-radar:V2.0.0"
    const val smart_refresh_header_falsify = "com.github.scwang90.SmartRefreshLayout:refresh-header-falsify:V2.0.0"
    const val smart_refresh_header_material = "com.github.scwang90.SmartRefreshLayout:refresh-header-material:V2.0.0"
    const val smart_refresh_header_two_level = "com.github.scwang90.SmartRefreshLayout:refresh-header-two-level:V2.0.0"
    const val smart_refresh_footer_ball = "com.github.scwang90.SmartRefreshLayout:refresh-footer-ball:V2.0.0"
    const val smart_refresh_footer_classics = "com.github.scwang90.SmartRefreshLayout:refresh-footer-classics:V2.0.0"

    //arouter
    const val arouter_compiler = "com.alibaba:arouter-compiler:1.5.1"
    const val arouter_api = "com.alibaba:arouter-api:1.5.1"
    const val arouter_annotation = "com.alibaba:arouter-annotation:1.0.6"

    // component 路由
    const val componentRouter = "com.github.xiaojinzi123.Component:component-impl:1.8.3-androidx"
    const val componentRouterCompiler = "com.github.xiaojinzi123.Component:component-compiler:+"
    const val pluginComponentName = "com.xiaojinzi.component.plugin"


    const val replugin_host_lib = "com.qihoo360.replugin:replugin-host-lib:2.3.3"

    const val glide = "com.github.bumptech.glide:glide:4.11.0"
    const val drouter="io.github.didi:drouter-api:1.0.6"
    const val glide_compiler = "com.github.bumptech.glide:compiler:4.11.0"
    const val glide_okhttp = "com.github.bumptech.glide:okhttp3-integration:4.11.0"
    const val glideTransformation = "jp.wasabeef:glide-transformations:4.1.0"
//    #glide=com.github.bumptech.glide:glide:4.8.0
//    #glide_compiler=com.github.bumptech.glide:compiler:4.8.0
//    #glide_okhttp=com.github.bumptech.glide:okhttp3-integration:4.8.0

    // skin
//skin_support=skin.support:skin-support:4.0.4
    const val skin_support_appcompat = "skin.support:skin-support-appcompat:4.0.4"
    const val skin_support_design = "skin.support:skin-support-design:4.0.4"
    const val skin_support_cardview = "skin.support:skin-support-cardview:4.0.4"
    const val skin_support_constraint = "skin.support:skin-support-constraint-layout:4.0.4"
    const val skin_flycotablayout = "skin.support:flycotablayout:2.1.2.2"
    const val navi = "com.trello.navi2:navi:2.1.0"
    const val freeReflection = "me.weishu:free_reflection:2.2.0"
    const val icarus_recycler = "com.x930073498.icarus:recycler:1.0.15"
    const val aspectjrt = "org.aspectj:aspectjrt:1.9.5"
    const val gson = "com.google.code.gson:gson:2.8.6"
    const val videoPlayer = "cn.jzvd:jiaozivideoplayer:7.2.2"
    const val exoPlayer = "com.google.android.exoplayer:exoplayer:2.10.4"
    const val ijkPlayerJava = "tv.danmaku.ijk.media:ijkplayer-java:0.8.8"
    const val ijkPlayerArmV7 = "tv.danmaku.ijk.media:ijkplayer-armv7a:0.8.4"
    const val ijkPlayerArm64 = "tv.danmaku.ijk.media:ijkplayer-arm64:0.8.8"
    const val fragmentationX = "me.yokeyword:fragmentationx:1.0.1"
    const val tablayout = "com.flyco.tablayout:FlycoTabLayout_Lib:2.1.2@aar"
    const val glide_palette = "com.github.florent37:glidepalette:2.1.2"
    const val banner = "com.youth.banner:banner:2.1.0"
    const val banner_zhpan = "com.zhpan.library:bannerview:2.6.6"
    const val CycleViewPager2 = "com.github.wangpeiyuan:CycleViewPager2:v1.0.7"
    const val text = "com.github.chenBingX:SuperTextView:3.2.5.64"
    const val tag = "com.hyman:flowlayout-lib:1.1.2"
    const val gravity_snap_helper = "com.github.rubensousa:gravitysnaphelper:2.2.0"
    const val mvrx = "com.airbnb.android:mavericks:2.2.0"
    const val paris = "com.airbnb.android:paris:1.3.1"
    const val mmkv = "com.tencent:mmkv-static:1.2.9"
//    const val mars = "com.tencent.mars:mars-wrapper:1.2.5"
//    const val mars = "com.tencent.mars:mars-core:1.2.5"
    const val xlog = "com.tencent.mars:mars-xlog:1.2.5"
    const val epoxy = "com.airbnb.android:epoxy:4.1.0"
    const val epoxy_compiler = "com.airbnb.android:epoxy-processor:4.1.0"
    const val epoxy_paging = "com.airbnb.android:epoxy-paging:4.1.0"
    const val epoxy_glide_preloading = "com.airbnb.android:epoxy-glide-preloading:4.1.0"
    const val epoxy_litho = "com.airbnb.android:epoxy-litho:4.1.0"

    const val discreteScrollview = "com.yarolegovich:discrete-scrollview:1.5.1"
    const val moshi = "com.squareup.moshi:moshi-kotlin:+"

    // moshi kapt
    const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:1.8.0"

    const val easyPhotos="com.github.HuanTanSheng:EasyPhotos:3.1.3"
    const val assent = "com.afollestad.assent:core:+"
    const val paris_compiler = "com.airbnb.android:paris-processor:1.3.1"
    const val richText = "com.zzhoujay.richtext:richtext:3.0.7"
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:2.3"
    const val immersionbar = "com.gyf.immersionbar:immersionbar:3.0.0"
    const val immersionbar_components = "com.gyf.immersionbar:immersionbar-components:3.0.0"
    const val immersionbar_ktx = "com.gyf.immersionbar:immersionbar-ktx:3.0.0"
    const val toastcompat = "me.drakeet.support:toastcompat:1.1.0"
    const val vasSonic = "com.tencent.sonic:sdk:3.1.0"
    const val liveEventBus = "com.jeremyliao:live-event-bus-x:1.7.2"
    const val agentWeb = "com.just.agentweb:agentweb:4.1.3"
    const val transferee = "com.github.Hitomis.transferee:Transferee:+"
    const val glideTransferee = "com.github.Hitomis.transferee:GlideImageLoader:+"
    const val agentWebFileChooser = "com.just.agentweb:filechooser:4.1.3"
    const val agentWebDownloader = "com.download.library:Downloader:4.1.3"
    const val anyLayer = "com.github.goweii.AnyLayer:anylayer-ktx:4.1.4-androidx"

    //sdk
    const val umsdk_common = "com.umeng.umsdk:common:9.3.3"
    const val umsdk_native_asms = "com.umeng.umsdk:asms:1.1.4"
    const val umsdk_native_crash = "com.umeng.umsdk:crash:0.0.5"
    const val umsdk_oaid_lenovo = "com.umeng.umsdk:oaid_lenovo:1.0.0"
    const val umsdk_oaid_mi = "com.umeng.umsdk:oaid_mi:1.0.0"
    const val umsdk_oaid_oppo = "com.umeng.umsdk:oaid_oppo:1.0.4"
    const val umsdk_oaid_vivo = "com.umeng.umsdk:oaid_vivo:1.0.0.1"
    const val getui_sdk = "com.getui:gtsdk:3.0.2.0"
    const val wx_sdk = "com.tencent.mm.opensdk:wechat-sdk-android-without-mta:+"
    const val filedownloader = "com.liulishuo.filedownloader:library:1.7.7"
    const val mzip = "com.github.ghost1372:Mzip-Android:0.4.0"
    const val tuia_sdk = "com.tuia:sdk:2.8.0.0"

    //网络
    const val okhttp = "com.squareup.okhttp3:okhttp:4.9.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
    const val converter_gson = "com.squareup.retrofit2:converter-gson:2.9.0"
//华为扫码服务
    const val hwScanKit="com.huawei.hms:scanplus:1.3.2.300"

}
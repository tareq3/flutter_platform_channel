package com.mti.flutter_platform_channel;

import android.content.Intent;
import android.os.Bundle;

import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {

  private static final String CHANNEL= "flutter.native/helper";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    GeneratedPluginRegistrant.registerWith(this);
    new MethodChannel(getFlutterView(), CHANNEL).setMethodCallHandler((methodCall, result) -> {
      if(methodCall.method.equals("helloFromNativeCode")){
        startActivity( new Intent(this, CustomActivity.class));
        String greeting= helloFromNativeCode();
        result.success(greeting);
      }
    });
  }


  private String helloFromNativeCode(){
    return "Hello from Native Android Code";
  }

}

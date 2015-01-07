package com.example.test2introsplash;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;

public class IntroSplashActivity extends Activity {

	int splashSceneNumber;

	LinearLayout splashLayout;

	Handler mHandler;

	boolean isClick;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_introsplash);

		// xml 소스 참조
		splashLayout = (LinearLayout) findViewById(R.id.splashLayout);

		// 처음화면 0
		splashSceneNumber = 0;

		// 클릭 이벤트가 있었는지 확인
		isClick = true;

		mHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				switch (splashSceneNumber) {
				case 0:
					// 두번째 화면
					splashSceneNumber = 1;

					Drawable bg = getResources().getDrawable(R.drawable.bg_sunset);
					
					if(bg==null){
						splashLayout.setBackgroundColor(Color.rgb(255,255,255));
					}else{
						splashLayout.setBackgroundDrawable(bg);
						splashLayout.invalidate();
					}


					mHandler.sendEmptyMessage(splashSceneNumber);
					break;

				case 1:
					splashSceneNumber = 2;
					mHandler.sendEmptyMessageDelayed(splashSceneNumber, 2000);
					break;

				case 2:
					// 엑티비티 종료
					IntroSplashActivity.this.finish();
					break;

				case 3:
					// 딜레이이벤트 클리기 없을경우 바로 0 이벤트로 보낸다..
					if (isClick && splashSceneNumber == 0) {
						splashSceneNumber = 0;
						mHandler.sendEmptyMessage(splashSceneNumber);
					}
					break;
				}
			}
		};
		mHandler.sendEmptyMessageDelayed(3, 2000);
	}

	public void hn_splashOnclick(View v) {

		switch (splashSceneNumber) {
		case 0:
			splashSceneNumber = 0;

			isClick = false;
			mHandler.sendEmptyMessage(splashSceneNumber);
			break;

		case 1:
			splashSceneNumber = 2;
			mHandler.sendEmptyMessage(splashSceneNumber);
			break;
		}
	}
}



package com.mazaiting.ffmpegtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @InjectView(R.id.tv_info)
    TextView mTvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.btn_protocol, R.id.btn_format, R.id.btn_codec, R.id.btn_filter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_protocol:
                mTvInfo.setText(urlprotocolinfo());
                break;
            case R.id.btn_format:
                mTvInfo.setText(avformatinfo());
                break;
            case R.id.btn_codec:
                mTvInfo.setText(avcodecinfo());
                break;
            case R.id.btn_filter:
                mTvInfo.setText(avfilterinfo());
                break;
            default:
                break;
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
//    public native String stringFromJNI();

    public native String urlprotocolinfo();
    public native String avformatinfo();
    public native String avcodecinfo();
    public native String avfilterinfo();

}

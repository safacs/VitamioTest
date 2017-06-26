package com.example.vitamiotest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.Toast;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;


public class MainActivity extends Activity implements MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnBufferingUpdateListener {

    private VideoView videoView;
    private MediaController mediaController;
    private String path = Environment.getExternalStorageDirectory() + "/movie/JAY.mp4";

    private Bitmap bitmap;
    private ImageView imageView;
//    private String uri = "http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8";

//    private String uri = "rtsp://xgrammyawardsx.is.livestream-api.com/livestreamiphone/grammyawards";

//    private String uri = "http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8";
//
//    private String uri = "http://www.modrails.com/videos/passenger_nginx.mov";
//
    private String uri = "http://m.livestream.com (site)" ;
//
//    private String uri = "rtsp://xgrammyawardsx.is.livestream-api.com/livestreamiphone/grammyawards"";
//
//    private String uri = "http://devimages.apple.com/iphone/samples/bipbop/bipbopall.m3u8";

//    private String uri = "rtmp://live2.imfoo.com/AppName/StreamName";

//    private String url = "http://litaoin.oss-cn-hangzhou.aliyuncs.com/record/mars/test/1470380268.m3u8";

//    private String urL = "http://litaoin.oss-cn-hangzhou.aliyuncs.com/upload/VID_20160808_134849.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(getApplicationContext());
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.surface_view);

//        imageView = (ImageView)findViewById(R.id.image);
//        imageView.setImageBitmap(bitmap);


//        bitmap = ThumbnailUtils.createVideoThumbnail(path, ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
//        bitmap = ThumbnailUtils.extractThumbnail(bitmap,200,200);


//        videoView.setVideoPath(path);
//        EditText url = (EditText)findViewById(R.id.editText);
//        Button play = (Button)findViewById(R.id.play);


        mediaController = new MediaController(this);
        mediaController.show(3000);


        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse(uri));
        videoView.requestFocus();

        videoView.setOnBufferingUpdateListener(this);
        videoView.setOnErrorListener(this);
        videoView.setOnInfoListener(this);
        videoView.setOnPreparedListener(this);


    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        Toast.makeText(getApplicationContext(),">>>>>>>>>>>>>",Toast.LENGTH_SHORT).show();
        switch (what){
            case MediaPlayer.MEDIA_ERROR_MALFORMED:
                Toast.makeText(getApplicationContext(),">>>",Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        return true;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {

    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {

    }
}

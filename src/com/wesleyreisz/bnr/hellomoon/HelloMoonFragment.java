package com.wesleyreisz.bnr.hellomoon;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

public class HelloMoonFragment extends Fragment {
	private AudioPlayer mPlayer = new AudioPlayer();
	private Button mButtonPlay;
	private Button mButtonStop;
	private static String imgPath =
			"android.resource://com.wesleyreisz.bnr.hellomoon/raw/apollo_17_stroll";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_hello_moon, container, false);
		VideoView vv = (VideoView)v.findViewById(R.id.hellomoon_viewVideo);
		vv.setVideoURI(Uri.parse(imgPath));
		vv.requestFocus();
	    vv.start();
	
		return v;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mPlayer.stop();
	}
}

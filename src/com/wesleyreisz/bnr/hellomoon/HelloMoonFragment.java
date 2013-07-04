package com.wesleyreisz.bnr.hellomoon;

import com.wesleyreisz.bnr.hellomoon.AudioPlayer.PlayerState;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloMoonFragment extends Fragment {
	private AudioPlayer mPlayer = new AudioPlayer();
	private Button mButtonPlay;
	private Button mButtonStop;
	private SurfaceView surfaceView;
	private SurfaceHolder surfaceHolder;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_hello_moon, container, false);
		
		surfaceView = (SurfaceView)v.findViewById(R.id.hellomoon_surfaceViewVideo);
		surfaceHolder = surfaceView.getHolder();
		
		
		mButtonPlay = (Button) v.findViewById(R.id.hellomoon_playButton);
		mButtonPlay.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (mPlayer.getPlayerState()==PlayerState.STOPPED){
					mPlayer.play(getActivity(), surfaceHolder);
					mButtonPlay.setText("Pause");
				}else if(mPlayer.getPlayerState()==PlayerState.RUNNING){
					mPlayer.pause();
					mButtonPlay.setText("Play");
				}else{
					mPlayer.pause();
					mButtonPlay.setText("Pause");
				}			
			}
		});
		mButtonStop = (Button) v.findViewById(R.id.hellomoon_stopButton);
		mButtonStop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mPlayer.stop();
				mButtonPlay.setText("Play");
				
			}
		});
		
		
		return v;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		mPlayer.stop();
	}
}

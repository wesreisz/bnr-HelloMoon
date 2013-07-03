package com.wesleyreisz.bnr.hellomoon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HelloMoonFragment extends Fragment {
	private AudioPlayer mPlayer = new AudioPlayer();
	private Button mButtonPlay;
	private Button mButtonStop;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_hello_moon, container, false);
		
		mButtonPlay = (Button) v.findViewById(R.id.hellomoon_playButton);
		mButtonPlay.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mPlayer.play(getActivity());
				
			}
		});
		mButtonStop = (Button) v.findViewById(R.id.hellomoon_stopButton);
		mButtonStop.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mPlayer.stop();
				
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

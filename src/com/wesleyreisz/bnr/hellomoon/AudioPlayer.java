package com.wesleyreisz.bnr.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

public class AudioPlayer {
	public enum PlayerState{
		RUNNING, STOPPED, PAUSED
	}
	
	private static String TAG = "AudioPlayer";
	private MediaPlayer mPlayer;
	private PlayerState state = PlayerState.STOPPED;
	
	public PlayerState getPlayerState(){
		return state;
	}
	public void stop(){
		Log.d(TAG,"Calling stop");
		state = PlayerState.STOPPED;
		if (mPlayer!=null){
			mPlayer.release();
			state = PlayerState.STOPPED;
			mPlayer = null;
		}
	}
	public void pause(){
		Log.d(TAG,"Calling pause");
		if(getPlayerState()==PlayerState.RUNNING){
			mPlayer.pause();
			state = PlayerState.PAUSED;
		}else{
			mPlayer.start();
			state = PlayerState.RUNNING;
		}
	}
	public void play(Context c){
		Log.d(TAG,"Calling play");
		stop();
		state = PlayerState.RUNNING;
		
		mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
		
		mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
			
			@Override
			public void onCompletion(MediaPlayer mp) {
				stop();
			}
		});
		mPlayer.start();
	}
}

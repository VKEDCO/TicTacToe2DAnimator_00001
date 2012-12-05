package org.vkedco.mobappdev.tic_tac_toe_2d_animator_00001;

/************************************************************
* Bugs to vladimir dot kulyukin at gmail dot com
*************************************************************
*/

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class TicTacToe2DAnimatorAct extends Activity {
	
	ImageView mImgViewFrameAnimator = null;
	AnimationDrawable mAnimDraw     = null;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tic_tac_toe_2d_animator_activity);
        mImgViewFrameAnimator = (ImageView) this.findViewById(R.id.img_view_frame);
    	mImgViewFrameAnimator.setBackgroundDrawable(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tic_tac_toe_2d_animator_activity, menu);
        return true;
    }
    
    @Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch ( item.getItemId() ) {
		case R.id.item_x_wins:
			animateTicTacToe_X_WINS();
			return true;
		case R.id.item_o_wins:
			animateTicTacToe_O_WINS();
			return true;
		case R.id.item_x_o_draw:
			animateTicTacToe_X_O_DRAW();
			return true;
		}
		return true;
	}
    
    void animateTicTacToe_O_WINS() {
    	mImgViewFrameAnimator.setBackgroundResource(R.drawable.tic_tac_toe_o_wins_animation_list);
        mImgViewFrameAnimator.setVisibility(ImageView.VISIBLE);
        mAnimDraw = (AnimationDrawable) mImgViewFrameAnimator.getBackground();
    	if ( mAnimDraw.isRunning() ) mAnimDraw.stop();
    	mAnimDraw.start();
    }
    
    void animateTicTacToe_X_WINS() {
    	mImgViewFrameAnimator.setBackgroundResource(R.drawable.tic_tac_toe_x_wins_animation_list);
    	mImgViewFrameAnimator.setVisibility(ImageView.VISIBLE);
        mAnimDraw = (AnimationDrawable) mImgViewFrameAnimator.getBackground();
    	if ( mAnimDraw.isRunning() ) mAnimDraw.stop();
    	mAnimDraw.start();
    }
    
    void animateTicTacToe_X_O_DRAW() {
    	mImgViewFrameAnimator.setBackgroundResource(R.drawable.tic_tac_toe_x_o_draw_animation_list);
    	mImgViewFrameAnimator.setVisibility(ImageView.VISIBLE);
        mAnimDraw = (AnimationDrawable) mImgViewFrameAnimator.getBackground();
    	if ( mAnimDraw.isRunning() ) mAnimDraw.stop();
    	mAnimDraw.start();
    }
    
    @Override
	protected void onDestroy() {
		super.onDestroy();
		if ( mAnimDraw == null ) return;
		if ( mAnimDraw.isRunning() ) mAnimDraw.stop();
		mAnimDraw = null;
	}

	@Override
	public void onLowMemory() {
		super.onLowMemory();
		if ( mAnimDraw == null ) return;
		if ( mAnimDraw.isRunning() ) mAnimDraw.stop();
		mAnimDraw = null;
	}

	@Override
	protected void onPause() {
		super.onPause();
		if ( mAnimDraw == null ) return;
		if ( mAnimDraw.isRunning() ) mAnimDraw.stop();
	}

	@Override
	protected void onStart() {
		super.onStart();
		if ( mAnimDraw == null ) return;
		if ( !mAnimDraw.isRunning() ) mAnimDraw.start();
	}

	@Override
	protected void onStop() {
		super.onStop();
		if ( mAnimDraw == null ) return;
		if ( mAnimDraw.isRunning() ) mAnimDraw.stop();
	}
}

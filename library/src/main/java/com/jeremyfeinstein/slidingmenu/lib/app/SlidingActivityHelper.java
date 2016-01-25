package com.jeremyfeinstein.slidingmenu.lib.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.jeremyfeinstein.slidingmenu.lib.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class SlidingActivityHelper {

	private Activity mActivity;

	private SlidingMenu mSlidingMenu;

	private View mViewAbove;

	private View mViewBehind;

	private boolean mBroadcasting = false;

	private boolean mOnPostCreateCalled = false;

	private boolean mEnableSlide = true;

	/**
	 * Instantiates a new SlidingActivityHelper.
	 *
	 * @param activity the associated activity
	 */
	public SlidingActivityHelper(Activity activity) {
		mActivity = activity;
	}

	/**
	 * Sets mSlidingMenu as a newly inflated SlidingMenu. Should be called within the activitiy's onCreate()
	 *
	 * @param savedInstanceState the saved instance state (unused)
	 */
	public void onCreate(Bundle savedInstanceState) {
		mSlidingMenu = (SlidingMenu) LayoutInflater.from(mActivity).inflate(R.layout.slidingmenumain, null);
	}

	/**
	 * Further SlidingMenu initialization. Should be called within the activitiy's onPostCreate()
	 *
	 * @param savedInstanceState the saved instance state (unused)
	 */
	public void onPostCreate(Bundle savedInstanceState) {
		if (mViewBehind == null || mViewAbove == null) {
			throw new IllegalStateException("Both setBehindContentView must be called " +
					"in onCreate in addition to setContentView.");
		}

		mOnPostCreateCalled = true;

		mSlidingMenu.attachToActivity(mActivity, 
				mEnableSlide ? SlidingMenu.SLIDING_WINDOW : SlidingMenu.SLIDING_CONTENT);
		
		final boolean open;
		final boolean secondary;
		if (savedInstanceState != null) {
			open = savedInstanceState.getBoolean("SlidingActivityHelper.open");
			secondary = savedInstanceState.getBoolean("SlidingActivityHelper.secondary");
		} else {
			open = false;
			secondary = false;
		}
		new Handler().post(new Runnable() {
			public void run() {
				if (open) {
					if (secondary) {
						mSlidingMenu.showSecondaryMenu(false);
					} else {
						mSlidingMenu.showMenu(false);
					}
				} else {
					mSlidingMenu.showContent(false);					
				}
			}
		});
	}

	/**
	 * Controls whether the ActionBar slides along with the above com.hy.news.view when the menu is opened,
	 * or if it stays in place.
	 *
	 * @param slidingActionBarEnabled True if you want the ActionBar to slide along with the SlidingMenu,
	 * false if you want the ActionBar to stay in place
	 */
	public void setSlidingActionBarEnabled(boolean slidingActionBarEnabled) {
		if (mOnPostCreateCalled)
			throw new IllegalStateException("enableSlidingActionBar must be called in onCreate.");
		mEnableSlide = slidingActionBarEnabled;
	}

	/**
	 * Finds a com.hy.news.view that was identified by the id attribute from the XML that was processed in onCreate(Bundle).
	 * 
	 * @param id the resource id of the desired com.hy.news.view
	 * @return The com.hy.news.view if found or null otherwise.
	 */
	public View findViewById(int id) {
		View v;
		if (mSlidingMenu != null) {
			v = mSlidingMenu.findViewById(id);
			if (v != null)
				return v;
		}
		return null;
	}

	/**
	 * Called to retrieve per-instance state from an activity before being killed so that the state can be
	 * restored in onCreate(Bundle) or onRestoreInstanceState(Bundle) (the Bundle populated by this method
	 * will be passed to both). 
	 *
	 * @param outState Bundle in which to place your saved state.
	 */
	public void onSaveInstanceState(Bundle outState) {
		outState.putBoolean("SlidingActivityHelper.open", mSlidingMenu.isMenuShowing());
		outState.putBoolean("SlidingActivityHelper.secondary", mSlidingMenu.isSecondaryMenuShowing());
	}

	/**
	 * Register the above content com.hy.news.view.
	 *
	 * @param v the above content com.hy.news.view to register
	 * @param params LayoutParams for that com.hy.news.view (unused)
	 */
	public void registerAboveContentView(View v, LayoutParams params) {
		if (!mBroadcasting)
			mViewAbove = v;
	}

	/**
	 * Set the activity content to an explicit com.hy.news.view. This com.hy.news.view is placed directly into the activity's com.hy.news.view
	 * hierarchy. It can itself be a complex com.hy.news.view hierarchy. When calling this method, the layout parameters
	 * of the specified com.hy.news.view are ignored. Both the width and the height of the com.hy.news.view are set by default to
	 * MATCH_PARENT. To use your own layout parameters, invoke setContentView(android.com.hy.news.view.View,
	 * android.com.hy.news.view.ViewGroup.LayoutParams) instead.
	 *
	 * @param v The desired content to display.
	 */
	public void setContentView(View v) {
		mBroadcasting = true;
		mActivity.setContentView(v);
	}

	/**
	 * Set the behind com.hy.news.view content to an explicit com.hy.news.view. This com.hy.news.view is placed directly into the behind com.hy.news.view 's com.hy.news.view hierarchy.
	 * It can itself be a complex com.hy.news.view hierarchy.
	 *
	 * @param view The desired content to display.
	 * @param layoutParams Layout parameters for the com.hy.news.view. (unused)
	 */
	public void setBehindContentView(View view, LayoutParams layoutParams) {
		mViewBehind = view;
		mSlidingMenu.setMenu(mViewBehind);
	}

	/**
	 * Gets the SlidingMenu associated with this activity.
	 *
	 * @return the SlidingMenu associated with this activity.
	 */
	public SlidingMenu getSlidingMenu() {
		return mSlidingMenu;
	}

	/**
	 * Toggle the SlidingMenu. If it is open, it will be closed, and vice versa.
	 */
	public void toggle() {
		mSlidingMenu.toggle();
	}

	/**
	 * Close the SlidingMenu and show the content com.hy.news.view.
	 */
	public void showContent() {
		mSlidingMenu.showContent();
	}

	/**
	 * Open the SlidingMenu and show the menu com.hy.news.view.
	 */
	public void showMenu() {
		mSlidingMenu.showMenu();
	}

	/**
	 * Open the SlidingMenu and show the secondary menu com.hy.news.view. Will default to the regular menu
	 * if there is only one.
	 */
	public void showSecondaryMenu() {
		mSlidingMenu.showSecondaryMenu();
	}

	/**
	 * On key up.
	 *
	 * @param keyCode the key code
	 * @param event the event
	 * @return true, if successful
	 */
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && mSlidingMenu.isMenuShowing()) {
			showContent();
			return true;
		}
		return false;
	}

}

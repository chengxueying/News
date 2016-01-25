package com.jeremyfeinstein.slidingmenu.lib.app;

import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public interface SlidingActivityBase {
	
	/**
	 * Set the behind com.hy.news.view content to an explicit com.hy.news.view. This com.hy.news.view is placed directly into the behind com.hy.news.view 's com.hy.news.view hierarchy.
	 * It can itself be a complex com.hy.news.view hierarchy.
	 *
	 * @param view The desired content to display.
	 * @param layoutParams Layout parameters for the com.hy.news.view.
	 */
	public void setBehindContentView(View view, LayoutParams layoutParams);

	/**
	 * Set the behind com.hy.news.view content to an explicit com.hy.news.view. This com.hy.news.view is placed directly into the behind com.hy.news.view 's com.hy.news.view hierarchy.
	 * It can itself be a complex com.hy.news.view hierarchy. When calling this method, the layout parameters of the specified
	 * com.hy.news.view are ignored. Both the width and the height of the com.hy.news.view are set by default to MATCH_PARENT. To use your
	 * own layout parameters, invoke setContentView(android.com.hy.news.view.View, android.com.hy.news.view.ViewGroup.LayoutParams) instead.
	 *
	 * @param view The desired content to display.
	 */
	public void setBehindContentView(View view);

	/**
	 * Set the behind com.hy.news.view content from a layout resource. The resource will be inflated, adding all top-level views
	 * to the behind com.hy.news.view.
	 *
	 * @param layoutResID Resource ID to be inflated.
	 */
	public void setBehindContentView(int layoutResID);

	/**
	 * Gets the SlidingMenu associated with this activity.
	 *
	 * @return the SlidingMenu associated with this activity.
	 */
	public SlidingMenu getSlidingMenu();
		
	/**
	 * Toggle the SlidingMenu. If it is open, it will be closed, and vice versa.
	 */
	public void toggle();
	
	/**
	 * Close the SlidingMenu and show the content com.hy.news.view.
	 */
	public void showContent();
	
	/**
	 * Open the SlidingMenu and show the menu com.hy.news.view.
	 */
	public void showMenu();

	/**
	 * Open the SlidingMenu and show the secondary (right) menu com.hy.news.view. Will default to the regular menu
	 * if there is only one.
	 */
	public void showSecondaryMenu();
	
	/**
	 * Controls whether the ActionBar slides along with the above com.hy.news.view when the menu is opened,
	 * or if it stays in place.
	 *
	 * @param slidingActionBarEnabled True if you want the ActionBar to slide along with the SlidingMenu,
	 * false if you want the ActionBar to stay in place
	 */
	public void setSlidingActionBarEnabled(boolean slidingActionBarEnabled);
	
}

/*
 * Created on Mar 19, 2012
 * Author: Paul Woelfel
 * Email: frig@frig.at
 */
package at.fhstp.wificompass.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import at.fhstp.wificompass.R;
import at.fhstp.wificompass.model.ProjectSite;

/**
 * @author Paul Woelfel (paul@woelfel.at)
 */
public class NorthDrawable extends MultiTouchDrawable implements OkCallback {

	protected BitmapDrawable icon;
	
	protected OkDrawable okPopup;

	protected ProjectSite site;
	/**
	 * @param context
	 * @param superDrawable
	 */
	public NorthDrawable(Context context, MultiTouchDrawable superDrawable,ProjectSite site) {
		super(context, superDrawable);
		this.site=site;
		icon = (BitmapDrawable) ctx.getResources().getDrawable(R.drawable.north);
		this.width = icon.getBitmap().getWidth();
		this.height = icon.getBitmap().getHeight();
		this.setPivot(37.5f/70f, 37.5f/72f);
		
		okPopup=new OkDrawable(ctx,this);
		okPopup.setRelativePosition(width/2, height/2);
		
	}

	/* (non-Javadoc)
	 * @see at.fhstp.wificompass.view.MultiTouchDrawable#getDrawable()
	 */
	@Override
	public Drawable getDrawable() {
		return icon;
	}

	/* (non-Javadoc)
	 * @see at.fhstp.wificompass.view.MultiTouchDrawable#isScalable()
	 */
	@Override
	public boolean isScalable() {
		return true;
	}

	/* (non-Javadoc)
	 * @see at.fhstp.wificompass.view.MultiTouchDrawable#isRotateable()
	 */
	@Override
	public boolean isRotateable() {
		return true;
	}

	/* (non-Javadoc)
	 * @see at.fhstp.wificompass.view.MultiTouchDrawable#isDragable()
	 */
	@Override
	public boolean isDragable() {
		return true;
	}

	/* (non-Javadoc)
	 * @see at.fhstp.wificompass.view.MultiTouchDrawable#isOnlyInSuper()
	 */
	@Override
	public boolean isOnlyInSuper() {
		return false;
	}

	@Override
	public void onOk() {
		// save north to site
		float mapAngle=angle;
		if(superDrawable!=null){
			mapAngle-=superDrawable.getAngle();
		}
		site.setNorth(mapAngle);
		this.deleteDrawable();
	}
	

}
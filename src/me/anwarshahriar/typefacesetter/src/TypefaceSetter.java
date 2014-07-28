package me.anwarshahriar.typefacesetter.src;

import java.lang.reflect.Method;
import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;

public class TypefaceSetter {
	private Activity mActivity;
	private View mView;
	private String mFontSource;
	private Typeface mDefaultTypeface;
	private AssetManager mAssetManager;
	
	public TypefaceSetter(Activity activity, AssetManager assetManager, String fontSource) {
		mActivity = activity;
		setDefaultFontSource(mFontSource);
		mAssetManager = assetManager;
		mView = mActivity.findViewById(android.R.id.content);
	}
	
	public TypefaceSetter(View view, AssetManager assetManager, String fontSource) {
		mView = view;
		mAssetManager = assetManager;
		setDefaultFontSource(fontSource);
	}
	
	public void setDefaultFontSource(String fontSource) {
		mFontSource = fontSource;
		mDefaultTypeface = Typeface.createFromAsset(mAssetManager, fontSource);
	}
	
	public void setTypeface() {
		traverseView(mView);
	}
	
	private void setTypeface(View tv, Typeface typeface) {
		Method m = null;
		try {
			m = tv.getClass().getMethod("setTypeface", Typeface.class);
			if (m != null) {
				m.invoke(tv, typeface);
			}
		} catch (Exception e) {
		}
	}
	
	private void traverseView(View view) {
		if (view instanceof ViewGroup) {
			ViewGroup viewGroup = (ViewGroup) view;
			for (int i = 0; i < viewGroup.getChildCount(); i++) {
				View v = viewGroup.getChildAt(i);
				setTypeface(v, mDefaultTypeface);
				if (v instanceof ViewGroup) {
					traverseView((ViewGroup) v);
				}
			}
		} else {
			setTypeface(view, mDefaultTypeface);
		}
	}
}

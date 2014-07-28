package me.anwarshahriar.typefacesetter.app;

import me.anwarshahriar.typefacesetter.src.TypefaceSetter;
import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//set a single typeface to whole view
		TypefaceSetter setter = new TypefaceSetter(this, "fonts/Roboto-Light.ttf");
		setter.setTypeface();
	}
}

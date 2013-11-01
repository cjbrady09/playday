package com.example.android.navigationdrawerexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	private Context context;
	private final String[] mobileValues;
 
	public ImageAdapter(Context context, String[] mobileValues) {
		this.context = context;
		this.mobileValues = mobileValues;
	}
 
	public View getView(int position, View convertView, ViewGroup parent) {
 
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View gridView;
 
		if (convertView == null) {
 
			gridView = new View(context);
 
			// get layout from mobile.xml
			gridView = inflater.inflate(R.layout.mobile, null);
 
			// set image based on selected text
			ImageView imageView = (ImageView) gridView
					.findViewById(R.id.grid_item_image);
 
			String mobile = mobileValues[position];
 
			if (mobile.equals("a")) {
				imageView.setImageResource(R.drawable.a);
				imageView.setId(R.id.myimage1);
			} else if (mobile.equals("b")) {
				imageView.setImageResource(R.drawable.b);
				imageView.setId(R.id.myimage2);
			} else if (mobile.equals("c")) {
				imageView.setImageResource(R.drawable.c);
				imageView.setId(R.id.myimage3);
			} else if (mobile.equals("d")) {
				imageView.setImageResource(R.drawable.d);
				imageView.setId(R.id.myimage4);
			} else if (mobile.equals("e")) {
				imageView.setImageResource(R.drawable.e);
				imageView.setId(R.id.myimage5);
			} else if (mobile.equals("f")) {
				imageView.setImageResource(R.drawable.f);
				imageView.setId(R.id.myimage6);
			} else if (mobile.equals("g")) {
				imageView.setImageResource(R.drawable.g);
				imageView.setId(R.id.myimage7);
			} else if (mobile.equals("h")) {
				imageView.setImageResource(R.drawable.h);
				imageView.setId(R.id.myimage8);
			} else if (mobile.equals("i")) {
				imageView.setImageResource(R.drawable.i);
				imageView.setId(R.id.myimage9);
			} else if (mobile.equals("j")) {
				imageView.setImageResource(R.drawable.j);
				imageView.setId(R.id.myimage10);
			} else if (mobile.equals("k")) {
				imageView.setImageResource(R.drawable.k);
				imageView.setId(R.id.myimage11);
			} else if (mobile.equals("l")) {
				imageView.setImageResource(R.drawable.l);
				imageView.setId(R.id.myimage12);
			} else if (mobile.equals("m")) {
				imageView.setImageResource(R.drawable.m);
				imageView.setId(R.id.myimage13);
			} else if (mobile.equals("n")) {
				imageView.setImageResource(R.drawable.n);
				imageView.setId(R.id.myimage14);
			} else if (mobile.equals("o")) {
				imageView.setImageResource(R.drawable.o);
				imageView.setId(R.id.myimage15);
			} else if (mobile.equals("p")) {
				imageView.setImageResource(R.drawable.p);
				imageView.setId(R.id.myimage16);
			} else if (mobile.equals("q")) {
				imageView.setImageResource(R.drawable.q);
				imageView.setId(R.id.myimage17);
			} else if (mobile.equals("r")) {
				imageView.setImageResource(R.drawable.r);
				imageView.setId(R.id.myimage18);
			} else if (mobile.equals("s")) {
				imageView.setImageResource(R.drawable.s);
				imageView.setId(R.id.myimage19);
			} else if (mobile.equals("t")) {
				imageView.setImageResource(R.drawable.t);
				imageView.setId(R.id.myimage20);
			} else if (mobile.equals("u")) {
				imageView.setImageResource(R.drawable.u);
				imageView.setId(R.id.myimage21);
			} else if (mobile.equals("v")) {
				imageView.setImageResource(R.drawable.v);
				imageView.setId(R.id.myimage22);
			} else if (mobile.equals("w")) {
				imageView.setImageResource(R.drawable.w);
				imageView.setId(R.id.myimage23);
			} else if (mobile.equals("x")) {
				imageView.setImageResource(R.drawable.x);
				imageView.setId(R.id.myimage24);
			} else if (mobile.equals("y")) {
				imageView.setImageResource(R.drawable.y);
				imageView.setId(R.id.myimage25);
			} else {
				imageView.setImageResource(R.drawable.z);
				imageView.setId(R.id.myimage26);
			}
 
		} else {
			gridView = (View) convertView;
		}
 
		return gridView;
	}
 
	@Override
	public int getCount() {
		return mobileValues.length;
	}
 
	@Override
	public Object getItem(int position) {
		return null;
	}
 
	@Override
	public long getItemId(int position) {
		return 0;
	}
 
}
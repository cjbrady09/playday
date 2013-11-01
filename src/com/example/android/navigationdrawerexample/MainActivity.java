/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigationdrawerexample;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private DrawerLayout mDrawerLayout;
    private GridView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    
    ImageView block5,block6,block7,block8;
    ImageView blocka,blockb,blockc,blockd,blocke,blockf,blockg,blockh,blocki,blockj,blockk,blockl,blockm;
    ImageView blockn,blocko,blockp,blockq,blockr,blocks,blockt,blocku,blockv,blockw,blockx,blocky,blockz;
	boolean p,l,a,y;
	MediaPlayer mp;
    
    GridView gridView;
    
	static final String[] ALPHABET = new String[] { 
		"a", "b","c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mTitle = mDrawerTitle = getTitle();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (GridView) findViewById(R.id.left_drawer);

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        // set up the drawer's list view with items and click listener
        mDrawerList.setAdapter(new ImageAdapter(this, ALPHABET));
        
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerList.setOnDragListener(new DrawerItemDragListener());
        	

      		//views to drop onto
      		block5 = (ImageView)findViewById(R.id.myanswer5);
      		block6 = (ImageView)findViewById(R.id.myanswer6);
      		block7 = (ImageView)findViewById(R.id.myanswer7);
      		block8 = (ImageView)findViewById(R.id.myanswer8);

      		//set drag listener
      		block5.setOnDragListener(new ChoiceDragListener());
      		block6.setOnDragListener(new ChoiceDragListener());
      		block7.setOnDragListener(new ChoiceDragListener());
      		block8.setOnDragListener(new ChoiceDragListener());

        // enable ActionBar app icon to behave as action to toggle nav drawer
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        // ActionBarDrawerToggle ties together the the proper interactions
        // between the sliding drawer and the action bar app icon
        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.drawable.ic_drawer,  /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
                ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
                
                //view to drag
          		blocka = (ImageView)findViewById(R.id.myimage1);
          		blockb = (ImageView)findViewById(R.id.myimage2);
          		blockc = (ImageView)findViewById(R.id.myimage3);
          		blockd = (ImageView)findViewById(R.id.myimage4);
          		blocke = (ImageView)findViewById(R.id.myimage5);
          		blockf = (ImageView)findViewById(R.id.myimage6);
          		blockg = (ImageView)findViewById(R.id.myimage7);
          		blockh = (ImageView)findViewById(R.id.myimage8);
          		blocki = (ImageView)findViewById(R.id.myimage9);
          		blockj = (ImageView)findViewById(R.id.myimage10);
          		blockk = (ImageView)findViewById(R.id.myimage11);
          		blockl = (ImageView)findViewById(R.id.myimage12);
          		blockm = (ImageView)findViewById(R.id.myimage13);
          		blockn = (ImageView)findViewById(R.id.myimage14);
          		blocko = (ImageView)findViewById(R.id.myimage15);
          		blockp = (ImageView)findViewById(R.id.myimage16);
          		blockq = (ImageView)findViewById(R.id.myimage17);
          		blockr = (ImageView)findViewById(R.id.myimage18);
          		blocks = (ImageView)findViewById(R.id.myimage19);
          		blockt = (ImageView)findViewById(R.id.myimage20);
          		blocku = (ImageView)findViewById(R.id.myimage21);
          		blockv = (ImageView)findViewById(R.id.myimage22);
          		blockw = (ImageView)findViewById(R.id.myimage23);
          		blockx = (ImageView)findViewById(R.id.myimage24);
          		blocky = (ImageView)findViewById(R.id.myimage25);
          		blockz = (ImageView)findViewById(R.id.myimage26);

          		//set touch listener
          		blocka.setOnTouchListener(new ChoiceTouchListener());
          		blockb.setOnTouchListener(new ChoiceTouchListener());
          		blockc.setOnTouchListener(new ChoiceTouchListener());
          		blockd.setOnTouchListener(new ChoiceTouchListener());
          		blocke.setOnTouchListener(new ChoiceTouchListener());
          		blockf.setOnTouchListener(new ChoiceTouchListener());
          		blockg.setOnTouchListener(new ChoiceTouchListener());
          		blockh.setOnTouchListener(new ChoiceTouchListener());
          		blocki.setOnTouchListener(new ChoiceTouchListener());
          		blockj.setOnTouchListener(new ChoiceTouchListener());
          		blockk.setOnTouchListener(new ChoiceTouchListener());
          		blockl.setOnTouchListener(new ChoiceTouchListener());
          		blockm.setOnTouchListener(new ChoiceTouchListener());
          		blockn.setOnTouchListener(new ChoiceTouchListener());
          		blocko.setOnTouchListener(new ChoiceTouchListener());
          		blockp.setOnTouchListener(new ChoiceTouchListener());
          		blockq.setOnTouchListener(new ChoiceTouchListener());
          		blockr.setOnTouchListener(new ChoiceTouchListener());
          		blocks.setOnTouchListener(new ChoiceTouchListener());
          		blockt.setOnTouchListener(new ChoiceTouchListener());
          		blocku.setOnTouchListener(new ChoiceTouchListener());
          		blockv.setOnTouchListener(new ChoiceTouchListener());
          		blockw.setOnTouchListener(new ChoiceTouchListener());
          		blockx.setOnTouchListener(new ChoiceTouchListener());
          		blocky.setOnTouchListener(new ChoiceTouchListener());
          		blockz.setOnTouchListener(new ChoiceTouchListener());
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            selectItem(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first

       mp.stop();
    }
    
    @Override
    public void onStop() {
        super.onStop();  // Always call the superclass method first
        mp.stop();  
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        mp = MediaPlayer.create(this, R.raw.morning);
        mp.start();
    }
    
    /* Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         // The action bar home/up action should open or close the drawer.
         // ActionBarDrawerToggle will take care of this.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action buttons
        switch(item.getItemId()) {
        default:
            return super.onOptionsItemSelected(item);
        }
    }

    /* The click listner for ListView in the navigation drawer */
    private class DrawerItemClickListener implements GridView.OnItemClickListener {
    	
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

		
        
    }
    
    private class DrawerItemDragListener implements GridView.OnDragListener {

    	@Override
		public boolean onDrag(View arg0, DragEvent arg1) {
			// TODO Auto-generated method stub
			
			switch (arg1.getAction()) {
			case DragEvent.ACTION_DRAG_STARTED:
				mDrawerLayout.closeDrawer(mDrawerList);
			break;
				
			}
			
			return false;
		}
    	
    }

    private void selectItem(int position) {
		mDrawerLayout.closeDrawer(mDrawerList);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
    
    /**
	 * ChoiceTouchListener will handle touch events on draggable views
	 *
	 */
	private final class ChoiceTouchListener implements OnTouchListener {
		public boolean onTouch(View view, MotionEvent motionEvent) {
			if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
				/*
				 * Drag details: we only need default behavior
				 * - clip data could be set to pass data as part of drag
				 * - shadow can be tailored
				 */
				ClipData data = ClipData.newPlainText("", "");
				DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
				//start dragging the item touched
				view.startDrag(data, shadowBuilder, view, 0);
				return true;
			} else {
				return false;
			}
		}
	} 
    
    /**
	 * DragListener will handle dragged views being dropped on the drop area
	 * - only the drop action will have processing added to it as we are not
	 * - amending the default behavior for other parts of the drag process
	 *
	 */
	private class ChoiceDragListener implements OnDragListener {

		@Override
		public boolean onDrag(View v, DragEvent event) {
			switch (event.getAction()) {
			case DragEvent.ACTION_DRAG_STARTED:
				//no action necessary
				break;
			case DragEvent.ACTION_DRAG_ENTERED:
				//no action necessary
				break;
			case DragEvent.ACTION_DRAG_EXITED:        
				//no action necessary
				break;
			case DragEvent.ACTION_DROP:
				//handle the dragged view being dropped over a drop view
				View view = (View) event.getLocalState();
				//stop displaying the view where it was before it was dragged
				//view.setVisibility(View.INVISIBLE);
				//view dragged item is being dropped on
				ImageView dropTarget = (ImageView) v;
				//view being dragged and dropped
				ImageView dropped = (ImageView) view;
				//update the text in the target view to reflect the data being dropped
				
				
				switch(dropTarget.getId()) {
				case R.id.myanswer5:
					switch(dropped.getId()) {
					case R.id.myimage1:
						dropTarget.setImageResource(R.drawable.a);
						p=false;
						break;
					case R.id.myimage2:
						dropTarget.setImageResource(R.drawable.b);
						p=false;
						break;
					case R.id.myimage3:
						dropTarget.setImageResource(R.drawable.c);
						p=false;
						break;
					case R.id.myimage4:
						dropTarget.setImageResource(R.drawable.d);
						p=false;
						break;
					case R.id.myimage5:
						dropTarget.setImageResource(R.drawable.e);
						p=false;
						break;
					case R.id.myimage6:
						dropTarget.setImageResource(R.drawable.f);
						p=false;
						break;
					case R.id.myimage7:
						dropTarget.setImageResource(R.drawable.g);
						p=false;
						break;
					case R.id.myimage8:
						dropTarget.setImageResource(R.drawable.h);
						p=false;
						break;
					case R.id.myimage9:
						dropTarget.setImageResource(R.drawable.i);
						p=false;
						break;
					case R.id.myimage10:
						dropTarget.setImageResource(R.drawable.j);
						p=false;
						break;
					case R.id.myimage11:
						dropTarget.setImageResource(R.drawable.k);
						p=false;
						break;
					case R.id.myimage12:
						dropTarget.setImageResource(R.drawable.l);
						p=false;
						break;
					case R.id.myimage13:
						dropTarget.setImageResource(R.drawable.m);
						p=false;
						break;
					case R.id.myimage14:
						dropTarget.setImageResource(R.drawable.n);
						p=false;
						break;
					case R.id.myimage15:
						dropTarget.setImageResource(R.drawable.o);
						p=false;
						break;
					case R.id.myimage16:
						dropTarget.setImageResource(R.drawable.p);
						p=true;
						break;
					case R.id.myimage17:
						dropTarget.setImageResource(R.drawable.q);
						p=false;
						break;
					case R.id.myimage18:
						dropTarget.setImageResource(R.drawable.r);
						p=false;
						break;
					case R.id.myimage19:
						dropTarget.setImageResource(R.drawable.s);
						p=false;
						break;
					case R.id.myimage20:
						dropTarget.setImageResource(R.drawable.t);
						p=false;
						break;
					case R.id.myimage21:
						dropTarget.setImageResource(R.drawable.u);
						p=false;
						break;
					case R.id.myimage22:
						dropTarget.setImageResource(R.drawable.v);
						p=false;
						break;
					case R.id.myimage23:
						dropTarget.setImageResource(R.drawable.w);
						p=false;
						break;
					case R.id.myimage24:
						dropTarget.setImageResource(R.drawable.x);
						p=false;
						break;
					case R.id.myimage25:
						dropTarget.setImageResource(R.drawable.y);
						p=false;
						break;
					case R.id.myimage26:
						dropTarget.setImageResource(R.drawable.z);
						p=false;
						break;
					}
					break;
				case R.id.myanswer6:
					switch(dropped.getId()) {
					case R.id.myimage1:
						dropTarget.setImageResource(R.drawable.a);
						l=false;
						break;
					case R.id.myimage2:
						dropTarget.setImageResource(R.drawable.b);
						l=false;
						break;
					case R.id.myimage3:
						dropTarget.setImageResource(R.drawable.c);
						l=false;
						break;
					case R.id.myimage4:
						dropTarget.setImageResource(R.drawable.d);
						l=false;
						break;
					case R.id.myimage5:
						dropTarget.setImageResource(R.drawable.e);
						l=false;
						break;
					case R.id.myimage6:
						dropTarget.setImageResource(R.drawable.f);
						l=false;
						break;
					case R.id.myimage7:
						dropTarget.setImageResource(R.drawable.g);
						l=false;
						break;
					case R.id.myimage8:
						dropTarget.setImageResource(R.drawable.h);
						l=false;
						break;
					case R.id.myimage9:
						dropTarget.setImageResource(R.drawable.i);
						l=false;
						break;
					case R.id.myimage10:
						dropTarget.setImageResource(R.drawable.j);
						l=false;
						break;
					case R.id.myimage11:
						dropTarget.setImageResource(R.drawable.k);
						l=false;
						break;
					case R.id.myimage12:
						dropTarget.setImageResource(R.drawable.l);
						l=true;
						break;
					case R.id.myimage13:
						dropTarget.setImageResource(R.drawable.m);
						l=false;
						break;
					case R.id.myimage14:
						dropTarget.setImageResource(R.drawable.n);
						l=false;
						break;
					case R.id.myimage15:
						dropTarget.setImageResource(R.drawable.o);
						l=false;
						break;
					case R.id.myimage16:
						dropTarget.setImageResource(R.drawable.p);
						l=false;
						break;
					case R.id.myimage17:
						dropTarget.setImageResource(R.drawable.q);
						l=false;
						break;
					case R.id.myimage18:
						dropTarget.setImageResource(R.drawable.r);
						l=false;
						break;
					case R.id.myimage19:
						dropTarget.setImageResource(R.drawable.s);
						l=false;
						break;
					case R.id.myimage20:
						dropTarget.setImageResource(R.drawable.t);
						l=false;
						break;
					case R.id.myimage21:
						dropTarget.setImageResource(R.drawable.u);
						l=false;
						break;
					case R.id.myimage22:
						dropTarget.setImageResource(R.drawable.v);
						l=false;
						break;
					case R.id.myimage23:
						dropTarget.setImageResource(R.drawable.w);
						l=false;
						break;
					case R.id.myimage24:
						dropTarget.setImageResource(R.drawable.x);
						l=false;
						break;
					case R.id.myimage25:
						dropTarget.setImageResource(R.drawable.y);
						l=false;
						break;
					case R.id.myimage26:
						dropTarget.setImageResource(R.drawable.z);
						l=false;
						break;
					}
					break;
				case R.id.myanswer7:
					switch(dropped.getId()) {
					case R.id.myimage1:
						dropTarget.setImageResource(R.drawable.a);
						a=true;
						break;
					case R.id.myimage2:
						dropTarget.setImageResource(R.drawable.b);
						a=false;
						break;
					case R.id.myimage3:
						dropTarget.setImageResource(R.drawable.c);
						a=false;
						break;
					case R.id.myimage4:
						dropTarget.setImageResource(R.drawable.d);
						a=false;
						break;
					case R.id.myimage5:
						dropTarget.setImageResource(R.drawable.e);
						a=false;
						break;
					case R.id.myimage6:
						dropTarget.setImageResource(R.drawable.f);
						a=false;
						break;
					case R.id.myimage7:
						dropTarget.setImageResource(R.drawable.g);
						a=false;
						break;
					case R.id.myimage8:
						dropTarget.setImageResource(R.drawable.h);
						a=false;
						break;
					case R.id.myimage9:
						dropTarget.setImageResource(R.drawable.i);
						a=false;
						break;
					case R.id.myimage10:
						dropTarget.setImageResource(R.drawable.j);
						a=false;
						break;
					case R.id.myimage11:
						dropTarget.setImageResource(R.drawable.k);
						a=false;
						break;
					case R.id.myimage12:
						dropTarget.setImageResource(R.drawable.l);
						a=false;
						break;
					case R.id.myimage13:
						dropTarget.setImageResource(R.drawable.m);
						a=false;
						break;
					case R.id.myimage14:
						dropTarget.setImageResource(R.drawable.n);
						a=false;
						break;
					case R.id.myimage15:
						dropTarget.setImageResource(R.drawable.o);
						a=false;
						break;
					case R.id.myimage16:
						dropTarget.setImageResource(R.drawable.p);
						a=false;
						break;
					case R.id.myimage17:
						dropTarget.setImageResource(R.drawable.q);
						a=false;
						break;
					case R.id.myimage18:
						dropTarget.setImageResource(R.drawable.r);
						a=false;
						break;
					case R.id.myimage19:
						dropTarget.setImageResource(R.drawable.s);
						a=false;
						break;
					case R.id.myimage20:
						dropTarget.setImageResource(R.drawable.t);
						a=false;
						break;
					case R.id.myimage21:
						dropTarget.setImageResource(R.drawable.u);
						a=false;
						break;
					case R.id.myimage22:
						dropTarget.setImageResource(R.drawable.v);
						a=false;
						break;
					case R.id.myimage23:
						dropTarget.setImageResource(R.drawable.w);
						a=false;
						break;
					case R.id.myimage24:
						dropTarget.setImageResource(R.drawable.x);
						a=false;
						break;
					case R.id.myimage25:
						dropTarget.setImageResource(R.drawable.y);
						a=false;
						break;
					case R.id.myimage26:
						dropTarget.setImageResource(R.drawable.z);
						a=false;
						break;
					}
					break;
				case R.id.myanswer8:
					switch(dropped.getId()) {
					case R.id.myimage1:
						dropTarget.setImageResource(R.drawable.a);
						y=false;
						break;
					case R.id.myimage2:
						dropTarget.setImageResource(R.drawable.b);
						y=false;
						break;
					case R.id.myimage3:
						dropTarget.setImageResource(R.drawable.c);
						y=false;
						break;
					case R.id.myimage4:
						dropTarget.setImageResource(R.drawable.d);
						y=false;
						break;
					case R.id.myimage5:
						dropTarget.setImageResource(R.drawable.e);
						y=false;
						break;
					case R.id.myimage6:
						dropTarget.setImageResource(R.drawable.f);
						y=false;
						break;
					case R.id.myimage7:
						dropTarget.setImageResource(R.drawable.g);
						y=false;
						break;
					case R.id.myimage8:
						dropTarget.setImageResource(R.drawable.h);
						y=false;
						break;
					case R.id.myimage9:
						dropTarget.setImageResource(R.drawable.i);
						y=false;
						break;
					case R.id.myimage10:
						dropTarget.setImageResource(R.drawable.j);
						y=false;
						break;
					case R.id.myimage11:
						dropTarget.setImageResource(R.drawable.k);
						y=false;
						break;
					case R.id.myimage12:
						dropTarget.setImageResource(R.drawable.l);
						y=false;
						break;
					case R.id.myimage13:
						dropTarget.setImageResource(R.drawable.m);
						y=false;
						break;
					case R.id.myimage14:
						dropTarget.setImageResource(R.drawable.n);
						y=false;
						break;
					case R.id.myimage15:
						dropTarget.setImageResource(R.drawable.o);
						y=false;
						break;
					case R.id.myimage16:
						dropTarget.setImageResource(R.drawable.p);
						y=false;
						break;
					case R.id.myimage17:
						dropTarget.setImageResource(R.drawable.q);
						y=false;
						break;
					case R.id.myimage18:
						dropTarget.setImageResource(R.drawable.r);
						y=false;
						break;
					case R.id.myimage19:
						dropTarget.setImageResource(R.drawable.s);
						y=false;
						break;
					case R.id.myimage20:
						dropTarget.setImageResource(R.drawable.t);
						y=false;
						break;
					case R.id.myimage21:
						dropTarget.setImageResource(R.drawable.u);
						y=false;
						break;
					case R.id.myimage22:
						dropTarget.setImageResource(R.drawable.v);
						y=false;
						break;
					case R.id.myimage23:
						dropTarget.setImageResource(R.drawable.w);
						y=false;
						break;
					case R.id.myimage24:
						dropTarget.setImageResource(R.drawable.x);
						y=false;
						break;
					case R.id.myimage25:
						dropTarget.setImageResource(R.drawable.y);
						y=true;
						break;
					case R.id.myimage26:
						dropTarget.setImageResource(R.drawable.z);
						y=false;
						break;
					}
					break;
				}
				
				//dropTarget.setImageResource(dropped.getId());
				//make it bold to highlight the fact that an item has been dropped
				//dropTarget.setTypeface(Typeface.DEFAULT_BOLD);
				//if an item has already been dropped here, there will be a tag
				Object tag = dropTarget.getTag();
				//if there is already an item here, set it back visible in its original place
				if(tag!=null)
				{//
					//the tag is the view id already dropped here
					int existingID = (Integer)tag;
					//set the original view visible again
					findViewById(existingID).setVisibility(View.VISIBLE);
				}
				//set the tag in the target view being dropped on - to the ID of the view being dropped
				dropTarget.setTag(dropped.getId());
				
				if(p && l && a && y)
				{
					nextGame();
				}
				
				break;
			case DragEvent.ACTION_DRAG_ENDED:
				//no action necessary
				break;
			default:
				break;
			}
			return true;
		}
	} 
	
	public void nextGame()
	{
		System.out.println("Good Game");
		ImageView nextView = (ImageView)findViewById(R.id.nextButton);
		nextView.setVisibility(View.VISIBLE);
	}
	
	public void toNext(View v)
	{

		mp.stop();
		Intent i = new Intent(getBaseContext(), ShowerActivity.class);   
		startActivity(i);
	}
}
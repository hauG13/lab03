package course.labs.activitylab;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityOne extends Activity {

		// string for logcat documentation
		private final static String TAG = "Lab-ActivityOne";
		private int createCtr;
		private int startCtr;
		private int resumeCtr;
		private int pauseCtr;
		private int stopCtr;
		private int restartCtr;
		private int destroyCtr;

	
		// lifecycle counts	
		//TODO:
		//Create 7 counter variables, each corresponding to a different one of the lifecycle callback methods.
		// You will need to increment these variables' values when their corresponding lifecycle methods get called.  
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_one);
			
			//Log cat print out
			Log.i(TAG, "onCreate called");

			createCtr++;

			if(savedInstanceState != null){
				createCtr=savedInstanceState.getInt("Create");
				startCtr=savedInstanceState.getInt("Start");
				resumeCtr=savedInstanceState.getInt("Resume");
				pauseCtr=savedInstanceState.getInt("Pause");
				stopCtr=savedInstanceState.getInt("Stop");
				restartCtr=savedInstanceState.getInt("Restart");
				destroyCtr=savedInstanceState.getInt("Destroy");
			}
			else{
				createCtr=1;
				startCtr=0;
				resumeCtr=0;
				pauseCtr=0;
				stopCtr=0;
				restartCtr=0;
				destroyCtr=0;
			}
			TextView element = (TextView)findViewById(R.id.create);
			element.setText(getString(R.string.onCreate) + createCtr);
			((TextView)findViewById(R.id.start)).setText(getString(R.string.onStart)+startCtr);
			((TextView)findViewById(R.id.resume)).setText(getString(R.string.onResume)+resumeCtr);
			((TextView)findViewById(R.id.pause)).setText(getString(R.string.onPause)+pauseCtr);
			((TextView)findViewById(R.id.stop)).setText(getString(R.string.onStop)+stopCtr);
			((TextView)findViewById(R.id.restart)).setText(getString(R.string.onRestart)+restartCtr);
			((TextView)findViewById(R.id.destroy)).setText(getString(R.string.onDestroy)+destroyCtr);
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.activity_one, menu);
			return true;
		}
		
		// lifecycle callback overrides


		@Override
		public void onStart(){
			super.onStart();


			//Log cat print out
			Log.i(TAG, "onStart called");
			startCtr++;
			TextView element = (TextView)findViewById(R.id.start);
			element.setText("onStart() calls: " +startCtr);
		}

		@Override
		public void onSaveInstanceState(Bundle savedInstanceState){
			super.onSaveInstanceState(savedInstanceState);
			savedInstanceState.putInt("Create",createCtr);
			savedInstanceState.putInt("Start",startCtr);
			savedInstanceState.putInt("Resume",resumeCtr);
			savedInstanceState.putInt("Pause",pauseCtr);
			savedInstanceState.putInt("Stop",stopCtr);
			savedInstanceState.putInt("Restart",restartCtr);
			savedInstanceState.putInt("Destroy",destroyCtr);
		}

		public void launchActivityTwo(View view) {
			Intent a2 = new Intent(ActivityOne.this, ActivityTwo.class);
			ActivityOne.this.startActivity(a2);
			//TODO:
			// This function launches Activity Two.
			// Hint: use Context’s startActivity() method.
		}

	@Override
	public void onResume(){
		super.onResume();

		//Log cat print out
		Log.i(TAG, "onResume called");
		resumeCtr++;
		TextView element = (TextView)findViewById(R.id.resume);
		element.setText("onResume() calls: " + restartCtr);
	}

	@Override
	public void onPause(){
		super.onPause();

		//Log cat print out
		Log.i(TAG, "onPause called");
		pauseCtr++;
		TextView element = (TextView)findViewById(R.id.pause);
		element.setText( "onPause() calls: " + pauseCtr);
	}

	@Override
	public void onStop(){
		super.onStop();

		//Log cat print out
		Log.i(TAG, "onStop called");
		stopCtr++;
		TextView element = (TextView)findViewById(R.id.stop);
		element.setText(getString(R.string.onStop)+ stopCtr);

		SharedPreferences pref = getPreferences(MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();
		editor.putInt("Create",createCtr);
		editor.putInt("Start",startCtr);
		editor.putInt("Resume",resumeCtr);
		editor.putInt("Pause",pauseCtr);
		editor.putInt("Stop",stopCtr);
		editor.putInt("Restart",restartCtr);
		editor.putInt("Destroy",destroyCtr);
		editor.commit();


	}

	@Override
	public void onRestart(){
		super.onRestart();

		//Log cat print out
		Log.i(TAG, "onRestart called");
		restartCtr++;
		TextView element = (TextView)findViewById(R.id.restart);
		element.setText(getString(R.string.onRestart) + restartCtr);
	}

	@Override
	public void onDestroy(){
		super.onDestroy();

		//Log cat print out
		Log.i(TAG, "onDestroy called");
		destroyCtr++;
		TextView element = (TextView)findViewById(R.id.destroy);
		element.setText("onDestroy() calls: " + destroyCtr);
	}


}

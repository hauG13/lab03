package course.labs.activitylab;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class ActivityTwo extends Activity {

	// string for logcat documentation
	private final static String TAG = "Lab-ActivityTwo";
	private int createCtr;
	private int startCtr;
	private int resumeCtr;
	private int pauseCtr;
	private int stopCtr;
	private int restartCtr;
	private int destroyCtr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);
		
		//Log cat print out
		Log.i(TAG, "onCreate called");
		createCtr++;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_two, menu);
		return true;
	}
	
	@Override
	public void onStart(){
		super.onStart();

		
		//Log cat print out
		Log.i(TAG, "onStart called");
		startCtr++;
	}
	
	@Override
	public void onResume(){
		super.onResume();

		//Log cat print out
		Log.i(TAG, "onResume called");
		resumeCtr++;
	}
	
	@Override
	public void onPause(){
		super.onPause();

		//Log cat print out
		Log.i(TAG, "onPause called");
		pauseCtr++;
	}
	
	@Override
	public void onStop(){
		super.onStop();

		//Log cat print out
		Log.i(TAG, "onStop called");
		stopCtr++;
	}

	@Override
	public void onRestart(){
		super.onRestart();

		//Log cat print out
		Log.i(TAG, "onRestart called");
		restartCtr++;
	}
	
	@Override
	public void onDestroy(){
		super.onDestroy();

		//Log cat print out
		Log.i(TAG, "onDestroy called");
		destroyCtr++;
	}
	
	public void close(View view){
		setResult(RESULT_OK);
		finish();
	}

}

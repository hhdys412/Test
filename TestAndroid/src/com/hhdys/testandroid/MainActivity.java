package com.hhdys.testandroid;

import java.util.ArrayList;
import java.util.List;

import com.hhdys.testandroid.NewItemFragment.OnNewItemAddedListener;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity implements OnNewItemAddedListener {
	private ListView lv;
	private EditText et;
	ArrayAdapter<String> ad;
	List<String> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FragmentManager fm = getFragmentManager();
		ToDoListFragment toDoListFragment = (ToDoListFragment) fm
				.findFragmentById(R.id.ToDoListFragment);
		list=new ArrayList<String>();
		ad=new ArrayAdapter<String>(this, R.layout.todolist_item,list);
		toDoListFragment.setListAdapter(ad);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void Add(View v) {
		list.add(0, et.getText().toString());
		ad.notifyDataSetChanged();
		et.setText("");
	}

	@Override
	public void onNewItemAdded(String newItem) {
		// TODO Auto-generated method stub
		list.add(0,newItem);
		ad.notifyDataSetChanged();
	}

}

package com.hhdys.test;

import com.hhdys.testandroid.R;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitlesFragment extends ListFragment {
	boolean mDualPane;
	int mCurcheckPosition = 0;

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		showDetails(position);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_activated_1,
				Shakespeare.TITLES));
		View detailFrame = getActivity().findViewById(R.id.details);
		mDualPane = detailFrame != null
				&& detailFrame.getVisibility() == View.VISIBLE;
		if (savedInstanceState != null) {
			mCurcheckPosition = savedInstanceState.getInt("curChoice", 0);
		}
		if (mDualPane) {
			getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
			showDetails(mCurcheckPosition);
		}
	}

	private void showDetails(int index) {
		mCurcheckPosition = index;
		if (mDualPane) {
			getListView().setItemChecked(index, true);
			DetailFragment detail = (DetailFragment) getFragmentManager()
					.findFragmentById(R.id.details);
			if(detail==null||detail.getShownIndex()!=index){
				detail=DetailFragment.newInstance(index);
				FragmentTransaction ft=getFragmentManager().beginTransaction();
				if(index==0){
					ft.replace(R.id.details, detail);
				}else {
					Log.i("aaa", "aaaaaaaaaaaa");
				}
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
				ft.addToBackStack(null);
				ft.commit();
			}
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("curChoice", mCurcheckPosition);
	}

}

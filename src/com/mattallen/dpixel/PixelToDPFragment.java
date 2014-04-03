package com.mattallen.dpixel;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class PixelToDPFragment extends ConverterFragment implements OnItemSelectedListener {

	private EditText				mPixelEntry;
	private TextView				mDP;
	private Spinner					mSpinner;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_pixel_to_dp, container, false);
		mPixelEntry = (EditText)view.findViewById(R.id.fragment_pixel_entry);
		mDP = (TextView)view.findViewById(R.id.fragment_pixel_dpamount);
		mSpinner = (Spinner)view.findViewById(R.id.fragment_pixel_spinner);
		return view;
	}

	@Override
	public void onStart(){
		super.onStart();
		mSpinner.setOnItemSelectedListener(this);
		mDP.setText("0dp");
		mPixelEntry.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(!s.toString().equals("")){
					updateValue(Double.parseDouble(s.toString()));
				} else {
					updateValue(0);
				}
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}
			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}

	private void updateValue(double pixels){
		String dpValue = "0dp";
		switch (mSpinner.getSelectedItemPosition()) {
		case 0:
			dpValue = DPConverter.pixelToDP(pixels, DPConverter.LDPI);
			break;
		case 1:
			dpValue = DPConverter.pixelToDP(pixels, DPConverter.MDPI);
			break;
		case 2:
			dpValue = DPConverter.pixelToDP(pixels, DPConverter.HDPI);
			break;
		case 3:
			dpValue = DPConverter.pixelToDP(pixels, DPConverter.XHDPI);
			break;
		case 4:
			dpValue = DPConverter.pixelToDP(pixels, DPConverter.XXHDPI);
			break;
		case 5:
			dpValue = DPConverter.pixelToDP(pixels, DPConverter.XXXHDPI);
			break;
		default:
			break;
		}
		mDP.setText(dpValue);
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		if(!mPixelEntry.getText().toString().equals("")){
			updateValue(Double.parseDouble(mPixelEntry.getText().toString()));
		} else {
			updateValue(0);
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
	}
}
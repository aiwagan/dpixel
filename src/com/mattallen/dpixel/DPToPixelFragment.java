package com.mattallen.dpixel;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class DPToPixelFragment extends ConverterFragment {
	
	private EditText						mDPEntry;
	private TextView						mLDPI, mMDPI, mHDPI, mXHDPI, mXXHDPI, mXXXHDPI;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_dp_to_pixel, container, false);
		return view;
	}

	@Override
	public void onStart(){
		super.onStart();
		mDPEntry = (EditText)getView().findViewById(R.id.fragment_dp_edittext);
		mLDPI = (TextView)getView().findViewById(R.id.fragment_dp_ldpi_value);
		mMDPI = (TextView)getView().findViewById(R.id.fragment_dp_mdpi_value);
		mHDPI = (TextView)getView().findViewById(R.id.fragment_dp_hdpi_value);
		mXHDPI = (TextView)getView().findViewById(R.id.fragment_dp_xhdpi_value);
		mXXHDPI = (TextView)getView().findViewById(R.id.fragment_dp_xxhdpi_value);
		mXXXHDPI = (TextView)getView().findViewById(R.id.fragment_dp_xxxhdpi_value);

		mDPEntry.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if(!s.toString().equals("")){
					updateValues(Double.parseDouble(s.toString()));
				} else {
					updateValues(0);
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

	private void updateValues(double dpAmount){
		mLDPI.setText(DPConverter.dpToPixel(dpAmount, DPConverter.LDPI));
		mMDPI.setText(DPConverter.dpToPixel(dpAmount, DPConverter.MDPI));
		mHDPI.setText(DPConverter.dpToPixel(dpAmount, DPConverter.HDPI));
		mXHDPI.setText(DPConverter.dpToPixel(dpAmount, DPConverter.XHDPI));
		mXXHDPI.setText(DPConverter.dpToPixel(dpAmount, DPConverter.XXHDPI));
		mXXXHDPI.setText(DPConverter.dpToPixel(dpAmount, DPConverter.XXXHDPI));
	}
}
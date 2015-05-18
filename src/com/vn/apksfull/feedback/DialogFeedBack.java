package com.vn.apksfull.feedback;

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.vn.apksfull.R;

public class DialogFeedBack extends Dialog implements
		android.view.View.OnClickListener, OnItemSelectedListener {

	public Context context;
	public Spinner spinner;
	public EditText noidung;
	public Button gui, huybo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dialog_feedback);
		spinner = (Spinner) findViewById(R.id.spn_loailoi);
		noidung = (EditText) findViewById(R.id.dialog_edt_feedback);
		gui = (Button) findViewById(R.id.btn_dialog_send);
		huybo = (Button) findViewById(R.id.btn_dialog_cancel);

		spinner.setOnItemSelectedListener(this);
		gui.setOnClickListener(this);
		huybo.setOnClickListener(this);

		List<String> categories = new ArrayList<String>();
		categories.add("Lỗi tải");
		categories.add("Lỗi tìm kiếm");
		categories.add("Lỗi đăng ký");
		categories.add("Lỗi đăng nhập");
		categories.add("Lỗi xung đột");

		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(
				getContext(), android.R.layout.simple_spinner_item, categories);

		// Drop down layout style - list view with radio button
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// attaching data adapter to spinner
		spinner.setAdapter(dataAdapter);

	}

	public DialogFeedBack(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_dialog_send:
			if (noidung.getText().toString().equals("")) {
				Toast.makeText(getContext(), "Nội dung không được rỗng!",
						Toast.LENGTH_SHORT).show();
				break;
			} else
				Toast.makeText(getContext(), "Đã gửi thành công!",
						Toast.LENGTH_SHORT).show();
			dismiss();
			break;
		case R.id.btn_dialog_cancel:
			dismiss();
			break;
		default:
			break;
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		String item = parent.getItemAtPosition(position).toString();

		Toast.makeText(parent.getContext(), "Select: " + item,
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

}

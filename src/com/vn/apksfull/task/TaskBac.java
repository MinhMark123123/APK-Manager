package com.vn.apksfull.task;

import java.util.ArrayList;

import android.content.Context;

import com.telpoo.frame.model.BaseModel;
import com.telpoo.frame.model.BaseTask;
import com.telpoo.frame.model.TaskParams;

public class TaskBac extends BaseTask implements TaskType{

	public TaskBac(BaseModel baseModel, int taskType, ArrayList<?> list, Context context) {
		super(baseModel, taskType, list, context);
	}
	
	@Override
	protected Boolean doInBackground(TaskParams... params) {
		return super.doInBackground(params);
	}

}

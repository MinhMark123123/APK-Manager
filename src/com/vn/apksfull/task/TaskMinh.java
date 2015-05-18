package com.vn.apksfull.task;

import java.util.ArrayList;

import android.content.Context;

import com.telpoo.frame.model.BaseModel;
import com.telpoo.frame.model.BaseTask;
import com.telpoo.frame.model.TaskParams;
import com.telpoo.frame.object.BaseObject;
import com.vn.apksfull.net.NetData;
import com.vn.apksfull.net.NetSupport;
import com.vn.apksfull.utils.AppTools;

public class TaskMinh extends BaseTask implements TaskType{

	public TaskMinh(BaseModel baseModel, int taskType, ArrayList<?> list, Context context) {
		super(baseModel, taskType, list, context);
	}
	
	@Override
	protected Boolean doInBackground(TaskParams... params) {
		
		switch (taskType) {
		case TASK_LOAD_APP_MNG:
			AppTools appTools = new AppTools(context);
			dataReturn = appTools.getAppInstalled();
			return true;			
			
		case TASK_LOAD_CATEGORY:
			NetData data = NetSupport.getCategory();
			
			if(data.status!=0){
				msg= data.getMessage();
				return TASK_FAILED;
			}
			
			dataReturn = (ArrayList<BaseObject>) data.data;
			return TASK_DONE;
			
			
		default:
			break;
		}	
		return super.doInBackground(params);
	}
	

}

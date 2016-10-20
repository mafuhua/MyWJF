package com.wjf.mywjf;

import android.os.Environment;

import org.xutils.DbManager;
import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CommonCallback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;
import java.util.Map;

public class XUtil {
	/**
	 * 发送get请求
	 * @param <T>
	 */
	public static <T> Cancelable Get(String url, Map<String,String> map, CommonCallback<T> callback){
		RequestParams params=new RequestParams(url);
		if(null!=map){
			for(Map.Entry<String, String> entry : map.entrySet()){
				params.addQueryStringParameter(entry.getKey(), entry.getValue());
			}
		}
		Cancelable cancelable = x.http().get(params, callback);
		return cancelable;
	}

	/**
	 * 发送post请求
	 * @param <T>
	 */
	public static <T> Cancelable Post(String url, Map<String,Object> map, CommonCallback<T> callback){
		RequestParams params=new RequestParams(url);
		if(null!=map){
			for(Map.Entry<String, Object> entry : map.entrySet()){
				params.addParameter(entry.getKey(), entry.getValue());
			}
		}
		Cancelable cancelable = x.http().get(params, callback);
		return cancelable;
	}


	/**
	 * 上传文件
	 * @param <T>
	 */
	public static <T> Cancelable UpLoadFile(String url, Map<String,Object> map, CommonCallback<T> callback){
		RequestParams params=new RequestParams(url);
		if(null!=map){
			for(Map.Entry<String, Object> entry : map.entrySet()){
				params.addParameter(entry.getKey(), entry.getValue());
			}
		}
		params.setMultipart(true);
		Cancelable cancelable = x.http().get(params, callback);
		return cancelable;
	}

	/**
	 * 下载文件
	 * @param <T>
	 */
	public static <T> Cancelable DownLoadFile(String url, String filepath, CommonCallback<T> callback){
		RequestParams params=new RequestParams(url);
		//设置断点续传
		params.setAutoResume(true);
		params.setSaveFilePath(filepath);
		Cancelable cancelable = x.http().get(params, callback);
		return cancelable;
	}


	static DbManager.DaoConfig daoConfig;
	public static DbManager.DaoConfig getDaoConfig(){
		File file=new File(Environment.getExternalStorageDirectory().getPath());
		if(daoConfig==null){
			daoConfig=new DbManager.DaoConfig()
					.setDbName("shiyan.db")     // 不设置dbDir时, 默认存储在app的私有目录.
					//.setDbDir(file)
					.setDbVersion(1)
					.setAllowTransaction(true)
					.setDbOpenListener(new DbManager.DbOpenListener() {
						@Override
						public void onDbOpened(DbManager db) {
							// 开启WAL, 对写入加速提升巨大
							db.getDatabase().enableWriteAheadLogging();
						}
					})
					.setDbUpgradeListener(new DbManager.DbUpgradeListener() {
						@Override
						public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

						}
					});
		}
		return daoConfig;
	}
}

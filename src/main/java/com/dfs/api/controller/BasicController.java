package com.dfs.api.controller;

import com.dfs.api.constant.Code;
import com.dfs.api.model.ReturnMsg;

/**
 * 基础Controller
 * @author Ming
 * @date 2018年11月26日
 */
public class BasicController {
	
	/**
	 * 获取返回消息模型
	 * @param <T> 数据泛型
	 * @param code 消息状态
	 * @param msg 信息
	 * @param data 数据
	 * @return
	 */
	protected <T> ReturnMsg<T> getReturnMsg(Integer code,String msg,T data) {
		return new ReturnMsg<T>(code,msg,data);
	}
	
	/**
	 * 获取返回消息模型
	 * @param code 消息状态
	 * @param msg 信息
	 * @return
	 */
	protected <T> ReturnMsg<T> getReturnMsg(Integer code,String msg) {
		return getReturnMsg(code,msg,null);
	}
	
	/**
	 * 操作成功消息模型
	 * @param data 返回数据
	 * @return
	 */
	protected <T> ReturnMsg<T> getSuccessMsg(T data) {
		return getReturnMsg(Code.SUCCESS,"操作成功",data);
	}
	
	/**
	 *操作成功消息模型
	 * @param message 返回信息
	 * @param data 返回数据
	 * @return
	 */
	protected <T> ReturnMsg<T> getSuccessMsg(String message,T data) {
		return getReturnMsg(Code.SUCCESS,message,data);
	}
	
	/**
	 * 操作失败消息模型
	 * @return
	 */
	protected <T> ReturnMsg<T> getErrorMsg() {
		return getReturnMsg(Code.ERROR,"操作失败");
	}
	
	/**
	 * 操作失败消息模型
	 * @param message 失败信息
	 * @return
	 */
	protected <T> ReturnMsg<T> getErrorMsg(String message) {
		return getReturnMsg(Code.ERROR,message);
	}
	
	/**
	 * 操作失败消息模型
	 * @param data 返回数据
	 * @return
	 */
	protected <T> ReturnMsg<T> getErrorMsg(T data) {
		return getReturnMsg(Code.ERROR,"操作失败",data);
	}
	
	/**
	 *操作失败消息模型
	 * @param message 失败信息
	 * @param data 返回数据
	 * @return
	 */
	protected <T> ReturnMsg<T> getErrorMsg(String message,T data) {
		return getReturnMsg(Code.ERROR,message,data);
	}
	
}

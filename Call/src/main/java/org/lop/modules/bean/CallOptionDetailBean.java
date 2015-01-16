package org.lop.modules.bean;

import org.lop.modules.constant.CallOptionTypeEnum;

/**
 * 呼叫程序选项详情.
 * 
 * @author 潘瑞峥
 * @date 2013-5-10
 */
public class CallOptionDetailBean extends BaseBean {

	private static final long serialVersionUID = 7194368146719059489L;

	/** 类型. */
	private String type;

	/** 类型. */
	private CallOptionTypeEnum typeEnum;

	/** x坐标. */
	private int xCoords;

	/** y坐标. */
	private int yCoords;

	public String getType() {
		return type;
	}

	public void setType( String type ) {
		this.type = type;
	}

	public CallOptionTypeEnum getTypeEnum() {
		typeEnum = CallOptionTypeEnum.returnEnum( type );
		return typeEnum;
	}

	public void setTypeEnum( CallOptionTypeEnum typeEnum ) {
		this.typeEnum = typeEnum;
	}

	public int getxCoords() {
		return xCoords;
	}

	public void setxCoords( int xCoords ) {
		this.xCoords = xCoords;
	}

	public int getyCoords() {
		return yCoords;
	}

	public void setyCoords( int yCoords ) {
		this.yCoords = yCoords;
	}

}
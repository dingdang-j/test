package org.lop.modules.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 呼叫程序选项类型.
 * 
 * @author 潘瑞峥
 * @date 2013-5-10
 */
public enum CallOptionTypeEnum implements PersistentEnum<CallOptionTypeEnum, String> {

	CALL_TAB( "CALL_TAB", "拨号选项卡" ),

	INPUT_BOX( "INPUT_BOX", "号码输入框" ),

	CALL_BUTTON( "CALL_BUTTON", "拨号按钮" ),

	HANGUP_BUTTON( "HANGUP_BUTTON", "挂机按钮" );

	private String value;
	private String displayName;

	private static Map<String, CallOptionTypeEnum> enumMap = new HashMap<String, CallOptionTypeEnum>();

	CallOptionTypeEnum( String vlaue, String displayName ) {
		this.value = vlaue;
		this.displayName = displayName;
	}

	static {
		for ( CallOptionTypeEnum e : CallOptionTypeEnum.values() ) {
			enumMap.put( e.getValue(), e );
		}
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getDisplayName() {
		return displayName;
	}

	@Override
	public CallOptionTypeEnum getEnum( String value ) {
		return returnEnum( value );
	}

	@Override
	public Map<String, CallOptionTypeEnum> getEnumMap() {
		return enumMap;
	}

	public static CallOptionTypeEnum returnEnum( String value ) {
		return enumMap.get( value );
	}

	@Override
	public String toString() {
		return this.getDisplayName();
	}

}
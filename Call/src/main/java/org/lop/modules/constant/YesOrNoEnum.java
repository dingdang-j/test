package org.lop.modules.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 是或否.
 * 
 * @author 潘瑞峥
 * @date 2013-5-10
 */
public enum YesOrNoEnum implements PersistentEnum<YesOrNoEnum, String> {

	YES( "1", "是" ),

	NO( "0", "否" );

	private String value;
	private String displayName;

	private static Map<String, YesOrNoEnum> enumMap = new HashMap<String, YesOrNoEnum>();

	YesOrNoEnum( String vlaue, String displayName ) {
		this.value = vlaue;
		this.displayName = displayName;
	}

	static {
		for ( YesOrNoEnum e : YesOrNoEnum.values() ) {
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
	public YesOrNoEnum getEnum( String value ) {
		return returnEnum( value );
	}

	@Override
	public Map<String, YesOrNoEnum> getEnumMap() {
		return enumMap;
	}

	public static YesOrNoEnum returnEnum( String value ) {
		return enumMap.get( value );
	}

	@Override
	public String toString() {
		return this.getDisplayName();
	}

}
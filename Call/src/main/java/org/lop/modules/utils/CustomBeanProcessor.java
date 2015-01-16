package org.lop.modules.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

/**
 * 扩展功能，支持字段含有'_'的映射.
 * 
 * @author 潘瑞峥
 * @date 2013-5-12
 */
public class CustomBeanProcessor extends BeanProcessor {

	/**
	 * Set a bean's primitive properties to these defaults when SQL NULL is returned. These are the
	 * same as the defaults that ResultSet get* methods return in the event of a NULL column.
	 */
	private static final Map<Class<?>, Object> primitiveDefaults = new HashMap<Class<?>, Object>();

	/**
	 * ResultSet column to bean property name overrides.
	 */
	private final Map<String, String> columnToPropertyOverrides;

	static {
		primitiveDefaults.put( Integer.TYPE, Integer.valueOf( 0 ) );
		primitiveDefaults.put( Short.TYPE, Short.valueOf( ( short ) 0 ) );
		primitiveDefaults.put( Byte.TYPE, Byte.valueOf( ( byte ) 0 ) );
		primitiveDefaults.put( Float.TYPE, Float.valueOf( 0f ) );
		primitiveDefaults.put( Double.TYPE, Double.valueOf( 0d ) );
		primitiveDefaults.put( Long.TYPE, Long.valueOf( 0L ) );
		primitiveDefaults.put( Boolean.TYPE, Boolean.FALSE );
		primitiveDefaults.put( Character.TYPE, Character.valueOf( ( char ) 0 ) );
	}

	/**
	 * Constructor for BeanProcessor.
	 */
	public CustomBeanProcessor() {
		this( new HashMap<String, String>() );
	}

	/**
	 * Constructor for BeanProcessor configured with column to property name overrides.
	 * 
	 * @param columnToPropertyOverrides
	 *            ResultSet column to bean property name overrides
	 * @since 1.5
	 */
	public CustomBeanProcessor( Map<String, String> columnToPropertyOverrides ) {
		super();
		if ( columnToPropertyOverrides == null ) {
			throw new IllegalArgumentException( "columnToPropertyOverrides map cannot be null" );
		}
		this.columnToPropertyOverrides = columnToPropertyOverrides;
	}

	/**
	 * Convert a <code>ResultSet</code> row into a JavaBean. This implementation uses reflection and
	 * <code>BeanInfo</code> classes to match column names to bean property names. Properties are
	 * matched to columns based on several factors: <br/>
	 * <ol>
	 * <li>
	 * The class has a writable property with the same name as a column. The name comparison is case
	 * insensitive.</li>
	 * 
	 * <li>
	 * The column type can be converted to the property's set method parameter type with a
	 * ResultSet.get* method. If the conversion fails (ie. the property was an int and the column
	 * was a Timestamp) an SQLException is thrown.</li>
	 * </ol>
	 * 
	 * <p>
	 * Primitive bean properties are set to their defaults when SQL NULL is returned from the
	 * <code>ResultSet</code>. Numeric fields are set to 0 and booleans are set to false. Object
	 * bean properties are set to <code>null</code> when SQL NULL is returned. This is the same
	 * behavior as the <code>ResultSet</code> get* methods.
	 * </p>
	 * 
	 * @param <T>
	 *            The type of bean to create
	 * @param rs
	 *            ResultSet that supplies the bean data
	 * @param type
	 *            Class from which to create the bean instance
	 * @throws SQLException
	 *             if a database access error occurs
	 * @return the newly created bean
	 */
	public <T> T toBean( ResultSet rs, Class<T> type ) throws SQLException {

		PropertyDescriptor[] props = this.propertyDescriptors( type );

		ResultSetMetaData rsmd = rs.getMetaData();
		int[] columnToProperty = this.mapColumnsToProperties( rsmd, props );

		return this.createBean( rs, type, props, columnToProperty );
	}

	/**
	 * Convert a <code>ResultSet</code> into a <code>List</code> of JavaBeans. This implementation
	 * uses reflection and <code>BeanInfo</code> classes to match column names to bean property
	 * names. Properties are matched to columns based on several factors: <br/>
	 * <ol>
	 * <li>
	 * The class has a writable property with the same name as a column. The name comparison is case
	 * insensitive.</li>
	 * 
	 * <li>
	 * The column type can be converted to the property's set method parameter type with a
	 * ResultSet.get* method. If the conversion fails (ie. the property was an int and the column
	 * was a Timestamp) an SQLException is thrown.</li>
	 * </ol>
	 * 
	 * <p>
	 * Primitive bean properties are set to their defaults when SQL NULL is returned from the
	 * <code>ResultSet</code>. Numeric fields are set to 0 and booleans are set to false. Object
	 * bean properties are set to <code>null</code> when SQL NULL is returned. This is the same
	 * behavior as the <code>ResultSet</code> get* methods.
	 * </p>
	 * 
	 * @param <T>
	 *            The type of bean to create
	 * @param rs
	 *            ResultSet that supplies the bean data
	 * @param type
	 *            Class from which to create the bean instance
	 * @throws SQLException
	 *             if a database access error occurs
	 * @return the newly created List of beans
	 */
	public <T> List<T> toBeanList( ResultSet rs, Class<T> type ) throws SQLException {
		List<T> results = new ArrayList<T>();

		if ( !rs.next() ) {
			return results;
		}

		PropertyDescriptor[] props = this.propertyDescriptors( type );
		ResultSetMetaData rsmd = rs.getMetaData();
		int[] columnToProperty = this.mapColumnsToProperties( rsmd, props );

		do {
			results.add( this.createBean( rs, type, props, columnToProperty ) );
		} while ( rs.next() );

		return results;
	}

	/**
	 * The positions in the returned array represent column numbers. The values stored at each
	 * position represent the index in the <code>PropertyDescriptor[]</code> for the bean property
	 * that matches the column name. If no bean property was found for a column, the position is set
	 * to <code>PROPERTY_NOT_FOUND</code>.
	 * 
	 * @param rsmd
	 *            The <code>ResultSetMetaData</code> containing column information.
	 * 
	 * @param props
	 *            The bean property descriptors.
	 * 
	 * @throws SQLException
	 *             if a database access error occurs
	 * 
	 * @return An int[] with column index to property index mappings. The 0th element is meaningless
	 *         because JDBC column indexing starts at 1.
	 */
	@Override
	public int[] mapColumnsToProperties( ResultSetMetaData rsmd, PropertyDescriptor[] props ) throws SQLException {

		int cols = rsmd.getColumnCount();
		int[] columnToProperty = new int[cols + 1];
		Arrays.fill( columnToProperty, PROPERTY_NOT_FOUND );

		for ( int col = 1; col <= cols; col++ ) {
			String columnName = rsmd.getColumnLabel( col );
			if ( null == columnName || 0 == columnName.length() ) {
				columnName = rsmd.getColumnName( col );
			}
			String propertyName = columnToPropertyOverrides.get( columnName );
			if ( propertyName == null ) {
				propertyName = columnName;
			}
			for ( int i = 0; i < props.length; i++ ) {

				if ( propertyName.replaceAll( "_", "" ).equalsIgnoreCase( props[ i ].getName() ) ) {
					columnToProperty[ col ] = i;
					break;
				}
			}
		}

		return columnToProperty;
	}

	/**
	 * Returns a PropertyDescriptor[] for the given Class.
	 * 
	 * @param c
	 *            The Class to retrieve PropertyDescriptors for.
	 * @return A PropertyDescriptor[] describing the Class.
	 * @throws SQLException
	 *             if introspection failed.
	 */
	private PropertyDescriptor[] propertyDescriptors( Class<?> c ) throws SQLException {
		// Introspector caches BeanInfo classes for better performance
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo( c );

		} catch ( IntrospectionException e ) {
			throw new SQLException( "Bean introspection failed: " + e.getMessage() );
		}

		return beanInfo.getPropertyDescriptors();
	}

	/**
	 * Creates a new object and initializes its fields from the ResultSet.
	 * 
	 * @param <T>
	 *            The type of bean to create
	 * @param rs
	 *            The result set.
	 * @param type
	 *            The bean type (the return type of the object).
	 * @param props
	 *            The property descriptors.
	 * @param columnToProperty
	 *            The column indices in the result set.
	 * @return An initialized object.
	 * @throws SQLException
	 *             if a database error occurs.
	 */
	private <T> T createBean( ResultSet rs, Class<T> type, PropertyDescriptor[] props, int[] columnToProperty ) throws SQLException {

		T bean = this.newInstance( type );

		for ( int i = 1; i < columnToProperty.length; i++ ) {

			if ( columnToProperty[ i ] == PROPERTY_NOT_FOUND ) {
				continue;
			}

			PropertyDescriptor prop = props[ columnToProperty[ i ] ];
			Class<?> propType = prop.getPropertyType();

			Object value = this.processColumn( rs, i, propType );

			if ( propType != null && value == null && propType.isPrimitive() ) {
				value = primitiveDefaults.get( propType );
			}

			this.callSetter( bean, prop, value );
		}

		return bean;
	}

	/**
	 * Calls the setter method on the target object for the given property. If no setter method
	 * exists for the property, this method does nothing.
	 * 
	 * @param target
	 *            The object to set the property on.
	 * @param prop
	 *            The property to set.
	 * @param value
	 *            The value to pass into the setter.
	 * @throws SQLException
	 *             if an error occurs setting the property.
	 */
	private void callSetter( Object target, PropertyDescriptor prop, Object value ) throws SQLException {

		Method setter = prop.getWriteMethod();

		if ( setter == null ) {
			/* 支持对某些受保护字段的写入. */
			String fieldName = prop.getName();
			if ( StringUtils.containsIgnoreCase( fieldName, "id" ) || StringUtils.containsIgnoreCase( fieldName, "identity" ) ) {
				try {
					FieldUtils.writeField( target, fieldName, value, true );
				} catch ( IllegalAccessException e ) {
				}
			}
			return;
		}

		Class<?>[] params = setter.getParameterTypes();
		try {
			// convert types for some popular ones
			if ( value instanceof java.util.Date ) {
				final String targetType = params[ 0 ].getName();
				if ( "java.sql.Date".equals( targetType ) ) {
					value = new java.sql.Date( ( ( java.util.Date ) value ).getTime() );
				} else if ( "java.sql.Time".equals( targetType ) ) {
					value = new java.sql.Time( ( ( java.util.Date ) value ).getTime() );
				} else if ( "java.sql.Timestamp".equals( targetType ) ) {
					value = new java.sql.Timestamp( ( ( java.util.Date ) value ).getTime() );
				}
			}

			// Don't call setter if the value object isn't the right type
			if ( this.isCompatibleType( value, params[ 0 ] ) ) {
				setter.invoke( target, new Object[] { value } );
			} else {
				throw new SQLException( "Cannot set " + prop.getName() + ": incompatible types, cannot convert "
						+ value.getClass().getName() + " to " + params[ 0 ].getName() );
				// value cannot be null here because isCompatibleType allows null
			}

		} catch ( IllegalArgumentException e ) {
			throw new SQLException( "Cannot set " + prop.getName() + ": " + e.getMessage() );

		} catch ( IllegalAccessException e ) {
			throw new SQLException( "Cannot set " + prop.getName() + ": " + e.getMessage() );

		} catch ( InvocationTargetException e ) {
			throw new SQLException( "Cannot set " + prop.getName() + ": " + e.getMessage() );
		}
	}

	/**
	 * ResultSet.getObject() returns an Integer object for an INT column. The setter method for the
	 * property might take an Integer or a primitive int. This method returns true if the value can
	 * be successfully passed into the setter method. Remember, Method.invoke() handles the
	 * unwrapping of Integer into an int.
	 * 
	 * @param value
	 *            The value to be passed into the setter method.
	 * @param type
	 *            The setter's parameter type (non-null)
	 * @return boolean True if the value is compatible (null => true)
	 */
	private boolean isCompatibleType( Object value, Class<?> type ) {
		// Do object check first, then primitives
		if ( value == null || type.isInstance( value ) ) {
			return true;

		} else if ( type.equals( Integer.TYPE ) && Integer.class.isInstance( value ) ) {
			return true;

		} else if ( type.equals( Long.TYPE ) && Long.class.isInstance( value ) ) {
			return true;

		} else if ( type.equals( Double.TYPE ) && Double.class.isInstance( value ) ) {
			return true;

		} else if ( type.equals( Float.TYPE ) && Float.class.isInstance( value ) ) {
			return true;

		} else if ( type.equals( Short.TYPE ) && Short.class.isInstance( value ) ) {
			return true;

		} else if ( type.equals( Byte.TYPE ) && Byte.class.isInstance( value ) ) {
			return true;

		} else if ( type.equals( Character.TYPE ) && Character.class.isInstance( value ) ) {
			return true;

		} else if ( type.equals( Boolean.TYPE ) && Boolean.class.isInstance( value ) ) {
			return true;

		}
		return false;

	}

}
package com.ding.beanuntil;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

public class BeanUtils {

	public static void populate(Object beanObj, Map<String, String[]> parmMap) {
		Class classObj=beanObj.getClass();
		//根据属性获得set方法
		Set set=parmMap.keySet();
	    Field field=null;
	    //  Type type=field.getType();
	      
		PropertyDescriptor pd=null;
		if(set.size()>0){
			String name=null;
			for(Object str:set)
				name=(String)str;
			try {
				 field=classObj.getDeclaredField(name);
				 System.out.println("The name of field "+field.getName());
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pd = new PropertyDescriptor(field.getName(),  
						classObj);
			
			} catch (IntrospectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		

			
			Method method=pd.getWriteMethod();
			
			try {
				System.out.println("The name of method "+method.getName());
				System.out.println("Invoke start");
				method.invoke(beanObj, parmMap.get(name));
				System.out.println("Invoke complete");
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		
		
	}

	public static void setProperty(Object beanObj, String name, Object existBean) {
		PropertyDescriptor pd=null;
		Class classObj=beanObj.getClass();
//		   Field field=null;
//		 try {
//			field=classObj.getDeclaredField(name);
//		} catch (NoSuchFieldException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			try {
				pd = new PropertyDescriptor(name,  
						classObj);
			} catch (IntrospectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Method method=pd.getWriteMethod();
			System.out.println("The name of method "+method.getName());
			System.out.println("Invoke start");
			try {
				method.invoke(beanObj, existBean);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Invoke complete");
		
	}

}
package com.ding.rasp.transformer;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.logging.Logger;

/**
 * @author kurt.ding
 * @date 2021/12/30 下午3:45
 */
public class TestTransformer implements ClassFileTransformer {
	Logger logger=Logger.getLogger(TestTransformer.class.toGenericString());
	//目标类名称，  .分隔
	private String targetClassName;
	//目标类名称，  /分隔
	private String targetVMClassName;
	private String targetMethodName;


	public TestTransformer(String className,String methodName){
		this.targetVMClassName = new String(className).replaceAll("\\.","\\/");
		this.targetMethodName = methodName;
		this.targetClassName=className;
	}
	//类加载时会执行该函数，其中参数 classfileBuffer为类原始字节码，返回值为目标字节码，className为/分隔
	public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
		//判断类名是否为
		if(className.contains("fastonetech")){
			System.out.println(String.format("Transform execute  classname: %s, target class: %s,target vm class name： %s",className,this.targetClassName,this.targetVMClassName));
		}
		if(!className.equals(targetVMClassName)){
			return classfileBuffer;
		}
		logger.info("Class equals");
		try {
			ClassPool classPool = ClassPool.getDefault();
			CtClass cls = classPool.get(this.targetClassName);
			CtMethod ctMethod = cls.getDeclaredMethod(this.targetMethodName);
			ctMethod.insertBefore("{ System.out.println(\"start cccc\"); }");
			ctMethod.insertAfter("{ System.out.println(\"end  cccc\"); }");
			return cls.toBytecode();
		} catch (Exception e) {
			System.out.println(e);
		}
		return classfileBuffer;
	}
}
import javax.swing.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author FastoneTeam
 * @date 2022/4/16 下午12:40
 */
public class MetaAnnotation {
	public static void main(String[] args) {
//		@Inherited
//		@Target({ElementType.TYPE, ElementType.METHOD})
//		@Retention(value = RetentionPolicy.RUNTIME)
	testInherited();
	}
	@Inherited
	@Target({ElementType.TYPE,ElementType.METHOD})
	@Retention(RetentionPolicy.RUNTIME)
	public  @interface Tx{

	}


	@Tx
	public static class Father{

	}
	public static class Child extends Father{

	}

	@Tx
	public static interface IFather{

	}
	public static class FatherImpl implements IFather{

	}
	/**
	 * 测试注解的继承，实现接口是否会拥有注解
	 */
	public static void testInherited(){
		System.out.println("Father annotation : "+Arrays.toString(Father.class.getAnnotations()));
		System.out.println("Child annotation : "+Arrays.toString(Child.class.getAnnotations()));
		System.out.println("Implementation annotation : "+Arrays.toString(FatherImpl.class.getAnnotations()));
	}
}

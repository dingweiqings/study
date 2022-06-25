package com.ding.rasp;

import com.ding.rasp.transformer.TestTransformer;

import java.lang.instrument.Instrumentation;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kurt.ding
 * @date 2021/12/30 下午3:44
 */
public class KurtAgentRewriteTest {

		private static String className = "com.fastonetech.notification.configuration.TestAutowireConstructor";
		private static String methodName = "getLists";

		public static void agentmain(String args, Instrumentation instrumentation) {

			try {
				List<Class> needRetransFormClasses = new LinkedList<>();
				Class[] loadedClass = instrumentation.getAllLoadedClasses();
				for (int i = 0; i < loadedClass.length; i++) {
					if (loadedClass[i].getName().equals(className)) {
						needRetransFormClasses.add(loadedClass[i]);
					}
				}

				instrumentation.addTransformer(new TestTransformer(className, methodName));
				instrumentation.retransformClasses(needRetransFormClasses.toArray(new Class[0]));
			} catch (Exception e) {

			}
		}

		public static void premain(String args, Instrumentation instrumentation) {
			instrumentation.addTransformer(new TestTransformer(className, methodName));
		}
}

package com.ding.rasp;

import java.lang.instrument.Instrumentation;

/**
 * 两个方法，一个premain 一个是agentmain，优先执行premain，agentmain会被覆盖
 * @author kurt.ding
 * @date 2021/12/29 下午6:06
 */
public class KurtAgentTest  {

	public static void premain(String param, Instrumentation inst) {
		main(param, inst);
	}

	public static void agentmain(String param, Instrumentation inst) {
		main(param, inst);
	}

	private synchronized static void main(String args, final Instrumentation inst) {
		// 打印 attach时传入的参数
		System.out.println("args: " + "eeee");
		// System.out.println("(v2)args: " + args); // V2版本agent
	}
}

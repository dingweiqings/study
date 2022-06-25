package com.ding.rasp;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * @author kurt.ding
 * @date 2021/12/29 下午5:34
 *
 */
public class KurtAgentAttacher {
	public static void main(String[] args) throws AttachNotSupportedException, IOException, AgentLoadException, AgentInitializationException, InterruptedException {
		// 传入目标 JVM pid
		VirtualMachine vm = VirtualMachine.attach(args[0]);
		vm.loadAgent("/my_project/study/java_study/rasp/build/libs/rasp-1.0-SNAPSHOT.jar");
		System.out.println("Attacher success");
		vm.detach();;
	}
}

package com.mutilprocess;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/** 
 * @author mike_yi
 * @Description 多进程描述符
 */
public class MutiyProcess implements Runnable{
	private final String[] command;

	public MutiyProcess(String... command) {
		super();
		this.command = command;
	}

	public String[] getCommand() {
		return command;
	}

	public void run() {
		Process process = null;
		try {
			process = new ProcessBuilder(getCommand()).start();
			InputStream stdout = process.getInputStream();
			InputStream stderr = process.getErrorStream();
			dumpProcessOutput(process, stdout);
			dumpProcessOutput(process, stderr);
			int exitcode = process.waitFor();
			System.out.println("exitcode :"+exitcode);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof RuntimeException) {
				throw (RuntimeException) e;
			}
			throw new RuntimeException(e);
		} finally {
			if (process != null) {
				process.destroy();
			}
		}
	}

	void dumpProcessOutput(Process process, InputStream in) throws Exception {
		System.out.println("+++++");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in,"gbk"));
		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println("process :"+process+"output :"+line);
		}
		in.close();
	}
	public static void main(String[] args) {
      	Thread thread = new Thread(new MutiyProcess("E:\\soft\\super.bat","7899"));
      	thread.start();
	}
}

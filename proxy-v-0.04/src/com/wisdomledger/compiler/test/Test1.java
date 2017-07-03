package com.wisdomledger.compiler.test;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.wisdomledger.proxy.Moveable;
import com.wisdomledger.proxy.Tank;

public class Test1 {

	public static void main(String[] args) throws Exception {
		String rt = "\r\n";
		String src = 
		"package com.wisdomledger.proxy;" + rt +

		"public class TankTimeProxy implements Moveable {" + rt +

		"	Moveable t;" + rt +

		"	public TankTimeProxy(Moveable t) {" + rt +
		"		super();" + rt +
		"		this.t = t;" + rt +
		"	}" + rt +

		"	@Override" + rt +
		"	public void move() {" + rt +
		"		long start = System.currentTimeMillis();" + rt +
		"		System.out.println(\"Tank start at time: \" + start);" + rt +
		"		t.move();" + rt +
		"		long end = System.currentTimeMillis();" + rt +
		"		System.out.println(\"Tank total moving time: \" + (end - start));" + rt +
		"	}" + rt +
		
		"}";
		
		// Process generate source code
		String fileName = System.getProperty("user.dir")+"/src/com/wisdomledger/proxy/TankTimeProxy.java";
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(src);
		fw.flush();
		fw.close();
		
		// Process compile source code
		// 1.Get Java compiler
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		// 2.Get a file manager which manage .java file 
		StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
		// 3.Get the context that need to be compiled
		Iterable units = fileMgr.getJavaFileObjects(fileName);
		// 4.Generate a compilation task according to file manager and the context which need to be compiled
		CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
		// 5.Start to compile
		t.call();
		// 6.Close the file manager
		fileMgr.close();
		
		// Process load into memory and create an instance
		// 1.Load into memory
		URL[] urls = new URL[]{new URL("file:/"+System.getProperty("user.dir")+"/src")};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.wisdomledger.proxy.TankTimeProxy");
		System.out.println(c);
		// 2.Get constructor whose parameter's type is Moveable
		Constructor ctr = c.getConstructor(Moveable.class);
		// 2.Create an instance
		Moveable m = (Moveable)ctr.newInstance(new Tank());
		m.move();
	}

}

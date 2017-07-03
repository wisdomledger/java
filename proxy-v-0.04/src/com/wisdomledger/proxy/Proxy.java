package com.wisdomledger.proxy;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class Proxy {
	public static Object newProxyInstance(Class infce,InvocationHandler h) throws Exception{
		String methodStr = "";
		String rt = "\r\n";
		
		Method[] methods = infce.getMethods();
		/*
		for(Method m: methods){
			methodStr += "	@Override" + rt +
				 "	public void " + m.getName() + "() {" + rt +
				 "		long start = System.currentTimeMillis();" + rt +
				 "		System.out.println(\"Tank start at time: \" + start);" + rt +
				 "		t." + m.getName() + "();" + rt +
				 "		long end = System.currentTimeMillis();" + rt +
				 "		System.out.println(\"Tank total moving time: \" + (end - start));" + rt +
				 "	}";
		}
		*/
		for(Method m: methods){
			methodStr += "	@Override" + rt +
				 "	public void " + m.getName() + "() {" + rt +
				 "	try {"  + rt +
				 "		Method md = " + infce.getName() + ".class.getMethod(\"" + m.getName() + "\");"+ rt +
				 "		h.invoke(this, md);" + rt +
				 "	}catch(Exception e) {e.printStackTrace();}" + rt +
				 "	}";
		}
		
		
		String src = 
		"package com.wisdomledger.proxy;" + rt +
		"import java.lang.reflect.Method;" + rt + rt +

		"public class TankTimeProxy implements " +infce.getName() +"{" + rt +

		"	com.wisdomledger.proxy.InvocationHandler h;" + rt +

		"	public TankTimeProxy(InvocationHandler h) {" + rt +
		"		super();" + rt +
		"		this.h = h;" + rt +
		"	}" + rt +

		methodStr + rt +
		
		"}";
		
		
		// Process generate source code
		String fileName = "d:/src/com/wisdomledger/proxy/TankTimeProxy.java";
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
		URL[] urls = new URL[]{new URL("file:/" + "d:/src/")};
		URLClassLoader ul = new URLClassLoader(urls);
		Class c = ul.loadClass("com.wisdomledger.proxy.TankTimeProxy");
		// 2.Get constructor whose parameter's type is Moveable
		Constructor ctr = c.getConstructor(InvocationHandler.class);
		// 3.Create an instance
		Object m = ctr.newInstance(h);
		return m;
	}
}

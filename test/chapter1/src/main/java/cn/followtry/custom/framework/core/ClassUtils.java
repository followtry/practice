package cn.followtry.custom.framework.core;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by followtry on 2017/4/12.
 */
public class ClassUtils {

	private static final Logger LOGGER=LoggerFactory.getLogger(ClassUtils.class);

	private ClassUtils() {
	}

	public static ClassLoader getClassLoader() {
		return Thread.currentThread().getContextClassLoader();
	}

	public static Class<?> loadClass(String className) throws ClassNotFoundException {

		return loadClass(className, false);
	}

	public static Class<?> loadClass(String className, Boolean isInited) throws ClassNotFoundException {

		Class<?> clazz=Class.forName(className, isInited, getClassLoader());
		return clazz;
	}

	public static Set<Class<?>> getAllClasses(String packageName) throws IOException {
		Set<Class<?>> classes=new HashSet<>();
		Enumeration<URL> urls=getClassLoader().getResources(packageName.replace(".", "/"));
		while (urls.hasMoreElements()) {
			URL url=urls.nextElement();
			if (url != null) {
				String protocol=url.getProtocol();
				if (protocol.equalsIgnoreCase("file")) {
					String packagePath=url.getPath().replace("%20", " ");
					addClass(classes, packagePath, packageName);
				} else if (protocol.equalsIgnoreCase("jar")) {

				}
			}
		}
		return null;
	}

	private static void addClass(Set<Class<?>> classSet, String packagePath, String packageName) {
		File[] files=new File(packagePath).listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
			}
		});

		Arrays.stream(files).forEach(file -> {
			String fileName=file.getName();
			if (file.isFile()) {
				String className=fileName.substring(0, fileName.lastIndexOf("."));
				if (StringUtils.isNotEmpty(packageName)) {
					className=packageName + "." + className;
				}
				try {
					doAddClass(classSet,className);
				} catch(ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
			} else {//子目录

				String subPackageName=fileName;
				String subPackagePath = fileName;
				if (StringUtils.isNotEmpty(packageName)) {
					subPackageName=packageName + "." + subPackageName;
				}
				if (StringUtils.isNotEmpty(packageName)) {
					subPackagePath=packageName + "." + subPackagePath;
				}

				addClass(classSet,subPackagePath,subPackageName);
			}

		});

	}

	private static void doAddClass(Set<Class<?>> classSet, String className) throws ClassNotFoundException {
		Class<?> aClass=loadClass(className, false);
		classSet.add(aClass);
	}
}

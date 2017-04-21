package cn.followtry.custom.framework.core;

import cn.followtry.custom.framework.annotation.Aspect;
import cn.followtry.custom.framework.aop.AspectProxy;
import cn.followtry.custom.framework.aop.Proxy;
import cn.followtry.custom.framework.aop.ProxyManager;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * Created by followtry on 2017/4/14.
 */
public class AopHelper {

	private static final Logger LOGGER= LoggerFactory.getLogger(AopHelper.class);

	static {
		Map<Class<?>, Set<Class<?>>> proxyMap=createProxyMap();
		Map<Class<?>, List<Proxy>> targetMap;
		try {
			targetMap=createTargetMap(proxyMap);
		} catch(Exception e) {
			LOGGER.error("aop failure",e);
			throw new RuntimeException(e);
		}
		if (MapUtils.isNotEmpty(targetMap)) {
			targetMap.entrySet().forEach(entry -> BeanHelper.setBean(entry.getKey(),ProxyManager.createProxy(entry.getKey(),entry.getValue())));
		}
	}

	public static Set<Class<?>> createTargetClassSet(Aspect aspect) {
		Class<? extends Annotation> annotation=aspect.value();
		if (!annotation.equals(Aspect.class)) {
			Set<Class<?>> classSet=ClassHelper.getClassSetByAnno(annotation);
			return classSet == null ? Collections.emptySet() : classSet;
		}
		return Collections.emptySet();
	}

	private static Map<Class<?>, Set<Class<?>>> createProxyMap() {
		return new HashMap<Class<?>, Set<Class<?>>>() {
			{
				ClassHelper.getClassSetBySuper(AspectProxy.class).stream()
						.filter(aClass -> aClass.isAnnotationPresent(Aspect.class)).forEach(aClass -> {
					Aspect aspect=aClass.getAnnotation(Aspect.class);
					put(aClass, createTargetClassSet(aspect));
				});
			}
		};
	}

	private static Map<Class<?>, List<Proxy>> createTargetMap(Map<Class<?>, Set<Class<?>>> proxyMap) throws Exception {
		if (MapUtils.isNotEmpty(proxyMap)) {
			HashMap<Class<?>, List<Proxy>> targetMap=new HashMap<>();
			proxyMap.entrySet().stream().forEach(entry -> {
				Class<?> proxyClass=entry.getKey();
				entry.getValue().stream().forEach(aClass -> {
					try {
						Proxy instance=(Proxy) proxyClass.newInstance();
						if (targetMap.containsKey(proxyClass)) {
							targetMap.get(proxyClass).add(instance);
						} else {
							targetMap.put(proxyClass, new ArrayList<Proxy>() {{
								add(instance);
							}});
						}
					} catch(InstantiationException e) {
						LOGGER.error("aop Instantiation failure",e);
						throw new RuntimeException(e);
					} catch(IllegalAccessException e) {
						LOGGER.error("aop IllegalAccess",e);
						throw new RuntimeException(e);
					}
				});
			});
			return targetMap;
		}
		return Collections.emptyMap();
	}

}

package com.yonyou.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author Administrator
 *
 */
public class TestJson {
	private ObjectId _id;
	
	private String id;
	
	private String __id;

	@JSONField(serialize=false,deserialize=false)
	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String get__id() {
		return __id;
	}

	public void set__id(String __id) {
		this.__id = __id;
	}

	@Override
	public String toString() {
		return "TestJson [id=" + id + ", __id=" + __id + ", _id=" + _id + "]";
	}

	public static void main(String[] args) throws Exception {
		/*TestJson testJson = new TestJson();
		
		testJson.setId("1234567890987654");
		testJson.set__id("abcdefghijklmnopqrst");
		String json = JSON.toJSONString(testJson);
		System.out.println("json:"+json);*/
		/*TestJson tj = (TestJson) JSON.parseObject(json, TestJson.class);
		System.out.println(tj.toString());*/
		
		String json="{id2:123231, id4:123233, id3:123232, id:123230}";
		Map map = JSON.parseObject(json, Map.class);
		System.out.println(map.toString());
		List<ObjectId> oList=new ArrayList<ObjectId>();
		for (int i = 0; i < 10; i++) {
			ObjectId objectId = new ObjectId();
			oList.add(objectId);
		}
		System.out.println(oList.toString()+"end");
	}
}

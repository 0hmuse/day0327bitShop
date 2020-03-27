package com.example.demo.db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.GoodsVo;

public class GoodsManager {

	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader reader = 
					Resources.getResourceAsReader("com/example/demo/db/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static List<GoodsVo> listGoods(){
		SqlSession session = factory.openSession();
		List<GoodsVo> list = session.selectList("goods.listGoods");
		session.close();
		return list;
	}
	
	public static GoodsVo detailGoods(GoodsVo v) {
		SqlSession session = factory.openSession();
		GoodsVo gv = session.selectOne("goods.detailGoods", v);
		session.close();
		return gv;
	}
	
	public static int nextNo() {
		SqlSession session = factory.openSession();
		int no = session.selectOne("goods.nextNo");
		session.close();
		return no;
	}
	
	public static int insertGoods(GoodsVo v) {
		SqlSession session = factory.openSession();
		int re = session.insert("goods.insertGoods", v);
		session.commit();
		session.close();
		return re;
	}
	
	public static int updateGoods(GoodsVo v) {
		SqlSession session = factory.openSession();
		int re = session.update("goods.updateGoods",v);
		session.commit();
		session.close();
		return re;
	}
	
	public static int deleteGoods(GoodsVo v) {
		SqlSession session = factory.openSession();
		int re = session.delete("goods.deleteGoods",v);
		session.commit();
		session.close();
		return re;
	}
	
}

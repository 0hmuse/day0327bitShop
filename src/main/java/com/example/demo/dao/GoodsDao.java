package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.GoodsManager;
import com.example.demo.vo.GoodsVo;

@Repository
public class GoodsDao {
	
	public List<GoodsVo> listGoods(){
		return GoodsManager.listGoods();
	}
	
	public GoodsVo detailGoods(GoodsVo v) {
		return GoodsManager.detailGoods(v);
	}
	
	public int nextNo() {
		return GoodsManager.nextNo();
	}
	
	public int insertGoods(GoodsVo v) {
		return GoodsManager.insertGoods(v);
	}
	
	public int updateGoods(GoodsVo v) {
		return GoodsManager.updateGoods(v);
	} 
	
	public int deleteGoods(GoodsVo v) {
		return GoodsManager.deleteGoods(v);
	}

}

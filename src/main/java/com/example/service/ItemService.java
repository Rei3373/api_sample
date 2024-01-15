package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Item;
import com.example.repository.ItemRepository;
import com.example.resource.RequestItem;

@Service
public class ItemService {
	
	private final ItemRepository itemRepository;
	
	@Autowired
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	//データの全件取得
	public List<Item> findAll(){
		return this.itemRepository.findAll();
	}
	
	//商品データ登録
	public Item insert(RequestItem requestItem) {
		Item item = new Item();
		// RequestItemオブジェクトに保存された値を使ってデータをセットします
		item.setName(requestItem.getName());
		item.setPrice(requestItem.getPrice());
		return this.itemRepository.save(item);
	}
}

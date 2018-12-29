package cn.itcast.microservice.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cn.itcast.microservice.order.pojo.Item;

@Service
public class ItemService {

	//Spring框架对RESTful方式的http请求做了封装,来简化操作,
	//默认底层使用jdk实现可以修改为使用httpClient或okhttp实现
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * 调用商品的微服务提供的接口进行查询数据
	 * @param id
	 * @return
	 */
	public Item queryItemById(Long id) {
		String url = "http://127.0.0.1:8080/item/" + id;
		return this.restTemplate.getForObject(url, Item.class);
	}

}

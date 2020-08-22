package cn.e3mall.search.service.impl;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.SearchResult;
import cn.e3mall.search.dao.SearchDao;
import cn.e3mall.search.service.SearchService;
/**
 * 商品搜索Service
 * @author 51145
 *
 */
@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private SearchDao searchDao;
	@Override
	public SearchResult search(String keyword, int page, int rows) throws Exception {
		//创建一个SolrQuery对象
				SolrQuery query = new SolrQuery();
				//设置查询条件
				query.setQuery(keyword);
				//设置分页条件
				query.setStart((page - 1) * rows);
				//设置rows
				query.setRows(rows);
				//设置默认搜索域
				query.set("df", "item_title");
				//设置高亮显示
				query.setHighlight(true);
				query.addHighlightField("item_title");
				query.setHighlightSimplePre("<em style=\"color:red\">");
				query.setHighlightSimplePost("</em>");
				//执行查询
				SearchResult searchResult = searchDao.search(query);
				//计算总页数
				int recourdCount = (int) searchResult.getRecourdCount();
				int pages = recourdCount / rows;
				if (recourdCount % rows > 0) pages++;
				//设置到返回结果
				searchResult.setTotalPages(pages);
				return searchResult;

	}

}

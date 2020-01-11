package com.laptrinhjavaweb.paging;

public class PageRequest implements Pageable{

	private Integer page;
	private Integer limit;
	private Integer offset;
	
	public PageRequest(Integer page,Integer limit) {
		this.page = page;
		this.limit = limit;
		if(page != null && limit != null) {
			this.offset = (this.page - 1) * this.limit;
		}
	}
	
	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public Integer getOffset() {
		return this.offset;
	}

	@Override
	public Integer getLimit() {
		return this.limit;
	}

}

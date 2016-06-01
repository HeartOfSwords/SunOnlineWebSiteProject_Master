package com.sunonline.web.bean.pager;
/**
 * 影视老司机分页bean
 * @author SnoWalker.wwl
 * <p>date：2016.5.31</p>
 */
public class OldDriverPagerBean {

	public static int PAGE_SIZE = 10;		//每页视频数量
	
	private int curPage;					//当前页
	
	private int maxPage;					//总页数

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

}

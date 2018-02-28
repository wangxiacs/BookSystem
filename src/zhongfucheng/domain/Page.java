package zhongfucheng.domain;

/**
 * Created by ozc on 2017/4/12.
 */

import java.util.List;

/**
 * Created by ozc on 2017/3/1.
 */
public class Page {

    //保存着分页的数据
    private List<Book> list;

    //总记录数
    private long totalRecord;

    //每页显示记录数，这里我规定每页显示3条
    private int linesize = 3;

    //总页数
    private int totalPageCount;

    //当前显示的页数
    private int currentPageCount;

    //开始取的记录位置
    private int startIndex;

    //记录JSP页面开始的页数和结束的页数
    private int startPage;
    private int endPage;

    private String url;


    public Page() {
    }

    public Page(int currentPageCount, long totalRecord) {


        //将传递进来的currentPageCount初始化
        this.currentPageCount = currentPageCount;

        //总页数
        totalPageCount = (int) (totalRecord % linesize == 0 ? totalRecord / linesize : totalRecord / linesize + 1);

        this.totalRecord = totalRecord;

        //开始取数据的位置
        startIndex = (currentPageCount - 1) * linesize;


        //如果当前页小于10，那么开始页为1，结束页为10就行了
        if (this.currentPageCount <= 10) {
            this.startPage = 1;
            this.endPage = totalPageCount;
        } else {
            this.startPage = this.currentPageCount - 4;
            this.endPage = this.totalPageCount + 5;

            //加减后页数越界的情况
            if (startPage < 1) {
                this.startPage = 1;
                this.endPage = totalPageCount;
            }
            if (endPage > totalPageCount) {
                this.startPage = this.currentPageCount - 9;
                this.endPage = this.totalPageCount;
            }
        }


    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setCurrentPageCount(int currentPageCount) {
        this.currentPageCount = currentPageCount;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getLinesize() {
        return linesize;
    }

    public void setLinesize(int linesize) {
        this.linesize = linesize;
    }


    public long getCurrentPageCount() {
        return currentPageCount;
    }

    public void setCurrentPageCount(long currentPageCount) {
        this.currentPageCount = (int) currentPageCount;
    }
}
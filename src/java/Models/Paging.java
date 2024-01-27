/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

public class Paging {
    
    public Paging(){     
    }
    
    private int nrpp; // số thành phần muốn xuất hiện trên 1 trang
    private int start; //Trang hiện tại
    private int size;  // Tổng số lượng sản phẩm

    public Paging(int nrpp, int start, int size) {
        this.nrpp = nrpp;
        this.start = start;
        this.size = size;
    }
    
    private int totalPage; // Tổng số trang
    private int begin; //Sản phẩm bắt đầu của 1 trang
    private int end;  //Sản phẩm kết thúc của 1 trang

    public int getNrpp() {
        return nrpp;
    }

    public void setNrpp(int nrpp) {
        this.nrpp = nrpp;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
    
    private int pageStart;  //Trang bắt đầu
    private int pageEnd;

    public int getPageStart() {
        return pageStart;
    }

    public void setPageStart(int pageStart) {
        this.pageStart = pageStart;
    }

    public int getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(int pageEnd) {
        this.pageEnd = pageEnd;
    }
   
    
    public void calc(){
//        nrpp: số mục trên mỗi trang
//        size: tổng lượng dữ liệu
//        totalPage = size/nrpp+(size%nrpp==0?0:1);
        totalPage = (size+nrpp-1)/nrpp; //biến lưu giữ tổng số trang
        // start đại diện cho trang bạn muốn hiện thị
        start = start < 0?0:start; // điều kiện để start ko nhỏ hơn 0
        start = start >= totalPage?(totalPage - 1):start; // đk để start ko lớn hơn hoặc bằng totalPage -1 
        //Tai moi page thi begin = tranghientai * so luong 1 trang
        begin = start*nrpp; //[begin,end)  
        end = begin+nrpp;
        end = end>size?size: end;
        pageStart = start -2;
        pageStart = pageStart<0?0:pageStart;
        pageEnd = start+2;
        pageEnd = pageEnd>totalPage-1?totalPage-1:pageEnd;
    }
}

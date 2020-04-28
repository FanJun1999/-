package com.hdax.entity;

public class SmbmsBill extends BaseEntity {
	private Integer id;
	private String billcode;
	private String productname;
	private String productdesc;
	private String productunit;
	private Integer productcount;
	private Double totalprice;
	private Integer ispayment;
	private Integer providerid;

	public SmbmsBill() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBillcode() {
		return billcode;
	}

	public void setBillcode(String billcode) {
		this.billcode = billcode;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductdesc() {
		return productdesc;
	}

	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}

	public String getProductunit() {
		return productunit;
	}

	public void setProductunit(String productunit) {
		this.productunit = productunit;
	}

	public Integer getProductcount() {
		return productcount;
	}

	public void setProductcount(Integer productcount) {
		this.productcount = productcount;
	}

	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public Integer getIspayment() {
		return ispayment;
	}

	public void setIspayment(Integer ispayment) {
		this.ispayment = ispayment;
	}

	public Integer getProviderid() {
		return providerid;
	}

	public void setProviderid(Integer providerid) {
		this.providerid = providerid;
	}
}

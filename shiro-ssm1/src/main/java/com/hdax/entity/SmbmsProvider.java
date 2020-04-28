package com.hdax.entity;


public class SmbmsProvider extends BaseEntity {
	private Integer id;
	private String procode;
	private String proname;
	private String prodesc;
	private String procontact;
	private String prophone;
	private String proaddress;
	private String profax;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProcode() {
		return procode;
	}
	public void setProcode(String procode) {
		this.procode = procode;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getProdesc() {
		return prodesc;
	}
	public void setProdesc(String prodesc) {
		this.prodesc = prodesc;
	}
	public String getProcontact() {
		return procontact;
	}
	public void setProcontact(String procontact) {
		this.procontact = procontact;
	}
	public String getProphone() {
		return prophone;
	}
	public void setProphone(String prophone) {
		this.prophone = prophone;
	}
	public String getProaddress() {
		return proaddress;
	}
	public void setProaddress(String proaddress) {
		this.proaddress = proaddress;
	}
	public String getProfax() {
		return profax;
	}
	public void setProfax(String profax) {
		this.profax = profax;
	}
}

package application;

public class Kullanýcý {
 private int id;
 private String ad;
 private String soyad;
 private String username;
 private String meslek ;
 public Kullanýcý()
 {
	 this.id=0;
	 this.ad=null;
	 this.soyad=null;
	 this.username=null;
	 this.meslek=null;
 }
 public Kullanýcý(String ad,String soyad)
 {
	 this.ad=ad;
	 this.soyad=soyad;
 }
public Kullanýcý(int id, String ad, String soyad, String username, String meslek) {
	super();
	this.id = id;
	this.ad = ad;
	this.soyad = soyad;
	this.username = username;
	this.meslek = meslek;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAd() {
	return ad;
}
public void setAd(String ad) {
	this.ad = ad;
}
public String getSoyad() {
	return soyad;
}
public void setSoyad(String soyad) {
	this.soyad = soyad;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getMeslek() {
	return meslek;
}
public void setMeslek(String meslek) {
	this.meslek = meslek;
}
 
	
}

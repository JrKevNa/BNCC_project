package Project;

import java.util.*;

public class Karyawan
{
	//private int urutan;
	private String id;
	private String nama;
	private String gender;
	private String jabatan;
	private double gaji;
	
	public Karyawan(String id, String nama, String gender, String jabatan, double gaji) {
		super();
		this.id = id;
		this.nama = nama;
		this.gender = gender;
		this.jabatan = jabatan;
		this.gaji = gaji;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJabatan() {
		return jabatan;
	}
	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}
	public double getGaji() {
		return gaji;
	}
	public void setGaji(double gaji) {
		this.gaji = gaji;
	}
}

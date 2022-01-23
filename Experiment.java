package Project;

import java.util.*;
import java.util.Collections;
import java.util.Vector;

public class Experiment 
{

	public Experiment() 
	{
		Vector <Karyawan> karyawan = new Vector();
		
		karyawan.addElement(new Karyawan("UX-1234", "Michael Mars", "Laki-laki", "Admin", 4000000));
		karyawan.addElement(new Karyawan("OH-1244", "Neil Bohr", "Laki-laki", "Admin", 4000000));
		karyawan.addElement(new Karyawan("PK-6823", "Hans Patric", "Laki-laki", "Admin", 4000000));
		
		karyawan.addElement(new Karyawan("PX-1334", "Michelle", "Perempuan", "Supervisor", 6000000));
		karyawan.addElement(new Karyawan("MJ-2354", "Horten Moore", "Laki-laki", "Supervisor", 6000000));
		karyawan.addElement(new Karyawan("OH-3554", "James Walt", "Laki-laki", "Supervisor", 6000000));
		
		karyawan.addElement(new Karyawan("AU-8123", "Dave Lee", "Laki-laki", "Manager", 8000000));
		karyawan.addElement(new Karyawan("IN-1432", "Jessica Brown", "Perempuan", "Manager", 8000000));
		karyawan.addElement(new Karyawan("OP-1243", "Felita", "Perempuan", "Manager", 8000000));
		
		Vector <Karyawan> sortKaryawan = new Vector();
		//copy satu2
		for(Karyawan k : karyawan)
		{
			sortKaryawan.addElement(new Karyawan(k.getId(), k.getNama(), k.getGender(), k.getJabatan(), k.getGaji()));
		}
		sortKaryawan = bubbleSort(sortKaryawan);
		
		
		
		int num = 1;
		System.out.println("|----|-----------------|------------------------------|--------------|--------------|--------------|");
		System.out.printf("|%-4s|%-17s|%-30s|%-14s|%-14s|%-14s|\n", "No", "Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan", "Gaji");
		System.out.println("|----|-----------------|------------------------------|--------------|--------------|--------------|");
		for(Karyawan k : sortKaryawan)
		{
			System.out.printf("|%4d|%17s|%30s|%14s|%14s|%14.0f|\n", num, k.getId(), k.getNama(), k.getGender(), k.getJabatan(), k.getGaji());
			num++;
		}
		System.out.println("|----|-----------------|------------------------------|--------------|--------------|--------------|");
		
		
		
		num = 1;
		System.out.println("|----|-----------------|------------------------------|--------------|--------------|--------------|");
		System.out.printf("|%-4s|%-17s|%-30s|%-14s|%-14s|%-14s|\n", "No", "Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan", "Gaji");
		System.out.println("|----|-----------------|------------------------------|--------------|--------------|--------------|");
		for(Karyawan k : karyawan)
		{
			System.out.printf("|%4d|%17s|%30s|%14s|%14s|%14.0f|\n", num, k.getId(), k.getNama(), k.getGender(), k.getJabatan(), k.getGaji());
			num++;
		}
		System.out.println("|----|-----------------|------------------------------|--------------|--------------|--------------|");	
	}
	
	Random rand = new Random();
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		new Experiment();
	}
	
	public Vector <Karyawan> bubbleSort(Vector <Karyawan> karyawan)
	{
		for(int i=0; i<karyawan.size(); i++)
		{
			for(int j=i+1; j<karyawan.size(); j++)
			{
				if(karyawan.elementAt(i).getNama().compareTo(karyawan.elementAt(j).getNama()) >= 1)
				{
					String temp1 = karyawan.elementAt(i).getId();
					String temp2 = karyawan.elementAt(i).getNama();
					String temp3 = karyawan.elementAt(i).getGender();
					String temp4 = karyawan.elementAt(i).getJabatan();
					Double temp5 = karyawan.elementAt(i).getGaji();			
					//set elemen satu per satu
					karyawan.elementAt(i).setId(karyawan.elementAt(j).getId());
					karyawan.elementAt(i).setNama(karyawan.elementAt(j).getNama());
					karyawan.elementAt(i).setGender(karyawan.elementAt(j).getGender());
					karyawan.elementAt(i).setJabatan(karyawan.elementAt(j).getJabatan());
					karyawan.elementAt(i).setGaji(karyawan.elementAt(j).getGaji());
					//set eleemn satu per satu					
					karyawan.elementAt(j).setId(temp1);
					karyawan.elementAt(j).setNama(temp2);
					karyawan.elementAt(j).setGender(temp3);
					karyawan.elementAt(j).setJabatan(temp4);
					karyawan.elementAt(j).setGaji(temp5);
					
				}
			}
		}
		return karyawan;
	}
}

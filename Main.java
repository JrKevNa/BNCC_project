package Project;

import java.util.Scanner;
import java.util.Vector;
import java.util.Random; 

public class Main 
{
	Scanner sc = new Scanner(System.in);
	public Main() 
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
		
		int opt = 0;
		
		int numAdmin = 3;
		int numAdminSebelumNaikGaji = 3;
		
		int numSupervisor = 3;
		int numSupervisorSebelumNaikGaji = 3;
		
		int numManager = 3;
		int numManagerSebelumNaikGaji = 3;
		
		do
		{
			System.out.println("1. Insert data karyawan");
			System.out.println("2. View data karyawan");
			System.out.println("3. Update data karyawan");
			System.out.println("4. Delete data karyawan");
			System.out.print("Opt >> ");
			opt = sc.nextInt();
			sc.nextLine();
			
			switch(opt)
			{
				case 1:
				{
					//case 1
					String id = generateRandomId();
					String nama;
					String gender;
					String jabatan;
					double gaji = 0;
					
					//validation of name
					do
					{
						System.out.print("Input nama karyawan [>=3]: ");
						nama = sc.nextLine();
					}while(nama.length() < 3);
					
					//validation of gender
					do
					{
						System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
						gender = sc.nextLine();
					}
					while(!(gender.equals("Laki-laki") || gender.equals("Perempuan")));
					
					//validation of jabatan
					do 
					{
						System.out.print("Input jabatan [Manager | Supervisor | Admin]: ");
						jabatan = sc.nextLine();
					}
					while(!(jabatan.equals("Admin") || jabatan.equalsIgnoreCase("Manager") || jabatan.equals("Supervisor")));
					
					//validation of Id
					boolean duplicateId = false;
					do
					{
						for(Karyawan k : karyawan)
						{
							if(k.getId().equals(id))
							{
								duplicateId = true;
								id = generateRandomId();	
								break;
							}
						}				
					}
					while(duplicateId == true);
					
					//auto input gaji
					if(jabatan.equalsIgnoreCase("Manager"))
					{
						gaji = 8000000;
						numManager += 1;
					}
					else if(jabatan.equals("Supervisor"))
					{
						gaji = 6000000;
						numSupervisor += 1;
					}
					else if(jabatan.equals("Admin"))
					{
						gaji = 4000000;
						numAdmin += 1;
					}
					
					System.out.printf("Berhasil mengupdate karyawan dengan id %s\n", id);
					//validation for bonus (belom buat)
					if(numManager % 3 == 1 && numManager > numManagerSebelumNaikGaji)
					{
						System.out.print("Bonus sebesar 10.0% telah diberikan kepada karyawan dengan id");
						int counter = 0;
						numManagerSebelumNaikGaji += 3;
						for(Karyawan k : karyawan)
						{
							if(counter == numManager - 1)
							{
								break;
							}
							else
							{
								if(k.getJabatan().equals("Manager"))
								{			
									k.setGaji(k.getGaji() * 1.1);
									System.out.printf(" %s", k.getId());
									counter++;
								}
							}
						}
						System.out.printf("\n");
					}
					else if(numSupervisor % 3 == 1 && numSupervisor > numSupervisorSebelumNaikGaji)
					{
						System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id");
						int counter = 0;
						numSupervisorSebelumNaikGaji += 3;
						for(Karyawan k : karyawan)
						{
							if(counter == numSupervisor - 1)
							{
								break;
							}
							else
							{
								if(k.getJabatan().equals("Supervisor"))
								{			
									k.setGaji(k.getGaji() * 1.075);
									System.out.printf(" %s", k.getId());
									counter++;
								}
							}
						}
						System.out.printf("\n");
					}
					else if(numAdmin % 3 == 1 && numAdmin > numAdminSebelumNaikGaji)
					{
						System.out.print("Bonus sebesar 5.0% telah diberikan kepada karyawan dengan id");
						int counter = 0;
						numAdminSebelumNaikGaji += 3;
						for(Karyawan k : karyawan)
						{
							if(counter == numAdmin - 1)
							{
								break;
							}
							else
							{
								if(k.getJabatan().equals("Admin"))
								{			
									k.setGaji(k.getGaji() * 1.05);
									System.out.printf(" %s", k.getId());
									counter++;
								}
							}
						}
						System.out.printf("\n");
					}
					karyawan.addElement(new Karyawan(id, nama, gender, jabatan, gaji));
					break;
				}
				
				case 2:
				{
					//belom di sort berdasarkan nama
					displaySortedKaryawan(karyawan);
					break;
				}
				case 3:
				{
					int idxKaryawan = 0;
					//belom di sort berdasarkan nama
					Vector <Karyawan> sortkaryawan = displaySortedKaryawan(karyawan);
					
					while(idxKaryawan < 1 || idxKaryawan > karyawan.size())
					{
						System.out.print("Input nomor urut karyawan yang ingin diupdate : ");
						idxKaryawan = sc.nextInt();
						sc.nextLine();
					};
					
					String sortId = ((Karyawan) sortkaryawan.elementAt(idxKaryawan-1)).getId();
					System.out.println(sortId);
					
					int tempIdx = 1;
					for(Karyawan k : karyawan)
					{
						if(k.getId().equals(sortId))
						{
							break;
						}
						tempIdx++;
					}
					
					idxKaryawan = tempIdx;
							
					String id;
					String nama;
					String gender;
					String jabatan;
					String jabatanBaru;
					double gaji = 0;
					
					//get idx
					id = karyawan.elementAt(idxKaryawan-1).getId();
					//validation of name
					do
					{
						System.out.print("Input nama karyawan [>=3]: ");
						nama = sc.nextLine();
						if(nama.equals("0"))
						{
							nama = karyawan.elementAt(idxKaryawan-1).getNama();
						}
					}while(nama.length() < 3);
					
					//validation of gender
					do
					{
						System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
						gender = sc.nextLine();
						if(gender.equals("0"))
						{
							gender = karyawan.elementAt(idxKaryawan-1).getGender();
						}
					}
					while(!(gender.equals("Laki-laki") || gender.equals("Perempuan")));
					
					//validation of jabatan
					jabatan = karyawan.elementAt(idxKaryawan-1).getJabatan();
					do 
					{
						System.out.print("Input jabatan [Manager | Supervisor | Admin]: ");
						jabatanBaru = sc.nextLine();
						if(jabatanBaru.equals("0"))
						{
							jabatanBaru = karyawan.elementAt(idxKaryawan-1).getJabatan();
						}
					}
					while(!(jabatanBaru.equals("Admin") || jabatanBaru.equalsIgnoreCase("Manager") || jabatanBaru.equals("Supervisor")));
					
					//auto input gaji
					if(jabatanBaru.equals(jabatan))
					{
						karyawan.elementAt(idxKaryawan-1).setNama(nama);
						karyawan.elementAt(idxKaryawan-1).setGender(gender);
						karyawan.elementAt(idxKaryawan-1).setJabatan(jabatan);
					}
					else
					{
						//ganti jabatan mengubah urutan pada vector
						karyawan.removeElementAt(idxKaryawan-1);
						
						if(jabatan.equals("Manager"))
						{
							numManager -= 1;
							if(numManagerSebelumNaikGaji - numManager == 3 && numManager > 0)
							{
								numManagerSebelumNaikGaji -= 3;
							}						
						}
						else if(jabatan.equals("Supervisor"))
						{
							numSupervisor -= 1;
							if(numSupervisorSebelumNaikGaji - numSupervisor == 3 && numSupervisor > 0)
							{
								numSupervisorSebelumNaikGaji -= 3;
							}
						}
						else if(jabatan.equals("Admin"))
						{
							numAdmin -= 1;
							if(numAdminSebelumNaikGaji - numAdmin == 3 && numAdmin > 0)
							{
								numAdminSebelumNaikGaji -= 3;
							}
						}
						
						if(jabatanBaru.equals("Manager"))
						{
							gaji = 8000000;
							numManager += 1;
							
							karyawan.addElement(new Karyawan(id, nama, gender, jabatanBaru, gaji));
						}
						else if(jabatanBaru.equals("Supervisor"))
						{
							gaji = 6000000;
							numSupervisor += 1;
							
							karyawan.addElement(new Karyawan(id, nama, gender, jabatanBaru, gaji));
						}
						else if(jabatanBaru.equals("Admin"))
						{
							gaji = 4000000;
							numAdmin += 1;
							
							karyawan.addElement(new Karyawan(id, nama, gender, jabatanBaru, gaji));
						}
					}
					
					System.out.printf("Berhasil mengupdate karyawan dengan id %s\n", id);
					
					//validation for bonus
					if(numManager % 3 == 1 && numManager > numManagerSebelumNaikGaji)
					{
						System.out.print("Bonus sebesar 10.0% telah diberikan kepada karyawan dengan id");
						int counter = 0;
						numManagerSebelumNaikGaji += 3;
						for(Karyawan k : karyawan)
						{
							if(counter == numManager - 1)
							{
								break;
							}
							else
							{
								if(k.getJabatan().equals("Manager"))
								{			
									k.setGaji(k.getGaji() * 1.1);
									System.out.printf(" %s", k.getId());
									counter++;
								}
							}
						}
						System.out.printf("\n");
						
						karyawan.addElement(new Karyawan(id, nama, gender, jabatanBaru, gaji));
					}
					else if(numSupervisor % 3 == 1 && numSupervisor > numSupervisorSebelumNaikGaji)
					{
						System.out.print("Bonus sebesar 7.5% telah diberikan kepada karyawan dengan id");
						int counter = 0;
						numSupervisorSebelumNaikGaji += 3;
						for(Karyawan k : karyawan)
						{
							if(counter == numSupervisor - 1)
							{
								break;
							}
							else
							{
								if(k.getJabatan().equals("Supervisor"))
								{			
									k.setGaji(k.getGaji() * 1.075);
									System.out.printf(" %s", k.getId());
									counter++;
								}
							}
						}
						System.out.printf("\n");
					}
					else if(numAdmin % 3 == 1 && numAdmin > numAdminSebelumNaikGaji)
					{
						System.out.print("Bonus sebesar 5.0% telah diberikan kepada karyawan dengan id");
						int counter = 0;
						numAdminSebelumNaikGaji += 3;
						for(Karyawan k : karyawan)
						{
							if(counter == numAdmin - 1)
							{
								break;
							}
							else
							{
								if(k.getJabatan().equals("Admin"))
								{			
									k.setGaji(k.getGaji() * 1.05);
									System.out.printf(" %s", k.getId());
									counter++;
								}
							}
						}
						System.out.printf("\n");
					}
					break;
				}
				case 4:
				{
					int idxKaryawan = 0;
					//belom di sort berdasarkan nama
					Vector <Karyawan> sortkaryawan = displaySortedKaryawan(karyawan);
					
					while(idxKaryawan < 1 || idxKaryawan > karyawan.size())
					{
						System.out.print("Input nomor urut karyawan yang ingin diupdate : ");
						idxKaryawan = sc.nextInt();
						sc.nextLine();
					};
					
					String sortId = ((Karyawan) sortkaryawan.elementAt(idxKaryawan-1)).getId();
					System.out.println(sortId);
					
					int tempIdx = 1;
					for(Karyawan k : karyawan)
					{
						if(k.getId().equals(sortId))
						{
							break;
						}
						tempIdx++;
					}
					
					idxKaryawan = tempIdx;
					String id = karyawan.elementAt(idxKaryawan-1).getId();
					karyawan.remove(idxKaryawan-1);
					
					if(numManagerSebelumNaikGaji - numManager == 3 && numManager > 0)
					{
						numManagerSebelumNaikGaji -= 3;
					}						
					numSupervisor -= 1;
					if(numSupervisorSebelumNaikGaji - numSupervisor == 3 && numSupervisor > 0)
					{
						numSupervisorSebelumNaikGaji -= 3;
					}
					numAdmin -= 1;
					if(numAdminSebelumNaikGaji - numAdmin == 3 && numAdmin > 0)
					{
						numAdminSebelumNaikGaji -= 3;
					}
					
					System.out.printf("Karyawan dengan kode %s berhasil dihapus\n", id);
					break;
				}
			}
		}while(opt != 5);
	}

	public static void main(String[] args) 
	{
		new Main();
		// TODO Auto-generated method stub
	}
	
	public String generateRandomId()
	{
		// TODO Auto-generated constructor stub
		Random rand = new Random();
		
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numbers = "1234567890";
		String uniqueId = "";
				
		char[] id = new char[7];
				
		for(int i=0; i<2; i++)
		{
			id[i] = characters.charAt(rand.nextInt(characters.length()));
		}
		id[2] = '-';
		for(int j=3; j<7; j++)
		{
			id[j] = numbers.charAt(rand.nextInt(numbers.length()));
		}
				
		for(int k=0; k<7; k++)
		{
			uniqueId += id[k];
		}
		
		return uniqueId;
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
	
	public Vector displaySortedKaryawan(Vector <Karyawan> karyawan)
	{
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
		
		return sortKaryawan;
	}

}

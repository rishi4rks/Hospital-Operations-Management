/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitaloperation;

import java.util.Scanner;



import java.util.Scanner;

class node                              //creating node 
{
	int emergency,id,age;
	String name,disease;
	
	node(int emergency,int id,String name,String disease,int age)       //constructor
	{
		this.emergency=emergency;                                       //attributes of node
		this.age=age;
		this.name=name;
		this.disease=disease;
		this.id=id;
	}
}

class management
{
	Scanner s=new Scanner(System.in);
	node heap[]=new node[20];
	node H[]=new node[20];
	int size,emergency,id,age;
	String name,disease;
	int max;
	int n=size;
	void accept()                                     //accepting the details
	{
		System.out.println("\nENTER THE DETAILS :\n");
		System.out.println("Enter the size :");
		size=s.nextInt();
		n=size;
		for(int i=1;i<=size;i++)
		{
			System.out.println("\nSr. No. :"+i);
			System.out.println("Enter the Patient Name :");
			name=s.next();
			System.out.println("Enter the Id :");
			id=s.nextInt();
			System.out.println("Enter the severity of patient :");
			emergency=s.nextInt();
			System.out.println("Enter the disease :");
			disease=s.next();
			System.out.println("Enter the Age of Patient :");
			age=s.nextInt();
			heap[i]=new node(emergency,id,name,disease,age);
			upadjustment(i);                                   //max heap creation 
		}
	}
	
	void upadjustment(int i)			//Up Adjustment
	{
		int temp;
		String temp1;
		int parent;
		while(i!=1)
		{
			parent=i/2;
			if(heap[parent].emergency<heap[i].emergency)		
			{
				temp=heap[i].emergency;
				heap[i].emergency=heap[parent].emergency;
				heap[parent].emergency=temp;
				
				temp=heap[i].id;
				heap[i].id=heap[parent].id;
				heap[parent].id=temp;
				
				temp1=heap[i].name;
				heap[i].name=heap[parent].name;
				heap[parent].name=temp1;
				
				temp1=heap[i].disease;
				heap[i].disease=heap[parent].disease;
				heap[parent].disease=temp1;
				
				temp=heap[i].age;
				heap[i].age=heap[parent].age;
				heap[parent].age=temp;
			}
			i=i/2;
		}
	}
	
	
	void downAdjustment(int i)			//Down Adjustment
	{
		
		int largest,temp,left,right;
		String temp1;
		
		left=2*i;
		right=(2*i)+1;
		if(left<=n && heap[left].emergency> heap[i].emergency)	
		{
			largest=left;				//Use smallest
		}
		else
		{
			largest=i;
		}
		
		if(right<=n && heap[right].emergency> heap[largest].emergency)
		{
			largest=right;
		}
	
	
		if(largest!=i)
		{
		  temp=heap[i].emergency;
		  heap[i].emergency=heap[largest].emergency;
		  heap[largest].emergency=temp;
		  
		  temp1=heap[i].name;
		  heap[i].name=heap[largest].name;
		  heap[largest].name=temp1;
		  
		  temp=heap[i].id;
		  heap[i].id=heap[largest].id;
		  heap[largest].id=temp;
		  
		  temp=heap[i].age;
		  heap[i].age=heap[largest].age;
		  heap[largest].age=temp;
		  
		  temp1=heap[i].disease;
		  heap[i].disease=heap[largest].disease;
		  heap[largest].disease=temp1;
		  
		  downAdjustment(largest);                        //down adjustment of largest
		}
	}

	
	void display()                                           //displaying the details
	{
		System.out.println("Total number of patients: "+size);
		System.out.println("\n");
		
		for(int i=1;i<=size;i++)
		{
			System.out.print(i+")"+" ID :"+heap[i].id+"\t"+"| SEVERITY :"+heap[i].emergency+"\t"+"| NAME :"+heap[i].name+"\t");
			System.out.print("| AGE :"+heap[i].age+"\t"+"| DISEASE :"+heap[i].disease+"\t");
			
			System.out.println("\n");
		}
		
		
		
	}

	
	void deleteNode()					//Delete Node
	{
		int temp;
		String temp1;
		int l=1;
		
		temp=heap[1].emergency;
		heap[1].emergency=heap[n].emergency;
		heap[n].emergency=temp;
		
	
		temp1=heap[1].disease;
		heap[1].disease=heap[n].disease;
		heap[n].disease=temp1;
		
		temp=heap[1].id;
		heap[1].id=heap[n].id;
		heap[n].id=temp;
		
		temp1=heap[1].name;
		heap[1].name=heap[n].name;
		heap[n].name=temp1;
		
		temp=heap[1].age;
		heap[1].age=heap[n].age;
		heap[n].age=temp;
		
		H[l]=new node(heap[n].emergency,heap[n].id,heap[n].name,heap[n].disease,heap[n].age);
		l++;
		n--;
		downAdjustment(1);
		
	
	}
	
	
	void delete()                                      //deletion
	{
		deleteNode();
		
		System.out.println("\n\n");
		System.out.println("Diagnosed Patient details :\n");                         //displaying diagnosed patient 
		System.out.println("| ID :"+heap[size].id+"\t"+"| SEVERITY :"+heap[size].emergency+"\t"+"| NAME :"+heap[size].name+"\t"
				+"| AGE :"+heap[size].age+"\t"+"| DISEASE :"+heap[size].disease+"\t");
		
		size=n;
		
		System.out.println("\n\n");
		System.out.println("Remaining patients to diagnose :");                //displaying remaining patients
		
		for(int i=1;i<=size;i++)
		{
			System.out.print("| ID :"+heap[i].id+"\t");
			System.out.print("| SEVERITY :"+heap[i].emergency+"\t");
			System.out.print("| NAME :"+heap[i].name+"\t");
			System.out.print("| AGE :"+heap[i].age+"\t");
			System.out.print("| DISEASE :"+heap[i].disease+"\t");
			System.out.println("\n");
		}
		
	}
	
	void heapSort()						//Sort in ascending order
	{	
		size=n;
		System.out.println("Size :"+n);
		while(n>0)
		{
				deleteNode();
		}
		
		
		System.out.println("Total number of patients: "+size);
		System.out.println("\n");
		
		for(int i=size;i>=1;i--)
		{
			System.out.print(i+")"+" ID :"+heap[i].id+"\t"+"| SEVERITY :"+heap[i].emergency+"\t"+"| NAME :"+heap[i].name+"\t");
			System.out.print("| AGE :"+heap[i].age+"\t"+"| DISEASE :"+heap[i].disease+"\t");
			
			System.out.println("\n");
		}
		
    }
	
	void insert()                       //inserting new details for emergency
	{
		
		System.out.println("Enter the Patient Name :");
		name=s.next();
		System.out.println("Enter the Id :");
		id=s.nextInt();
		System.out.println("Enter the severity of patient :");
		emergency=s.nextInt();
		System.out.println("Enter the disease :");
		disease=s.next();
		System.out.println("Enter the Age of Patient :");
		age=s.nextInt();
		
		size++;
		n=size;
		heap[n]=new node(emergency,id,name,disease,age);
				
		upadjustment(n);
		                            
	}

	
	void search()                                      //searching the details of patient
	{
		int option;
		System.out.println("ENTER CHOICE :\n1.SEARCH BY NAME\t\t2.SEARCH BY ID\t\t3.SEARCH BY SEVERITY");
		option=s.nextInt();
		switch(option)
		{
		case 1:                                          //searching the list using name
			String key;
			int flag=0;
			System.out.println("Enter the name to be searched :");
			key=s.next();
			for(int i=1;i<=size;i++)
			{
				if(heap[i].name.compareTo(key)==0)
				{
					System.out.println("\n***DETAILS***\n");
					System.out.println("| ID :"+heap[i].id+"\t"+"| SEVERITY :"+heap[i].emergency+"\t"+"| NAME :"+heap[i].name+"\t"
							+"| DISEASE :"+heap[i].disease+"\t"+"| AGE :"+heap[i].age+"\t");
					flag=1;
				}
			}
			if(flag==0)
			{
				System.out.println("\nPatient name not found!!!\n");
			}
			break;
		case 2:                                         //searching the list using patient Id
			int key1,flag1=0;
			System.out.println("Enter the id of patient to be searched :");
			key1=s.nextInt();
			for(int i=1;i<=size;i++)
			{
				if(heap[i].id==key1)
				{
					System.out.println("\n***DETAILS***\n");
					System.out.println("| ID :"+heap[i].id+"\t"+"| SEVERITY :"+heap[i].emergency+"\t"+"| NAME :"+heap[i].name+"\t"
							+"| DISEASE :"+heap[i].disease+"\t"+"| AGE :"+heap[i].age+"\t");
					flag1=1;
				}
			}
			if(flag1==0)
			{
				System.out.println("\nPatient with id not found!!!\n");
			}
			break;
		case 3:                                         //searching details using severity
			int key2,flag2=0;
			System.out.println("Enter the severity of patient to be searched :");
			key2=s.nextInt();
			for(int i=1;i<=size;i++)
			{
				if(heap[i].emergency==key2)
				{
					System.out.println("\n***DETAILS***\n");
					System.out.println("| ID :"+heap[i].id+"\t"+"| SEVERITY :"+heap[i].emergency+"\t"+"| NAME :"+heap[i].name+"\t"
							+"| DISEASE :"+heap[i].disease+"\t"+"| AGE :"+heap[i].age+"\t");
					flag2=1;
				}
			}
			if(flag2==0)
			{
				System.out.println("\nPatient with severity not found!!!\n");
			}
			break;
			default:System.out.println("\nINVALID ENTRY!!!!\n");
		}
	}
	
	void update()                       //updating the severity of patient and sorting 
	{
		String patient_name;
		int option;
		System.out.println("\nENTER CHOICE :\n1.UPDATE SEVERITY USING NAME\t\t2.UPDATE SEVERITY USING ID");
		option=s.nextInt();
		switch(option)
		{
		case 1:                                       //updating using name
			int flag=0;
            System.out.println("Enter the name of patient :");
            patient_name=s.next();
            for(int i=1;i<=size;i++)
            {
            	if(heap[i].name.compareTo(patient_name)==0)
            	{
            		System.out.println("Enter the severity of patient :");
            		emergency=s.nextInt();
            		heap[i]=new node(emergency,heap[i].id,heap[i].name,heap[i].disease,heap[i].age);
        			for(int j=size/2;j>=1;j--)
        			{
        				downAdjustment(j);
        			}
        			
        			flag=1;
            	}
            }
            if(flag==0)
            {
            	System.out.println("Patient name not found!!!");
            }
            break;
		case 2:                                        //updating using Id
			int flag1=0;
			int patient_id;
			System.out.println("Enter the Patient Id :");
			patient_id=s.nextInt();
			for(int j=1;j<=size;j++)
			{
				if(heap[j].id==patient_id)
				{
					System.out.println("Enter the severity of patient :");
					emergency=s.nextInt();
					heap[j]=new node(emergency,heap[j].id,heap[j].name,heap[j].disease,heap[j].age);
        			for(int i=size/2;i>=1;i--)
        			{
        				downAdjustment(i);
        			}
        			
        			flag1=1;
				}
			}
            if(flag1==0)
            {
            	System.out.println("Patient name not found!!!");
            }
            break;
		    default:System.out.println("\nINVALID ENTRY!!!!\n");
		}
		
	}

	
}
public class HospitalOperation 
{

	
	public static void main(String[] args)
	{
        Scanner sc=new Scanner(System.in);
		management m=new management();
		int opt;
		char ans;
		
		do
		{
			System.out.println("*****Enter your option*****");
			System.out.println("\n---------------------------------------------------------\n");
			System.out.println("1.Accept Patient Details\n2.Display Patient Details\n3.Delete data");
			System.out.println("4.Insert Patient Details\n5.Search Patient\n6.Update the Severity");
			System.out.println("7.List of treated Patients\n");
			opt=sc.nextInt();
			
			switch(opt)
			{
			case 1: m.accept();
			        break;
			case 2: System.out.println("\n************PATIENT DETAILS************\n");
				    m.display();
			        break;
			case 3: m.delete();
			        break;
			case 4: m.insert();
				    System.out.println("\n*****INSERTED RESULT*****\n");
				    m.display();
				    break;
			case 5: System.out.println("\n*****SEARCH RESULT*****\n");
			        m.search();
			        break;
			case 6: m.update();
			        System.out.println("\n*****UPDATED RESULT*****\n");
			        m.display();
				    break;
			case 7: System.out.println("\n*****LIST OF TREATED PATIENTS*****\n");
			        m.heapSort();
				    break;
			default:System.out.println("\nEnter valid option.");

			}
			
			
			System.out.println("\nDo you want to continue? (y or n)");
			ans=sc.next().charAt(0);
		}
		
		while(ans=='y'|| ans=='Y');		
		
	}

}



/*
 * OUTPUT: 
 * 
 * 
 * *****Enter your option*****

---------------------------------------------------------

1.Accept Patient Details
2.Display Patient Details
3.Delete data
4.Insert Patient Details
5.Search Patient
6.Update the Severity
7.List of treated Patients

1

ENTER THE DETAILS :

Enter the size :
10

Sr. No. :1
Enter the Patient Name :
Revati
Enter the Id :
103
Enter the severity of patient :
10
Enter the disease :
Heart_Attack
Enter the Age of Patient :
42

Sr. No. :2
Enter the Patient Name :
Ramesh
Enter the Id :
107
Enter the severity of patient :
1
Enter the disease :
Routine_Checkup
Enter the Age of Patient :
21

Sr. No. :3
Enter the Patient Name :
Rekha
Enter the Id :
110
Enter the severity of patient :
8
Enter the disease :
Cancer
Enter the Age of Patient :
35

Sr. No. :4
Enter the Patient Name :
Radhika
Enter the Id :
114
Enter the severity of patient :
2
Enter the disease :
Viral_Infection
Enter the Age of Patient :
19

Sr. No. :5
Enter the Patient Name :
Gaurish
Enter the Id :
112
Enter the severity of patient :
5
Enter the disease :
Food_Poisoning
Enter the Age of Patient :
26

Sr. No. :6
Enter the Patient Name :
Ramdev
Enter the Id :
113
Enter the severity of patient :
3
Enter the disease :
TB
Enter the Age of Patient :
58

Sr. No. :7
Enter the Patient Name :
Sunanda
Enter the Id :
116
Enter the severity of patient :
9
Enter the disease :
Accident
Enter the Age of Patient :
22

Sr. No. :8
Enter the Patient Name :
Maya
Enter the Id :
118
Enter the severity of patient :
6
Enter the disease :
Bone_Facture
Enter the Age of Patient :
47

Sr. No. :9
Enter the Patient Name :
Danesh
Enter the Id :
119
Enter the severity of patient :
4
Enter the disease :
Diabetes
Enter the Age of Patient :
54

Sr. No. :10
Enter the Patient Name :
Sammer
Enter the Id :
120
Enter the severity of patient :
7
Enter the disease :
Dengue
Enter the Age of Patient :
16

Do you want to continue? (y or n)
y
*****Enter your option*****

---------------------------------------------------------

1.Accept Patient Details
2.Display Patient Details
3.Delete data
4.Insert Patient Details
5.Search Patient
6.Update the Severity
7.List of treated Patients

2

************PATIENT DETAILS************

Total number of patients: 10


1) ID :103	| SEVERITY :10	| NAME :Revati	| AGE :42	| DISEASE :Heart_Attack	

2) ID :120	| SEVERITY :7	| NAME :Sammer	| AGE :16	| DISEASE :Dengue	

3) ID :116	| SEVERITY :9	| NAME :Sunanda	| AGE :22	| DISEASE :Accident	

4) ID :112	| SEVERITY :5	| NAME :Gaurish	| AGE :26	| DISEASE :Food_Poisoning	

5) ID :118	| SEVERITY :6	| NAME :Maya	| AGE :47	| DISEASE :Bone_Facture	

6) ID :113	| SEVERITY :3	| NAME :Ramdev	| AGE :58	| DISEASE :TB	

7) ID :110	| SEVERITY :8	| NAME :Rekha	| AGE :35	| DISEASE :Cancer	

8) ID :107	| SEVERITY :1	| NAME :Ramesh	| AGE :21	| DISEASE :Routine_Checkup	

9) ID :119	| SEVERITY :4	| NAME :Danesh	| AGE :54	| DISEASE :Diabetes	

10) ID :114	| SEVERITY :2	| NAME :Radhika	| AGE :19	| DISEASE :Viral_Infection	


Do you want to continue? (y or n)
y
*****Enter your option*****

---------------------------------------------------------

1.Accept Patient Details
2.Display Patient Details
3.Delete data
4.Insert Patient Details
5.Search Patient
6.Update the Severity
7.List of treated Patients

3



Diagnosed Patient details :

| ID :103	| SEVERITY :10	| NAME :Revati	| AGE :42	| DISEASE :Heart_Attack	



Remaining patients to diagnose :
| ID :116	| SEVERITY :9	| NAME :Sunanda	| AGE :22	| DISEASE :Accident	

| ID :120	| SEVERITY :7	| NAME :Sammer	| AGE :16	| DISEASE :Dengue	

| ID :110	| SEVERITY :8	| NAME :Rekha	| AGE :35	| DISEASE :Cancer	

| ID :112	| SEVERITY :5	| NAME :Gaurish	| AGE :26	| DISEASE :Food_Poisoning	

| ID :118	| SEVERITY :6	| NAME :Maya	| AGE :47	| DISEASE :Bone_Facture	

| ID :113	| SEVERITY :3	| NAME :Ramdev	| AGE :58	| DISEASE :TB	

| ID :114	| SEVERITY :2	| NAME :Radhika	| AGE :19	| DISEASE :Viral_Infection	

| ID :107	| SEVERITY :1	| NAME :Ramesh	| AGE :21	| DISEASE :Routine_Checkup	

| ID :119	| SEVERITY :4	| NAME :Danesh	| AGE :54	| DISEASE :Diabetes	


Do you want to continue? (y or n)
y
*****Enter your option*****

---------------------------------------------------------

1.Accept Patient Details
2.Display Patient Details
3.Delete data
4.Insert Patient Details
5.Search Patient
6.Update the Severity
7.List of treated Patients

4
Enter the Patient Name :
Sanjay
Enter the Id :
125
Enter the severity of patient :
12
Enter the disease :
Brain_Tumour
Enter the Age of Patient :
48

*****INSERTED RESULT*****

Total number of patients: 10


1) ID :125	| SEVERITY :12	| NAME :Sanjay	| AGE :48	| DISEASE :Brain_Tumour	

2) ID :116	| SEVERITY :9	| NAME :Sunanda	| AGE :22	| DISEASE :Accident	

3) ID :110	| SEVERITY :8	| NAME :Rekha	| AGE :35	| DISEASE :Cancer	

4) ID :112	| SEVERITY :5	| NAME :Gaurish	| AGE :26	| DISEASE :Food_Poisoning	

5) ID :120	| SEVERITY :7	| NAME :Sammer	| AGE :16	| DISEASE :Dengue	

6) ID :113	| SEVERITY :3	| NAME :Ramdev	| AGE :58	| DISEASE :TB	

7) ID :114	| SEVERITY :2	| NAME :Radhika	| AGE :19	| DISEASE :Viral_Infection	

8) ID :107	| SEVERITY :1	| NAME :Ramesh	| AGE :21	| DISEASE :Routine_Checkup	

9) ID :119	| SEVERITY :4	| NAME :Danesh	| AGE :54	| DISEASE :Diabetes	

10) ID :118	| SEVERITY :6	| NAME :Maya	| AGE :47	| DISEASE :Bone_Facture	


Do you want to continue? (y or n)
y
*****Enter your option*****

---------------------------------------------------------

1.Accept Patient Details
2.Display Patient Details
3.Delete data
4.Insert Patient Details
5.Search Patient
6.Update the Severity
7.List of treated Patients

5

*****SEARCH RESULT*****

ENTER CHOICE :
1.SEARCH BY NAME		2.SEARCH BY ID		3.SEARCH BY SEVERITY
1
Enter the name to be searched :
Danesh

***DETAILS***

| ID :119	| SEVERITY :4	| NAME :Danesh	| DISEASE :Diabetes	| AGE :54	

Do you want to continue? (y or n)
y
*****Enter your option*****

---------------------------------------------------------

1.Accept Patient Details
2.Display Patient Details
3.Delete data
4.Insert Patient Details
5.Search Patient
6.Update the Severity
7.List of treated Patients

5

*****SEARCH RESULT*****

ENTER CHOICE :
1.SEARCH BY NAME		2.SEARCH BY ID		3.SEARCH BY SEVERITY
2
Enter the id of patient to be searched :
114

***DETAILS***

| ID :114	| SEVERITY :2	| NAME :Radhika	| DISEASE :Viral_Infection	| AGE :19	

Do you want to continue? (y or n)
y
*****Enter your option*****

---------------------------------------------------------

1.Accept Patient Details
2.Display Patient Details
3.Delete data
4.Insert Patient Details
5.Search Patient
6.Update the Severity
7.List of treated Patients

5

*****SEARCH RESULT*****

ENTER CHOICE :
1.SEARCH BY NAME		2.SEARCH BY ID		3.SEARCH BY SEVERITY
3
Enter the severity of patient to be searched :
5

***DETAILS***

| ID :112	| SEVERITY :5	| NAME :Gaurish	| DISEASE :Food_Poisoning	| AGE :26	

Do you want to continue? (y or n)
y
*****Enter your option*****

---------------------------------------------------------

1.Accept Patient Details
2.Display Patient Details
3.Delete data
4.Insert Patient Details
5.Search Patient
6.Update the Severity
7.List of treated Patients

5

*****SEARCH RESULT*****

ENTER CHOICE :
1.SEARCH BY NAME		2.SEARCH BY ID		3.SEARCH BY SEVERITY
1
Enter the name to be searched :
Seema

Patient name not found!!!


Do you want to continue? (y or n)
y
*****Enter your option*****

---------------------------------------------------------

1.Accept Patient Details
2.Display Patient Details
3.Delete data
4.Insert Patient Details
5.Search Patient
6.Update the Severity
7.List of treated Patients

6

ENTER CHOICE :
1.UPDATE SEVERITY USING NAME		2.UPDATE SEVERITY USING ID
1
Enter the name of patient :
Sammer
Enter the severity of patient :
10

*****UPDATED RESULT*****

Total number of patients: 10


1) ID :125	| SEVERITY :12	| NAME :Sanjay	| AGE :48	| DISEASE :Brain_Tumour	

2) ID :120	| SEVERITY :10	| NAME :Sammer	| AGE :16	| DISEASE :Dengue	

3) ID :110	| SEVERITY :8	| NAME :Rekha	| AGE :35	| DISEASE :Cancer	

4) ID :112	| SEVERITY :5	| NAME :Gaurish	| AGE :26	| DISEASE :Food_Poisoning	

5) ID :116	| SEVERITY :9	| NAME :Sunanda	| AGE :22	| DISEASE :Accident	

6) ID :113	| SEVERITY :3	| NAME :Ramdev	| AGE :58	| DISEASE :TB	

7) ID :114	| SEVERITY :2	| NAME :Radhika	| AGE :19	| DISEASE :Viral_Infection	

8) ID :107	| SEVERITY :1	| NAME :Ramesh	| AGE :21	| DISEASE :Routine_Checkup	

9) ID :119	| SEVERITY :4	| NAME :Danesh	| AGE :54	| DISEASE :Diabetes	

10) ID :118	| SEVERITY :6	| NAME :Maya	| AGE :47	| DISEASE :Bone_Facture	


Do you want to continue? (y or n)
y
*****Enter your option*****

---------------------------------------------------------

1.Accept Patient Details
2.Display Patient Details
3.Delete data
4.Insert Patient Details
5.Search Patient
6.Update the Severity
7.List of treated Patients

6

ENTER CHOICE :
1.UPDATE SEVERITY USING NAME		2.UPDATE SEVERITY USING ID
2
Enter the Patient Id :
111
Patient name not found!!!

*****UPDATED RESULT*****

Total number of patients: 10


1) ID :125	| SEVERITY :12	| NAME :Sanjay	| AGE :48	| DISEASE :Brain_Tumour	

2) ID :120	| SEVERITY :10	| NAME :Sammer	| AGE :16	| DISEASE :Dengue	

3) ID :110	| SEVERITY :8	| NAME :Rekha	| AGE :35	| DISEASE :Cancer	

4) ID :112	| SEVERITY :5	| NAME :Gaurish	| AGE :26	| DISEASE :Food_Poisoning	

5) ID :116	| SEVERITY :9	| NAME :Sunanda	| AGE :22	| DISEASE :Accident	

6) ID :113	| SEVERITY :3	| NAME :Ramdev	| AGE :58	| DISEASE :TB	

7) ID :114	| SEVERITY :2	| NAME :Radhika	| AGE :19	| DISEASE :Viral_Infection	

8) ID :107	| SEVERITY :1	| NAME :Ramesh	| AGE :21	| DISEASE :Routine_Checkup	

9) ID :119	| SEVERITY :4	| NAME :Danesh	| AGE :54	| DISEASE :Diabetes	

10) ID :118	| SEVERITY :6	| NAME :Maya	| AGE :47	| DISEASE :Bone_Facture	


Do you want to continue? (y or n)
y
*****Enter your option*****

---------------------------------------------------------

1.Accept Patient Details
2.Display Patient Details
3.Delete data
4.Insert Patient Details
5.Search Patient
6.Update the Severity
7.List of treated Patients

6

ENTER CHOICE :
1.UPDATE SEVERITY USING NAME		2.UPDATE SEVERITY USING ID
2
Enter the Patient Id :
113
Enter the severity of patient :
11

*****UPDATED RESULT*****

Total number of patients: 10


1) ID :125	| SEVERITY :12	| NAME :Sanjay	| AGE :48	| DISEASE :Brain_Tumour	

2) ID :120	| SEVERITY :10	| NAME :Sammer	| AGE :16	| DISEASE :Dengue	

3) ID :113	| SEVERITY :11	| NAME :Ramdev	| AGE :58	| DISEASE :TB	

4) ID :112	| SEVERITY :5	| NAME :Gaurish	| AGE :26	| DISEASE :Food_Poisoning	

5) ID :116	| SEVERITY :9	| NAME :Sunanda	| AGE :22	| DISEASE :Accident	

6) ID :110	| SEVERITY :8	| NAME :Rekha	| AGE :35	| DISEASE :Cancer	

7) ID :114	| SEVERITY :2	| NAME :Radhika	| AGE :19	| DISEASE :Viral_Infection	

8) ID :107	| SEVERITY :1	| NAME :Ramesh	| AGE :21	| DISEASE :Routine_Checkup	

9) ID :119	| SEVERITY :4	| NAME :Danesh	| AGE :54	| DISEASE :Diabetes	

10) ID :118	| SEVERITY :6	| NAME :Maya	| AGE :47	| DISEASE :Bone_Facture	


Do you want to continue? (y or n)
y
*****Enter your option*****

---------------------------------------------------------

1.Accept Patient Details
2.Display Patient Details
3.Delete data
4.Insert Patient Details
5.Search Patient
6.Update the Severity
7.List of treated Patients

7

*****LIST OF TREATED PATIENTS*****

Size :10
Total number of patients: 10


10) ID :125	| SEVERITY :12	| NAME :Sanjay	| AGE :48	| DISEASE :Brain_Tumour	

9) ID :113	| SEVERITY :11	| NAME :Ramdev	| AGE :58	| DISEASE :TB	

8) ID :120	| SEVERITY :10	| NAME :Sammer	| AGE :16	| DISEASE :Dengue	

7) ID :116	| SEVERITY :9	| NAME :Sunanda	| AGE :22	| DISEASE :Accident	

6) ID :110	| SEVERITY :8	| NAME :Rekha	| AGE :35	| DISEASE :Cancer	

5) ID :118	| SEVERITY :6	| NAME :Maya	| AGE :47	| DISEASE :Bone_Facture	

4) ID :112	| SEVERITY :5	| NAME :Gaurish	| AGE :26	| DISEASE :Food_Poisoning	

3) ID :119	| SEVERITY :4	| NAME :Danesh	| AGE :54	| DISEASE :Diabetes	

2) ID :114	| SEVERITY :2	| NAME :Radhika	| AGE :19	| DISEASE :Viral_Infection	

1) ID :107	| SEVERITY :1	| NAME :Ramesh	| AGE :21	| DISEASE :Routine_Checkup	


Do you want to continue? (y or n)
n

 */


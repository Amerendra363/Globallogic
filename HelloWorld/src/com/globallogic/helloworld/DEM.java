package com.globallogic.helloworld;
//create a array of object of student type and create and store 10 object and print 10 object value
import java.util.*;
class stu
{
	int id;
	String sub;
	@Override
	public String toString() {
		return "stu [id=" + id + ", sub=" + sub + ", marks=" + marks + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	float marks;
}
public class DEM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		stu s[]=new stu[2];
		for(int i=0;i<2;i++)
		{
			int id=sc.nextInt();
			String sub=sc.next();
			float marks=sc.nextFloat();
			stu st=new stu();
			st.setId(id);
			st.setSub(sub);
			st.setMarks(marks);
			s[i]=st;
			
		}
		for(stu stu:s)
		{
			System.out.println("ID="+stu.getId()+" Sub= "+stu.getSub()+" Marks= "+stu.getMarks());
		}

	}

}

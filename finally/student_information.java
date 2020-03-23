package Student_Manage;


public class student_information {
	private String stuID;    /*  学生学号  */
	private String name;     /* 学生姓名 */
    private String age;        /*  学生年龄  */
    private String callnumber;   /* 学生电话号码   */
    private String home_place;   /* 学生家庭住址，籍贯 */
    private String identityID;   /* 学生身份证号码 */
    private String info1;
    private String info2;
    //private String info3;
    //private String info4;
    
    /*无参构造函数*/
    public student_information() {
    
    }
    /*有参构造函数 */
    public student_information(String stuID,String name,String age,String callnumber,String home_place,
    							String identityID,String info1,String info2) {
    	super();
    	this.stuID=stuID;
    	this.name=name;
    	this.age=age;
    	this.callnumber=callnumber;
    	this.home_place=home_place;
    	this.identityID=identityID;
    	this.info1=info1;
    	this.info2=info2;
    	//this.info1=info3;
    	//this.info1=info4;
    }
    public String getStuID() {
    	return this.stuID;
    }
    public void setStuID(String stuID) {
    	this.stuID=stuID;
    }
    
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name=name;
    }
    
    public String getAge() {
    	return this.age;
    }
    public void setAge(String age) {
    	this.age=age;
    }
    
    public String getCallnumber() {
    	return this.callnumber;
    }
    public void setCallnummber(String callnumber) {
    	this.callnumber=callnumber;
    }
    
    public String getHome_place() {
    	return this.home_place;
    }
    public void setHome_place(String home_place) {
    	this.home_place=home_place;
    }
    
    public String getIdentityID() {
    	return this.identityID;
    }
    public void setIdentityID(String identityID) {
    	this.identityID=identityID;
    }
    
    public String getInfo1() {
    	return this.info1;
    }
    public void setInfo1(String info1) {
    	this.info1=info1;
    }
    
    public String getInfo2() {
    	return this.info2;
    }
    public void setInfo2(String info2) {
    	this.info2=info2;
    }
    
    //public String getInfo3() {
    	//return this.info3;
   // }
    //public void setInfo3(String info3) {
    //	this.info3=info3;
   // }
    
   // public String getInfo4() {
    //	return this.info4;
   // }
   // public void setInfo4(String info4) {
    //	this.info4=info4;
   // }
    
    //从文件中录入的数据格式    "学号  姓名  性别  年龄  电话号码  家庭住址  身份证号码"  
    public String fileString()
	{
		return stuID+" "+name+" "+age+"  "+callnumber+"  "+home_place+"  "+identityID+" "+info1+" "+info2;
	}

   
}

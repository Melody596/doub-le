package Student_Manage;


//信息管理人员登陆后的界面
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;/*ArrayList;
import java.util.Hashtable;
*/
public class ManagerLogin extends JFrame implements  ActionListener{
	
	Function fun=new Function();
	
	//定义组件 
	JLabel lb1=new JLabel("当前是信息管理人员登录界面" );//JLabel 对象可以显示文本、图像
	JLabel lb2=new JLabel("提示：录入前请先输入学号，修改、删除根据学号修改信息");
	
  JTextField 学工号,姓名,学院,个人联系方式,现居住地,登记日期;//输入学生基本信息得文本
  JRadioButton 是,否,有,无;//声明单选项对象，性别选择
  ButtonGroup group1=null;//声明按钮组
  ButtonGroup group2=null;
  JButton 录入,查询,删除,修改,显示,返回,柱状图;//声明相应的操作的按钮
  JPanel p1,p2,p3,p4,p5,p6,p7,p8,pv,ph,pb;//调节布局的通道
  
  public ManagerLogin(){       //负责管理员登录的主窗口
      super("西北师范疫情上报系统");
      学工号=new JTextField(15);//创建文本信息的的对象
      姓名=new JTextField(15);
      个人联系方式=new JTextField(15);
      学院=new JTextField(15);
      现居住地=new JTextField(15);
      登记日期=new JTextField(15);
      
      
      group1=new ButtonGroup();
      是=new JRadioButton("是");//初始化单选框,
      否=new JRadioButton("否");
      group1.add(是);//把按钮添加到按钮组
      group1.add(否);
      
      group2=new ButtonGroup();
      有=new JRadioButton("是");//初始化单选框,
      无=new JRadioButton("否");
      group2.add(有);//把按钮添加到按钮组
      group2.add(无);
      
      录入=new JButton("增加信息");//创建按钮对象
      查询=new JButton("查询符合条件的信息");
      删除=new JButton("删除信息");
      修改=new JButton("修改信息");
      显示=new JButton("显示全部信息");
      柱状图=new JButton("柱状图");
      返回=new JButton("返回登录界面");
      
  
      pb=new JPanel();
      pb.add(lb1,JLabel.CENTER);
              
      //p1=new JPanel();//创建一个面板          
      //p1.add(lb2,JLabel.CENTER);
      //p1.add(lb2,JLabel.LEFT);
      
      p1=new JPanel();
      p1.add(new JLabel("学工号:",JLabel.CENTER));//JLabel.CENTER是指JLabel的中心点。CENTER是中心点的坐标
      p1.add(学工号);
      
      p2=new JPanel();
      p2.add(new JLabel("姓名:",JLabel.CENTER));
      p2.add(姓名);
      
      p3=new JPanel();
      p3.add(new JLabel("学院:",JLabel.CENTER));
      p3.add(学院);
      
      p4=new JPanel();
      p4.add(new JLabel("个人联系方式:",JLabel.CENTER));
      p4.add(个人联系方式);    
      
      p5=new JPanel();
      p5.add(new JLabel("现居住地:",JLabel.CENTER));
      p5.add(现居住地);
      
      p6=new JPanel();
      p6.add(new JLabel("登记日期:",JLabel.CENTER));
      p6.add(登记日期);
      
      p7=new JPanel();
      p7.add(new JLabel("是否确诊:",JLabel.CENTER));
      p7.add(是);
      p7.add(否);
     
      p8=new JPanel();
      p8.add(new JLabel("是否与患者有亲密接触:",JLabel.CENTER));
      p8.add(有);
      p8.add(无);
      
      pv=new JPanel();//面板
      pv.setLayout(new GridLayout(8,1));   //把pv组件设置成第七行1列的网格布局
          
      pv.add(p1);//把面板放到容器中,add()代表容器
      pv.add(p2);
      pv.add(p3);
      pv.add(p4);
      pv.add(p5);
      pv.add(p6);
      pv.add(p7);
      pv.add(p8);

      ph=new JPanel();      
      ph.add(录入);
      ph.add(查询);
      ph.add(修改);
      ph.add(删除);    
      ph.add(显示);
      ph.add(柱状图);
      ph.add(返回);
             
      Container con=getContentPane();//建立容器对象con,取得容器面板
      con.setLayout(new BorderLayout());//设置布局为边框布局，边框布局分东南西北中5个方位来添加控件。
      //若没有指定方位，将添加到中间，上下左右都可以扩展
      con.add(pb, BorderLayout.NORTH);//Frame对象lb调用方法add（）,lb放在最北上方     
      con.add(pv, BorderLayout.CENTER);//pv在中间
      con.add(ph, BorderLayout.SOUTH);//ph在南边
      setDefaultCloseOperation(EXIT_ON_CLOSE);//置一个默认的关闭操作，也就是你的JFrame窗口的关闭按钮，点击它时，退出程序
      setBounds(100,100,900,600);//setBounds(x,y,width,height); x:组件在容器X轴上的起点 y:组件在容器Y轴上的起点 width:组件的长度 height:组件的高度
      setVisible(true);//目的是使控件可以显示出来,如果该控件已经被显示出来
        
      student_information stu=new student_information();
      ArrayList<student_information> arry=new ArrayList<student_information>();
      //添加监听
      //点击录入按钮  学号","姓名","性别","年龄","电话号码","家庭住址","身份证号码"  
      录入.addActionListener(new ActionListener() {
  	   public void actionPerformed(ActionEvent e) {		     		     
  		 String sID = 学工号.getText();    //获取文本框中内容
  		 if(fun.find(sID)!=-1)
  		 {
  			 JOptionPane.showMessageDialog(null, "该学/工号对应的学生已经存在！！！\n\n请重新输入或者修改已经录入的信息");   			 
  			  //清空文本框
  			 学工号.setText("");
  			 姓名.setText("");
  			 学院.setText("");
  			 个人联系方式.setText("");
  			 现居住地.setText("");
  			 登记日期.setText("");
  			 return;
  		 }      		 
  		 String sname = 姓名.getText();  		 
  		 //先判断学号和姓名是否为空，如果为空，直接退出
  		 if(sID.equals("")||sname.equals(""))
  		 {
  			 JOptionPane.showMessageDialog(null, "录入的学生学号或姓名为空！！！\n\n请重新输入");
  			 return;
  		 }  	   		 	 
    		 String scollege = 学院.getText();     		 
    		 if(scollege.equals(""))//年龄为空，没有输入
 			    scollege="--";  		 
    		 String scall = 个人联系方式.getText();
    		 if(scall.equals(""))
   			  scall="--";
    		 String shome = 现居住地.getText();
    		if(shome.equals(""))
    		    shome="--";
    		 String stime = 登记日期.getText();
    		if(stime.equals(""))
    		   stime="--";
    		
    		String sinfo1=null;
            if(是.isSelected()){//选择是否与患者有接触
               sinfo1=是.getText();
            }
            else{
                sinfo1=否.getText();
            } 

  		 //String sinfo2=null;
         //if(是.isSelected()){//选择是否在武汉
          //  sinfo2=是.getText();
         //}
         //else{
             //sinfo2=否.getText();
         //}   
         
         String sinfo2=null;
         if(有.isSelected()){//选择是否与患者有接触
            sinfo2=有.getText();
         }
         else{
             sinfo2=无.getText();
         } 
         
         //String sinfo4=null;
         //if(是.isSelected()){//选择是否返校
           // sinfo4=是.getText();
        // }
        // else{
        //     sinfo4=否.getText();
        // } 
    		 stu.setStuID(sID);
    		 stu.setName(sname);
    		 stu.setAge(scollege);
    		 stu.setCallnummber(scall);
    		 stu.setHome_place(shome);
    		 stu.setIdentityID(stime);
    		 stu.setInfo1(sinfo1);
    		 //stu.setInfo2(sinfo2);
    		 stu.setInfo2(sinfo2);
    		 //stu.setInfo4(sinfo4);
    		 
    		 //arry.clear();//	清除原数组列表中的数据	
    		// Input input=new Input(stu);
    		 System.out.println("信息管理员");
    		 System.out.println(stu.fileString());
    		 
    		 fun.add(stu);
    		 fun.writefile();
    		 
    		 JOptionPane.showMessageDialog(null, "录入成功！！！");
    		 //dispose();
    		 setVisible(false); 
    		 new ManagerLogin();
    		 
    		  //清空文本框
    		 /*
			学号.setText("");
			姓名.setText("");
			年龄.setText("");
			电话号码.setText("");
		    家庭住址.setText("");
			身份证号码.setText("");
			group.clearSelection();   //清空按钮已选状态
			*/
  	   }   	   
     });
      
                 
     //显示全部学生信息
        显示.addActionListener(new ActionListener() {
   	   public void actionPerformed(ActionEvent e) {     		   
   		   //show_stuall all=new show_stuall();     
   		   new show_stuall();   		     		   
   	    }	     		   
        });
                    
      //查询某个学生信息       
      查询.addActionListener(new ActionListener() {
      	   public void actionPerformed(ActionEvent e) {      		  
      		   String sID = 学工号.getText();    //获取文本框中内容 
      		   if(sID.equals(""))
      		     sID="--";       		   
        		  String sname = 姓名.getText();  		 
        		  if(sname.equals(""))
      			   sname="--";      		 	 
          	  String scollege = 学院.getText();     		 
          	  if(scollege.equals(""))             //年龄为空，没有输入
       			    scollege="--";  		 
          	  String scall = 个人联系方式.getText();
          	 if(scall.equals(""))
          			  scall="--";
          		 String shome = 现居住地.getText();
          		if(shome.equals(""))
          		    shome="--";
          		 String stime = 登记日期.getText();
          		if(stime.equals(""))
          		   stime="--";
          		 String sinfo1=null;
                 if(是.isSelected()){//选择是否发热
                    sinfo1=是.getText();
                 }
                 else {
              	    if(否.isSelected())
                       sinfo1=否.getText();
                     else {
						  sinfo1="--";
					   }
                 }
          		// String sinfo2=null;
                 //if(是.isSelected()){//选择是否在武汉
                   // sinfo2=是.getText();
               //  }
                // else {
              	  //  if(否.isSelected())
                    //   sinfo2=否.getText();
                   //  else {
					//	  sinfo2="--";
					//   }
               //  }          		    
                 
          		 String sinfo2=null;
                 if(有.isSelected()){//选择与患者接触
                    sinfo2=有.getText();
                 }
                 else {
              	    if(无.isSelected())
                       sinfo2=无.getText();
                     else {
						  sinfo2="--";
					   }
                 }
          		 //String sinfo4=null;
                // if(是.isSelected()){//选择是否返校
                 //   sinfo4=是.getText();
               //  }
                // else {
              	 //   if(否.isSelected())
                    //   sinfo4=否.getText();
                    // else {
					//	  sinfo4="--";
					 //  }
                 //}          		            
      	 		 //将要查询的符合条件的写入文件
      	 		FileWriter fw=null;
  				BufferedWriter out=null;//学号","姓名","性别","年龄","电话号码","家庭住址","身份证号码" };
  				try {
  					 fw = new FileWriter("C:\\Users\\Administrator\\Desktop\\查询时暂时存放的文件.txt");
  					 out = new BufferedWriter(fw);
  					 //姓名学号等中间隔一个空格
  					 out.write(sID+"  ");
  					 out.write(sname+"  ");
  					 out.write(scollege+"  "); 					   					 
  					 out.write(scall+"  ");
  					 out.write(shome+"  ");
  					 out.write(stime+"  "); 
  					out.write(sinfo1+"  ");
  					out.write(sinfo2+"  ");
  					//out.write(sinfo3+"  ");
  					//out.write(sinfo4+"  ");//每次覆盖写入，无需全部保存
  				   					 
  					out.close();
  					fw.close();
  						
  				} catch (IOException e1) {
  					e1.printStackTrace();
  					
  				}     				
  				//开始查询
  				new showones();  
  				
  				//清空文本框
  				学工号.setText("");
  				姓名.setText("");
  				学院.setText("");
  				个人联系方式.setText("");
  			    现居住地.setText("");
  				登记日期.setText("");
  				group1.clearSelection();
  				group2.clearSelection();
  				
      	    }	     		   
           }); 
     

     
     //删除学生信息,按学号删除
        删除.addActionListener(new ActionListener() {
      	   public void actionPerformed(ActionEvent e) {
      		   String sID = 学工号.getText();    //获取文本框中内容
      		   int flag=fun.find(sID);
      		   if(flag==-1)
      		   {
      			   JOptionPane.showMessageDialog(null, "未查找到该学号的学生！！！\n\n请重新输入");       			    
      		   }
      		   else {
					 fun.delete(sID); 
      		     fun.writefile();
      		     JOptionPane.showMessageDialog(null, "删除成功！！！\n");
				 }
     		
      		   //清空文本框
     			学工号.setText("");
     			姓名.setText("");
     			学院.setText("");
     			个人联系方式.setText("");
     		    现居住地.setText("");
     			登记日期.setText("");
     			group1.clearSelection();
     			group2.clearSelection();
      	    }	     		   
           });       
        
        //修改学生信息
        修改.addActionListener(new ActionListener() {
        	   public void actionPerformed(ActionEvent e) {
        		  String sID = 学工号.getText();    //获取文本框中内容
        		 int flag=fun.find(sID);    //查找是否存在      		
       		 if (flag==-1)
       		 {
   			   JOptionPane.showMessageDialog(null, "未查找到该学号的学生！！！\n\n请重新输入");
    			   return;  
   		    }    
       		else
    			   JOptionPane.showMessageDialog(null, "该系统中存在该学生数据！\n\n,确认返回后请输入需要修改后的数据");
     			 		    		     		 
        		 String scollege = 学院.getText();     		 
        		 if(scollege.equals(""))//年龄为空，没有输入
     			    scollege="--";  		 
        		 String scall = 个人联系方式.getText();
        		 if(scall.equals(""))
        			  scall="--";
        		 String shome = 现居住地.getText();
        		if(shome.equals(""))
        		    shome="--";
        		 String stime = 登记日期.getText();
        		if(stime.equals(""))
        		   stime="--";
        		
        		 String sinfo1=null;
               if(是.isSelected()){//选择男女
                  sinfo1=是.getText();
               }
               else{
                   sinfo1=否.getText();
               }   
               
               String sinfo2=null;
               if(有.isSelected()){//选择男女
                  sinfo2=有.getText();
               }
               else{
                   sinfo2=无.getText();
               }   
              // String sinfo3=null;
               //if(是.isSelected()){//选择男女
               //   sinfo3=是.getText();
              // }
              // else{
               //    sinfo3=否.getText();
              // }   
              // String sinfo4=null;
               //if(是.isSelected()){//选择男女
                //   sinfo4=是.getText();
            //    }
             //   else{
             //       sinfo4=否.getText();
             //   }   
               String sname = 姓名.getText();  		 
      		 //先判断学号和姓名是否为空，如果为空，直接退出
      		 if(sname.equals(""))
      		 {
      			 JOptionPane.showMessageDialog(null, "录入的学生姓名为空！！！\n\n请重新输入");
      			 return;
      		 }  	
      		// student_information stu=new student_information();
        		 stu.setStuID(sID);
        		 stu.setAge(scollege);
        		 stu.setName(sname);
        		 stu.setCallnummber(scall);
        		 stu.setHome_place(shome);
        		 stu.setIdentityID(stime);
        		 stu.setInfo1(sinfo1);
        		 stu.setInfo2(sinfo2);
        		// stu.setInfo3(sinfo3);
        		// stu.setInfo4(sinfo4);
       		 
        		 fun.update(stu);       //修改
        		 fun.writefile();
        		 JOptionPane.showMessageDialog(null, "修改成功！！！");
        		  //清空文本框
   			学工号.setText("");
   			姓名.setText("");
   			学院.setText("");
   			个人联系方式.setText("");
   		    现居住地.setText("");
   			登记日期.setText("");
   			group1.clearSelection();	 
   			group2.clearSelection();
        	    }	     		             	   
             });
                      
  返回.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);      //目的是使控件不可以显示出来
			new Login();
		}
	});
   }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
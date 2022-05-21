package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

import runPart.Properties;


public class FacilityManage {

	/**
	 * �Ƿ���ڸ��豸
	 * @param no
	 * @param Category
	 * @return
	 */
	public static boolean isExist_Facility(String no) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Customer");

            String sql = "select * from facility";    //Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
                System.out.println("���"+"\t"+"\t"+"\t"+"���");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.println();
                    if(rs.getString(1).equals(no)) {
                        rs.close();
                        stmt.close();
                        conn.close();
                        System.out.println("find facility");
                    	return true;
                    }
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    	System.out.println("false");
		return false;
    }
	
	public static boolean isExist_runStatus(Integer runNo,String no) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Customer");

            String sql = "select * from runstatus";    //Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
                System.out.println("���б��"+"\t"+"�豸���");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.println();
                    if(rs.getString(1).equals(runNo.toString()) && rs.getString(2).equals(no)) {
                        rs.close();
                        stmt.close();
                        conn.close();
                    	return true;
                    }
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return false;
    }
	
	public static boolean isRun_Facility(String no,String runNo) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Customer");

            String sql = "select * from runstatus";    //Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
                System.out.println("�豸���"+"\t"+"���б��"+"\t��ʼ����ʱ��"+"\t��������ʱ��");
                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minute = cal.get(Calendar.MINUTE);
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.print(rs.getString(3)+":"+rs.getString(4)+"\t");
                    System.out.print(rs.getString(5)+":"+rs.getString(6)+"\t");
                    System.out.println();
                    if(rs.getString(1).equals(no) && rs.getString(2).equals(runNo) && 
                    		Integer.parseInt(rs.getString(5))>hour && Integer.parseInt(rs.getString(6))>minute) {
                        rs.close();
                        stmt.close();
                        conn.close();
                    	return true;
                    }
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return false;
    }
	
	/**
	 * �豸��ӣ��޷�����Ϣ��
	 * @param no
	 * @param Category
	 * @param inRemainWarPer
	 */
	public static void add_Facility(String no,String Category, Integer inRemainWarPer) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-regist_Customer");
                
            String url=Properties.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-regist_Customer");
            String sql="";
            
            sql = "insert into facility(No,Category,RemainWarPer,isFault) values('"+no+"','"+Category+
            		"','"+inRemainWarPer.toString()+"');";

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	
	/**
	 *  �豸��ӣ��з�����Ϣ��
	 * @param no
	 * @param Category
	 * @param inRemainWarPer
	 * @param roomName
	 */
	public static void add_Facility(String no,String Category, Integer inRemainWarPer, String roomName) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-regist_Customer");
                
            String url=Properties.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-regist_Customer");
            String sql="";
            
            sql = "insert into facility(FacilityNo,Category,RemainWarPer,RoomName,isFault,ControledNum) values('"+no+"','"+Category+
            		"','"+inRemainWarPer.toString()+"','" +roomName +"','false',0);";

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	
	/**
	 * ɾ���豸���Լ��豸������״̬
	 * @param no
	 */
	public static void delete_Facility(String no) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-regist_Customer");
                
            String url=Properties.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-regist_Customer");
            String sql="";
            
            sql = "call facilityDelete('"+no+"');";
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	

	
	public static void facility_Time_add(String no,
			Integer openHour,Integer openMinute, Integer endHour, Integer endMinute) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-changePassword");
                
            String url=Properties.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-changePassword");

            String sql = "insert into runstatus(FacilityNo,OpenHour,OpenMin,CloseHour,CloseMin) values('"
            +no+"','"+openHour.toString()+"','"+openMinute.toString()+
            	"','"+endHour.toString()+"','"+endMinute.toString()+"');";
    
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	

	/**
	 * �豸�����޸�
	 * @param no
	 * @param category
	 * @param roomname
	 */
	public static void facility_room_change(String no,String roomname) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-changePassword");
                
            String url=Properties.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-changePassword");

            String sql = "update facility set RoomName = '"+roomname+"' where No = '"+no+
            		"';";    //Ҫִ�е�SQL
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	
	
	/**
	 * 
	 * @param no
	 * @param runNo
	 */
	public static void delete_runstatus(String no,Integer runNo) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-regist_Customer");
                
            String url=Properties.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-regist_Customer");
            String sql="";
            
            sql = "Delete from runstatus where FacilityNo = '"+no+
            		"'and RunNo = " + runNo.toString()+ ";";

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }

	public static boolean select_guarantee(Integer guarantee) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Customer");
            String sql = "select FacilityNo,Category,AccumuRuntime,RemainWarPer "
            		+ "from facility"
            		+ " where facility.RemainWarPer <= '" + guarantee.toString()+"';";    //Ҫִ�е�SQL
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
                System.out.println("�豸���"+"\t����"+"\t������Сʱ"+"\tʣ�ౣ���ڣ��£�");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.print(rs.getString(3) + "\t");
                    System.out.print(rs.getString(4) + "\t");
                    System.out.println();
                    
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return false;
    }
	
	/**
	 * ��ѯָ�����������ڹ������豸
	 * @param roomName
	 * @return
	 */
	public static boolean select_runFacility(String roomName) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Customer");
            String sql = "select No,Category,Name "
            		+ "from room, facility"
            		+ " where Name ='"+roomName+"' and isFault = 'false'"
            				+ "and facility.RoomName = room.Name;";    //Ҫִ�е�SQL
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
                System.out.println("���"+"\t����"+"\t����");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.print(rs.getString(3) + "\t");
                    System.out.println();
                    
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return false;
    }
	
	
	public static Integer getFacilitycount(String bool) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Customer");

            String sql = "select count(*) from facility where isFault = '"+bool+ "';";    //Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
            rs.next();
            Integer i =Integer.parseInt(rs.getString(1));
            
            rs.close();
            stmt.close();
            conn.close();
            return i;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return -1;
    }

	
	public static String[][] select_allrunFacility() {
		int i = getFacilitycount("false");
		String[][] anStrings = new String[i][4];
    	try{
            //����Class.forName()����������������
    		
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Customer");
            String sql = "select FacilityNo,Category,RemainWarper,RoomName "
            		+ "from facility"
            		+ " where isFault = 'false';";    //Ҫִ�е�SQL
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
                System.out.println("���"+"\t����"+"\t����");
                int j=0;
                while (rs.next()&&j<i){
                    anStrings[j][0]= rs.getString(1);
                    anStrings[j][1]= rs.getString(2);
                    anStrings[j][2]= rs.getString(3);
                    anStrings[j][3]= rs.getString(4);
                    j++;
                }
                rs.close();
                stmt.close();
                conn.close();
                return anStrings;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return anStrings;
    }
	
	
	public static String[][] select_allFaultFacility() {
		int i = getFacilitycount("true");
		String[][] anStrings = new String[i][5];
    	try{
            //����Class.forName()����������������
    		
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Customer");
            String sql = "select FacilityNo,Category,RemainWarper,RoomName,FaultType "
            		+ "from facility"
            		+ " where isFault = 'true';";    //Ҫִ�е�SQL
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
                System.out.println("���"+"\t����"+"\t����");
                int j=0;
                while (rs.next()&&j<i){
                    anStrings[j][0]= rs.getString(1);
                    anStrings[j][1]= rs.getString(2);
                    anStrings[j][2]= rs.getString(3);
                    anStrings[j][3]= rs.getString(4);
                    anStrings[j][4]= rs.getString(5);
                    j++;
                }
                rs.close();
                stmt.close();
                conn.close();
                return anStrings;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return anStrings;
    }
	
	public static void changeFacility(String FacilityNo,String category,String newValue) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-changePassword");
                
            String url=Properties.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-changePassword");

            String sql = "update facility set "+category +"='"+newValue+"' where FacilityNo = '"+FacilityNo+"';";    //Ҫִ�е�SQL
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	
	public static Integer getLogscount(String category) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Customer");

            String sql = "select count(*) from logs where Category = '"+category+ "';";    //Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
            rs.next();
            Integer i =Integer.parseInt(rs.getString(1));
            
            rs.close();
            stmt.close();
            conn.close();
            return i;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return -1;
    }
	
	public static String[][] select_Logs(String category) {
		int i = getLogscount(category);
		String[][] anStrings = new String[i][4];
    	try{
            //����Class.forName()����������������
    		
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Customer");
            String sql = "select Time,Events,Category,KeyWords "
            		+ "from logs "
            		+ "where Category = '"+category+ "' order by Time asc;";    //Ҫִ�е�SQL
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
                System.out.println("���"+"\t����"+"\t����");
                int j=0;
                while (rs.next()&&j<i){
                    anStrings[j][0]= rs.getString(1);
                    anStrings[j][1]= rs.getString(2);
                    anStrings[j][2]= rs.getString(4);
                    anStrings[j][3]= rs.getString(3);
                    j++;
                }
                rs.close();
                stmt.close();
                conn.close();
                return anStrings;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return anStrings;
    }
	
	public static void delete_Logs(String category) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-regist_Customer");
                
            String url=Properties.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-regist_Customer");
            String sql="";
            
            sql = "Delete from logs where Category = '"+category+"';";

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	
	public static boolean select_faultFacility(String roomName) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Customer");
            String sql = "select No,facility.Category,Name,FaultType "
            		+ "from room, facility, runstatus "
            		+ " where Name ='"+roomName+"' and isFault = 'true' "
            				+ "and facility.RoomName = room.Name "
            				+ "and facility.No = runstatus.FacilityNo ;";    //Ҫִ�е�SQL
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
            	System.out.println("���"+"\t����"+"\t����"+"\t�������");
                while (rs.next()){
                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.print(rs.getString(3) + "\t");
                    System.out.print(rs.getString(4) + "\t");
                    System.out.println();
                    
                }
                rs.close();
                stmt.close();
                conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return false;
    }
	
	public static void add_Control(String userAccount,String facilityNo) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-regist_Customer");
                
            String url=Properties.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-regist_Customer");
            String sql="";
            
            sql = "insert into control(UserAccount,FacilityNo) values('"+userAccount+"','"+facilityNo+
            		"');";

            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	
	public static void delete_Control(String userAccount, String facilityNo ) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-regist_Customer");
                
            String url=Properties.JDBC_URL;    //JDBC��URL    
            Connection conn;

            conn = DriverManager.getConnection(url,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-regist_Customer");
            String sql="";
            
            sql = "Delete from control where UserAccount = '"+userAccount+
            		"'and FacilityNo = '" + facilityNo+ "';";
            
            PreparedStatement stmts = conn.prepareStatement(sql);
            stmts.executeUpdate();  
            
            stmts.close();
            stmt.close();
            conn.close();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
	
	
	public static Integer getControlcount(String bool) {
    	try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Customer");

            String sql = "select count(*) from control where UserAccount = '"+bool+ "';";    //Ҫִ�е�SQL
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
            rs.next();
            Integer i =Integer.parseInt(rs.getString(1));
            
            rs.close();
            stmt.close();
            conn.close();
            return i;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return -1;
    }
	
	public static String[][] Select_Control(String account) {
		int i = getControlcount(account);
		String[][] anStrings = new String[i][4];
    	try{
            //����Class.forName()����������������
    		
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL����-isExist_Customer");
                
            Connection conn;

            conn = DriverManager.getConnection(Properties.JDBC_URL,Properties.username,Properties.password);
            Statement stmt = conn.createStatement(); //����Statement����
            System.out.println("�ɹ����ӵ����ݿ�-isExist_Customer");
            String sql = "select UserAccount,FacilityNo,RoomName,isFault "
            		+ "from controlFacilityView"
            		+ " where UserAccount = '"+account+"';";    //Ҫִ�е�SQL
            //System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
                System.out.println("���"+"\t����"+"\t����");
                int j=0;
                while (rs.next()&&j<i){
                    anStrings[j][0]= rs.getString(1);
                    anStrings[j][1]= rs.getString(2);
                    anStrings[j][2]= rs.getString(3);
                    anStrings[j][3]= rs.getString(4);
                    j++;
                }
                rs.close();
                stmt.close();
                conn.close();
                return anStrings;
            }catch(Exception e)
            {
                e.printStackTrace();
            }
		return anStrings;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		isExist_Facility("L5");
		
		
	}

}

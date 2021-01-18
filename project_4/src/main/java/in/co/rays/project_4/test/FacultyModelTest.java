package in.co.rays.project_4.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project_4.bean.FacultyBean;
import in.co.rays.project_4.exception.DuplicateRecordsException;
import in.co.rays.project_4.model.FacultyModel;

/**
 * The Class FacultyModelTest.
 */
public class FacultyModelTest {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws ParseException the parse exception
	 * @throws SQLException the SQL exception
	 */
	public static void main(String[] args) throws ParseException, SQLException {
		//testAdd();
		//testDelete();
		//testUpdate();
		//testFindByEmaiId();
		//testFindByPk();
		testSearch();
		//testList();
	}
	
	/**
	 * Test add.
	 *
	 * @throws ParseException the parse exception
	 * @throws SQLException 
	 * @throws DuplicateRecordsException 
	 */
	public static void testAdd() throws ParseException, DuplicateRecordsException, SQLException{
		FacultyBean bean= new FacultyBean();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date date = sdf.parse("24/09/2019");
		
				
		bean.setFirstName("Rishabh");
		bean.setLastName("sharma");
		bean.setGender("male");
		bean.setDoj(date);
		bean.setQualification("MBA");
		bean.setEmailId("Rishabh@gmail.com");
		bean.setMobileNo("3698521470");
		bean.setCollegeId(14778522L);
		bean.setCollegeName("Bunsal");
		bean.setCourseId(505L);
		bean.setCourseName("Mtech");
		bean.setSubjectId(506L);
		bean.setSubjectName("Network");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(null);
        bean.setModifiedDatetime(null);
        
        FacultyModel model= new FacultyModel();
        model.add(bean);
        
		
		
	}

	
	/**
	 * Test delete.
	 */
	public static void testDelete(){
		FacultyBean bean= new FacultyBean();
		bean.setId(1L);
		
		FacultyModel model= new FacultyModel();
		model.Delete(bean);
	}
	
	/**
	 * Test update.
	 *
	 * @throws ParseException the parse exception
	 */
	public static void testUpdate() throws ParseException{
		FacultyBean bean= new FacultyBean();
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		java.util.Date date = sdf.parse("24/09/2019");
		
		bean.setId(1L);

		bean.setFirstName("DR.raghu");
		bean.setLastName("prasad");
		bean.setGender("male");
		bean.setDoj(date);
		bean.setQualification("PHD");
		bean.setEmailId("raghu@gmail.com");
		bean.setMobileNo("3698521470");
		bean.setCollegeId(14778522L);
		bean.setCollegeName("Bunsal");
		bean.setCourseId(502L);
		bean.setCourseName("Mtech");
		bean.setSubjectId(505L);
		bean.setSubjectName("Network");
		bean.setCreatedBy("admin");
		bean.setModifiedBy("admin");
		bean.setCreatedDatetime(null);
        bean.setModifiedDatetime(null);
        
        FacultyModel model=new FacultyModel();
        model.update(bean);
		
	}
	
	/**
	 * Test find by emai id.
	 */
	public static void testFindByEmaiId(){
		FacultyBean bean= new FacultyBean();
		
		FacultyModel model= new FacultyModel();
		bean=model.findByemailId("raghu@gmail.com");
		
		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getGender());
		System.out.println(bean.getDoj());
		System.out.println(bean.getQualification());
		System.out.println(bean.getEmailId());
		System.out.println(bean.getMobileNo());
		System.out.println(bean.getCollegeId());
		System.out.println(bean.getCollegeName());
		System.out.println(bean.getCourseId());
		System.out.println(bean.getCourseName());
		System.out.println(bean.getSubjectId());
		System.out.println(bean.getSubjectName());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getModifiedBy());
		System.out.println(bean.getCreatedDatetime());
		System.out.println(bean.getModifiedDatetime());
	}
	
	/**
	 * Test find by pk.
	 */
	public static void testFindByPk(){
		FacultyBean bean= new FacultyBean();
	     
		FacultyModel model= new FacultyModel();
	      bean=model.findByPk(1L);
		
		System.out.println(bean.getId());
		System.out.println(bean.getFirstName());
		System.out.println(bean.getLastName());
		System.out.println(bean.getGender());
		System.out.println(bean.getDoj());
		System.out.println(bean.getQualification());
		System.out.println(bean.getEmailId());
		System.out.println(bean.getMobileNo());
		System.out.println(bean.getCollegeId());
		System.out.println(bean.getCollegeName());
		System.out.println(bean.getCourseId());
		System.out.println(bean.getCourseName());
		System.out.println(bean.getSubjectId());
		System.out.println(bean.getSubjectName());
		System.out.println(bean.getCreatedBy());
		System.out.println(bean.getModifiedBy());
		System.out.println(bean.getCreatedDatetime());
		System.out.println(bean.getModifiedDatetime());
		
	}
	
	/**
	 * Test search.
	 *
	 * @throws SQLException the SQL exception
	 */
	public static void testSearch() throws SQLException{
		FacultyBean bean= new FacultyBean();
		FacultyModel model=new FacultyModel();
		List list=new ArrayList();
		//bean.setFirstName("DR.raghu");
		bean.setEmailId("Himanshu@gmail.com");
		list=model.search(bean, 0, 0);
		Iterator it= list.iterator();
		while(it.hasNext()){
			bean=(FacultyBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getGender());
			System.out.println(bean.getDoj());
			System.out.println(bean.getQualification());
			System.out.println(bean.getEmailId());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getCollegeId());
			System.out.println(bean.getCollegeName());
			System.out.println(bean.getCourseId());
			System.out.println(bean.getCourseName());
			System.out.println(bean.getSubjectId());
			System.out.println(bean.getSubjectName());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
			
		}
		
	}
	
	/**
	 * Test list.
	 */
	public static void testList(){
		FacultyBean bean= new FacultyBean();
		FacultyModel model=new FacultyModel();
		List list=new ArrayList();
	
		list=model.list(0, 0);
		Iterator it= list.iterator();
		while(it.hasNext()){
			bean=(FacultyBean) it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getGender());
			System.out.println(bean.getDoj());
			System.out.println(bean.getQualification());
			System.out.println(bean.getEmailId());
			System.out.println(bean.getMobileNo());
			System.out.println(bean.getCollegeId());
			System.out.println(bean.getCollegeName());
			System.out.println(bean.getCourseId());
			System.out.println(bean.getCourseName());
			System.out.println(bean.getSubjectId());
			System.out.println(bean.getSubjectName());
			System.out.println(bean.getCreatedBy());
			System.out.println(bean.getModifiedBy());
			System.out.println(bean.getCreatedDatetime());
			System.out.println(bean.getModifiedDatetime());
			
		}
		
	}
	
	
	
	
	
	
	
	
	
}

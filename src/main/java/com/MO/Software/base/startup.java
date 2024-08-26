package com.MO.Software.base;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.MO.Software.operation.operationModel;
import com.MO.Software.operation.pages.pageModel;
import com.MO.Software.operation.pages.service.pageServiceInterface;
import com.MO.Software.operation.service.operationServiceInterface;

@Component
public class startup implements CommandLineRunner{

	@Autowired
	private pageServiceInterface pageServiceI;
	
	@Autowired
	private operationServiceInterface operationServiceI;
	
	@Override
	public void run(String... args) throws Exception {
//		
//		List<pageModel> pages=new ArrayList<pageModel>();
//		pageModel page1=new pageModel();
//		page1.setName("الموردين");
//		pageModel page2=new pageModel();
//		page2.setName("العاملين");
//		pageModel page3=new pageModel();
//		page3.setName("المنتجات");
//		pageModel page4=new pageModel();
//		page4.setName("اليوزرات");
//		pageModel page5=new pageModel();
//		page5.setName("المخازن");
//		pageModel page6=new pageModel();
//		page6.setName("الفواتير");
//		pageModel page7=new pageModel();
//		page7.setName("المبيعات");
//		pageModel page8=new pageModel();
//		page8.setName("المشتريات");
//		pageModel page9=new pageModel();
//		page9.setName("التوتال");
//		pageModel page10=new pageModel();
//		page10.setName("الحضور");
//		
//		pages.add(page1);
//	    pages.add(page2);
//		pages.add(page3);
//		pages.add(page4);
//		pages.add(page5);
//		pages.add(page6);
//		pages.add(page7);
//		pages.add(page8);
//		pages.add(page9);
//		pages.add(page10);
//		
//		pageServiceI.insertAllPages(pages);
//		
//		for(int i=1;i<=10;i++)
//		{
//			List<operationModel> opModelsInsert=new ArrayList<operationModel>();
//			pageModel pageModelForOperations=new pageModel();
//			pageModelForOperations.setId(i);
//			operationModel opModel1=new operationModel();
//			opModel1.setName("حفظ");
//			opModel1.setPageModel(pageModelForOperations);
//			operationModel opModel2=new operationModel();
//			opModel2.setName("حذف");
//			opModel2.setPageModel(pageModelForOperations);
//			operationModel opModel3=new operationModel();
//			opModel3.setName("تعديل");
//			opModel3.setPageModel(pageModelForOperations);
//			operationModel opModel4=new operationModel();
//			opModel4.setName("عرض");
//			opModel4.setPageModel(pageModelForOperations);
//			opModelsInsert.add(opModel1);
//			opModelsInsert.add(opModel2);
//			opModelsInsert.add(opModel3);
//			opModelsInsert.add(opModel4);
//			operationServiceI.insertAllOperations(opModelsInsert);
//		}
	}

}

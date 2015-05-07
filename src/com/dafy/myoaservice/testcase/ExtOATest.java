package com.dafy.myoaservice.testcase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.cdoframework.cdolib.base.Return;
import com.cdoframework.cdolib.data.cdo.CDO;
import com.dafy.myoaservice.element.DataService;
import com.dafy.myoaservice.element.DataServicePlugin;
import com.dafy.myoaservice.element.Delete;
import com.dafy.myoaservice.element.Insert;
import com.dafy.myoaservice.element.OnException;
import com.dafy.myoaservice.element.ReturnItem;
import com.dafy.myoaservice.element.SQLIf;
import com.dafy.myoaservice.element.SQLThen;
import com.dafy.myoaservice.element.SQLTrans;
import com.dafy.myoaservice.element.SelectField;
import com.dafy.myoaservice.element.SelectRecord;
import com.dafy.myoaservice.element.SelectRecordSet;
import com.dafy.myoaservice.element.ServiceConfig;
import com.dafy.myoaservice.element.ServicePlugin;
import com.dafy.myoaservice.element.Update;
import com.dafy.myoaservice.parserutil.ParserUtil;
import com.dafy.myoaservice.parserutil.XmlUtil;

public class ExtOATest extends TestCase {

	private Logger log = Logger.getLogger(ExtOATest.class);


	public static void main(String[] args)
	{

		
	}
	
	@Test
	public void execSqlTest()
	{
		
		/*MysqlEngine de = new MysqlEngine();
		try {
			Connection connection = de.getDE().getConnection();
			
			Statement stmt = connection.createStatement(
					ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet resultSet = stmt
					.executeQuery(" select * from Account.tbFundAccount limit 10 ");
			while(resultSet.next())
			{
				System.out.println(resultSet.getString("strName"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
	}
	@Test
	public void  testCreateDBService()
	{
		String TABLE_SCHEMA = "myoa";
		CDO cdoRequest = CDO.newRequest("SchemaService", "findTableList");
		cdoRequest.setStringValue("strDBName", TABLE_SCHEMA);
		CDO cdoResponse= new CDO();
		Return ret = this.service.handleTrans(cdoRequest, cdoResponse);
		log.info(ret.toCDO().toJSON());
		CDO[] cdos = cdoResponse.getCDOArrayValue("cdosTable");
		
		
		ServicePlugin serviceplugin = new ServicePlugin();
		List<ServiceConfig> serviceConfigs = new ArrayList<ServiceConfig>();
		serviceplugin.setServiceConfigs(serviceConfigs );
		for(CDO c:cdos)
		{
			
			String TABLE_NAME = c.getStringValue("TABLE_NAME");
			
			CDO cdoReq = CDO.newRequest("SchemaService", "findColumnList");
			cdoReq.setStringValue("strDBName", TABLE_SCHEMA);
			cdoReq.setStringValue("strTableName", TABLE_NAME);
			CDO cdoRes = new CDO();
			String TABLE_TYPE = c.getStringValue("TABLE_TYPE");
			
			cdoReq.setStringValue("TABLE_SCHEMA", TABLE_SCHEMA);
			cdoReq.setStringValue("TABLE_NAME", TABLE_NAME);
			Return ret1 = this.service.handleTrans(cdoReq, cdoRes);
			CDO[] cdosColumn = cdoRes.getCDOArrayValue("cdosColumn");
			
			/************findList****************/
			DataService d = new DataService();
	    	SQLTrans findList = getFindListMethod(TABLE_NAME, TABLE_SCHEMA,
					cdosColumn);
			d.setFindList(findList);
			/************findList****************/
			/************findListByPage*************/
			SQLTrans findListByPage = getFindListByPageMethod(TABLE_NAME,
					TABLE_SCHEMA, cdosColumn);
			d.setFindListByPage(findListByPage);
			/************findListByPage*************/
			/************insert*********************/
			SQLTrans add = getInsertMethod(TABLE_NAME, TABLE_SCHEMA, cdosColumn);
			d.setAdd(add );
			/************insert*********************/
			/************Delete*********************/
			SQLTrans deleteSQLTrans = getDeleteMethod(TABLE_NAME, TABLE_SCHEMA,
					cdosColumn);
			d.setDelete(deleteSQLTrans);
			/************Delete*********************/
			/************Update*********************/
			SQLTrans updateSQLTrans = getUpdateMethod(TABLE_NAME, TABLE_SCHEMA,
					cdosColumn);
			
			d.setUpdate(updateSQLTrans);
			/************Update*********************/
			/************findOne*********************/
			
			SQLTrans findOneSQLTrans = getFindOneMethod(TABLE_SCHEMA,
					TABLE_NAME, cdosColumn);
			d.setFindOne(findOneSQLTrans );
			
			/************findOne*********************/
			
	    	System.out.println(XmlUtil.toXML(d ));
	    	
	    	writeFile(TABLE_NAME,XmlUtil.toXML(d ));
	    	
	    	String fileName = ParserUtil.parseTableName(TABLE_NAME)+"Service";
	    	ServiceConfig serviceconfig = new ServiceConfig(fileName);
	    	DataServicePlugin dataService = new DataServicePlugin();
	    	dataService.Resource="com/dafy/extoa/business/"+fileName+".xml";
			serviceconfig.setDataService(dataService );
			serviceConfigs.add(serviceconfig);
		}
		
		try {
			String fileName = "plugin.xml";
			File file = new File("file/"+fileName);
			file.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(XmlUtil.toXML(serviceplugin ));
			writer.flush();
			writer.close();  
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	@Test
	public void testCreateTableService()
	{

		
		String TABLE_SCHEMA = "myoa";
		String TABLE_NAME = "tb_company";
		
		CDO cdoReq = CDO.newRequest("SchemaService", "findColumnList");
		cdoReq.setStringValue("strDBName", TABLE_SCHEMA);
		cdoReq.setStringValue("strTableName", TABLE_NAME);
		CDO cdoRes = new CDO();
		
		cdoReq.setStringValue("TABLE_SCHEMA", TABLE_SCHEMA);
		cdoReq.setStringValue("TABLE_NAME", TABLE_NAME);
		Return ret1 = this.service.handleTrans(cdoReq, cdoRes);
		CDO[] cdosColumn = cdoRes.getCDOArrayValue("cdosColumn");
		
		/************findList****************/
		DataService d = new DataService();
    	SQLTrans findList = getFindListMethod(TABLE_NAME, TABLE_SCHEMA,
				cdosColumn);
		d.setFindList(findList);
		/************findList****************/
		/************findListByPage*************/
		SQLTrans findListByPage = getFindListByPageMethod(TABLE_NAME,
				TABLE_SCHEMA, cdosColumn);
		d.setFindListByPage(findListByPage);
		/************findListByPage*************/
		/************insert*********************/
		SQLTrans add = getInsertMethod(TABLE_NAME, TABLE_SCHEMA, cdosColumn);
		d.setAdd(add );
		/************insert*********************/
		/************Delete*********************/
		SQLTrans deleteSQLTrans = getDeleteMethod(TABLE_NAME, TABLE_SCHEMA,
				cdosColumn);
		d.setDelete(deleteSQLTrans);
		/************Delete*********************/
		/************Update*********************/
		SQLTrans updateSQLTrans = getUpdateMethod(TABLE_NAME, TABLE_SCHEMA,
				cdosColumn);
		
		d.setUpdate(updateSQLTrans);
		/************Update*********************/
		/************findOne*********************/
		
		SQLTrans findOneSQLTrans = getFindOneMethod(TABLE_SCHEMA,
				TABLE_NAME, cdosColumn);
		d.setFindOne(findOneSQLTrans );
		
		/************findOne*********************/
		
    	System.out.println(XmlUtil.toXML(d ));
		
    	writeFile(TABLE_NAME,XmlUtil.toXML(d ));
	
	}
	
	private SQLTrans getFindOneMethod(String TABLE_SCHEMA, String TABLE_NAME,
			CDO[] cdosColumn) {
		SQLTrans findOneSQLTrans = new SQLTrans("0","findOne",this.service.getParameter("readGroupCountId"));
		SelectRecord selectRecord = new SelectRecord("{cdo"+ParserUtil.parseTableName(TABLE_NAME)+"}","{nRecordCount}");
		selectRecord.setOutputSQL(" select * from "+TABLE_SCHEMA+"."+TABLE_NAME+"	where 1=1 ");
		List<SQLIf> sQLIf = this.createSQLIfList(cdosColumn);
		selectRecord.setSQLIf(sQLIf );
		selectRecord.setOutputSQL2(" limit 1	");
		findOneSQLTrans.setSelectRecord(selectRecord );
		OnException _onException = new OnException(ParserUtil.parseTableName(TABLE_NAME)+"Service","findOne");
		findOneSQLTrans.setOnException(_onException );
		
		com.dafy.myoaservice.element.Return return1 = new com.dafy.myoaservice.element.Return("0","OK","OK");
		return1.ReturnItems = new ArrayList<ReturnItem>();
		return1.ReturnItems.add(new ReturnItem("{cdo"+ParserUtil.parseTableName(TABLE_NAME)+"}","{cdo"+ParserUtil.parseTableName(TABLE_NAME)+"}"));
		return1.ReturnItems.add(new ReturnItem("{nRecordCount}","{nRecordCount}"));
		findOneSQLTrans.setReturn(return1);
		return findOneSQLTrans;
	}
	private SQLTrans getUpdateMethod(String TABLE_NAME, String TABLE_SCHEMA,
			CDO[] cdosColumn) {
		SQLTrans updateSQLTrans = new SQLTrans("1","update",this.service.getParameter("writeGroupCountId"));
		
		Update update = new Update("{nRecordCount}");
		String priKey = "";
		for(CDO cdo:cdosColumn)
		{
			if(cdo.exists("COLUMN_KEY") && cdo.getStringValue("COLUMN_KEY").equals("PRI") )
			{
				priKey = cdo.getStringValue("COLUMN_NAME");
				break;
			}
		}
		
		if("".equals(priKey)==false)
		{
			update.setOutputSQL(" update "+TABLE_SCHEMA+"."+TABLE_NAME+" set "+priKey+"="+priKey+" ");
		}else
		{
			String _strColumn = cdosColumn[0].getStringValue("COLUMN_NAME");
			update.setOutputSQL(" update "+TABLE_SCHEMA+"."+TABLE_NAME+" set "+_strColumn+"="+_strColumn+" ");
		}
		List<SQLIf> sQLIfs = new ArrayList<SQLIf>();
		for(CDO cdo:cdosColumn)
		{
			if(cdo.exists("COLUMN_KEY") && cdo.getStringValue("COLUMN_KEY").equals("PRI") )
				continue;//主键忽略
			String columnName = cdo.getStringValue("COLUMN_NAME");
			SQLIf e = new SQLIf();
			e.Type = "String";
			e.Value1 ="{"+ cdo.getStringValue("COLUMN_NAME") + "}";
			e.Operator = "EXIST";
			e.Value2 = "";
			SQLThen sQLThen = new SQLThen();
			sQLThen.setOutputSQL("	, "+columnName+" = {"+cdo.getStringValue("COLUMN_NAME")+"} ");
			e.setSQLThen(sQLThen );
			sQLIfs.add(e );
		}
		if(sQLIfs.isEmpty())
		{
			log.error(" The table has no columns but the pri key,can't create updateHandleTrans!  ");
			return null;
		}
		update.setSQLIf(sQLIfs);
		
		update.setOutputSQL2(" where 1=1 ");
		
		List<SQLIf> sQLIf2 = this.createSQLIfList(cdosColumn);
		update.setSQLIf2(sQLIf2);
		
		updateSQLTrans.setUpdate(update );
		
		OnException _onException = new OnException(ParserUtil.parseTableName(TABLE_NAME)+"Service","update");
		updateSQLTrans.setOnException(_onException );
		
		com.dafy.myoaservice.element.Return return1 = new com.dafy.myoaservice.element.Return("0","OK","OK");
		return1.ReturnItems = new ArrayList<ReturnItem>();
		return1.ReturnItems.add(new ReturnItem("{nRecordCount}","{nRecordCount}"));
		updateSQLTrans.setReturn(return1);
		return updateSQLTrans;
	}
	private SQLTrans getDeleteMethod(String TABLE_NAME, String TABLE_SCHEMA,
			CDO[] cdosColumn) {
		SQLTrans deleteSQLTrans = new SQLTrans("1","delete",this.service.getParameter("writeGroupCountId"));
		
		Delete delete = new Delete("{nRecordCount}");
		
		delete.setOutputSQL(" delete from "+TABLE_SCHEMA+"."+TABLE_NAME+"	where 1=1	" );
		
		List<SQLIf> sQLIf = this.createSQLIfList(cdosColumn);
		delete.setSQLIf(sQLIf );
		
		deleteSQLTrans.setDelete(delete );
		
		
		OnException _onException = new OnException(ParserUtil.parseTableName(TABLE_NAME)+"Service","delete");
		deleteSQLTrans.setOnException(_onException );
		
		com.dafy.myoaservice.element.Return return1 = new com.dafy.myoaservice.element.Return("0","OK","OK");
		return1.ReturnItems = new ArrayList<ReturnItem>();
		return1.ReturnItems.add(new ReturnItem("{nRecordCount}","{nRecordCount}"));
		deleteSQLTrans.setReturn(return1);
		return deleteSQLTrans;
	}
	private SQLTrans getInsertMethod(String TABLE_NAME, String TABLE_SCHEMA,
			CDO[] cdosColumn) {
		SQLTrans add = new SQLTrans("1","add",this.service.getParameter("writeGroupCountId"));
		Insert insert = new Insert();
		StringBuilder outputSQL = new StringBuilder();
		outputSQL.append(" insert into ");
		outputSQL.append(TABLE_SCHEMA+"."+TABLE_NAME+"(");
		for(int i=0,len=cdosColumn.length;i<len;i++)
		{
			CDO cdo = cdosColumn[i];
			String columnName = cdo.getStringValue("COLUMN_NAME");
			if("lId".equals(columnName))continue;
			if(i<len-1)
			{
				outputSQL.append(cdo.getStringValue("COLUMN_NAME"));
				outputSQL.append(",");
			}
			else
			{
				outputSQL.append(cdo.getStringValue("COLUMN_NAME"));
			}
		}
		outputSQL.append(")");
		outputSQL.append("	values(");
		for(int i=0,len=cdosColumn.length;i<len;i++)
		{
			CDO cdo = cdosColumn[i];
			if(cdo.exists("COLUMN_KEY") && cdo.getStringValue("COLUMN_KEY").equals("PRI")&&cdo.exists("EXTRA")&&cdo.getStringValue("EXTRA").equalsIgnoreCase("auto_increment") )
				continue;//自增主键忽略
			String columnName = cdo.getStringValue("COLUMN_NAME");
			String strEnd = "";
			String IS_NULLABLE = cdo.getStringValue("IS_NULLABLE");
			if("dtCreateTime".equalsIgnoreCase(columnName))
			{	
				strEnd = "|NOW()}";
			}else if("YES".equalsIgnoreCase(IS_NULLABLE))
			{
				strEnd = "|NULL}";
			} 
			else{
				if(cdo.exists("COLUMN_DEFAULT")==true)
				{
					String COLUMN_DEFAULT = cdo.getStringValue("COLUMN_DEFAULT");
					strEnd = "|"+COLUMN_DEFAULT+"}";
				}else
				{
					String DATA_TYPE = cdo.getStringValue("DATA_TYPE");
					String defaultValue = XmlUtil.getDefault(DATA_TYPE);
					strEnd = "|"+defaultValue+"}";
				}
			}
			outputSQL.append("{"+cdo.getStringValue("COLUMN_NAME")+strEnd);
			if(i<len-1)
			{
				
				outputSQL.append(",");
			}
		}
		outputSQL.append(")");
		insert.setOutputSQL(outputSQL.toString());
		
		SelectField selectField = new SelectField("{lId}");
		selectField.setOutputSQL(" select LAST_INSERT_ID() lId FROM " +TABLE_SCHEMA+"."+TABLE_NAME+"	"); 
		add.setSelectField(selectField);
		
		
		OnException _onException = new OnException(ParserUtil.parseTableName(TABLE_NAME)+"Service","findList");
		add.setOnException(_onException );
		
		com.dafy.myoaservice.element.Return return1 = new com.dafy.myoaservice.element.Return("0","OK","OK");
		return1.ReturnItems = new ArrayList<ReturnItem>();
		return1.ReturnItems.add(new ReturnItem("{lId}","{lId}"));
		add.setReturn(return1);
		
		add.setInsert(insert );
		return add;
	}
	private SQLTrans getFindListByPageMethod(String TABLE_NAME,
			String TABLE_SCHEMA, CDO[] cdosColumn) {
		SQLTrans findListByPage = new SQLTrans("0","findListByPage",this.service.getParameter("readGroupCountId"));
		SelectRecordSet selectRecordSet = new SelectRecordSet("{cdos"+ParserUtil.parseTableName(TABLE_NAME)+"}","{nRecordCount}");
		selectRecordSet.setOutputSQL("	select * from "+TABLE_SCHEMA+"."+TABLE_NAME+" where 1=1	");
		List<SQLIf> sQLIfs = createSQLIfList(cdosColumn);
		selectRecordSet.setSQLIf(sQLIfs );
		selectRecordSet.setOutputSQL2(" limit {start},{limit} ");
		findListByPage.setSelectRecordSet(selectRecordSet );
		
		SelectField selectField = new SelectField("{nTotalCount}");
		selectField.setOutputSQL("	select count(*) from "+TABLE_SCHEMA+"."+TABLE_NAME+" where 1=1	");
		List<SQLIf> sQLIf = createSQLIfList(cdosColumn);
		selectField.setSQLIf(sQLIf );
		findListByPage.setSelectField(selectField );
		OnException _onException = new OnException(ParserUtil.parseTableName(TABLE_NAME)+"Service","findListByPage");
		findListByPage.setOnException(_onException );
		com.dafy.myoaservice.element.Return return1 = new com.dafy.myoaservice.element.Return("0","OK","OK");
		return1.setReturnItems(new ArrayList<ReturnItem>());
		return1.getReturnItems().add(new ReturnItem("{cdos"+ParserUtil.parseTableName(TABLE_NAME)+"}","{cdos"+ParserUtil.parseTableName(TABLE_NAME)+"}"));
		return1.getReturnItems().add(new ReturnItem("{nRecordCount}","{nRecordCount}"));
		return1.getReturnItems().add(new ReturnItem("{nTotalCount}","{nTotalCount}"));
		findListByPage.setReturn(return1);
		return findListByPage;
	}
	
	private SQLTrans getFindListMethod(String TABLE_NAME, String TABLE_SCHEMA,
			CDO[] cdosColumn) {
		SQLTrans findList = new SQLTrans();
		findList.TransFlag="0";
		findList.TransName="findList";
		findList.DataGroupId=this.service.getParameter("readGroupCountId");
		SelectRecordSet selectRecordSet = new SelectRecordSet();
		selectRecordSet.OutputId="{cdos"+ParserUtil.parseTableName(TABLE_NAME)+"}";
		selectRecordSet.RecordCountId="{nRecordCount}";   
		selectRecordSet.setOutputSQL("	select * from "+TABLE_SCHEMA+"."+TABLE_NAME+" where 1=1	");
		
		List<SQLIf> sQLIfs = createSQLIfList(cdosColumn);
		
		selectRecordSet.setSQLIf(sQLIfs );
		
		findList.setSelectRecordSet(selectRecordSet);
		
		OnException _onException = new OnException(ParserUtil.parseTableName(TABLE_NAME)+"Service","findList");
		findList.setOnException(_onException );
		
		com.dafy.myoaservice.element.Return return1 = new com.dafy.myoaservice.element.Return("0","OK","OK");
		return1.setReturnItems(new ArrayList<ReturnItem>());
		return1.getReturnItems().add(new ReturnItem("{cdos"+ParserUtil.parseTableName(TABLE_NAME)+"}","{cdos"+ParserUtil.parseTableName(TABLE_NAME)+"}"));
		return1.getReturnItems().add(new ReturnItem("{nRecordCount}","{nRecordCount}"));
		findList.setReturn(return1);
		return findList;
	}
	
	private List<SQLIf> createSQLIfList(CDO[] cdosColumn) {
		List<SQLIf> sQLIfs = new ArrayList<SQLIf>();
		for(CDO cdo:cdosColumn)
		{
			SQLIf e = new SQLIf();
			e.Type = "String";
			e.Value1 ="{"+ cdo.getStringValue("COLUMN_NAME") + "}";
			e.Operator = "EXIST";
			e.Value2 = "";
			SQLThen sQLThen = new SQLThen();
			sQLThen.setOutputSQL("	AND "+cdo.getStringValue("COLUMN_NAME")+" = {"+cdo.getStringValue("COLUMN_NAME")+"} ");
			e.setSQLThen(sQLThen );
			sQLIfs.add(e );
		}
		return sQLIfs;
	}
	
	public void writeFile(String TableName,String content)
	{
		try {
			String fileName = ParserUtil.parseTableName(TableName)+"Service.xml";
//			String path = "file/"+ParserUtil.parseFilePath(TableName);
//			
//			File file = new File(path);
//			if(file.exists()==false)
//			{
//				file.mkdirs();
//			}
			File file = new File("file/"+fileName);
			file.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(content);
			writer.flush();
			writer.close();  
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

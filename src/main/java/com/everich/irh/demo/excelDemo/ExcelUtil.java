package com.everich.irh.demo.excelDemo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
/**
 * Excel生成类.
 */
public class ExcelUtil {
	/**
	 * 根据模板生成Excel文件.
	 * 
	 * @param templateFileName
	 *            模板文件.
	 * @param list
	 *            模板中存放的数据.
	 * @param resultFileName
	 *            生成的文件.
	 * @throws IOException
	 * @throws InvalidFormatException
	 * @throws ParsePropertyException
	 */
	public void createExcel(String templateFileName, List<?> list, String resultFileName) throws ParsePropertyException, InvalidFormatException, IOException {
		// 创建XLSTransformer对象
		XLSTransformer transformer = new XLSTransformer();
		// 获取java项目编译后根路径
		// URL url = this.getClass().getClassLoader().getResource("");
		// 得到模板文件路径
		// String srcFilePath = url.getPath() + templateFileName;
		String srcFilePath = templateFileName;
		Map<String, Object> beanParams = new HashMap<String, Object>();
		beanParams.put("list", list);
		// String destFilePath = url.getPath() + resultFileName;
		String destFilePath = resultFileName;
		// 生成Excel文件
		transformer.transformXLS(srcFilePath, beanParams, destFilePath);
	}

	public static void main(String[] args) throws ParsePropertyException, InvalidFormatException, IOException {
		List<Fruit> list = new ArrayList<Fruit>();
		list.add(new Fruit("苹果", 2.01f));
		list.add(new Fruit("桔子", 2.05f));
		String templateFileName = "E:/template/fruit.xls";
		String resultFileName = "E:/export/fruit.xls";
		new ExcelUtil().createExcel(templateFileName, list, resultFileName);
	}
}
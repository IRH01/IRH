package com.everich.irh.demo.excelDemo;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import net.sf.jxls.exception.ParsePropertyException;
import net.sf.jxls.transformer.XLSTransformer;
import com.everich.irh.entity.role.Role;
public class TestExcel {
	public static void main(String[] args) throws ParsePropertyException, InvalidFormatException, IOException {
		String templateDir = "E:/template/role.xls";
		String targetDir = "E:/export/" + new Date() + "role.xls";
		Map<String, Role> beans = new HashMap<String, Role>();
		Role role = new Role();
		role.setRoleName("rh");
		beans.put("role", role);
		XLSTransformer transformer = new XLSTransformer();
		transformer.transformXLS(templateDir, beans, targetDir);
	}
}

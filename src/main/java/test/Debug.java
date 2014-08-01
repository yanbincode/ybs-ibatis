package test;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import pojo.Student;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class Debug {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, SQLException {
		Reader reader = Resources.getResourceAsReader("ibatis/sql_map_config.xml");
		SqlMapClient sqlMap = SqlMapClientBuilder.buildSqlMapClient(reader);

		List<Student> students = (List<Student>) sqlMap.queryForList("getAll", null);
		for (Student student : students) {
			System.out.print(student.getStuId() + "\t");
			System.out.print(student.getStuName() + "\t");
			System.out.print(student.getStuGender() + "\t");
			System.out.println(student.getStuAge() + "\n");
		}
	}

}

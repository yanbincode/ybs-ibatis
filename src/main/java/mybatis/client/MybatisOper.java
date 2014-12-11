package mybatis.client;

import java.io.Reader;

import model.Student;
import mybatis.dao.StudentDao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * mybatis的简单操作
 * 
 * @author yanbin
 * 
 */
public class MybatisOper {

	public void oper() throws Exception {
		// 1、指定配置文件、找到配置
		Reader reader = Resources.getResourceAsReader("mybatis/configuration.xml");
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

		// 2、加载配置文件构建SqlSessionFactory对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);

		// 3、打开SqlSession
		SqlSession session = sqlSessionFactory.openSession();

		try {
			// 4、从Session中获取到Mapper
			StudentDao mapper = session.getMapper(StudentDao.class);

			// 5、调用mapper 操作db
			Student student = mapper.selectById(1L);
			System.out.println(student);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6、提交数据库
			session.commit();
			// 7、关闭session
			session.close();
		}
	}

}

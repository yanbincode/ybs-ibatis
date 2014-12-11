package mybatis.dao;

import java.util.List;

import model.Student;

/**
 * Mapper类：映射的student的dao。 myBatis的特性，就是不需要再用实现类，来实现代码，只需要声明对应Mapper里面方法名的接口
 * 
 * @author yanbin
 * 
 */
public interface StudentDao {

	/**
	 * 根据ID获取student实体
	 * 
	 * @param id
	 * @return
	 */
	public Student selectById(Long id);

	/**
	 * 获取所有的Student数据
	 * 
	 * @return
	 */
	public List<Student> selectAll();

	/**
	 * 插入一条student数据
	 * 
	 * @param student
	 */
	public void insert(Student student);

	/**
	 * 更新student
	 * 
	 * @param map
	 */
	public void update(Student student);

	/**
	 * 根据id删除student
	 * 
	 * @param id
	 */
	public void deleteById(Long id);

}

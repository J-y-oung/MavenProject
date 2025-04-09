package org.example.springbootproject01.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.springbootproject01.Pojo.User_db;

import java.util.List;

@Mapper//加上mapper注解后会自动生成注解的实现类对象，并将该对象交给IOC容器管理
public interface UserMapper {
    @Select("select * from user")
    public List<User_db> list();
    /*
    * 占位符：用#{}格式的占位符会让sql预编译，有如下优点：
    * 1.使SQL性能更高。2.防止sql注入。如，在提交的字段后拼接sql语句，能够改变原有的sql语句作用
    * ${}同样是占位符，但是它的实现是拼接sql语句，所以，${}存在sql注入问题，也无法提高sql性能
     */
    @Delete("delete from user where id = #{id}")
    public int delete(Integer id);
    /*
    * 插入与更新操作一般直接传递实体类，以免操作过于繁琐，传递的参数过杂
     */
//    @Insert("insert into user(name,age,gender,phone)"+ "values(#{name},#{age},#{gender},#{phone})")
    public void insert(User_db user_db);
    /*
    * 删除插入返回值代表影响的数据条数，也可以设置为void。
    * 查询操作因为要返回数据，所以返回值类型为对应查询的实体类
    * 另，注意名称对应问题，一般实体类参数采用驼峰命名法，而数据库字段采用下划线命名法，因此如果名称不一致将不会自动封装，需要进行特殊操作：
    * 1.在@Select内部的sql语句中直接取别名，使其一一对应
    * 2.在@Select上方使用@Results注解，指定实体类属性与数据库字段对应关系，格式如下：
    * @Results({
    *   @Result(property = "数据库字段名",column = "实体参数名"),
    *   @Result(property = "数据库字段名",column = "实体参数名")
    * })
     */
    @Select("select * from user where id = #{id}")
    public User_db select(Integer id);
    /*
     *上面是通过主键查询，是单条查询，因此只需要返回相应的实体类即可。接下来是通过其他字段条件查询，
     * 可能有多条符合结果的数据，因此需要返回List<实体类>。
     * 在模糊匹配中，若直接拼接需要使用${}而非#{},因为预编译会将后者替换为?导致结果错误，
     * 前者直接拼接字符串避免了这个问题。但又会引发sql注入问题，因此可以使用concat方法拼接字符串。
     */
//    @Select("select * from user where name like concat('%',#{name},'%') and" +
//            " age between #{begin} and #{end}")
    public List<User_db> listSelect(String name, Short begin, Short end);

    public List<User_db> listSelect2(String name, Short begin, Short end);

    public void update(User_db user_db);

    public void deleteByIds(List<Integer> ids);

    public List<User_db> commonSelect();
}

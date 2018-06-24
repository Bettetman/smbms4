package com.rimi.cs.dao.impl;

import com.rimi.cs.dao.IUserDao;
import com.rimi.cs.pojo.User;
import com.rimi.cs.utils.DbUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @author szf
 */
@Repository
public class UserDaoImpl implements IUserDao {

    @Override
    public List<User> selectAll() {
        String sql = "select * form smbms_user";
        // 获得连接
        Connection connection = DbUtils.getConnection();
        // 通过connection 创建 Statement
        Statement statement = null;
        // 创建返回的结果
        List<User> userList = null;
        try {
            statement = connection.createStatement();
            // 执行 SQL 语句得到结果
            ResultSet resultSet = statement.executeQuery(sql);
            // 遍历结果集
            while (resultSet.next()){
                // 创建对象
                User user = new User();
                // 获取一条记录中的ID值
                Object id = resultSet.getObject("id");
                // 把ID存放到user对象中的ID属性中
                user.setId((Long) id);
                //把存好值的对象放入到集合中
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            DbUtils.close(connection);
        }
        return userList;
    }
}

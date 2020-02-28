package com.buy.dao.user;

import com.buy.dao.user.IUser;
import com.buy.entity.EasybuyUser;
import com.buy.utils.DataSourceUtil;
import com.buy.utils.EmptyUtils;

import javax.persistence.Embeddable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EasybuyUserImpl extends DataSourceUtil implements IUser {
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    public EasybuyUser TableClass  (ResultSet rs) throws SQLException{
        EasybuyUser user = new EasybuyUser();
        user.setId(rs.getInt("id"));
        user.setLoginname(rs.getString("loginName"));
        user.setUsername(rs.getString("userName"));
        user.setPassword(rs.getString("password"));
        user.setSex(rs.getInt("sex"));
        user.setIdentitycode(rs.getString("identityCode"));
        user.setEmail(rs.getString("email"));
        user.setMobile(rs.getString("mobile"));
        user.setType(rs.getInt("type"));
        return user;
    }

    @Override
    public EasybuyUser loginByName(String name) throws SQLException {
         EasybuyUser user = null;
//         //编写SQL语句
        StringBuffer sql = new StringBuffer("SELECT * FROM `easybuy_user` where 1=1");
        if (!EmptyUtils.isEmpty(name)){
            sql.append(" and loginName = ?");
        }

//        String sql = "SELECT * FROM `easybuy_user` where 1=1 and loginName = ?";
        conn = DataSourceUtil.getConn();
        pstmt = conn.prepareStatement(sql.toString());
        if (!"".equals(name) && null != name) {
            pstmt.setObject(1, name);
        }
        rs = pstmt.executeQuery();
        while (rs.next()){
            user = TableClass(rs);
        }
        return user;
    }
    @Override
    public int queryAllUser(String name,String password) {
        EasybuyUser user = null;
        int returned = 0;

        try {
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT COUNT(*) FROM `easybuy_user`");

            //判断name和password 的值是否正确，如果为0，显示的是一级分类
            if (!"".equals(name) || null!= name||!"".equals(password) || null!= password){
                sql.append("where loginName = ? AND `password` = ?");
            }
            //获取连接
            Connection conn = DataSourceUtil.getConn();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());
            if (!"".equals(name) && null != name&&!"".equals(password) && null != password) {
                pstmt.setObject(1, name);
                pstmt.setObject(2,password);
            }
            //处理结果集
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                returned = rs.getInt("COUNT(*)");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return returned;
    }

    @Override
    public int save(EasybuyUser user) {

        int num = 0;
//         //编写SQL语句
        StringBuffer sql = new StringBuffer("INSERT INTO easybuy_user ");
        sql.append("(loginName,userName,password,sex,identityCode,email,mobile,type)");
        if (!EmptyUtils.isEmpty(user)){
            sql.append(" values(?,?,?,?,?,?,?,?)");
        }
        num = this.executeInsert(sql.toString(),user.getLoginname(),user.getUsername(),user.getPassword(),
                user.getSex(),user.getIdentitycode(),user.getEmail(),user.getMobile(),user.getType());

//        try {
////            conn = DataSourceUtil.getConn();
////            pstmt = conn.prepareStatement(sql.toString());
////            if (!"".equals(user) && null != user) {
////                pstmt.setObject(1, user.getLoginname());
////                pstmt.setObject(2, user.getUsername());
////                pstmt.setObject(3, user.getPassword());
////                pstmt.setObject(4, user.getSex());
////                pstmt.setObject(5, user.getIdentitycode());
////                pstmt.setObject(6, user.getEmail());
////                pstmt.setObject(7, user.getMobile());
////                pstmt.setObject(7, user.getType());
////            }
////            num = pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return num;
    }

}

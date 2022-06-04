package dao;
import dao.pojo.Account;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class AccountDao extends BaseDao{
    List<Account> accountList = new ArrayList<>();
    public List<Account> getAccount() {
        ResultSet rs = executeQuerySQL("select * from account;");
        try {
            while (true) {
                assert rs != null;
                if (!rs.next()) break;
                String username = rs.getString("username");
                String password = rs.getString("password");
                accountList.add(new Account(1, username, password));
            }
        }catch (Exception e) {
            System.out.println("获取数据失败");
        }
        return accountList;
    } 
}
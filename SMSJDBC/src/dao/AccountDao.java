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
                accountList.add(new Account(1, rs.getString("username"), rs.getString("password")));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return accountList;
    }
}
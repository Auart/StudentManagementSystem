package service.impl;
import dao.AccountDao;
import dao.pojo.Account;
import service.AccountService;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    AccountDao accountDao=new AccountDao();
    @Override
    public boolean getAccount(String username,String password) {
        List<Account> account = accountDao.getAccount();
        for (Account a:account){
            if(username.equals(a.getUsername()) &password.equals( a.getPassword())) return true;
        }
        return false;
    }
}

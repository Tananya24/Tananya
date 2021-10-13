package ku.cs.controllers.admin;

import java.io.IOException;

public interface AccountData {
    Account getAccount();

    void setAccountData(Account lists) throws IOException;
}

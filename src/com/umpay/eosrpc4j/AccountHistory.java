package com.umpay.eosrpc4j;


public interface AccountHistory {
    void getTransaction(String transactionID);

    void getTransactions(String accountName);

    void getKeyAccounts(String publicKey);

    void getControlledAccounts(String accountName);
}

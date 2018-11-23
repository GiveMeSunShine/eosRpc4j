package com.umpay.eosrpc4j;


import java.util.Date;
import java.util.List;
import java.util.Map;

import com.umpay.eosrpc4j.exceptions.ChainException;
import com.umpay.eosrpc4j.types.AccountInfo;
import com.umpay.eosrpc4j.types.BlockInfo;
import com.umpay.eosrpc4j.types.ChainInfo;
import com.umpay.eosrpc4j.types.Code;
import com.umpay.eosrpc4j.types.RequiredKeys;
import com.umpay.eosrpc4j.types.SignedTransaction;
import com.umpay.eosrpc4j.types.TableRows;
import com.umpay.eosrpc4j.types.Transaction;
import com.umpay.eosrpc4j.types.TransactionBinArgs;
import com.umpay.eosrpc4j.types.TransactionJSONArgs;

public interface Chain {
    ChainInfo getInfo() throws ChainException;

    BlockInfo getBlock(String blockNumOrID) throws ChainException;

    AccountInfo getAccount(String accountName) throws ChainException;

    Code getCode(String accountName) throws ChainException;

    TableRows getTableRows(String contract,
                           String scope,
                           String table,
                           long limit,
                           boolean json) throws ChainException;

    TableRows getTableRows(String contract,
                           String scope,
                           String table,
                           String lowerBound,
                           String upperBound,
                           long limit,
                           boolean json) throws ChainException;

    TableRows getTableRows(String contract,
                           String scope,
                           String table,
                           String key,
                           String lowerBound,
                           String upperBound,
                           long limit,
                           boolean json) throws ChainException;

    TransactionBinArgs abiJsonToBin(String code,
                                    String action,
                                    Map args) throws ChainException;

    TransactionJSONArgs abiBinToJson(String code,
                                     String action,
                                     String binArgs) throws ChainException;

    RequiredKeys getRequiredKeys(Transaction transaction,
                                 List<String> availableKeys) throws ChainException;

    Transaction.Response pushTransaction(SignedTransaction transaction) throws ChainException;

    List<Transaction.Response> pushTransactions(List<SignedTransaction> signedTransactions) throws ChainException;

    Transaction createRawTransaction(String account,
                                     String name,
                                     Map args,
                                     List<String> scopes,
                                     List<Transaction.Authorization> authorizations,
                                     Date expirationDate) throws ChainException;

    String packTransaction(SignedTransaction transaction) throws ChainException;
}

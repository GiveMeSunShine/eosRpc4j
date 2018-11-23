package com.umpay.eosrpc4j.types;

import java.util.List;
import java.util.Map;

public class TransactionJSONArgs {
    public Map args;
    public List<String> required_scope;
    public List<String> required_auth;
}

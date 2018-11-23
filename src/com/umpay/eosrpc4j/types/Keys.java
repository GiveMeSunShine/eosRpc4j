package com.umpay.eosrpc4j.types;

import java.util.List;

public class Keys {

    public List<KeyPair> keys;

    public static class KeyPair{
        public String publicKey;
        public String privateKey;

        public KeyPair(String publicKey, String privateKey) {
            this.publicKey = publicKey;
            this.privateKey = privateKey;
        }
    }
}

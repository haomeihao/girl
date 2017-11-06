package com.imooc.girl.chain;

import com.chain.api.Account;
import com.chain.api.Asset;
import com.chain.api.MockHsm;
import com.chain.api.Transaction;
import com.chain.http.Client;
import com.chain.signing.HsmSigner;

/**
 * Created by hmh on 2017/9/11.
 */
public class FiveMinuteGuide {
    public static void main(String[] args) throws Exception {
        // 1、snippet create-client
        Client client = new Client();
        // endsnippet

        // 2、snippet create-key
        MockHsm.Key key = MockHsm.Key.create(client);
        // endsnippet

        // 3、snippet signer-add-key
        HsmSigner.addKey(key, MockHsm.getSignerClient(client));
        // endsnippet

        // 4、snippet create-asset
        new Asset.Builder()
                .setAlias("gold")
                .addRootXpub(key.xpub)
                .setQuorum(1)
                .create(client);
        // endsnippet

        // 5、snippet create-account-alice
        new Account.Builder()
                .setAlias("alice")
                .addRootXpub(key.xpub)
                .setQuorum(1)
                .create(client);
        // endsnippet

        // snippet create-account-bob
        new Account.Builder()
                .setAlias("bob")
                .addRootXpub(key.xpub)
                .setQuorum(1)
                .create(client);
        // endsnippet

        // 6、snippet issue
        Transaction.Template issuance = new Transaction.Builder()
                .addAction(new Transaction.Action.Issue()
                        .setAssetAlias("gold")
                        .setAmount(100)
                ).addAction(new Transaction.Action.ControlWithAccount()
                        .setAccountAlias("alice")
                        .setAssetAlias("gold")
                        .setAmount(100)
                ).build(client);

        Transaction.submit(client, HsmSigner.sign(issuance));
        // endsnippet

        // 7、snippet spend
        Transaction.Template spending = new Transaction.Builder()
                .addAction(new Transaction.Action.SpendFromAccount()
                        .setAccountAlias("alice")
                        .setAssetAlias("gold")
                        .setAmount(10))
                .addAction(new Transaction.Action.ControlWithAccount()
                        .setAccountAlias("bob")
                        .setAssetAlias("gold")
                        .setAmount(10)
                ).build(client);

        Transaction.submit(client, HsmSigner.sign(spending));
        // endsnippet

        // 8、snippet retire
        Transaction.Template retirement = new Transaction.Builder()
                .addAction(new Transaction.Action.SpendFromAccount()
                        .setAccountAlias("bob")
                        .setAssetAlias("gold")
                        .setAmount(5)
                ).addAction(new Transaction.Action.Retire()
                        .setAssetAlias("gold")
                        .setAmount(5)
                ).build(client);

        Transaction.submit(client, HsmSigner.sign(retirement));
        // endsnippet
    }
}

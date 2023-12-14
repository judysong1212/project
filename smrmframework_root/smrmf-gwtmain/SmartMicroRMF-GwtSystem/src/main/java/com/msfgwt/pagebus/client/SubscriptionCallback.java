package com.msfgwt.pagebus.client;

public interface SubscriptionCallback {

  void execute(String subject, Object message);
}

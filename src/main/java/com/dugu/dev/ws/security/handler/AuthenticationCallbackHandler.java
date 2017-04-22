package com.dugu.dev.ws.security.handler;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.cxf.interceptor.security.AuthenticationException;
import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.stereotype.Component;
@Component
public class AuthenticationCallbackHandler implements CallbackHandler {

	WSPasswordCallback wsPasswordCallback = null;

	@Override
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException, AuthenticationException {

		wsPasswordCallback = (WSPasswordCallback) callbacks[0];

		if (wsPasswordCallback.getIdentifier().equals("Basanta")) {

			// set the password on the callback. This will be compared to the
			// password which was sent from the client.
			wsPasswordCallback.setPassword("Sriman_Java_Gyan_Mantra");
		}
	}

	
}
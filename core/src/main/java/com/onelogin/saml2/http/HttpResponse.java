package com.onelogin.saml2.http;

import java.io.IOException;

/**
 * Framework-agnostic definition of an HTTP response with a very minimal set of
 * methods needed to support the SAML handshake.
 *
 * @since 3.0.0
 */
public interface HttpResponse {

    void sendRedirect(final String location) throws IOException;

    void sendError(final int statusCode) throws IOException;

    void sendError(final int statusCode, final String message) throws IOException;


}

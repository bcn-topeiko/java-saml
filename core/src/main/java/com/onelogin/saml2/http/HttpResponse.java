package com.onelogin.saml2.http;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Framework-agnostic definition of an HTTP response with a very minimal set of
 * methods needed to support the SAML handshake.
 *
 * @since 3.0.0
 */
public interface HttpResponse {

    public boolean containsHeader(String name);

    public String encodeURL(String url);

    public String encodeRedirectURL(String url);

    public void sendError(int sc, String msg) throws IOException;

    public void sendError(int sc) throws IOException;

    public void sendRedirect(String location) throws IOException;

    public void setDateHeader(String name, long date);

    public void addDateHeader(String name, long date);

    public void setHeader(String name, String value);

    public void addHeader(String name, String value);

    public void setIntHeader(String name, int value);

    public void addIntHeader(String name, int value);

    public void setStatus(int sc);

    public int getStatus();

    public String getHeader(String name);

    public Collection<String> getHeaders(String name);

    public Collection<String> getHeaderNames();

    public void setTrailerFields(Supplier<Map<String, String>> supplier);

    public Supplier<Map<String, String>> getTrailerFields();
}

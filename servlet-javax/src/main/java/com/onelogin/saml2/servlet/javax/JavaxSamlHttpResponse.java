package com.onelogin.saml2.servlet.javax;

import com.onelogin.saml2.http.HttpResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static com.onelogin.saml2.util.Preconditions.checkNotNull;

/**
 * A pre EE9 implementation of {@link HttpResponse} based the {@code javax} flavor
 * of {@link HttpServletResponse}.
 *
 * @see JavaxSamlHttpResponse#makeHttpResponse(HttpServletResponse)
 */
public class JavaxSamlHttpResponse implements HttpResponse {

    private final HttpServletResponse delegate;

    private JavaxSamlHttpResponse(HttpServletResponse delegate) {
        this.delegate = checkNotNull(delegate, "Servlet response cannot be null.");
    }

    @Override
    public void sendRedirect(final String location) throws IOException {
        delegate.sendRedirect(location);
    }

    @Override
    public void setDateHeader(String name, long date) {
        delegate.setDateHeader(name, date);
    }

    @Override
    public void addDateHeader(String name, long date) {
        delegate.addDateHeader(name, date);
    }

    @Override
    public void setHeader(String name, String value) {
        delegate.setHeader(name, value);
    }

    @Override
    public void addHeader(String name, String value) {
        delegate.addHeader(name, value);
    }

    @Override
    public void setIntHeader(String name, int value) {
        delegate.setIntHeader(name, value);
    }

    @Override
    public void addIntHeader(String name, int value) {
        delegate.addIntHeader(name, value);
    }

    @Override
    public void setStatus(int sc) {
        delegate.setStatus(sc);
    }

    @Override
    public int getStatus() {
        return delegate.getStatus();
    }

    @Override
    public String getHeader(String name) {
        return delegate.getHeader(name);
    }

    @Override
    public Collection<String> getHeaders(String name) {
        return delegate.getHeaders(name);
    }

    @Override
    public Collection<String> getHeaderNames() {
        return delegate.getHeaderNames();
    }

    @Override
    public void setTrailerFields(Supplier<Map<String, String>> supplier) {
        delegate.setTrailerFields(supplier);
    }

    @Override
    public Supplier<Map<String, String>> getTrailerFields() {
        return delegate.getTrailerFields();
    }

    @Override
    public void sendError(final int statusCode) throws IOException {
        delegate.sendError(statusCode);
    }

    @Override
    public boolean containsHeader(String name) {
        return delegate.containsHeader(name);
    }

    @Override
    public String encodeURL(String url) {
        return delegate.encodeURL(url);
    }

    @Override
    public String encodeRedirectURL(String url) {
        return delegate.encodeRedirectURL(url);
    }

    @Override
    public void sendError(final int statusCode, final String message) throws IOException {
        delegate.sendError(statusCode, message);
    }

    public static HttpResponse makeHttpResponse(HttpServletResponse delegate) {
        return new JavaxSamlHttpResponse(delegate);
    }

}

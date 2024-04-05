package com.onelogin.saml2.servlet.jakarta;

import com.onelogin.saml2.http.HttpResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.onelogin.saml2.util.Preconditions.checkNotNull;

/**
 * An EE9 or later implementation of {@link HttpResponse} based the {@code jakarta} flavor
 * of {@link HttpServletResponse}.
 *
 * @see JakartaSamlHttpResponse#makeHttpResponse(HttpServletResponse)
 */
public class JakartaSamlHttpResponse implements HttpResponse {

    private final HttpServletResponse delegate;

    private JakartaSamlHttpResponse(HttpServletResponse delegate) {
        this.delegate = checkNotNull(delegate, "Servlet response cannot be null.");
    }

    public HttpServletResponse getDelegate() {
        return delegate;
    }

    @Override
    public void sendRedirect(final String location) throws IOException {
        delegate.sendRedirect(location);
    }

    @Override
    public void sendError(final int statusCode) throws IOException {
        delegate.sendError(statusCode);
    }

    @Override
    public void sendError(final int statusCode, final String message) throws IOException {
        delegate.sendError(statusCode, message);
    }

    public static HttpResponse makeHttpResponse(HttpServletResponse delegate) {
        return new JakartaSamlHttpResponse(delegate);
    }

}

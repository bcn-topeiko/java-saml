package com.onelogin.saml2.servlet.javax;

import com.onelogin.saml2.http.HttpResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    public void sendError(final int statusCode) throws IOException {
        delegate.sendError(statusCode);
    }

    @Override
    public void sendError(final int statusCode, final String message) throws IOException {
        delegate.sendError(statusCode, message);
    }

    public static HttpResponse makeHttpResponse(HttpServletResponse delegate) {
        return new JavaxSamlHttpResponse(delegate);
    }

}

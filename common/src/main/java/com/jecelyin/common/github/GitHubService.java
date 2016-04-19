
package com.jecelyin.common.github;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.jecelyin.common.github.PagedRequest.PAGE_FIRST;
import static com.jecelyin.common.github.PagedRequest.PAGE_SIZE;

/**
 * Base GitHub service class.
 */
public abstract class GitHubService {

    /**
     * Accept header for raw response (only body)
     */
    public static final String ACCEPT_RAW = "application/vnd.github.v3.raw+json"; //$NON-NLS-1$

    /**
     * Accept header for HTML response (only bodyHtml)
     */
    public static final String ACCEPT_HTML = "application/vnd.github.v3.html+json"; //$NON-NLS-1$

    /**
     * Accept header for text response (only bodyText)
     */
    public static final String ACCEPT_TEXT = "application/vnd.github.v3.text+json"; //$NON-NLS-1$

    /**
     * Accept header for full response (body, bodyText and bodyHtml)
     */
    public static final String ACCEPT_FULL = "application/vnd.github.v3.full+json"; //$NON-NLS-1$

    /**
     * Accept header to use preview features of the 'ironman' release.
     *
     * @see <a href="https://developer.github.com/changes">https://developer.github.com/changes</a>
     * @since 4.2
     */
    public static final String ACCEPT_PREVIEW_IRONMAN = "application/vnd.github.ironman-preview+json"; //$NON-NLS-1$

    /**
     * Accept header to use preview features of the 'loki' release.
     *
     * @see <a href="https://developer.github.com/changes">https://developer.github.com/changes</a>
     * @since 4.2
     */
    public static final String ACCEPT_PREVIEW_LOKI = "application/vnd.github.loki-preview+json"; //$NON-NLS-1$

    /**
     * Accept header to use preview features of the 'drax' release.
     *
     * @see <a href="https://developer.github.com/changes">https://developer.github.com/changes</a>
     * @since 4.2
     */
    public static final String ACCEPT_PREVIEW_DRAX = "application/vnd.github.drax-preview+json"; //$NON-NLS-1$

    /**
     * Client field
     */
    protected final GitHubClient client;

    /**
     * Create service using a default {@link GitHubClient}
     */
    public GitHubService() {
        this(new GitHubClient());
    }

    /**
     * Create service for client
     *
     * @param client must be non-null
     */
    public GitHubService(GitHubClient client) {
        if (client == null)
            throw new IllegalArgumentException("Client cannot be null"); //$NON-NLS-1$
        this.client = client;
    }

    /**
     * Get configured client
     *
     * @return non-null client
     */
    public GitHubClient getClient() {
        return client;
    }

    /**
     * Unified paged request creation method that all sub-classes should use so
     * overriding classes can extend and configure the default request.
     *
     * @return request
     */
    protected <V> PagedRequest<V> createPagedRequest() {
        return createPagedRequest(PAGE_FIRST, PAGE_SIZE);
    }

    /**
     * Unified paged request creation method that all sub-classes should use so
     * overriding classes can extend and configure the default request.
     *
     * @param start
     * @param size
     * @return request
     */
    protected <V> PagedRequest<V> createPagedRequest(int start, int size) {
        return new PagedRequest<V>(start, size);
    }

    /**
     * Unified page iterator creation method that all sub-classes should use so
     * overriding classes can extend and configure the default iterator.
     *
     * @param request
     * @return iterator
     */
    protected <V> PageIterator<V> createPageIterator(PagedRequest<V> request) {
        return new PageIterator<V>(request, client);
    }

    /**
     * Get paged request by performing multiple requests until no more pages are
     * available or an exception occurs.
     *
     * @param <V>
     * @param request
     * @return list of all elements
     * @throws IOException
     */
    protected <V> List<V> getAll(PagedRequest<V> request) throws IOException {
        return getAll(createPageIterator(request));
    }

    /**
     * Get paged request by performing multiple requests until no more pages are
     * available or an exception occurs.
     *
     * @param <V>
     * @param iterator
     * @return list of all elements
     * @throws IOException
     */
    protected <V> List<V> getAll(PageIterator<V> iterator) throws IOException {
        List<V> elements = new ArrayList<V>();
        try {
            while (iterator.hasNext())
                elements.addAll(iterator.next());
        } catch (NoSuchPageException pageException) {
            throw pageException.getCause();
        }
        return elements;
    }

    /**
     * Verify user and repository name
     *
     * @param user
     * @param repository
     * @return this service
     */
    protected GitHubService verifyRepository(String user, String repository) {
        if (user == null)
            throw new IllegalArgumentException("User cannot be null"); //$NON-NLS-1$
        if (user.length() == 0)
            throw new IllegalArgumentException("User cannot be empty"); //$NON-NLS-1$
        if (repository == null)
            throw new IllegalArgumentException("Repository cannot be null"); //$NON-NLS-1$
        if (repository.length() == 0)
            throw new IllegalArgumentException("Repository cannot be empty"); //$NON-NLS-1$
        return this;
    }

    protected String getActionUrl(String action) {
        String repoId = IGitHubConstants.REPO_USER + '/' + IGitHubConstants.REPO_NAME;

        StringBuilder uri = new StringBuilder(IGitHubConstants.SEGMENT_REPOS);
        uri.append('/').append(repoId);
        uri.append(action);

        return uri.toString();
    }
}

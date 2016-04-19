
package com.jecelyin.common.github;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * Issue service class for listing, searching, and fetching {@link Issue}
 * objects using a {@link GitHubClient}.
 *
 * @see <a href="http://developer.github.com/v3/issues">GitHub Issues API
 * documentation</a>
 */
public class IssueService extends GitHubService {

    /**
     * Filter field key
     */
    public static final String FIELD_FILTER = "filter"; //$NON-NLS-1$

    /**
     * Filter by issue assignee
     */
    public static final String FILTER_ASSIGNEE = "assignee"; //$NON-NLS-1$

    /**
     * Filter by issue's milestone
     */
    public static final String FILTER_MILESTONE = "milestone"; //$NON-NLS-1$

    /**
     * Filter by user mentioned in issue
     */
    public static final String FILTER_MENTIONED = "mentioned"; //$NON-NLS-1$

    /**
     * Filter by subscribed issues for user
     */
    public static final String FILTER_SUBSCRIBED = "subscribed"; //$NON-NLS-1$

    /**
     * Filter by created issues by user
     */
    public static final String FILTER_CREATED = "created"; //$NON-NLS-1$

    /**
     * Filter by assigned issues for user
     */
    public static final String FILTER_ASSIGNED = "assigned"; //$NON-NLS-1$

    /**
     * Filter by issue's labels
     */
    public static final String FILTER_LABELS = "labels"; //$NON-NLS-1$

    /**
     * Filter by issue's state
     */
    public static final String FILTER_STATE = "state"; //$NON-NLS-1$

    /**
     * Issue open state filter value
     */
    public static final String STATE_OPEN = "open"; //$NON-NLS-1$

    /**
     * Issue closed state filter value
     */
    public static final String STATE_CLOSED = "closed"; //$NON-NLS-1$

    /**
     * Issue body field name
     */
    public static final String FIELD_BODY = "body"; //$NON-NLS-1$

    /**
     * Issue title field name
     */
    public static final String FIELD_TITLE = "title"; //$NON-NLS-1$

    /**
     * Since date field
     */
    public static final String FIELD_SINCE = "since"; //$NON-NLS-1$

    /**
     * Sort direction of output
     */
    public static final String FIELD_DIRECTION = "direction"; //$NON-NLS-1$

    /**
     * Ascending direction sort order
     */
    public static final String DIRECTION_ASCENDING = "asc"; //$NON-NLS-1$

    /**
     * Descending direction sort order
     */
    public static final String DIRECTION_DESCENDING = "desc"; //$NON-NLS-1$

    /**
     * Sort field key
     */
    public static final String FIELD_SORT = "sort"; //$NON-NLS-1$

    /**
     * Sort by created at
     */
    public static final String SORT_CREATED = "created"; //$NON-NLS-1$

    /**
     * Sort by updated at
     */
    public static final String SORT_UPDATED = "updated"; //$NON-NLS-1$

    /**
     * Sort by commented on at
     */
    public static final String SORT_COMMENTS = "comments"; //$NON-NLS-1$

    /**
     * Create issue service
     */
    public IssueService() {
        super();
    }

    /**
     * Create issue service
     *
     * @param client cannot be null
     */
    public IssueService(GitHubClient client) {
        super(client);
    }


    /**
     * Create issue map for issue
     *
     * @param issue
     * @return map
     */
    protected Map<Object, Object> createIssueMap(Issue issue) {
        Map<Object, Object> params = new HashMap<Object, Object>();
        if (issue != null) {
            params.put(FIELD_BODY, issue.getBody());
            params.put(FIELD_TITLE, issue.getTitle());
        }
        return params;
    }

    public Issue createIssue(Issue issue) throws IOException {
        Map<Object, Object> params = createIssueMap(issue);
        String uri = getActionUrl(IGitHubConstants.SEGMENT_ISSUES);
        return client.post(uri, params, Issue.class);
    }

}

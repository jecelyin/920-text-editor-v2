
package com.jecelyin.common.github;

import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Map;


/**
 * Issue service class for listing, searching, and fetching {@link Issue}
 * objects using a {@link GitHubClient}.
 *
 * @see <a href="http://developer.github.com/v3/issues">GitHub Issues API
 * documentation</a>
 */
public class ReleasesService extends GitHubService {

    public PageIterator<Release> pageReleases() {
        return pageReleases(null, PagedRequest.PAGE_FIRST, PagedRequest.PAGE_SIZE);
    }

    public PageIterator<Release> pageReleases(
            Map<String, String> filterData, int start, int size) {

        String uri = getActionUrl(IGitHubConstants.SEGMENT_RELEASES);

        PagedRequest<Release> request = createPagedRequest(start, size);
        request.setParams(filterData);
        request.setUri(uri);
        request.setType(new TypeReference<List<Release>>() {
        }.getType());
        return createPageIterator(request);
    }
}

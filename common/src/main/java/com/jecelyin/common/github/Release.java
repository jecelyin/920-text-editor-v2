
package com.jecelyin.common.github;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Release model class
 *
 * @since 4.2
 */
public class Release implements Serializable {

    private static final long serialVersionUID = 1L;

    private String url;

    private String htmlUrl;

    private String assetsUrl;

    private String uploadUrl;

    private String tarballUrl;

    private String zipballUrl;

    private long id;

    private String tagName;

    private String targetCommitish;

    private String name;

    private String body;

    private boolean isDraft;

    private boolean isPrerelease;

    private Date createdAt;

    private Date publishedAt;

    private List<Assets> assets;

    public static class Assets {
        private String url;
        private String name;
        private int size;
        private String state; //uploaded
        private String browser_download_url;

        public String getBrowser_download_url() {
            return browser_download_url;
        }

        public void setBrowser_download_url(String browser_download_url) {
            this.browser_download_url = browser_download_url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     * @return this release
     */
    public Release setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * @return htmlUrl
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * @param htmlUrl
     * @return this release
     */
    public Release setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
        return this;
    }

    /**
     * @return assetsUrl
     */
    public String getAssetsUrl() {
        return assetsUrl;
    }

    /**
     * @param assetsUrl
     * @return this release
     */
    public Release setAssetsUrl(String assetsUrl) {
        this.assetsUrl = assetsUrl;
        return this;
    }

    /**
     * @return uploadUrl
     */
    public String getUploadUrl() {
        return uploadUrl;
    }

    /**
     * @param uploadUrl
     * @return this release
     */
    public Release setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
        return this;
    }

    /**
     * @return tarballUrl
     */
    public String getTarballUrl() {
        return tarballUrl;
    }

    /**
     * @param tarballUrl
     * @return this release
     */
    public Release setTarballUrl(String tarballUrl) {
        this.tarballUrl = tarballUrl;
        return this;
    }

    /**
     * @return zipballUrl
     */
    public String getZipballUrl() {
        return zipballUrl;
    }

    /**
     * @param zipballUrl
     * @return this release
     */
    public Release setZipballUrl(String zipballUrl) {
        this.zipballUrl = zipballUrl;
        return this;
    }

    /**
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id
     * @return this release
     */
    public Release setId(long id) {
        this.id = id;
        return this;
    }

    /**
     * @return tagName
     */
    public String getTagName() {
        return tagName;
    }

    /**
     * @param tagName
     * @return this release
     */
    public Release setTagName(String tagName) {
        this.tagName = tagName;
        return this;
    }

    /**
     * @return targetCommitish
     */
    public String getTargetCommitish() {
        return targetCommitish;
    }

    /**
     * @param targetCommitish
     * @return this release
     */
    public Release setTargetCommitish(String targetCommitish) {
        this.targetCommitish = targetCommitish;
        return this;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     * @return this release
     */
    public Release setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @return body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body
     * @return this release
     */
    public Release setBody(String body) {
        this.body = body;
        return this;
    }

    /**
     * @return isDraft
     */
    public boolean isDraft() {
        return isDraft;
    }

    /**
     * @param isDraft
     * @return this release
     */
    public Release setDraft(boolean isDraft) {
        this.isDraft = isDraft;
        return this;
    }

    /**
     * @return isPrerelease
     */
    public boolean isPrerelease() {
        return isPrerelease;
    }

    /**
     * @param isPrerelease
     * @return this release
     */
    public Release setPrerelease(boolean isPrerelease) {
        this.isPrerelease = isPrerelease;
        return this;
    }

    /**
     * @return createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt
     * @return this release
     */
    public Release setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * @return publishedAt
     */
    public Date getPublishedAt() {
        return publishedAt;
    }

    /**
     * @param publishedAt
     * @return this release
     */
    public Release setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
        return this;
    }

    public List<Assets> getAssets() {
        return assets;
    }

    public void setAssets(List<Assets> assets) {
        this.assets = assets;
    }
}

/*******************************************************************************
 *  Copyright (c) 2011 GitHub Inc.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *    Kevin Sawicki (GitHub Inc.) - initial API and implementation
 *******************************************************************************/
package com.jecelyin.common.github;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * GitHub issue model class.
 */
public class Issue implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6358575015023539051L;

    private int id;
    private int number;

    private String body;
    private List<String> labels;
    private String title;

    /**
     * @return body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body
     * @return this issue
     */
    public Issue setBody(String body) {
        this.body = body;
        return this;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     * @return this issue
     */
    public Issue setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getId() {
        return id;
    }

    public Issue setId(int id) {
        this.id = id;
        return this;
    }

    public int getNumber() {
        return number;
    }

    public Issue setNumber(int number) {
        this.number = number;
        return this;
    }

    /**
     * @return labels
     */
    public List<String> getLabels() {
        return labels;
    }

    /**
     * @param labels
     * @return this issue
     */
    public Issue setLabels(List<String> labels) {
        this.labels = labels != null ? new ArrayList<String>(labels) : null;
        return this;
    }

    public Issue setLabel(String label) {
        if (this.labels == null)
            this.labels = new ArrayList<>();
        labels.add(label);
        return this;
    }
}

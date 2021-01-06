package com.balestero.githubrepos.factory;

import com.balestero.githubrepos.controller.dto.RepositoryOwner;
import com.balestero.githubrepos.controller.dto.RepositorySummary;

public class RepositorySummaryBuilder {

    private RepositorySummary repositorySummary;

    public RepositorySummaryBuilder() {
        this.repositorySummary = new RepositorySummary();
    }

    public RepositorySummary build() {
        return repositorySummary;
    }

    public RepositorySummaryBuilder withPrivate(Boolean aPrivate) {
        repositorySummary.setPrivateRepo(aPrivate);
        return this;
    }

    public RepositorySummaryBuilder withCreatedAt(String createdAt) {
        repositorySummary.setCreatedAt(createdAt);
        return this;
    }

    public RepositorySummaryBuilder withDescription(String description) {
        repositorySummary.setDescription(description);
        return this;
    }

    public RepositorySummaryBuilder withFullName(String fullName) {
        repositorySummary.setFullName(fullName);
        return this;
    }

    public RepositorySummaryBuilder withName(String name) {
        repositorySummary.setName(name);
        return this;
    }

    public RepositorySummaryBuilder withLanguage(String language) {
        repositorySummary.setLanguage(language);
        return this;
    }

    public RepositorySummaryBuilder withOwner(RepositoryOwner owner) {
        repositorySummary.setOwner(owner.getLogin());
        return this;
    }

    public RepositorySummaryBuilder withUpdatedAt(String updatedAt) {
        repositorySummary.setUpdatedAt(updatedAt);
        return this;
    }

}

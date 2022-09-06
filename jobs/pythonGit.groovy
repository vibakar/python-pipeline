pipelineJob("python-git") {
    displayName("Python Git")

    parameters {
        nonStoredPasswordParam("GIT_TOKEN", "Github access token")
        stringParam("GIT_ORGANIZATION", "", "Organization to create a repo")
        stringParam("GIT_REPO_NAME", "", "Repo name to create")
        booleanParam("GIT_REPO_PRIVACY_SETTING", "", "Check the box to set the repo as private")
    }

    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url("https://github.com/vibakar/python-pipeline.git")
                    }
                    branch("master")
                }
            }
            scriptPath("jenkinsfiles/pythonGit.groovy")
        }
    }
}
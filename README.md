# SETUP

For running as example with provided docker-compose.

## Prepare remote Git repository

1. Open Gitea (http://localhost:3000) and login
2. Create an empty Git repository.
3. In repository administration, add SSH key (docker/business-central-workbench/ssh_keys/id_rsa.pub) and enable write permissions.

## Business Central Workbench setup

1. Login into workbench (http://localhost:8080/business-central/) with predefined user (admin:admin)
2. Create new Space and New project (If you have basic project generated by Maven, you can import it if you pushed that into created repository).
3. Connect to running workbench container (`docker exec -it business-central-workbench /bin/bash`)
4. Go to git folder of created project `cd $JBOSS_HOME/bin/.niogit/SPACE_NAME/PROJECT_NAME.git/`
5. Setup remote git repository `git remote add origin git@gitea:MY/REPO.git` -> This can be copied in Gitea web UI on repository, please use a SSH option. _In case of existing remote, use `git remote set-url origin git@gitea:MY/REPO.git` command_
6. Validate git remote `git remote -v`
7. Create a post-commit hook to push all saved changes in this git repository to remote by creating `post-commit` file in _hooks_ folder of project repository.
8. Insert content of [post-commit](post-commit).
9. Make that file executable by `chmod +x hooks/post-commit`.

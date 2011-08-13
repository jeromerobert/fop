#! /bin/sh -ex
git fetch --all
git checkout jr-debian
git reset --hard origin/jr-debian
git checkout jr-dev
git reset --hard origin/jr-dev
git checkout jr-tarball
git reset --hard origin/jr-tarball
git rebase upstream/trunk jr-tarball
git rebase jr-tarball jr-dev
git rebase jr-tarball jr-debian


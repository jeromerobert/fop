#!/bin/sh -e

# called by uscan with '--upstream-version' <version> <file>
TAR=../fop_$2.dfsg.orig.tar.gz
DIR=fop-$2

# clean up the upstream tarball
tar -zxvf $3
tar -czf $TAR --exclude '*/lib/*' $DIR
rm -rf $DIR $3

# move to directory 'tarballs'
if [ -r .svn/deb-layout ]; then
    . .svn/deb-layout
    mv $TAR $origDir
    echo "moved $TAR to $origDir"
fi


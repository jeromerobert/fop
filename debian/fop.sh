#! /bin/sh

# Shell script wrapper around the fop program,
# Copyright 2008 by Vincent Fourmond <fourmond@debian.org>
#
# Licensed under the same terms as fop itself, that is under
# the conditions of the Apache 2 licence.

# Include the wrappers utility script
. /usr/lib/java-wrappers/java-wrappers.sh

# comment this line if you want fop to run without headless property,
# or write a line containing
#  HEADLESS=
# in your fop configuration file.
HEADLESS=-Djava.awt.headless=true


for cf in /etc/fop.conf.d/*.conf; do
    if [ -f $cf ]; then
        . $cf;
    fi
done

# To override the default logging configuration, add a LOGGING line to
# your fop configuration file. To disable logging altogether, set
#  LOGGING=
# in your configuration file.
LOGGING="-Dorg.apache.commons.logging.Log=org.apache.commons.logging.impl.SimpleLog"

# Load system-wide configuration, if any
if [ -f /etc/fop.conf ]; then
    . /etc/fop.conf
fi

# Load user's preferences, if any
if [ -f "$HOME/.foprc" ]; then
    . $HOME/.foprc
fi

# We prefer to use openjdk or Sun's java if available
find_java_runtime openjdk sun  || find_java_runtime 

find_jars commons-io avalon-framework serializer xalan2 xml-apis 
find_jars batik-all commons-logging servlet-api xercesImpl xmlgraphics-commons
find_jars xml-apis-ext 

# We load the hyphenation jar at the request of the user.
if [ "$FOP_HYPHENATION_PATH" ]; then
    find_jars $FOP_HYPHENATION_PATH
fi
find_jars fop



run_java $HEADLESS $LOGGING org.apache.fop.cli.Main "$@"
